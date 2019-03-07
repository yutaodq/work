import {
  ChangeDetectionStrategy,
  Component,
  OnDestroy,
  OnInit,
  ViewChild
} from "@angular/core";
import { IKufangEntity, KufangEntity } from "../models";
import { ActionsSubject, Store } from "@ngrx/store";
import { Subscription } from "rxjs";
import { ActivatedRoute, Router } from "@angular/router";
import * as fromKufangs from "../reducers";
import { NewKufangPageActions } from "../actions";
import { KufangService } from "../service";

import { ofType } from "@ngrx/effects";
import { Observable } from "rxjs/index";
import { KufangFormComponent } from "app/xtwh/kufang/components";
import { FormGroup } from "@angular/forms";
import {
  DynamicFormControlModel,
  DynamicFormService
} from "@ng-dynamic-forms/core";
import { KufangFormModelService } from "app/xtwh/kufang/form";

@Component({
  selector: "zy-new-kufang-page",
  templateUrl: "./new-kufang-page.component.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class NewKufangPageComponent implements OnInit, OnDestroy {
  private _pageTitle: string;
  redirectSub: Subscription;
  private _entity: IKufangEntity;
  private _formModel: DynamicFormControlModel[];
  private _formGroup: FormGroup;
  private _kufang: IKufangEntity;

  @ViewChild("kufangForm") private _kufangFormComponent: KufangFormComponent;

  constructor(
    private store: Store<fromKufangs.State>,
    private router: Router,
    private _kufangService: KufangService,
    private activatedRoute: ActivatedRoute,
    private actionsSubject: ActionsSubject,
    private _formService: DynamicFormService,
    private _formModelService: KufangFormModelService
  ) {
    this.activatedRoute.data.subscribe(data => {
      this._entity = data.kufang;
      this._kufang = data.kufang;
    });
  }

  ngOnInit() {
    this.setPageTitle();
    this.CreateKufangSuccessLink();
    this.initFormGroup();
  }
  initFormGroup() {
    this._formModel = this._formModelService.createFormModel(
      this.entity,
      false
    );
    this._formGroup = this._formService.createFormGroup(this._formModel);
  }

  saveCreate(kufang: string) {
    this.store.dispatch(
      new NewKufangPageActions.CreateKufang(
        this._kufangFormComponent.returnEntity()
      )
    );
  }
  recoverCreate(kufang: string) {
    this._kufangFormComponent.restoreEntity();
  }

  private setPageTitle() {
    this.activatedRoute.data.subscribe(data => {
      this._pageTitle = data.pageTitle;
    });
  }
  private CreateKufangSuccessLink() {
    this.redirectSub = this.actionsSubject
      .asObservable()
      .pipe(
        ofType(
          NewKufangPageActions.NewKufangPageActionTypes.CreateKufangSuccess
        )
      )
      .subscribe((action: NewKufangPageActions.CreateKufangSuccess) =>
        this.linkToViewKufangPage(action.payload.id)
      );
  }
  private linkToViewKufangPage(recordID: number) {
    this._kufangService.linkToViewKufangPage(recordID);
  }

  get entity(): IKufangEntity {
    return this._entity;
  }
  get pageTitle(): string {
    return this._pageTitle;
  }
  get formGroup() {
    return this._formGroup;
  }

  get formModel() {
    return this._formModel;
  }

  get kufang() {
    return this._kufang;
  }

  // 以前的状态 在表单中按返回键时调用的方法
  previousState() {
    window.history.back();
  }

  ngOnDestroy() {
    this.redirectSub.unsubscribe();
  }
}

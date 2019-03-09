import {
  ChangeDetectionStrategy,
  Component,
  OnDestroy,
  OnInit
} from "@angular/core";
import { Store, ActionsSubject, select } from "@ngrx/store";
import { Observable, Subscription } from "rxjs";
import { ActivatedRoute, Router } from "@angular/router";
import { ofType } from "@ngrx/effects";
import { filter } from "rxjs/operators";

import { IKufangEntity } from "app/models/kufang.model";
import * as fromKufangs from "../reducers";
import { SelectedKufangPageActions, CollectionApiActions } from "../actions";
import { KufangService } from "../service";
import { KufangFormModelService } from "app/xtwh/kufang/form";
import {
  DynamicFormControlModel,
  DynamicFormService
} from "@ng-dynamic-forms/core";
import { FormGroup } from "@angular/forms";
import { NG_BOOTSTRAP_KUFANG_FORM_MODEL } from "app/xtwh/kufang/form/kufang-form.model";

@Component({
  selector: "zy-selected-kufang-page",
  templateUrl: "./selected-kufang-page.component.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
// 学习案例 https://github.com/avatsaev/angular-contacts-app-example
// app\views\contacts\contact-details\contact-details.component.ts
export class SelectedKufangPageComponent implements OnInit, OnDestroy {
  private _pageTitle: string;
  private _entity$: Observable<IKufangEntity>;
  redirectSub: Subscription;
  private _formModel: DynamicFormControlModel[];
  private _formGroup: FormGroup;
  private _kufang: IKufangEntity;
  constructor(
    private _store: Store<fromKufangs.State>,
    private activatedRoute: ActivatedRoute,
    private actionsSubject: ActionsSubject,
    private _kufangService: KufangService,
    private _formService: DynamicFormService,
    private _formModelService: KufangFormModelService
  ) {}

  ngOnInit() {
    this.initEntity();
    this.initKufang();
    this.setPageTitle();
    this.removeKufangSuccessLink();
    this.initFormGroup();
  }

  initFormGroup() {
    this._formModel = this._formModelService.createFormModel(
      this.kufang,
      this.kufangService,
      true
    );
    this._formGroup = this._formService.createFormGroup(this._formModel);
  }

  private removeKufangSuccessLink() {
    // If the destroy effect fires, we check if the current id is the one being viewed, and redirect to index
    this.redirectSub = this.actionsSubject
      .pipe(
        ofType(
          CollectionApiActions.CollectionApiActionTypes.RemoveKufangSuccess
        ),
        filter(
          (action: CollectionApiActions.RemoveKufangSuccess) =>
            action.payload.id === this.activatedRoute.snapshot.params["id"]
        )
      )
      .subscribe(_ => this._kufangService.linkToKufang());

    this.redirectSub = this.actionsSubject
      .pipe(
        filter(
          action =>
            action.type ===
            CollectionApiActions.CollectionApiActionTypes.RemoveKufangSuccess
        )
      )
      .subscribe(_ => this._kufangService.linkToKufang());
  }

  private initEntity() {
    this._entity$ = this._store.pipe(
      select(fromKufangs.getSelectedKufang)
    ) as Observable<IKufangEntity>;
  }
  private initKufang() {
    this._entity$.subscribe((enityt: IKufangEntity) => (this._kufang = enityt));
  }

  private setPageTitle() {
    this.activatedRoute.data.subscribe(data => {
      this._pageTitle = data.pageTitle;
    });
  }

  ngOnDestroy() {
    this.redirectSub.unsubscribe();
  }

  get entity$(): Observable<IKufangEntity> {
    return this._entity$;
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
  get kufangService() {
    return this._kufangService;
  }
}

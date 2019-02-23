import {
  ChangeDetectionStrategy,
  Component,
  OnDestroy,
  OnInit
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

@Component({
  selector: "zy-new-kufang-page",
  templateUrl: "./new-kufang-page.component.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class NewKufangPageComponent implements OnInit, OnDestroy {
  private _pageTitle: string;
  redirectSub: Subscription;
  private _entity: IKufangEntity;

  constructor(
    private store: Store<fromKufangs.State>,
    private router: Router,
    private _kufangService: KufangService,
    private activatedRoute: ActivatedRoute,
    private actionsSubject: ActionsSubject
  ) {
    this.activatedRoute.data.subscribe(data => {
      this._entity = data.kufang;
    });
  }

  ngOnInit() {
    this.setPageTitle();
    this.CreateKufangSuccessLink();
  }

  cancelCreate(kufang: IKufangEntity) {
    this.previousState();
  }

  saveCreate(kufang: IKufangEntity) {
    this.store.dispatch(new NewKufangPageActions.CreateKufang(kufang));
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

  get cancelButtonCaption(): string {
    return "取消创建";
  }
  get saveButtonCaption(): string {
    return "保存记录";
  }
  get recoverButtonCaption(): string {
    return "恢复初始值";
  }

  // 以前的状态 在表单中按返回键时调用的方法
  previousState() {
    window.history.back();
  }

  ngOnDestroy() {
    this.redirectSub.unsubscribe();
  }
}

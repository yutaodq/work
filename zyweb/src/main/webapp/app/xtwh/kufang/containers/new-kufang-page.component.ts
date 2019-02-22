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
  redirectSub: Subscription;
  private _entity$: Observable<IKufangEntity>;

  constructor(
    private store: Store<fromKufangs.State>,
    private router: Router,
    private _kufangService: KufangService,
    private activatedRoute: ActivatedRoute,
    private actionsSubject: ActionsSubject
  ) {
    this.activatedRoute.data.subscribe(({ entity }) => {
      this._entity$ = entity;
    });
  }

  ngOnInit() {
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

  linkToViewKufangPage(recordID: number) {
    this._kufangService.linkToViewKufangPage(recordID);
  }

  cancelCreate(kufang: IKufangEntity) {
    this.previousState();
  }

  saveCreate(kufang: IKufangEntity) {
    this.store.dispatch(new NewKufangPageActions.CreateKufang(kufang));
  }

  get entity$(): Observable<IKufangEntity> {
    return this._entity$;
  }

  // 以前的状态 在表单中按返回键时调用的方法
  previousState() {
    window.history.back();
  }

  ngOnDestroy() {
    this.redirectSub.unsubscribe();
  }
}

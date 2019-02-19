import {
  ChangeDetectionStrategy,
  Component,
  OnDestroy,
  OnInit
} from "@angular/core";
import { IKufangEntity, KufangEntity } from "../models";
import { ActionsSubject, Store } from "@ngrx/store";
import { Subscription } from "rxjs";
import { Router } from "@angular/router";
import * as fromKufangs from "../reducers";
import { NewKufangPageActions } from "../actions";
import { KufangService } from "../service";

import { ofType } from "@ngrx/effects";

@Component({
  selector: "zy-new-kufang-page",
  templateUrl: "./new-kufang-page.component.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class NewKufangPageComponent implements OnInit, OnDestroy {
  redirectSub: Subscription;

  constructor(
    private store: Store<fromKufangs.State>,
    private router: Router,
    private _kufangService: KufangService,
    private actionsSubject: ActionsSubject
  ) {}

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

  // 以前的状态 在表单中按返回键时调用的方法
  previousState() {
    window.history.back();
  }

  ngOnDestroy() {
    this.redirectSub.unsubscribe();
  }

  submitted(kufang: IKufangEntity) {
    // this.store.dispatch(new Create(kufang));
  }
}

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
// import { Create } from "../actions";
import { NewKufangPageActions } from "../actions";

// import * as fromRoot from '@app-root-store';
// import {ContactsActionTypes, Create, CreateSuccess} from '@app-contacts-store/actions/contacts-actions';
import { ofType } from "@ngrx/effects";

@Component({
  selector: "zy-new-kufang-page",
  templateUrl: "./new-kufang-page.component.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class NewKufangPageComponent implements OnInit, OnDestroy {
  redirectSub: Subscription;

  constructor() {}
  // private store: Store<fromRoot.State>,
  // private router: Router,
  // private actionsSubject: ActionsSubject

  ngOnInit() {
    // this.redirectSub = this.actionsSubject.asObservable().pipe(
    //   ofType(ContactsActionTypes.CREATE_SUCCESS)
    // ).subscribe(
    //   (action: CreateSuccess) => this.router.navigate(['/contacts', action.payload.id])
    // );
  }
  cancelCreate(kufang: IKufangEntity) {
    this.previousState();
  }
  // 以前的状态 在表单中按返回键时调用的方法
  previousState() {
    window.history.back();
  }

  ngOnDestroy() {
    // this.redirectSub.unsubscribe();
  }

  submitted(kufang: IKufangEntity) {
    // this.store.dispatch(new Create(kufang));
  }
}

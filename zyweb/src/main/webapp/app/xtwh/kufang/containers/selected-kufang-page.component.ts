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

import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";
import * as fromKufangs from "../reducers";
import { SelectedKufangPageActions, CollectionApiActions } from "../actions";
import { KufangService } from "../service";

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

  constructor(
    private _store: Store<fromKufangs.State>,
    private activatedRoute: ActivatedRoute,
    // private _router: Router,
    private actionsSubject: ActionsSubject,
    private _kufangService: KufangService
  ) {
    this._entity$ = this._store.pipe(
      select(fromKufangs.getSelectedKufang)
    ) as Observable<IKufangEntity>;

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
      .subscribe(_ => this._kufangService.getAllLink());

    this.redirectSub = this.actionsSubject
      .pipe(
        filter(
          action =>
            action.type ===
            CollectionApiActions.CollectionApiActionTypes.RemoveKufangSuccess
        )
      )
      .subscribe(_ => this._kufangService.getAllLink());
    this.activatedRoute.data.subscribe(data => {
      this._pageTitle = data.pageTitle;
    });
  }

  ngOnInit() {
    // this._pageTitle = "库房";
  }

  onKufangList(kufang: IKufangEntity) {
    this._kufangService.getAllLink();
  }

  onKufangDelete(kufang: IKufangEntity) {
    const r = confirm("Are you sure?");
    if (r) {
      this._store.dispatch(new SelectedKufangPageActions.RemoveKufang(kufang));
    }
  }

  previousState() {
    window.history.back();
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
}

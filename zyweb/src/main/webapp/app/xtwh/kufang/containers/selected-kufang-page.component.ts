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

import {
  IKufangEntity,
  KufangEntity
} from "app/xtwh/kufang/models/kufang.model";
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
  private _kufang: IKufangEntity;

  constructor(
    private _store: Store<fromKufangs.State>,
    private activatedRoute: ActivatedRoute,
    private actionsSubject: ActionsSubject,
    private _kufangService: KufangService
  ) {}

  ngOnInit() {
    this.set_entity$();
    this.setPageTitle();
    this.setKufang();
    this.removeKufangSuccessLink();
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
  private set_entity$() {
    this._entity$ = this._store.pipe(
      select(fromKufangs.getSelectedKufang)
    ) as Observable<IKufangEntity>;
  }
  private setPageTitle() {
    this.activatedRoute.data.subscribe(data => {
      this._pageTitle = data.pageTitle;
    });
  }
  private setKufang() {
    this._entity$.subscribe((kf: IKufangEntity) => {
      this._kufang = kf;
    });
  }

  onKufangList() {
    // onKufangList(kufang: IKufangEntity) {
    this._kufangService.linkToKufang();
  }

  onKufangDelete() {
    const r = confirm("Are you sure?");
    if (r) {
      this._store.dispatch(
        new SelectedKufangPageActions.RemoveKufang(this._kufang)
      );
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

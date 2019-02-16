import { Component, OnInit, OnDestroy } from "@angular/core";
import { Observable } from "rxjs/Observable";
import { select, Store } from "@ngrx/store";

import { IKufangEntity } from "app/xtwh/kufang/models";

import { KufangService } from "../service";

import * as fromKufangs from "app/xtwh/kufang/reducers";
import { CollectionPageActions } from "app/xtwh/kufang/actions";

@Component({
  selector: "zy-kufang",
  templateUrl: "./kufang.component.html"
})
export class KufangComponent implements OnInit {
  private _kufangs$: Observable<IKufangEntity[]>;
  private _pageTitle: string;
  constructor(
    private store: Store<fromKufangs.State>,
    private _kufangService: KufangService
  ) {
    this._kufangs$ = store.pipe(select(fromKufangs.getKufangCollection));
  }

  loadAll() {
    this.store.dispatch(new CollectionPageActions.LoadCollection());
  }

  onCreate(lx: string) {
    this._kufangService.createLink();
  }
  showEntity(kufang: IKufangEntity) {
    this._kufangService.findLink(kufang.id);
  }

  ngOnInit() {
    this.loadAll();
  }

  get kufangs$(): Observable<IKufangEntity[]> {
    return this._kufangs$;
  }
  get pageTitle(): string {
    return this._pageTitle;
  }
}

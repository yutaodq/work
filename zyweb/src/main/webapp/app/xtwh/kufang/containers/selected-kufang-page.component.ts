import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Store, select } from "@ngrx/store";
import { Observable } from "rxjs";

import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";
import * as fromKufangs from "../reducers";

@Component({
  selector: "zy-kufang-selected",
  templateUrl: "./selected-kufang-page.component.html"
})
export class SelectedKufangPageComponent implements OnInit {
  private _pageTitle: string;
  private _entity$: Observable<IKufangEntity>;

  constructor(
    private store: Store<fromKufangs.State>,
    private activatedRoute: ActivatedRoute
  ) {
    this.activatedRoute.data.subscribe(data => {
      this._pageTitle = data.pageTitle;
    });
    this._entity$ = store.pipe(
      select(fromKufangs.getSelectedKufang)
    ) as Observable<IKufangEntity>;
  }

  ngOnInit() {}

  previousState() {
    window.history.back();
  }
  get entity$(): Observable<IKufangEntity> {
    return this._entity$;
  }
  get pageTitle(): string {
    return this._pageTitle;
  }
}

import { Component, OnInit, OnDestroy } from "@angular/core";
import { HttpErrorResponse, HttpResponse } from "@angular/common/http";
import { ActivatedRoute, Router } from "@angular/router";
import { Subscription } from "rxjs";
import { JhiEventManager, JhiAlertService } from "ng-jhipster";
import { Observable } from "rxjs/Observable";
import { select, Store } from "@ngrx/store";

import { IKufangEntity } from "app/xtwh/kufang/models";
import { Principal } from "app/core";
import { KufangService } from "../service";
import * as link from "../kufang.constants";
import * as fromKufangs from "app/xtwh/kufang/reducers";
import {
  CollectionPageActions,
  ViewKufangPageActions
} from "app/xtwh/kufang/actions";

@Component({
  selector: "zy-kufang",
  templateUrl: "./kufang.component.html"
})
export class KufangComponent implements OnInit, OnDestroy {
  // kufangs$: Observable<Array<IKufangEntity>>;
  private _kufangs$: Observable<IKufangEntity[]>;

  currentAccount: any;
  eventSubscriber: Subscription;
  currentSearch: string;
  private _pageTitle: string;
  constructor(
    private kufangService: KufangService,
    private jhiAlertService: JhiAlertService,
    private eventManager: JhiEventManager,
    private activatedRoute: ActivatedRoute,
    private principal: Principal,
    private _router: Router,
    private store: Store<fromKufangs.State>
  ) {
    this.currentSearch =
      this.activatedRoute.snapshot &&
      this.activatedRoute.snapshot.params["search"]
        ? this.activatedRoute.snapshot.params["search"]
        : "";
    this.activatedRoute.data.subscribe(data => {
      this._pageTitle = data.pageTitle;
    });
    this._kufangs$ = store.pipe(select(fromKufangs.getKufangCollection));
  }

  loadAll() {
    this.store.dispatch(new CollectionPageActions.LoadCollection());
    // if (this.currentSearch) {
    //   this.kufangService
    //     .search({
    //       query: this.currentSearch
    //     })
    //     .subscribe(
    //       (res: HttpResponse<IKufangEntity[]>) => {
    //         this.rows$ = res.body;
    //       },
    //       (res: HttpErrorResponse) => this.onError(res.message)
    //     );
    //   return;
    // }
    this.kufangService.query().subscribe(
      (res: HttpResponse<IKufangEntity[]>) => {
        this.currentSearch = "";
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
  }

  search(query) {
    if (!query) {
      return this.clear();
    }
    this.currentSearch = query;
    this.loadAll();
  }

  onCreate(lx: string) {
    this._router.navigate([link.ROUTE_KUFANG_NEW]);
  }
  onLook(recordID: number) {
    const routerLink = link.ROUTE_KUFANG + "/" + recordID + "/view";
    this._router.navigate([routerLink]);
  }
  showEntity(kufang: IKufangEntity) {
    const id = kufang.id;
    this.store.dispatch(new ViewKufangPageActions.SelectKufang(id));
    this._router.navigate([link.ROUTE_KUFANG + "/" + id + "/view"]);
  }
  clear() {
    this.currentSearch = "";
    this.loadAll();
  }

  ngOnInit() {
    this.loadAll();
    this.registerChangeInKufangs();
  }

  ngOnDestroy() {
    this.eventManager.destroy(this.eventSubscriber);
  }

  trackId(index: number, item: IKufangEntity) {
    return item.id;
  }

  registerChangeInKufangs() {
    this.eventSubscriber = this.eventManager.subscribe(
      "kufangListModification",
      response => this.loadAll()
    );
  }
  get kufangs$(): Observable<IKufangEntity[]> {
    return this._kufangs$;
  }
  get pageTitle(): string {
    return this._pageTitle;
  }
  private onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }
}

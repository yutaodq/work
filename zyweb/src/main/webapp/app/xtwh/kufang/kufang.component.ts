import { Component, OnInit, OnDestroy } from "@angular/core";
import { HttpErrorResponse, HttpResponse } from "@angular/common/http";
import { ActivatedRoute, Router } from "@angular/router";
import { Subscription } from "rxjs";
import { JhiEventManager, JhiAlertService } from "ng-jhipster";
// import { Observable } from "rxjs/Observable";

import { IKufangEntity } from "app/shared/model/kufang.model";
import { Principal } from "app/core";
import { KufangService } from "./kufang.service";
// import { ZyCardTableComponent } from "app/core/components";
import * as path from "./kufang.constants";

@Component({
  selector: "zy-kufang",
  templateUrl: "./kufang.component.html"
})
export class KufangComponent implements OnInit, OnDestroy {
  // rows$: Observable<Array<IKufangEntity>>;
  rows$: Array<IKufangEntity>;

  currentAccount: any;
  eventSubscriber: Subscription;
  currentSearch: string;
  pageTitle: string;

  constructor(
    private kufangService: KufangService,
    private jhiAlertService: JhiAlertService,
    private eventManager: JhiEventManager,
    private activatedRoute: ActivatedRoute,
    private principal: Principal,
    private _router: Router
  ) {
    this.currentSearch =
      this.activatedRoute.snapshot &&
      this.activatedRoute.snapshot.params["search"]
        ? this.activatedRoute.snapshot.params["search"]
        : "";
    this.activatedRoute.data.subscribe(data => {
      this.pageTitle = data.pageTitle;
    });
  }

  loadAll() {
    if (this.currentSearch) {
      this.kufangService
        .search({
          query: this.currentSearch
        })
        .subscribe(
          (res: HttpResponse<IKufangEntity[]>) => {
            this.rows$ = res.body;
          },
          (res: HttpErrorResponse) => this.onError(res.message)
        );
      return;
    }
    this.kufangService.query().subscribe(
      (res: HttpResponse<IKufangEntity[]>) => {
        this.rows$ = res.body;

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
    console.log("父组件 ");
    this._router.navigate([path.ROUTE_KUFANG_NEW]);
  }

  clear() {
    this.currentSearch = "";
    this.loadAll();
  }

  ngOnInit() {
    // this.setPage({ offset: 0 });

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

  private onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }
}

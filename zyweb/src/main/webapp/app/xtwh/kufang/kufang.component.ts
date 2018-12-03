import { Component, OnInit, OnDestroy } from "@angular/core";
import { HttpErrorResponse, HttpResponse } from "@angular/common/http";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { JhiEventManager, JhiAlertService } from "ng-jhipster";
import { LocalDataSource } from "ng2-smart-table";

import { IKufangEntity } from "app/shared/model/kufang.model";
import { Principal } from "app/core";
import { KufangService } from "./kufang.service";

@Component({
  selector: "zy-kufang",
  templateUrl: "./kufang.component.html"
})
export class KufangComponent implements OnInit, OnDestroy {
  source: LocalDataSource = new LocalDataSource();

  // kufangs: IKufangEntity[];
  // kufangs = [];
  currentAccount: any;
  eventSubscriber: Subscription;
  currentSearch: string;
  pageTitle: string;

  settings = {
    add: {
      addButtonContent: '<i class="nb-plus"></i>',
      createButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>'
    },
    edit: {
      editButtonContent: '<i class="nb-edit"></i>',
      saveButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>'
    },
    delete: {
      deleteButtonContent: '<i class="nb-trash"></i>',
      confirmDelete: true
    },
    columns: {
      id: {
        title: "序号",
        type: "number",
        filter: false
      },
      identifier: {
        title: "标识",
        filter: false,
        type: "string"
      },
      name: {
        title: "库房名称",
        type: "string",
        filter: false
      }
    }
  };

  constructor(
    private kufangService: KufangService,
    private jhiAlertService: JhiAlertService,
    private eventManager: JhiEventManager,
    private activatedRoute: ActivatedRoute,
    private principal: Principal
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
            this.source = new LocalDataSource(res.body);
          },
          (res: HttpErrorResponse) => this.onError(res.message)
        );
      return;
    }
    this.kufangService.query().subscribe(
      (res: HttpResponse<IKufangEntity[]>) => {
        console.log("yyuuuuuuuu" + res.body);
        this.source = new LocalDataSource(res.body);

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

  clear() {
    this.currentSearch = "";
    this.loadAll();
  }

  ngOnInit() {
    this.loadAll();
    // this.principal.identity().then(account => {
    //   this.currentAccount = account;
    // });
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

  onSearch(query: String = "") {
    this.source.setFilter(
      [
        {
          field: "id",
          search: query
        },
        {
          field: "name",
          search: query
        }
      ],
      false
    );
  }
}

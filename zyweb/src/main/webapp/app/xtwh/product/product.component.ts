import {Component, OnInit, OnDestroy} from '@angular/core';
import {HttpErrorResponse, HttpResponse} from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';
import {Subscription} from 'rxjs';
import {JhiEventManager, JhiAlertService} from 'ng-jhipster';

import {IProductEntity} from 'app/shared/model/product.model';
import {Principal} from 'app/core';
import {ProductService} from './product.service';

@Component({
  selector: 'jhi-product',
  templateUrl: './product.component.html'
})
export class ProductComponent implements OnInit, OnDestroy {
  // productEntities: IProductEntity[];
  products: IProductEntity[];

  currentAccount: any;
  eventSubscriber: Subscription;
  currentSearch: string;
  pageTitle: string;

  constructor(
    private productService: ProductService,
    private jhiAlertService: JhiAlertService,
    private eventManager: JhiEventManager,
    private activatedRoute: ActivatedRoute,
    private principal: Principal
  ) {
    this.currentSearch =
      this.activatedRoute.snapshot && this.activatedRoute.snapshot.params['search']
        ? this.activatedRoute.snapshot.params['search']
        : '';
    this.activatedRoute.data.subscribe(data => {
      this.pageTitle = data.pageTitle;
    });
  }

  loadAll() {
    if (this.currentSearch) {
      this.productService
        .search({
          query: this.currentSearch
        })
        .subscribe(
          (res: HttpResponse<IProductEntity[]>) => (this.products = res.body),
          (res: HttpErrorResponse) => this.onError(res.message)
        );
      return;
    }
    this.productService.query().subscribe(
      (res: HttpResponse<IProductEntity[]>) => {
        // this.products = res.body;
        console.log('yyuuuuuuuu'+ res.body);
        this.products =  res.body;

        this.currentSearch = '';
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
    this.currentSearch = '';
    this.loadAll();
  }

  ngOnInit() {
    this.loadAll();
    // this.principal.identity().then(account => {
    //   this.currentAccount = account;
    // });
    this.registerChangeInProductes();
  }

  ngOnDestroy() {
    this.eventManager.destroy(this.eventSubscriber);
  }

  trackId(index: number, item: IProductEntity) {
    return item.id;
  }

  registerChangeInProductes() {
    this.eventSubscriber = this.eventManager.subscribe('productListModification', response => this.loadAll());
  }

  private onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }
}

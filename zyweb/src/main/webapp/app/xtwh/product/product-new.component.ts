import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { HttpResponse, HttpErrorResponse } from "@angular/common/http";
import { Observable } from "rxjs";
import { JhiAlertService } from "ng-jhipster";

import { IProductEntity } from "app/models";
import { ProductService } from "./product.service";

import { ProductFormGroup } from "./product-form-group";

@Component({
  selector: "zy-product-new",
  templateUrl: "./product-new.component.html"
})
export class ProductNewComponent implements OnInit {
  private _product: IProductEntity;
  isSaving: boolean;
  pageTitle: string;
  form: ProductFormGroup = new ProductFormGroup();

  constructor(
    private jhiAlertService: JhiAlertService,
    private productService: ProductService,
    private activatedRoute: ActivatedRoute
  ) {
    this.activatedRoute.data.subscribe(data => {
      this.pageTitle = data.pageTitle;
    });
  }

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ product }) => {
      this.product = product;
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    if (this.product.id !== undefined) {
      this.subscribeToSaveResponse(this.productService.update(this.product));
    } else {
      this.subscribeToSaveResponse(this.productService.create(this.product));
    }
  }

  private subscribeToSaveResponse(
    result: Observable<HttpResponse<IProductEntity>>
  ) {
    result.subscribe(
      (res: HttpResponse<IProductEntity>) => this.onSaveSuccess(),
      (res: HttpErrorResponse) => this.onSaveError()
    );
  }

  private onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  private onSaveError() {
    this.isSaving = false;
  }

  private onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }

  get product() {
    return this._product;
  }

  set product(product: IProductEntity) {
    this._product = product;
  }
}

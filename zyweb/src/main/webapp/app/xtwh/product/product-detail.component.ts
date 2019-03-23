import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

import { IProductEntity } from "app/models";

@Component({
  selector: "zy-product-detail",
  templateUrl: "./product-detail.component.html"
})
export class ProductDetailComponent implements OnInit {
  product: IProductEntity;
  pageTitle: string;
  constructor(private activatedRoute: ActivatedRoute) {
    this.activatedRoute.data.subscribe(data => {
      this.pageTitle = data.pageTitle;
    });
  }

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ product }) => {
      this.product = product;
      console.log(`在控制台打印ppppp:{}`, this.product.name);
    });
  }

  previousState() {
    window.history.back();
  }
}

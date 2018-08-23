import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IProductEntity } from 'app/shared/model/product.model';

@Component({
    selector: 'zy-product-detail',
    templateUrl: './product-detail.component.html'
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
        });
    }

    previousState() {
        window.history.back();
    }
}

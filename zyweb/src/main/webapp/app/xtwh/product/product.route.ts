import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { ProductEntity } from 'app/shared/model/product.model';
import { UserRouteAccessService } from 'app/core';

import { ProductService } from './product.service';
import { ProductComponent } from './product.component';
import {ProductDetailComponent } from './product-detail.component';
import {ProductUpdateComponent} from './product-update.component';
import {ProductNewComponent} from './product-new.component';

import { ProductDeletePopupComponent } from './product-delete-dialog.component';
import { IProductEntity } from 'app/shared/model/product.model';

@Injectable({ providedIn: 'root' })
export class ProductResolve implements Resolve<IProductEntity> {
    constructor(private service: ProductService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((product: HttpResponse<ProductEntity>) => product.body));
        }
        return of(new ProductEntity());
    }
}

export const productRoute: Routes = [
    {
        path: 'product',
        component: ProductComponent,
        data: { pageTitle: '工具列表：' },
      canActivate: [UserRouteAccessService]

    },
  {
    path: 'product/:id/view',
    component: ProductDetailComponent,
    resolve: {
      product: ProductResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: '工具-查看表单'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'product/:id/edit',
    component: ProductUpdateComponent,
    resolve: {
      product: ProductResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: '工具-修改记录表单'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'product/new',
    component: ProductNewComponent,
    resolve: {
      product: ProductResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: '工具-添加新记录表单'
    },
    canActivate: [UserRouteAccessService]
  },
];
export const productPopupRoute: Routes = [
  {
    path: 'product/:id/delete',
    component: ProductDeletePopupComponent,
    resolve: {
      product: ProductResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: '工具-删除记录表单'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];

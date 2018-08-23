import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ZyxtSharedModule } from 'app/shared';
import {
    ProductComponent,
    ProductDetailComponent,
    ProductUpdateComponent,
    ProductDeletePopupComponent,
    ProductDeleteDialogComponent,
    productRoute,
    productPopupRoute
} from './';

const PRODUCT_STATES = [...productRoute, ...productPopupRoute];
// const PRODUCT_STATES = [...productRoute];

@NgModule({
    imports: [ZyxtSharedModule, RouterModule.forChild(PRODUCT_STATES)],
    declarations: [
        ProductComponent,
        ProductDetailComponent,
        ProductUpdateComponent,
        ProductDeleteDialogComponent,
        ProductDeletePopupComponent
    ],
  entryComponents: [ProductComponent, ProductUpdateComponent, ProductDeleteDialogComponent, ProductDeletePopupComponent],
    // entryComponents: [ProductComponent, ProductUpdateComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProductModule {}

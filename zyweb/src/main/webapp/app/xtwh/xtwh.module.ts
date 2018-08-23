import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { ProductModule } from './product/product.module';

@NgModule({
    // prettier-ignore
    imports: [
      ProductModule
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ZyxtXtwhModule {}

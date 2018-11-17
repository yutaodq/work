import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";

import { ProductModule } from "./product/product.module";
import { KufangModule } from "app/xtwh/kufang/kufang.module";

@NgModule({
  imports: [ProductModule, KufangModule],
  declarations: [],
  entryComponents: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ZyxtXtwhModule {}

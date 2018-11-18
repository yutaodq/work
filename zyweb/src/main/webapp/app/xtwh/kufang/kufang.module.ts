import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { RouterModule } from "@angular/router";
import { ZyxtSharedModule } from "app/shared";
import { KufangComponent, kufangRoute } from "./";

const KUFANG_STATES = [...kufangRoute];

@NgModule({
  imports: [ZyxtSharedModule, RouterModule.forChild(KUFANG_STATES)],
  declarations: [KufangComponent],
  entryComponents: [KufangComponent],
  // entryComponents: [ProductComponent, ProductUpdateComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class KufangModule {}

import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { RouterModule } from "@angular/router";
import { HttpClientModule } from "@angular/common/http";
import { ZyxtSharedModule } from "app/shared";
import { CoreModule } from "app/core";
import { NebularModule } from "app/core";
import { NgxDatatableModule } from "@swimlane/ngx-datatable";
import {
  kufangRoute,
  KufangComponent,
  KufangDetailComponent,
  KufangNewComponent,
  KufangService,
  KufangFormService
} from "./";

import { DynamicFormsNGBootstrapUIModule } from "@ng-dynamic-forms/ui-ng-bootstrap";

const ROUTE = [...kufangRoute];

const IMPORTS_MODULES = [
  HttpClientModule,
  ZyxtSharedModule,
  CoreModule,
  NebularModule,
  NgxDatatableModule,
  DynamicFormsNGBootstrapUIModule
];
const COMPONENT = [KufangComponent, KufangDetailComponent, KufangNewComponent];
const ENTRY_COMPONENTS = [KufangComponent, KufangDetailComponent];
const SERVICE = [KufangFormService, KufangService];
@NgModule({
  imports: [...IMPORTS_MODULES, RouterModule.forChild(ROUTE)],
  declarations: [COMPONENT],
  entryComponents: [ENTRY_COMPONENTS],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [...SERVICE]
})
export class KufangModule {}

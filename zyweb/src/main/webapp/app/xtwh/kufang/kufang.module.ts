import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { RouterModule } from "@angular/router";
import { HttpClientModule } from "@angular/common/http";
import { Ng2SmartTableModule } from "ng2-smart-table";
import { ZyxtSharedModule } from "app/shared";
import { CoreModule } from "app/core";
import { NebularModule } from "app/core";
import { NgxDatatableModule } from "@swimlane/ngx-datatable";
import {
  kufangRoute,
  KufangComponent,
  KufangDetailComponent,
  KufangNewComponent,
  KufangFormModel
} from "./";

const ROUTE = [...kufangRoute];

const IMPORTS_MODULES = [
  HttpClientModule,
  ZyxtSharedModule,
  CoreModule,
  NebularModule,
  NgxDatatableModule,
  Ng2SmartTableModule
];
const COMPONENT = [KufangComponent, KufangDetailComponent, KufangNewComponent];
const ENTRY_COMPONENTS = [KufangComponent, KufangDetailComponent];

@NgModule({
  imports: [...IMPORTS_MODULES, RouterModule.forChild(ROUTE)],
  declarations: [COMPONENT],
  entryComponents: [ENTRY_COMPONENTS],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [KufangFormModel]
})
export class KufangModule {}

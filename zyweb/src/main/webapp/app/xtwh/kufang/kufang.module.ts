import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { RouterModule } from "@angular/router";
import { HttpClientModule } from "@angular/common/http";
import { NgxDatatableModule } from "@swimlane/ngx-datatable";
import { Ng2SmartTableModule } from "ng2-smart-table";
import { ZyxtSharedModule } from "app/shared";
import { KufangComponent, kufangRoute } from "./";
import { CoreModule } from "app/core";

const ROUTE = [...kufangRoute];
const IMPORTS_MODULES = [
  HttpClientModule,
  ZyxtSharedModule,
  CoreModule,
  NgxDatatableModule,
  Ng2SmartTableModule
];
const COMPONENT = [KufangComponent];
const ENTRY_COMPONENTS = [KufangComponent];

@NgModule({
  imports: [...IMPORTS_MODULES, RouterModule.forChild(ROUTE)],
  declarations: [COMPONENT],
  entryComponents: [ENTRY_COMPONENTS],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class KufangModule {}

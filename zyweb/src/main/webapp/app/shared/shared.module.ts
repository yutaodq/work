import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { ThemeNebularModule } from "./theme-nebular.module";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";
import { LayoutModule } from "./layout";

const BASE_MODULES = [
  CommonModule,
  ThemeNebularModule.forRoot(),
  RouterModule,
  LayoutModule
];
const EXPORTS_MODULES = [ThemeNebularModule, RouterModule, LayoutModule];

@NgModule({
  imports: [...BASE_MODULES],
  providers: [],
  exports: [...EXPORTS_MODULES],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ZyxtSharedModule {}

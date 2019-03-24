import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";

const BASE_MODULES = [CommonModule, RouterModule];
const EXPORTS_MODULES = [RouterModule];

@NgModule({
  imports: [...BASE_MODULES],
  providers: [],
  exports: [...EXPORTS_MODULES],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class LayoutModule {}

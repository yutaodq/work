import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { HomeComponent } from "./home.component";

@NgModule({
  imports: [],
  declarations: [HomeComponent],
  exports: [HomeComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ZyxtHomeModule {}

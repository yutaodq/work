import { NgModule, LOCALE_ID } from "@angular/core";
import { DatePipe, registerLocaleData } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { Title } from "@angular/platform-browser";
import locale from "@angular/common/locales/en";

import { AppComponent } from "./containers";
const CONTAINERS = [AppComponent];

import { SampleLayoutComponent } from "./components";

const COMPONENTS = [SampleLayoutComponent];
@NgModule({
  imports: [HttpClientModule],
  exports: [COMPONENTS, CONTAINERS],
  declarations: [COMPONENTS, CONTAINERS],
  providers: [
    Title,
    {
      provide: LOCALE_ID,
      useValue: "en"
    },
    DatePipe
  ]
})
export class ZyxtCoreModule {
  constructor() {
    registerLocaleData(locale);
  }
}

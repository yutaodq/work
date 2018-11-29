import { NgModule, LOCALE_ID } from "@angular/core";
import { DatePipe, registerLocaleData } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { Title } from "@angular/platform-browser";
import locale from "@angular/common/locales/en";
import { RouterModule } from "@angular/router";
import {
  NbLayoutModule,
  NbMenuModule,
  NbSidebarModule,
  NbThemeModule
} from "@nebular/theme";

const NB_MODULES = [NbLayoutModule, NbMenuModule, NbSidebarModule];

import { AppComponent } from "./containers";
const CONTAINERS = [AppComponent];

import { SampleLayoutComponent } from "./components";

const COMPONENTS = [SampleLayoutComponent];
@NgModule({
  imports: [
    HttpClientModule,
    RouterModule,
    NbThemeModule.forRoot(),
    NbMenuModule.forRoot(),
    NbSidebarModule.forRoot()
  ],
  exports: [...COMPONENTS, ...NB_MODULES],
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

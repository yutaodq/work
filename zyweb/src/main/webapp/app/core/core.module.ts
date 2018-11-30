import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import {
  NbLayoutModule,
  NbThemeModule,
  NbMenuModule,
  NbSidebarModule
} from "@nebular/theme";

const NB_MODULES = [NbLayoutModule];

import { AppComponent } from "./containers";

const CONTAINERS = [AppComponent];

import {
  SampleLayoutComponent,
  FooterComponent,
  HeaderComponent
} from "./components";

const COMPONENTS = [SampleLayoutComponent, FooterComponent, HeaderComponent];

import { AnalyticsService, UserService, LayoutService } from "app/core/service";
const SERVICE = [AnalyticsService, UserService, LayoutService];
@NgModule({
  imports: [
    RouterModule,
    NbThemeModule.forRoot({
      name: "corporate"
    }),
    NbMenuModule.forRoot(),
    NbSidebarModule.forRoot(),
    ...NB_MODULES
  ],
  exports: [...COMPONENTS, ...NB_MODULES],
  declarations: [COMPONENTS, CONTAINERS],
  providers: [...SERVICE]
})
export class ZyxtCoreModule {
  constructor() {}
}

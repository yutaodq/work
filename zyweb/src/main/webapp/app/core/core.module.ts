import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import {
  NbThemeModule,
  NbLayoutModule,
  NbMenuModule,
  NbSidebarModule
} from "@nebular/theme";

const NB_MODULES = [NbLayoutModule];

import { AppComponent } from "./containers";
const CONTAINERS = [AppComponent];

import { SampleLayoutComponent } from "./components";

const COMPONENTS = [SampleLayoutComponent];
@NgModule({
  imports: [
    RouterModule,
    NbThemeModule.forRoot({
      name: "corporate"
    }),
    ...NB_MODULES,
    NbMenuModule.forRoot(),
    NbSidebarModule.forRoot()
  ],
  exports: [...COMPONENTS, ...NB_MODULES],
  declarations: [COMPONENTS, CONTAINERS],
  providers: []
})
export class ZyxtCoreModule {
  constructor() {}
}

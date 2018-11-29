import "./vendor.ts";

import { NgModule, Injector } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { Ng2Webstorage } from "ngx-webstorage";
import { JhiEventManager } from "ng-jhipster";
import { HTTP_INTERCEPTORS } from "@angular/common/http";
// import { NbThemeModule } from "@nebular/theme";

import { StoreModule } from "@ngrx/store";
import { EffectsModule } from "@ngrx/effects";
import { StoreRouterConnectingModule } from "@ngrx/router-store";
import { StoreDevtoolsModule } from "@ngrx/store-devtools";

import { environment } from "../../../environments/environment";
import { ErrorHandlerInterceptor } from "./blocks/interceptor/errorhandler.interceptor";
import { NotificationInterceptor } from "./blocks/interceptor/notification.interceptor";
import { reducers, metaReducers } from "./reducers";

import { ZyxtAppRoutingModule } from "./app-routing.module";
import { ZyxtHomeModule } from "./home/index";
import { ZyxtAboutModule } from "./about/index";
import { ZyxtCoreModule } from "app/core/core.module";
import { ZyxtSharedModule } from "app/shared";
import {
  ZyxtMainComponent,
  FooterComponent,
  NavbarComponent,
  ErrorComponent,
  PageRibbonComponent
} from "./layouts";
import { ZyxtXtwhModule } from "app/xtwh/xtwh.module";
import { AppComponent } from "app/core/containers/app.component";
@NgModule({
  imports: [
    BrowserModule,
    ZyxtAppRoutingModule,
    Ng2Webstorage.forRoot({ prefix: "zy", separator: "-" }),
    ZyxtSharedModule,
    ZyxtCoreModule,
    ZyxtAboutModule,
    ZyxtXtwhModule,
    ZyxtHomeModule,
    // NbThemeModule.forRoot(),
    /**
     * StoreModule.forRoot is imported once in the root module, accepting a reducer
     * function or object map of reducer functions. If passed an object of
     * reducers, combineReducers will be run creating your application
     * meta-reducer. This returns all providers for an @ngrx/store
     * based application.
     */
    StoreModule.forRoot(reducers, { metaReducers }),

    /**
     * @ngrx/router-store keeps router state up-to-date in the store.
     */
    StoreRouterConnectingModule.forRoot(),

    /**
     * Store devtools instrument the store retaining past versions of state
     * and recalculating new states. This enables powerful time-travel
     * debugging.
     *
     * To use the debugger, install the Redux Devtools extension for either
     * Chrome or Firefox
     *
     * See: https://github.com/zalmoxisus/redux-devtools-extension
     */
    StoreDevtoolsModule.instrument({
      name: "NgRx Book Store App",
      logOnly: environment.production
    }),

    /**
     * EffectsModule.forRoot() is imported once in the root module and
     * sets up the effects class to be initialized immediately when the
     * application starts.
     *
     * See: https://github.com/ngrx/platform/blob/master/docs/effects/api.md#forroot
     */
    EffectsModule.forRoot([])
  ],
  declarations: [
    ZyxtMainComponent,
    FooterComponent,
    NavbarComponent,
    ErrorComponent,
    PageRibbonComponent
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorHandlerInterceptor,
      multi: true,
      deps: [JhiEventManager]
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: NotificationInterceptor,
      multi: true,
      deps: [Injector]
    }
  ],
  bootstrap: [AppComponent]
})
export class ZyxtAppModule {}

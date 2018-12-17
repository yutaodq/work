import "./vendor.ts";

import { NgModule, Injector } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";

import { Ng2Webstorage } from "ngx-webstorage";
import { JhiEventManager } from "ng-jhipster";
import { HTTP_INTERCEPTORS } from "@angular/common/http";

import { StoreModule } from "@ngrx/store";
import { EffectsModule } from "@ngrx/effects";
import { StoreRouterConnectingModule } from "@ngrx/router-store";
import { StoreDevtoolsModule } from "@ngrx/store-devtools";
// 一个开源的图标库
import { FontAwesomeModule } from "@fortawesome/angular-fontawesome";
import { DynamicFormsCoreModule } from "@ng-dynamic-forms/core";
import { DynamicFormsNGBootstrapUIModule } from "@ng-dynamic-forms/ui-ng-bootstrap";
import { environment } from "../../../environments/environment";
import { ErrorHandlerInterceptor } from "./blocks/interceptor/errorhandler.interceptor";
import { NotificationInterceptor } from "./blocks/interceptor/notification.interceptor";
import { reducers, metaReducers } from "./reducers";

import { ZyxtAppRoutingModule } from "./app-routing.module";
import { ZyxtHomeModule } from "./home";
import { ZyxtAboutModule } from "./about";
import { CoreModule } from "app/core/core.module";
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
    BrowserAnimationsModule,
    FontAwesomeModule,
    DynamicFormsCoreModule,
    DynamicFormsNGBootstrapUIModule,

    ZyxtAppRoutingModule,
    Ng2Webstorage.forRoot({ prefix: "zy", separator: "-" }),
    ZyxtSharedModule,
    ZyxtAboutModule,
    ZyxtXtwhModule,
    ZyxtHomeModule,
    CoreModule,
    /**
     * StoreModule.forRoot is imported once in the root module, accepting a reducer
     * function or object map of reducer functions. If passed an object of
     * reducers, combineReducers will be run creating your application
     * meta-reducer. This returns all providers for an @ngrx/store
     * based application.
     */
    /*StoreModule。在根模块中导入一次forRoot，接受一个还原函数或还原函数的对象映射。
     *如果传递了一个简化程序的对象，那么将运行组合还原程序来创建您的应用程序元简化程序。
     *这将返回基于@ngrx/store应用程序的所有提供者。
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

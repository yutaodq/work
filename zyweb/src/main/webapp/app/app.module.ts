import "./vendor.ts";

import { NgModule, Injector } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { Ng2Webstorage } from "ngx-webstorage";
import { JhiEventManager } from "ng-jhipster";
import { HTTP_INTERCEPTORS } from "@angular/common/http";

import { StoreModule } from "@ngrx/store";
import { EffectsModule } from "@ngrx/effects";
import { DBModule } from "@ngrx/db";
import { StoreRouterConnectingModule } from "@ngrx/router-store";
import { StoreDevtoolsModule } from "@ngrx/store-devtools";

// import { AuthExpiredInterceptor } from './blocks/interceptor/auth-expired.interceptor';
import { ErrorHandlerInterceptor } from "./blocks/interceptor/errorhandler.interceptor";
import { NotificationInterceptor } from "./blocks/interceptor/notification.interceptor";

import { ZyxtAppRoutingModule } from "./app-routing.module";
import { ZyxtHomeModule } from "./home/index";
import { ZyxtAboutModule } from "./about/index";
import { ZyxtCoreModule } from "app/core";
import { ZyxtSharedModule } from "app/shared";
import {
  ZyxtMainComponent,
  FooterComponent,
  NavbarComponent,
  ErrorComponent,
  PageRibbonComponent
} from "./layouts";
import { ZyxtXtwhModule } from "app/xtwh/xtwh.module";

@NgModule({
  imports: [
    BrowserModule,
    ZyxtAppRoutingModule,
    Ng2Webstorage.forRoot({ prefix: "zy", separator: "-" }),
    ZyxtSharedModule,
    ZyxtCoreModule,
    ZyxtAboutModule,
    ZyxtXtwhModule,
    ZyxtHomeModule
  ],
  declarations: [
    ZyxtMainComponent,
    FooterComponent,
    NavbarComponent,
    ErrorComponent,
    PageRibbonComponent
  ],
  providers: [
    // AuthExpiredInterceptor 的功能还没有实现
    // {
    //   provide: HTTP_INTERCEPTORS,
    //   useClass: AuthExpiredInterceptor,
    //   multi: true,
    //   deps: [
    //     Injector
    //   ]
    // },
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
  bootstrap: [ZyxtMainComponent]
})
export class ZyxtAppModule {}

import "./vendor.ts";

import { NgModule, Injector } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";

import { Ng2Webstorage } from "ngx-webstorage";
import { HTTP_INTERCEPTORS } from "@angular/common/http";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";

import { StoreModule } from "@ngrx/store";
import { EffectsModule } from "@ngrx/effects";
import {
  StoreRouterConnectingModule,
  RouterStateSerializer
} from "@ngrx/router-store";
import { StoreDevtoolsModule } from "@ngrx/store-devtools";

// 一个开源的图标库
import { FontAwesomeModule } from "@fortawesome/angular-fontawesome";
import { DynamicFormsCoreModule } from "@ng-dynamic-forms/core";

// import { reducers, metaReducers } from "./store/reducers";
import * as fromStore from "./store";

import { environment } from "../../../environments/environment";
// import { ErrorHandlerInterceptor } from "./blocks/interceptor/errorhandler.interceptor";
// import { NotificationInterceptor } from "./blocks/interceptor/notification.interceptor";
import { ZyxtAppRoutingModule } from "./app-routing.module";
// import { HomeModule } from "./features/home";
import { ZyxtAboutModule } from "./about";
import { CoreModule } from "app/core";
import { ZyxtSharedModule } from "app/shared";
import { ZyxtXtwhModule } from "app/xtwh/xtwh.module";
// import { ThemeModule } from "./theme";
import { UserModule } from "./user";

import { AppComponent } from "app/core/containers/app.component";

@NgModule({
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FontAwesomeModule,
    ReactiveFormsModule,
    FormsModule,
    DynamicFormsCoreModule,
    HttpClientModule,

    ZyxtAppRoutingModule,

    Ng2Webstorage.forRoot({ prefix: "zy", separator: "-" }),
    ZyxtSharedModule,
    ZyxtAboutModule,
    ZyxtXtwhModule,
    // HomeModule,
    CoreModule,
    UserModule,
    NgbModule,
    // ThemeModule.forRoot(),

    /*StoreModule。在根模块中导入一次forRoot，接受一个还原函数或还原函数的对象映射。
     *如果传递了一个简化程序的对象，那么将运行组合还原程序来创建您的应用程序元简化程序。
     *这将返回基于@ngrx/store应用程序的所有提供者。
     */
    StoreModule.forRoot(fromStore.reducers, {
      metaReducers: fromStore.metaReducers
    }),

    StoreRouterConnectingModule.forRoot(),

    StoreDevtoolsModule.instrument({
      name: "NgRx Book Store App",
      logOnly: environment.production
    }),
    // EffectsModule.forRoot(effects),
    EffectsModule.forRoot([])
  ],
  declarations: [],
  providers: [],
  bootstrap: [AppComponent]
})
export class ZyxtAppModule {}

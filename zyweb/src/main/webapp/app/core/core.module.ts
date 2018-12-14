import {
  CUSTOM_ELEMENTS_SCHEMA,
  ModuleWithProviders,
  NgModule
} from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ExtraOptions, RouterModule, Routes } from "@angular/router";
import { NebularModule } from "app/core/nebular.module";
// 不加"FontAwesomeModule" core模块中的组件不显示图标
import { FontAwesomeModule } from "@fortawesome/angular-fontawesome";

import { AppComponent } from "./containers";

import {
  SampleLayoutComponent,
  FooterComponent,
  HeaderComponent,
  ZyCardHeaderComponent
} from "./components";

const COMPONENTS = [
  AppComponent,
  SampleLayoutComponent,
  FooterComponent,
  HeaderComponent,
  ZyCardHeaderComponent
];

const BASE_MODULES = [
  CommonModule,
  FormsModule,
  ReactiveFormsModule,
  FontAwesomeModule
];

import { AnalyticsService, UserService, LayoutService } from "app/core/service";

const SERVICE = [AnalyticsService, UserService, LayoutService];

@NgModule({
  imports: [...BASE_MODULES, RouterModule, NebularModule.forRoot()],
  exports: [...BASE_MODULES, ...COMPONENTS, NebularModule],
  declarations: [...COMPONENTS],
  providers: [...SERVICE],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CoreModule {}

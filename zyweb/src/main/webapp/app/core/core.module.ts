import {
  CUSTOM_ELEMENTS_SCHEMA,
  ModuleWithProviders,
  NgModule
} from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ExtraOptions, RouterModule, Routes } from "@angular/router";
// import { NebularModule } from "../nebular";
import { NbDialogModule, NbWindowModule } from "@nebular/theme";

import { ThemeModule } from "app/theme";

// 不加"FontAwesomeModule" core模块中的组件不显示图标
import { FontAwesomeModule } from "@fortawesome/angular-fontawesome";

import { AppComponent } from "./containers";

import {
  // SampleLayoutCoreComponent,
  // FooterComponent,
  // HeaderComponent,
  ZyCardTableComponent,
  ZyTableColumnActionComponent,
  ZyTableButtonComponent,
  ZyFormHeaderComponent,
  ZyFormLayoutsComponent,
  SelectedPageButtonComponent,
  NewPageButtonComponent,
  RemoveDialogComponent,
  DialogButtonComponent
} from "./components";

import { AnalyticsService, UserService, LayoutService } from "app/core/service";

const COMPONENTS = [
  AppComponent,
  // SampleLayoutCoreComponent,
  // FooterComponent,
  // HeaderComponent,
  ZyCardTableComponent,
  ZyTableColumnActionComponent,
  ZyTableButtonComponent,
  ZyFormHeaderComponent,
  ZyFormLayoutsComponent,
  SelectedPageButtonComponent,
  NewPageButtonComponent,
  RemoveDialogComponent,
  DialogButtonComponent
];

const BASE_MODULES = [
  CommonModule,
  FormsModule,
  ReactiveFormsModule,
  FontAwesomeModule,
  ThemeModule,
  NbDialogModule.forChild()
];

const SERVICE = [AnalyticsService, UserService, LayoutService];
const ENTRY_COMPONENTS = [RemoveDialogComponent];

@NgModule({
  imports: [...BASE_MODULES, RouterModule],
  // exports: [...BASE_MODULES, ...COMPONENTS],
  exports: [, ...COMPONENTS],
  declarations: [...COMPONENTS],
  providers: [...SERVICE],
  entryComponents: [...ENTRY_COMPONENTS],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CoreModule {}

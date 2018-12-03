import { ModuleWithProviders, NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ExtraOptions, RouterModule, Routes } from "@angular/router";
import { NebularModule } from "app/core/nebular.module";

import { AppComponent } from "./containers";

import {
  SampleLayoutComponent,
  FooterComponent,
  HeaderComponent
} from "./components";

const COMPONENTS = [
  AppComponent,
  SampleLayoutComponent,
  FooterComponent,
  HeaderComponent
];

const BASE_MODULES = [CommonModule, FormsModule, ReactiveFormsModule];

import { AnalyticsService, UserService, LayoutService } from "app/core/service";

const SERVICE = [AnalyticsService, UserService, LayoutService];

@NgModule({
  imports: [...BASE_MODULES, RouterModule, NebularModule.forRoot()],
  exports: [...BASE_MODULES, ...COMPONENTS, NebularModule],
  declarations: [...COMPONENTS],
  providers: [...SERVICE]
})
export class CoreModule {}

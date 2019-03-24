import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";
import { ThemeNebularModule } from "../theme-nebular.module";
import { MainLayoutComponent, HomeLayoutComponent } from "./app-layouts";
import { HeaderComponent } from "./header";
import { FooterComponent } from "./footer";

const BASE_MODULES = [CommonModule, RouterModule, ThemeNebularModule];
const EXPORTS_MODULES = [RouterModule];
const COMPONENT = [
  MainLayoutComponent,
  HomeLayoutComponent,
  HeaderComponent,
  FooterComponent
];
const EXPORTS_COMPONENT = [RouterModule, HeaderComponent, FooterComponent];

@NgModule({
  imports: [...BASE_MODULES],
  declarations: [...COMPONENT],
  providers: [],
  exports: [...EXPORTS_MODULES, ...EXPORTS_COMPONENT],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class LayoutModule {}

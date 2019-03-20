import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { DynamicFormsNGBootstrapUIModule } from "@ng-dynamic-forms/ui-ng-bootstrap";

import { ThemeModule } from "app/theme";
import { CoreModule } from "app/core";

import { UserRoutingModule } from "./user-routing.module";
import { LoginFormComponent } from "./component";
import { LoginPageComponent } from "./containers";
import { UserService } from "./service";

const IMPORTS_MODULES = [
  CommonModule,
  ThemeModule,
  DynamicFormsNGBootstrapUIModule,
  CoreModule,
  UserRoutingModule
];
@NgModule({
  imports: [...IMPORTS_MODULES],

  declarations: [LoginPageComponent, LoginFormComponent],
  providers: [UserService]
})
export class UserModule {}

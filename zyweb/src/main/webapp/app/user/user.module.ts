import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { DynamicFormsNGBootstrapUIModule } from "@ng-dynamic-forms/ui-ng-bootstrap";
import { EffectsModule } from "@ngrx/effects";
import { StoreModule } from "@ngrx/store";

import { ThemeModule } from "app/theme";
import { CoreModule } from "app/core";

import { UserRoutingModule } from "./user-routing.module";
import { LoginFormComponent } from "./component";
import { LoginPageComponent } from "./containers";
import { UserService } from "./service";
import { UserEffects } from "./effects";
import { reducers } from "./reducers";

const IMPORTS_MODULES = [
  CommonModule,
  ThemeModule,
  EffectsModule,
  DynamicFormsNGBootstrapUIModule,
  CoreModule,
  UserRoutingModule
];
const COMPONENT = [LoginPageComponent, LoginFormComponent];

const SERVICE = [UserService];

@NgModule({
  imports: [
    ...IMPORTS_MODULES,
    StoreModule.forFeature("users", reducers),
    EffectsModule.forFeature([UserEffects])
  ],

  declarations: [...COMPONENT],
  providers: [...SERVICE]
})
export class UserModule {}

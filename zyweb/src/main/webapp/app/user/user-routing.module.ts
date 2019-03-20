import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

import { LoginPageComponent } from "./containers";
const routes: Routes = [
  {
    path: "login",
    component: LoginPageComponent,
    data: { pageTitle: "登录" }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule {}

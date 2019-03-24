import { NgModule } from "@angular/core";
import { Routes, RouterModule, ExtraOptions } from "@angular/router";
import { HomeComponent } from "./home";

import { MainLayoutComponent } from "./shared/layout";
// import { AuthLayoutComponent } from "./shared/layout/app-layouts/auth-layout.component";
// import { HomeLayoutComponent } from "./shared/layout/app-layouts/home-layout.component";

const ROUTES: Routes = [
  // { path: "", redirectTo: "home", pathMatch: "full" },
  {
    path: "",
    component: MainLayoutComponent,
    data: { pageTitle: "Home" }
    // children: [
    //   {
    //     path: "",
    //     redirectTo: "dashboard/analytics",
    //     pathMatch: "full"
    //   }
    // ]
  },
  { path: "home", component: HomeComponent }
];

const CONFIG: ExtraOptions = {
  useHash: true
};

@NgModule({
  imports: [RouterModule.forRoot([...ROUTES], CONFIG)],
  exports: [RouterModule]
})
export class ZyxtAppRoutingModule {}

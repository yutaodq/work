import { NgModule } from "@angular/core";
import { Routes, RouterModule, ExtraOptions } from "@angular/router";
// import { HomeComponent } from "./home";

import { MainLayoutComponent } from "./shared/layout";
import { AboutComponent } from "app/about";
import { HomeComponent } from "app/features/home/home.component";
import { KufangComponent } from "app/xtwh/kufang";
// import { AuthLayoutComponent } from "./shared/layout/app-layouts/auth-layout.component";
// import { HomeLayoutComponent } from "./shared/layout/app-layouts/home-layout.component";

const ROUTES: Routes = [
  // { path: "", redirectTo: "home", pathMatch: "full" },
  {
    path: "",
    component: MainLayoutComponent,
    data: { pageTitle: "Home" },
    children: [
      {
        path: "",
        redirectTo: "home",
        // loadChildren: "./features/home/home.module#HomeModule",
        pathMatch: "full"
      },
      {
        path: "home",
        loadChildren: "./features/home/home.module#HomeModule",
        data: { pageTitle: "App Views" }
      },
      {
        path: "kufang",
        component: KufangComponent,
        // loadChildren: "./features/home/home.module#HomeModule",
        data: { pageTitle: "App Views" }
      }
    ]
  },
  { path: "about", component: AboutComponent }
];

const CONFIG: ExtraOptions = {
  useHash: true
};

@NgModule({
  imports: [RouterModule.forRoot([...ROUTES], CONFIG)],
  exports: [RouterModule]
})
export class ZyxtAppRoutingModule {}

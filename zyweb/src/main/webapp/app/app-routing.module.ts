import { NgModule } from "@angular/core";
import { Routes, RouterModule, ExtraOptions } from "@angular/router";

import { MainLayoutComponent } from "./shared/layout";
import { KufangComponent } from "app/xtwh/kufang";

const ROUTES: Routes = [
  // { path: "", redirectTo: "home", pathMatch: "full" },
  {
    path: "",
    component: MainLayoutComponent,
    data: { pageTitle: "Home" },
    children: [
      {
        path: "",
        redirectTo: "kufang",
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
  // { path: "about", component: AboutComponent }
  { path: "about", loadChildren: "./about/about.module#AboutModule" }

];

const CONFIG: ExtraOptions = {
  useHash: true
};

@NgModule({
  imports: [RouterModule.forRoot([...ROUTES], CONFIG)],
  exports: [RouterModule]
})
export class ZyxtAppRoutingModule {}

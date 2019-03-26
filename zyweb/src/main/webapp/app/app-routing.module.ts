import { NgModule } from "@angular/core";
import { Routes, RouterModule, ExtraOptions } from "@angular/router";
// import { HomeComponent } from "./home";

import { MainLayoutComponent } from "./shared/layout";
import { AboutComponent } from "app/about";
import { HomeComponent } from "app/features/home/home.component";
import { KufangComponent } from "app/xtwh/kufang";

const routes: Routes = [
  // { path: "", redirectTo: "home", pathMatch: "full" },
  {
    path: "",
    component: MainLayoutComponent,
    data: { pageTitle: "Home" },
    children: [
      {
        path: "",
        redirectTo: "kufang",
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
  { path: "about", loadChildren: "./about/about.module#AboutModule" }
  // { path: "aboutds", component: AboutComponent }
];

const CONFIG: ExtraOptions = {
  useHash: true,
  enableTracing: true
};
// imports: [RouterModule.forRoot([...routes], CONFIG)],

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { useHash: true, enableTracing: true })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}

import { ModuleWithProviders } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from "app/features/home/home.component";

export const routes: Routes = [
  {
    path: "",
    component: HomeComponent,
    // loadChildren: "./main/main.module#MainModule",
    pathMatch: "full"
  }
  // {
  //   path: "main",
  //   loadChildren: "./main/main.module#MainModule"
  // }
];

export const routing = [RouterModule.forChild(routes)];

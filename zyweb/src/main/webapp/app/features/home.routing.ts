import { ModuleWithProviders } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

export const routes: Routes = [
  {
    path: "",
    loadChildren: "./main/main.module#MainModule",
    pathMatch: "full"
  },
  {
    path: "main",
    loadChildren: "./main/main.module#MainModule"
  }
];

export const routing = [RouterModule.forChild(routes)];

import { NgModule } from "@angular/core";
import { Routes, RouterModule, ExtraOptions } from "@angular/router";
import { HomeComponent } from "./home";
const ROUTES: Routes = [
  { path: "home", component: HomeComponent },
  { path: "", redirectTo: "home", pathMatch: "full" }
];
const CONFIG: ExtraOptions = {
  useHash: true
};
@NgModule({
  imports: [RouterModule.forRoot([...ROUTES], CONFIG)],

  exports: [RouterModule]
})
export class ZyxtAppRoutingModule {}

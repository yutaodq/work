import { Routes, RouterModule } from "@angular/router";

import { AboutComponent } from "./";
import { NgModule } from "@angular/core";

const routes: Routes = [
  {
    path: "",
    component: AboutComponent,
    data: {
      authorities: [],
      pageTitle: "Welcome, Java Hipster!"
    }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AboutRoutingModule {}

import { Routes, RouterModule } from "@angular/router";
import { NgModule } from "@angular/core";
import { AboutComponent } from "app/about/about.component";

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

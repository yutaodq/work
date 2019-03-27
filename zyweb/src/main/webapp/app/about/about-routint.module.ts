import { Routes, RouterModule } from "@angular/router";
import { NgModule } from "@angular/core";
import { AboutComponent } from "app/about/about.component";

const routes: Routes = [{
    path: 'about',
    component: AboutComponent,
    data: {
        authorities: [],
        pageTitle: 'Welcome, Java Hipster!'
    }
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AboutRoutingModule { }

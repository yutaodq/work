import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from "app/features/home/home.component";
import { NgModule } from "@angular/core";

export const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  }
];

// export const routing = [RouterModule.forChild(routes)];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class HomeRoutingModule {}

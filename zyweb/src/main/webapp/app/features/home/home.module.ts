import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { HomeRoutingModule } from "./home-routing.module";
import { HomeComponent } from "app/features/home/home.component";

const IMPORTS_MODULES = [CommonModule, HomeRoutingModule];
const COMPONENT = [HomeComponent];
@NgModule({
  imports: [...IMPORTS_MODULES],
  declarations: [...COMPONENT],
  exports: []
})
export class HomeModule {}

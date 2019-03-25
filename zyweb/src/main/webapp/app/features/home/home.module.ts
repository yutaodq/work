import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { routing } from "./home.routing";
import { HomeComponent } from "app/features/home/home.component";

const IMPORTS_MODULES = [CommonModule, routing];
const COMPONENT = [HomeComponent];
@NgModule({
  imports: [...IMPORTS_MODULES],
  declarations: [...COMPONENT],
  exports: []
})
export class HomeModule {}

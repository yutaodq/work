import { NgModule } from "@angular/core";
<<<<<<< HEAD
import { AboutRoutingModule } from "app/about/about-routint.module";
import { CommonModule } from "@angular/common";
import { AboutComponent } from "app/about/about.component";

@NgModule({
  imports: [CommonModule, AboutRoutingModule],
  declarations: [AboutComponent],
=======
import { CommonModule } from "@angular/common";
import { AboutRoutingModule, AboutComponent } from "./index";

const IMPORTS_MODULES = [CommonModule, AboutRoutingModule];
const COMPONENT = [AboutComponent];

@NgModule({
  imports: [...IMPORTS_MODULES],
  declarations: [...COMPONENT]
>>>>>>> 055e1cd8a4bcb67b9871aabcbb78244ea310cefa
})
export class AboutModule {}

import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { AboutRoutingModule, AboutComponent } from "./index";

const IMPORTS_MODULES = [CommonModule, AboutRoutingModule];
const COMPONENT = [AboutComponent];

@NgModule({
  imports: [...IMPORTS_MODULES],
  declarations: [...COMPONENT]
})
export class AboutModule {}

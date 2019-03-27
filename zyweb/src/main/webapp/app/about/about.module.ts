import { NgModule } from "@angular/core";
import { AboutRoutingModule } from "app/about/about-routint.module";
import { CommonModule } from "@angular/common";
import { AboutComponent } from "app/about/about.component";

@NgModule({
  imports: [CommonModule, AboutRoutingModule],
  declarations: [AboutComponent],
})
export class ZyxtAboutModule {}

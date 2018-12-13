import { Component, Input } from "@angular/core";

@Component({
  selector: "zy-card-header",
  templateUrl: "./zy-card-header.component.html"
})
export class ZyCardHeaderComponent {
  @Input("title") title: string;
}

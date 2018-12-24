import { Component, Input, EventEmitter, Output } from "@angular/core";

@Component({
  selector: "zy-table-button",
  templateUrl: "./zy-table-button.component.html"
})
export class ZyTableButtonComponent {
  @Output() createButtonClick = new EventEmitter<string>();
  onCreate(): void {
    this.createButtonClick.emit("abc");
  }
}

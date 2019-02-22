import { Component, OnInit, Output, EventEmitter } from "@angular/core";

@Component({
  selector: "zy-new-page-button",
  templateUrl: "./new-page-button.component.html"
})
export class NewPageButtonComponent {
  @Output() cancel = new EventEmitter<IKufangEntity>();
  @Output() save = new EventEmitter<IKufangEntity>();

  onCancel() {
    this.cancel.emit("cancel");
  }

  onSave() {
    this.save.emit("this.kufangEntity");
  }
}

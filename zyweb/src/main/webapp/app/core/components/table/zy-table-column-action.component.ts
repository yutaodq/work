import { Component, Input, EventEmitter, Output } from "@angular/core";

@Component({
  selector: "zy-table-column-action",
  templateUrl: "./zy-table-column-action.component.html"
})
export class ZyTableColumnActionComponent {
  private _caption = "操作";
  @Output() lookRecord = new EventEmitter<string>();

  onLookRecord(): void {
    console.log("The child speak status is ");
    this.lookRecord.emit("abc");
  }
  @Input()
  set caption(value: string) {
    this._caption = value;
  }

  get caption(): string {
    return this._caption;
  }
}

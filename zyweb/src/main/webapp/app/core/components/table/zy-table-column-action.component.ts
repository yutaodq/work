import { Component, Input, EventEmitter, Output } from "@angular/core";

@Component({
  selector: "zy-table-column-action",
  templateUrl: "./zy-table-column-action.component.html"
})
export class ZyTableColumnActionComponent {
  // private _caption = "操作";
  @Output() lookRecord = new EventEmitter<number>();
  @Input() private _recordID: number;
  onLookRecord(): void {
    console.log("The child speak status is ");
    this.lookRecord.emit(this._recordID);
  }
  @Input()
  set recordID(value: number) {
    this._recordID = value;
  }

  get recordID(): number {
    return this._recordID;
  }
}

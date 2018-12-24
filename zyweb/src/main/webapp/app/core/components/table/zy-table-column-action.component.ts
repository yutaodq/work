import { Component, Input, EventEmitter, Output } from "@angular/core";

@Component({
  selector: "zy-table-column-action",
  templateUrl: "./zy-table-column-action.component.html"
})
export class ZyTableColumnActionComponent {
  @Output() lookRecord = new EventEmitter<number>();
  @Input() private _recordID: number;
  onLookRecord(): void {
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

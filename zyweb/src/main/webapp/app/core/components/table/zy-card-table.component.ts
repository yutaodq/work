import { Component, Input, EventEmitter, Output } from "@angular/core";

@Component({
  selector: "zy-card-table",
  templateUrl: "./zy-card-table.component.html"
})
export class ZyCardTableComponent {
  private _title: string;
  @Output() createRecord = new EventEmitter<string>();

  create(): void {
    console.log("The child speak status is ");
    this.createRecord.emit("abc");
  }

  @Input()
  set title(value: string) {
    this._title = value;
  }

  get title(): string {
    return this._title;
  }
}

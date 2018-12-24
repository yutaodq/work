import { Component, Input, EventEmitter, Output } from "@angular/core";

@Component({
  selector: "zy-form",
  templateUrl: "./zy-form.component.html"
})
export class ZyFormComponent {
  private _title: string;

  @Input()
  set title(value: string) {
    this._title = value;
  }

  get title(): string {
    return this._title;
  }
}

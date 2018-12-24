import { Component, Input, EventEmitter, Output } from "@angular/core";

@Component({
  selector: "zy-form-header",
  template: " <h4> {{title}} </h4>  "
})
export class ZyFormHeaderComponent {
  private _title: string;

  @Input()
  set title(value: string) {
    this._title = value;
  }

  get title(): string {
    return this._title;
  }
}

import { Component, EventEmitter, Input, Output } from "@angular/core";
import * as dialog from "app/app.constants";

@Component({
  selector: "zy-dialog-button",
  templateUrl: `./dialog-button.component.html`
})
export class DialogButtonComponent {
  private _noButtonCaption = "否";
  private _yesButtonCaption = "是";

  @Output() noButtonClick = new EventEmitter<string>();
  @Output() yesButtonClick = new EventEmitter<string>();

  onZyNo(): void {
    this.noButtonClick.emit(dialog.DIALOG_NO);
  }
  onZyYes(): void {
    this.yesButtonClick.emit(dialog.DIALOG_YES);
  }

  @Input()
  set noButtonCaption(value: string) {
    this._noButtonCaption = value;
  }
  get noButtonCaption(): string {
    return this._noButtonCaption;
  }

  @Input()
  set yesButtonCaption(value: string) {
    this._yesButtonCaption = value;
  }
  get yesButtonCaption(): string {
    return this._yesButtonCaption;
  }
}

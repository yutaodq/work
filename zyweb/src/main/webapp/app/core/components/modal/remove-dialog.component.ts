import { Component, Input } from "@angular/core";
import { NbDialogRef } from "@nebular/theme";

@Component({
  selector: "zy-remove-dialog",
  templateUrl: "./remove-dialog.component.html"
})
export class RemoveDialogComponent {
  private _title: string;
  private _cancelButtonCaption = "否";
  private _submitButtonCaption = "是";
  constructor(protected ref: NbDialogRef<RemoveDialogComponent>) {}
  cancel() {
    this.ref.close("No");
  }
  submit() {
    this.ref.close("Yes");
  }

  @Input()
  set title(value: string) {
    this._title = value;
  }
  get title(): string {
    return this._title;
  }

  @Input()
  set cancelButtonCaption(value: string) {
    this._cancelButtonCaption = value;
  }
  get cancelButtonCaption(): string {
    return this._cancelButtonCaption;
  }

  @Input()
  set submitButtonCaption(value: string) {
    this._submitButtonCaption = value;
  }
  get submitButtonCaption(): string {
    return this._submitButtonCaption;
  }
}
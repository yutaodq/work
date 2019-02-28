import { Component, Input } from "@angular/core";
import { NbDialogRef } from "@nebular/theme";
import * as dialog from "app/app.constants";

@Component({
  selector: "zy-remove-dialog",
  templateUrl: "./remove-dialog.component.html"
})
export class RemoveDialogComponent {
  private _title: string;
  private _cancelButtonCaption = "否";
  private _deleteButtonCaption = "是";
  private _promptMessage = "您确定要删除这个记录吗？";

  constructor(private _refDialog: NbDialogRef<RemoveDialogComponent>) {}

  onCancel() {
    this.closeDialog(dialog.DIALOG_NO);
  }
  private closeDialog(closeType: string) {
    this._refDialog.close(closeType);
  }
  onDelete() {
    this.closeDialog(dialog.DIALOG_YES);
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
  set deleteButtonCaption(value: string) {
    this._deleteButtonCaption = value;
  }
  get deleteButtonCaption(): string {
    return this._deleteButtonCaption;
  }
  @Input()
  set promptMessage(value: string) {
    this._promptMessage = value;
  }
  get promptMessage(): string {
    return this._promptMessage;
  }
}

import { Component, OnInit, Output, EventEmitter, Input } from "@angular/core";
import { IKufangEntity } from "app/xtwh/kufang";

@Component({
  selector: "zy-new-page-button",
  templateUrl: "../../../template/new-page-button.component.html"
})
export class NewPageButtonComponent {
  private _cancelButtonCaption = "取消创建";
  private _saveButtonCaption = "保存记录";
  private _recoverButtonCaption = "恢复初始值";

  @Output() cancelButtonClick = new EventEmitter<string>();
  @Output() saveButtonClick = new EventEmitter<string>();
  @Output() recoverButtonClick = new EventEmitter<string>();

  onCancel() {
    this.cancelButtonClick.emit("cancel");
  }

  onSave() {
    this.saveButtonClick.emit("save");
  }

  onRecover() {
    this.recoverButtonClick.emit("recover");
  }

  @Input()
  set cancelButtonCaption(value: string) {
    this._cancelButtonCaption = value;
  }
  get cancelButtonCaption(): string {
    return this._cancelButtonCaption;
  }
  @Input()
  set saveButtonCaption(value: string) {
    this._saveButtonCaption = value;
  }
  get saveButtonCaption(): string {
    return this._saveButtonCaption;
  }
  @Input()
  set recoverButtonCaption(value: string) {
    this._recoverButtonCaption = value;
  }
  get recoverButtonCaption(): string {
    return this._recoverButtonCaption;
  }
}

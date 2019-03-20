import { Component, EventEmitter, Input, Output } from "@angular/core";

@Component({
  selector: "zy-confirm-cancel-button",
  templateUrl: `./confirm-cancel-button.component.html`
})
export class ConfirmCancelButtonComponent {
  private _confirmButtonCaption = "确定";
  private _cancelButtonCaption = "取消";

  @Output() confirmButtonClick = new EventEmitter<string>();
  @Output() cancelButtonClick = new EventEmitter<string>();

  onConfirm(): void {
    this.confirmButtonClick.emit();
  }
  onCancel(): void {
    this.cancelButtonClick.emit();
  }

  @Input()
  set confirmButtonCaption(value: string) {
    this._confirmButtonCaption = value;
  }
  get confirmButtonCaption(): string {
    return this._confirmButtonCaption;
  }
  @Input()
  set cancelButtonCaption(value: string) {
    this._cancelButtonCaption = value;
  }
  get cancelButtonCaption(): string {
    return this._cancelButtonCaption;
  }
}

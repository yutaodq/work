import { Component, EventEmitter, Input, Output } from "@angular/core";

@Component({
  selector: "zy-selected-page-button",
  templateUrl: `./selected-page-button.component.html`
})
export class SelectedPageButtonComponent {
  private _toListButtonCaption = "返回列表";
  private _createButtonCaption = "新建记录";
  private _deleteButtonCaption = "删除记录";

  @Output() toListButtonClick = new EventEmitter<string>();
  @Output() createButtonClick = new EventEmitter<string>();
  @Output() deleteButtonClick = new EventEmitter<string>();

  // constructor(
  //   private store: Store<fromKufangs.State>,
  // ) {}

  onZyList(): void {
    this.toListButtonClick.emit("abc");
  }
  onZyCreate(): void {
    this.createButtonClick.emit("abc");
  }
  onZyDelete(): void {
    this.deleteButtonClick.emit("abc");
  }

  @Input()
  set toListButtonCaption(value: string) {
    this._toListButtonCaption = value;
  }
  get toListButtonCaption(): string {
    return this._toListButtonCaption;
  }
  @Input()
  set createButtonCaption(value: string) {
    this._createButtonCaption = value;
  }
  get createButtonCaption(): string {
    return this._createButtonCaption;
  }
  @Input()
  set deleteButtonCaption(value: string) {
    this._deleteButtonCaption = value;
  }
  get deleteButtonCaption(): string {
    return this._deleteButtonCaption;
  }
}

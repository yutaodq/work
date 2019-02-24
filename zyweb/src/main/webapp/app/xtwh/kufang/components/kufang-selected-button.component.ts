import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output
} from "@angular/core";

import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";
import { Store } from "@ngrx/store";
import * as fromKufangs from "app/xtwh/kufang/reducers";
import { KufangService } from "app/xtwh/kufang/service";
import { SelectedKufangPageActions } from "app/xtwh/kufang/actions";

@Component({
  selector: "zy-kufang-selected-button",
  templateUrl: "./kufang-selected-button.component.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class KufangSelectedButtonComponent implements OnInit {
  private _kufang: IKufangEntity;
  constructor(
    private _store: Store<fromKufangs.State>,
    private _kufangService: KufangService
  ) {}
  ngOnInit() {}
  onKufangList(zy: string) {
    this._kufangService.linkToKufang();
  }
  onKufangCreate(zy: string) {
    this._kufangService.linkToNewKufangPage();
  }

  onKufangDelete(zy: string) {
    const r = confirm("Are you sure?");
    if (r) {
      this._store.dispatch(
        new SelectedKufangPageActions.RemoveKufang(this._kufang)
      );
    }
  }

  @Input()
  set kufang(entity: IKufangEntity) {
    this._kufang = entity;
  }
  get kufang(): IKufangEntity {
    return this._kufang;
  }

  /*
按键标题
 */
  get toListButtonCaption(): string {
    return "返回库房列表";
  }
  get createButtonCaption(): string {
    return "新建库房记录";
  }
  get deleteButtonCaption(): string {
    return "删除库房记录";
  }
}

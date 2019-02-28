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
import { RemoveDialogComponent } from "app/core";
import { NbDialogService } from "@nebular/theme";

@Component({
  selector: "zy-kufang-selected-button",
  templateUrl: "./kufang-selected-button.component.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class KufangSelectedButtonComponent implements OnInit {
  private _kufang: IKufangEntity;
  constructor(
    private _store: Store<fromKufangs.State>,
    private _kufangService: KufangService,
    private dialogService: NbDialogService
  ) {}
  ngOnInit() {}
  onKufangList(zy: string) {
    this._kufangService.linkToKufang();
  }
  onKufangCreate(zy: string) {
    this._kufangService.linkToNewKufangPage();
  }
  /* onKufangDelete() 请参照angular-example-app项目
   * \heroes\pages\heroes-list-page\heroes-list-page.component.ts
   * deleteHero(hero: Hero)
   */
  open() {
    this.dialogService.open(ShowcaseDialogComponent, {
      context: {
        title: "This is a title passed to the dialog component"
      }
    });
  }

  onKufangDelete(zy: string) {
    this.dialogService
      .open(RemoveDialogComponent, {
        context: {
          title: this._kufang.name + "对话框"
        }
      })
      .onClose.filter(data => data === "Yes")
      .subscribe(_ => {
        this._store.dispatch(
          new SelectedKufangPageActions.RemoveKufang(this._kufang)
        );
      });
  }

  onKufangEdit() {
    console.log(`在控制台打印:修改库房名称`);
    this._kufangService.linkToEditKufangPage();
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

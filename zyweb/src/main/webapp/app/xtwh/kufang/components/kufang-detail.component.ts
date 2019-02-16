import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output
} from "@angular/core";

import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";

@Component({
  selector: "zy-kufang-detail",
  templateUrl: "./kufang-detail.component.html",
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class KufangDetailComponent implements OnInit {
  @Input() kufang: IKufangEntity;
  @Output() list = new EventEmitter<IKufangEntity>();
  @Output() delete = new EventEmitter<IKufangEntity>();

  constructor() {}

  ngOnInit() {}
  onList() {
    this.list.emit(this.kufang);
  }
  onDelete() {
    this.delete.emit(this.kufang);
  }

  /*
   * 获取表属性
   */

  get name() {
    return this.kufang.name;
  }
  get bz() {
    return this.kufang.bz;
  }
}

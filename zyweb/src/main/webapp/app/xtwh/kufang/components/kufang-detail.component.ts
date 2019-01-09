import { Component, Input, OnInit } from "@angular/core";

import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";

@Component({
  selector: "zy-kufang-detail",
  templateUrl: "./kufang-detail.component.html"
})
export class KufangDetailComponent implements OnInit {
  @Input() kufang: IKufangEntity;

  constructor() {}

  ngOnInit() {}
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

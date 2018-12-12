import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

import { IKufangEntity } from "app/shared/model/kufang.model";

@Component({
  selector: "zy-kufang-detail",
  templateUrl: "./kufang-detail.component.html"
})
export class KufangNewComponent implements OnInit {
  kufang: IKufangEntity;
  pageTitle: string;
  constructor(private activatedRoute: ActivatedRoute) {
    this.activatedRoute.data.subscribe(data => {
      this.pageTitle = data.pageTitle;
    });
  }

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ kufang }) => {
      this.kufang = kufang;
    });
  }

  previousState() {
    window.history.back();
  }
}

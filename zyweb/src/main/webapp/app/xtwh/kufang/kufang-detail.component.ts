import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";

@Component({
  selector: "zy-kufang-detail",
  templateUrl: "./kufang-detail.component.html"
})
export class KufangDetailComponent implements OnInit {
  kufang: IKufangEntity;
  pageTitle: string;
  constructor(private activatedRoute: ActivatedRoute) {
    this.activatedRoute.data.subscribe(data => {
      this.pageTitle = data.pageTitle;
    });
  }

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ entity }) => {
      this.kufang = entity;
    });
  }

  previousState() {
    window.history.back();
  }
}

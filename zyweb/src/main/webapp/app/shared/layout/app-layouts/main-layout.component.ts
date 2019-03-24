import { Component, OnDestroy, OnInit } from "@angular/core";
import { MAIN_MENU_ITEMS } from "./app-menu";
@Component({
  selector: "zy-app-main-layout",
  templateUrl: "./main-layout.component.html",
  styles: []
})
export class MainLayoutComponent implements OnDestroy {
  menu = MAIN_MENU_ITEMS;
  layout: any = {};
  sidebar: any = {};

  private alive = true;

  currentTheme: string;

  constructor() {}

  ngOnDestroy() {
    this.alive = false;
  }
}

import { Component, OnDestroy } from "@angular/core";
import { Router, ActivatedRouteSnapshot, NavigationEnd } from "@angular/router";

import {
  NbMediaBreakpointsService,
  NbMenuService,
  NbSidebarService,
  NbThemeService
} from "@nebular/theme";

// TODO: move layouts into the framework
@Component({
  selector: "zy-sample-layout",
  styleUrls: ["./sample.layout.component.scss"],
  templateUrl: `./sample.layout.component.html`
})
export class SampleLayoutComponent implements OnDestroy {
  layout: any = {};
  sidebar: any = {};

  private alive = true;

  currentTheme: string;

  constructor() {}

  ngOnDestroy() {
    this.alive = false;
  }
}

import { Component, OnDestroy } from "@angular/core";
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
  template: ` ./sample.layout.component.html `
})
export class SampleLayoutComponent implements OnDestroy {
  layout: any = {};
  sidebar: any = {};

  private alive = true;

  currentTheme: string;

  constructor(
    protected menuService: NbMenuService,
    protected themeService: NbThemeService,
    protected bpService: NbMediaBreakpointsService,
    protected sidebarService: NbSidebarService
  ) {}

  ngOnDestroy() {
    this.alive = false;
  }
}

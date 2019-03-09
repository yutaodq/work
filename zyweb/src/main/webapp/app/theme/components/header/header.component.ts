import { Component, Input, OnInit } from "@angular/core";

import { NbMenuService, NbSidebarService } from "@nebular/theme";

import { AnalyticsService, LayoutService } from "app/core/service";
@Component({
  selector: "zy-header",
  styleUrls: ["./header.component.scss"],
  templateUrl: "./header.component.html"
})
export class HeaderComponent implements OnInit {
  @Input() position = "normal";

  user: any;

  userMenu = [{ title: "Profile" }, { title: "Log out" }];

  constructor(
    private sidebarService: NbSidebarService,
    private menuService: NbMenuService,
    private analyticsService: AnalyticsService,
    private layoutService: LayoutService
  ) {}

  ngOnInit() {
    // this.userService
    //   .getUsers()
    //   .subscribe((users: any) => (this.user = users.nick));
  }

  toggleSidebar(): boolean {
    this.sidebarService.toggle(true, "menu-sidebar");
    this.layoutService.changeLayoutSize();

    return false;
  }

  toggleSettings(): boolean {
    this.sidebarService.toggle(false, "settings-sidebar");

    return false;
  }

  goToHome() {
    this.menuService.navigateHome();
  }

  startSearch() {
    this.analyticsService.trackEvent("startSearch");
  }
}

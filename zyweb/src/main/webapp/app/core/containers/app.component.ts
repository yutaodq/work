import { ChangeDetectionStrategy, Component } from "@angular/core";
import { Observable } from "rxjs";
import { select, Store } from "@ngrx/store";

import { faCoffee } from "@fortawesome/free-solid-svg-icons";
import { MENU_ITEMS } from "./app-menu";
import * as fromRoot from "app/store/reducers";

@Component({
  selector: "zy-app",
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: `./app.component.html`
})
export class AppComponent {
  showSidenav$: Observable<boolean>;
  menu = MENU_ITEMS;
  constructor(private store: Store<fromRoot.State>) {
    this.showSidenav$ = this.store.pipe(select(fromRoot.getShowSidenav));
  }
}

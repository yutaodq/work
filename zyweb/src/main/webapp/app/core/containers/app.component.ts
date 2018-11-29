import { ChangeDetectionStrategy, Component } from "@angular/core";
import { select, Store } from "@ngrx/store";
import { Observable } from "rxjs";

import * as AuthActions from "@example-app/auth/actions/auth.actions";
import * as fromAuth from "@example-app/auth/reducers";
import * as fromRoot from "@example-app/reducers";
import { LayoutActions } from "@example-app/core/actions";

@Component({
  selector: "zy-app",
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `./app.component.html`
})
export class AppComponent {
  showSidenav$: Observable<boolean>;
  loggedIn$: Observable<boolean>;

  constructor(private store: Store<fromRoot.State>) {
    /**
     * Selectors can be applied with the `select` operator which passes the state
     * tree to the provided selector
     */
    this.showSidenav$ = this.store.pipe(select(fromRoot.getShowSidenav));
    this.loggedIn$ = this.store.pipe(select(fromAuth.getLoggedIn));
  }

  closeSidenav() {
    /**
     * All state updates are handled through dispatched actions in 'container'
     * components. This provides a clear, reproducible history of state
     * updates and user interaction through the life of our
     * application.
     */
    this.store.dispatch(new LayoutActions.CloseSidenav());
  }

  openSidenav() {
    this.store.dispatch(new LayoutActions.OpenSidenav());
  }

  logout() {
    this.closeSidenav();

    this.store.dispatch(new AuthActions.LogoutConfirmation());
  }
}

import {NgModule} from '@angular/core';
import {Route, RouterModule} from '@angular/router';
import {navbarRoute, errorRoute} from './layouts/index';
const defRoute: Route = {
  path: '',
  redirectTo: '/home'
};

const LAYOUT_ROUTES = [navbarRoute, ...errorRoute];

@NgModule({
  imports: [
    RouterModule.forRoot(
      [
        ...LAYOUT_ROUTES
      ],
      {useHash: true}
    )
  ],

  exports: [RouterModule]
})
export class ZyxtAppRoutingModule {
}

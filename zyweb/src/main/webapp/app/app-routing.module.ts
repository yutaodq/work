import { NgModule } from '@angular/core';
import { RouterModule} from '@angular/router';
import { navbarRoute, errorRoute } from './layouts/index';

const LAYOUT_ROUTES = [navbarRoute, ...errorRoute];

@NgModule({
  imports: [
  RouterModule.forRoot(
    [
      ...LAYOUT_ROUTES
     ],
    { useHash: true }
  )
],

  exports: [RouterModule]
})
export class ZyxtAppRoutingModule {}

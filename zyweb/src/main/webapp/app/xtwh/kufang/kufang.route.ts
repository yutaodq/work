import { Injectable } from "@angular/core";
import { HttpResponse } from "@angular/common/http";
import {
  Resolve,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  Routes
} from "@angular/router";
import { of } from "rxjs";
import { map } from "rxjs/operators";
import { KufangEntity } from "app/shared/model/kufang.model";
import { UserRouteAccessService } from "app/core";

import { KufangService } from "./kufang.service";
import { KufangComponent } from "./kufang.component";
// import { ProductDetailComponent } from './product-detail.component';
// import { ProductUpdateComponent } from './product-update.component';
// import { ProductNewComponent } from './product-new.component';

// import { ProductDeletePopupComponent } from './product-delete-dialog.component';
import { IKufangEntity } from "app/shared/model/kufang.model";

// @Injectable({ providedIn: 'root' })
// export class KufangResolve implements Resolve<IKufangEntity> {
//   constructor(private service: KufangService) {}
//
//   resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
//     const id = route.params["id"] ? route.params["id"] : null;
//     if (id) {
//       return this.service
//         .find(id)
//         .pipe(map((product: HttpResponse<KufangEntity>) => product.body));
//     }
//     return of(new KufangEntity());
//   }
// }

export const kufangRoute: Routes = [
  {
    path: "kufang",
    component: KufangComponent,
    data: { pageTitle: "库房列表：" },
    canActivate: [UserRouteAccessService]
  }
];

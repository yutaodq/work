import { HttpResponse } from "@angular/common/http";
import {
  Resolve,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  Routes
} from "@angular/router";
import { KufangEntity } from "app/xtwh/kufang/models/kufang.model";
import { UserRouteAccessService } from "app/core";
import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";
import { KufangService } from "./service/kufang.service";
import * as path from "app/app.constants";

import {
  KufangComponent,
  SelectedKufangPageComponent,
  ViewKufangPageComponent,
  NewKufangPageComponent
} from "./containers";

// @Injectable({ providedIn: "root" })
// export class KufangResolve implements Resolve<IKufangEntity> {
//   constructor(private service: KufangService) {}
//
//   resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
//     const id = route.params["id"] ? route.params["id"] : null;
//     if (id) {
//       return this.service
//         .find(id)
//         .pipe(map((kufang: HttpResponse<KufangEntity>) => kufang.body));
//     }
//     return of(new KufangEntity());
//   }
// }

export const kufangRoute: Routes = [
  {
    path: path.ROUTE_KUFANG,
    component: KufangComponent,
    data: { pageTitle: "库房名称列表" },
    canActivate: [UserRouteAccessService]
  },
  {
    path: path.ROUTE_KUFANG_VIEW,
    component: ViewKufangPageComponent,
    resolve: {},
    data: {
      authorities: ["ROLE_USER"],
      pageTitle: "库房名称-查看表单"
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: path.ROUTE_KUFANG_NEW,
    component: NewKufangPageComponent,
    resolve: {},
    data: {
      authorities: ["ROLE_USER"],
      pageTitle: "工具-添加新记录表单"
    },
    canActivate: [UserRouteAccessService]
  }
];

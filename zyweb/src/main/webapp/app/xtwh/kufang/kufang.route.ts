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
import { KufangDetailComponent } from "./kufang-detail.component";
import { IKufangEntity } from "app/shared/model/kufang.model";

@Injectable({ providedIn: "root" })
export class KufangResolve implements Resolve<IKufangEntity> {
  constructor(private service: KufangService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const id = route.params["id"] ? route.params["id"] : null;
    if (id) {
      return this.service
        .find(id)
        .pipe(map((kufang: HttpResponse<KufangEntity>) => kufang.body));
    }
    return of(new KufangEntity());
  }
}

export const kufangRoute: Routes = [
  {
    path: "kufang",
    component: KufangComponent,
    data: { pageTitle: "库房名称列表：" },
    canActivate: [UserRouteAccessService]
  },
  {
    path: "kufang/:id/view",
    component: KufangDetailComponent,
    resolve: {
      kufang: KufangResolve
    },
    data: {
      authorities: ["ROLE_USER"],
      pageTitle: "工具-查看表单"
    },
    canActivate: [UserRouteAccessService]
  }
];

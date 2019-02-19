import { HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";

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
  ViewKufangPageComponent,
  NewKufangPageComponent
} from "./containers";

@Injectable({ providedIn: "root" })
export class KufangResolve implements Resolve<IKufangEntity> {
  constructor(private service: KufangService) {}
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return {
      id: undefined,
      identifier: "",
      name: "",
      bz: ""
    };
  }
}

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
    resolve: { KufangResolve },
    data: {
      authorities: ["ROLE_USER"],
      pageTitle: "工具-添加新记录表单"
    },
    canActivate: [UserRouteAccessService]
  }
];

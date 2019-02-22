import { HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { of } from "rxjs";

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
export class NewKufangResolve implements Resolve<IKufangEntity> {
  constructor(private service: KufangService) {}
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return of({
      id: undefined,
      identifier: "",
      name: "hjkl",
      bz: ""
    });
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
    resolve: { kufang: NewKufangResolve },
    data: {
      authorities: ["ROLE_USER"],
      pageTitle: "工具-添加新记录表单"
    },
    canActivate: [UserRouteAccessService]
  }
];

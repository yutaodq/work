import { NgModule } from "@angular/core";
import { Injectable } from "@angular/core";
import { of } from "rxjs";

import {
  Resolve,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  Routes,
  RouterModule
} from "@angular/router";

import { IKufangEntity } from "app/models";
import { KufangService } from "./service";
import * as path from "app/app.constants";

import {
  KufangComponent,
  ViewKufangPageComponent,
  NewKufangPageComponent,
  EditKufangPageComponent
} from "./containers";
import { KufangSelectedButtonComponent } from "app/xtwh/kufang/components";

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

const routes: Routes = [
  {
    path: path.ROUTE_KUFANG,
    component: KufangComponent,
    data: { pageTitle: "库房名称列表" }
    // canActivate: [UserRouteAccessService]
  },
  {
    path: path.ROUTE_KUFANG_VIEW,
    component: ViewKufangPageComponent,
    resolve: {},
    data: {
      authorities: ["ROLE_USER"],
      pageTitle: "库房名称-查看表单"
    },
    // canActivate: [UserRouteAccessService],
    children: [{ path: "", component: KufangSelectedButtonComponent }]
  },
  {
    path: path.ROUTE_KUFANG_NEW,
    component: NewKufangPageComponent,
    resolve: { kufang: NewKufangResolve },
    data: {
      authorities: ["ROLE_USER"],
      pageTitle: "工具-添加新记录表单"
    }
    // canActivate: [UserRouteAccessService]
  },
  {
    path: path.ROUTE_KUFANG_EDIT,
    component: EditKufangPageComponent,
    resolve: {},
    data: {
      authorities: ["ROLE_USER"],
      pageTitle: "库房记录-修改库房名称"
    }
    // canActivate: [UserRouteAccessService]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class KufangRoutingModule {}

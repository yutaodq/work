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

import { IKufangEntity } from "app/shared/model/kufang.model";

export const kufangRoute: Routes = [
  {
    path: "kufang",
    component: KufangComponent,
    data: { pageTitle: "库房名称列表：" },
    canActivate: [UserRouteAccessService]
  }
];

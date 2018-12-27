import { Action } from "@ngrx/store";

import { KufangEntity } from "app/xtwh/kufang/models/kufang.model";

export enum KufangActionTypes {
  LoadKufang = "[Kufang Exists Guard] Load Kufang"
}

export class LoadKufang implements Action {
  readonly type = KufangActionTypes.LoadKufang;

  constructor(public payload: KufangEntity) {}
}

export type KufangActionsUnion = LoadKufang;

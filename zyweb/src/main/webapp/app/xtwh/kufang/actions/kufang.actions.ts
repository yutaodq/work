import { Action } from "@ngrx/store";

import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";

export enum KufangActionTypes {
  LoadKufang = "[Kufang Exists Guard] Load Kufang"
}

export class LoadKufang implements Action {
  readonly type = KufangActionTypes.LoadKufang;

  constructor(public payload: IKufangEntity) {}
}

export type KufangActionsUnion = LoadKufang;

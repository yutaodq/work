import { Action } from "@ngrx/store";
import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";

export enum NewKufangPageActionTypes {
  CreateKufang = "[New Kufang Page] Create Kufang",
  CreateKufangSuccess = "[New Kufang Page] Create Kufang Success"
}

export class CreateKufang implements Action {
  readonly type = NewKufangPageActionTypes.CreateKufang;

  constructor(public payload: IKufangEntity) {}
}

export class CreateKufangSuccess implements Action {
  readonly type = NewKufangPageActionTypes.CreateKufangSuccess;

  constructor(public payload: IKufangEntity) {}
}

export type NewKufangPageActionsUnion = CreateKufang | CreateKufangSuccess;

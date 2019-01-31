import { Action } from "@ngrx/store";
import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";
import { CollectionApiActionTypes } from "app/xtwh/kufang/actions/collection-api.actions";

export enum NewKufangPageActionTypes {
  CreateKufang = "[New Kufang Page] Create Kufang",
  CreateKufangSuccess = "[New Kufang Page] Create Kufang Success",
  CreateKufangFailure = "[New Kufang Page] Create Kufang Failure"
}

export class CreateKufang implements Action {
  readonly type = NewKufangPageActionTypes.CreateKufang;

  constructor(public payload: IKufangEntity) {}
}

export class CreateKufangSuccess implements Action {
  readonly type = NewKufangPageActionTypes.CreateKufangSuccess;

  constructor(public payload: IKufangEntity) {}
}

export class CreateKufangFailure implements Action {
  readonly type = NewKufangPageActionTypes.CreateKufangFailure;

  constructor(public payload: IKufangEntity) {}
}

export type NewKufangPageActionsUnion =
  | CreateKufang
  | CreateKufangSuccess
  | CreateKufangFailure;

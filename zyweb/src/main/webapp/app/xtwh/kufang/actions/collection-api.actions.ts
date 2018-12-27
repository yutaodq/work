import { Action } from "@ngrx/store";
import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";

export enum CollectionApiActionTypes {
  AddKufangSuccess = "[Collection/API] Add Kufang Success",
  AddKufangFailure = "[Collection/API] Add Kufang Failure",
  RemoveKufangSuccess = "[Collection/API] Remove Kufang Success",
  RemoveKufangFailure = "[Collection/API] Remove Kufang Failure",
  LoadKufangsSuccess = "[Collection/API] Load Kufangs Success",
  LoadKufangsFailure = "[Collection/API] Load Kufangs Failure"
}

/**
 * Add Book to Collection Actions
 */

export class AddKufangSuccess implements Action {
  readonly type = CollectionApiActionTypes.AddKufangSuccess;

  constructor(public payload: IKufangEntity) {}
}

export class AddKufangFailure implements Action {
  readonly type = CollectionApiActionTypes.AddKufangFailure;

  constructor(public payload: IKufangEntity) {}
}

/**
 * Remove Book from Collection Actions
 */
export class RemoveKufangSuccess implements Action {
  readonly type = CollectionApiActionTypes.RemoveKufangSuccess;

  constructor(public payload: IKufangEntity) {}
}

export class RemoveKufangFailure implements Action {
  readonly type = CollectionApiActionTypes.RemoveKufangFailure;

  constructor(public payload: IKufangEntity) {}
}

/**
 * Load Collection Actions
 */
export class LoadKufangsSuccess implements Action {
  readonly type = CollectionApiActionTypes.LoadKufangsSuccess;

  constructor(public payload: IKufangEntity[]) {}
}

export class LoadKufangsFailure implements Action {
  readonly type = CollectionApiActionTypes.LoadKufangsFailure;

  constructor(public payload: any) {}
}

export type CollectionApiActionsUnion =
  | AddKufangSuccess
  | AddKufangFailure
  | RemoveKufangSuccess
  | RemoveKufangFailure
  | LoadKufangsSuccess
  | LoadKufangsFailure;

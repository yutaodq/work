import { Action } from "@ngrx/store";
import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";

export enum CollectionApiActionTypes {
  AddKufangSuccess = "[Collection/API] Add Kufang Success",
  AddKufangFailure = "[Collection/API] Add Kufang Failure",
  RemoveKufangSuccess = "[Collection/API] Remove Kufang Success",
  RemoveBookFailure = "[Collection/API] Remove Kufang Failure",
  LoadBooksSuccess = "[Collection/API] Load Kufangs Success",
  LoadBooksFailure = "[Collection/API] Load Kufangs Failure"
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

export class RemoveBookFailure implements Action {
  readonly type = CollectionApiActionTypes.RemoveBookFailure;

  constructor(public payload: IKufangEntity) {}
}

/**
 * Load Collection Actions
 */
export class LoadBooksSuccess implements Action {
  readonly type = CollectionApiActionTypes.LoadBooksSuccess;

  constructor(public payload: IKufangEntity[]) {}
}

export class LoadBooksFailure implements Action {
  readonly type = CollectionApiActionTypes.LoadBooksFailure;

  constructor(public payload: any) {}
}

export type CollectionApiActionsUnion =
  | AddKufangSuccess
  | AddKufangFailure
  | RemoveKufangSuccess
  | RemoveBookFailure
  | LoadBooksSuccess
  | LoadBooksFailure;

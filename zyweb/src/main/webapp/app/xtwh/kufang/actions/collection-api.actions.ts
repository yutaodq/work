import { Action } from "@ngrx/store";
import { IKufangEntity } from "app/models/kufang.model";

export enum CollectionApiActionTypes {
  // CreateKufangSuccess = "[Collection/API] Create Kufang Success",
  // CreateKufangFailure = "[Collection/API] Create Kufang Failure",
  RemoveKufangSuccess = "[Collection/API] Remove Kufang Success",
  RemoveKufangFailure = "[Collection/API] Remove Kufang Failure",
  LoadKufangsSuccess = "[Collection/API] Load Kufangs Success",
  LoadKufangsFailure = "[Collection/API] Load Kufangs Failure"
}

/**
 * Add Book to Collection Actions
 */

// export class CreateKufangSuccess implements Action {
//   readonly type = CollectionApiActionTypes.CreateKufangSuccess;
//
//   constructor(public payload: IKufangEntity) {}
// }
//
// export class CreateKufangFailure implements Action {
//   readonly type = CollectionApiActionTypes.CreateKufangFailure;
//
//   constructor(public payload: IKufangEntity) {}
// }

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
  | RemoveKufangSuccess
  | RemoveKufangFailure
  | LoadKufangsSuccess
  | LoadKufangsFailure;

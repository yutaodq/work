import { Action } from "@ngrx/store";
import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";

export enum KufangApiActionTypes {
  SearchSuccess = "[Kufangs/API] Search Success",
  SearchFailure = "[Kufangs/API] Search Failure"
}

/**
 * Every action is comprised of at least a type and an optional
 * payload. Expressing actions as classes enables powerful
 * type checking in reducer functions.
 *
 * See Discriminated Unions: https://www.typescriptlang.org/docs/handbook/advanced-types.html#discriminated-unions
 */
export class SearchSuccess implements Action {
  readonly type = KufangApiActionTypes.SearchSuccess;

  constructor(public payload: IKufangEntity[]) {}
}

export class SearchFailure implements Action {
  readonly type = KufangApiActionTypes.SearchFailure;

  constructor(public payload: string) {}
}

/**
 * Export a type alias of all actions in this action group
 * so that reducers can easily compose action types
 */
export type KufangApiActionsUnion = SearchSuccess | SearchFailure;

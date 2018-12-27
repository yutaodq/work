import { Action } from "@ngrx/store";
import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";

export enum SelectedKufangsPageActionTypes {
  AddKufangs = "[Selected Kufangs Page] Add Kufangs",
  RemoveKufangs = "[Selected Kufangs Page] Remove Kufangs"
}

/**
 * Add Kufangs to Collection Action
 */
export class AddKufangs implements Action {
  readonly type = SelectedKufangsPageActionTypes.AddKufangs;

  constructor(public payload: IKufangEntity) {}
}

/**
 * Remove Kufangs from Collection Action
 */
export class RemoveKufangs implements Action {
  readonly type = SelectedKufangsPageActionTypes.RemoveKufangs;

  constructor(public payload: IKufangEntity) {}
}

export type SelectedKufangsPageActionsUnion = AddKufangs | RemoveKufangs;

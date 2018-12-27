import { Action } from "@ngrx/store";
import { IKufangEntity } from "app/xtwh/kufang/models/kufang.model";

export enum SelectedKufangPageActionTypes {
  AddKufang = "[Selected Kufang Page] Add Kufang",
  RemoveKufang = "[Selected Kufang Page] Remove Kufang"
}

/**
 * Add Kufangs to Collection Action
 */
export class AddKufang implements Action {
  readonly type = SelectedKufangPageActionTypes.AddKufang;

  constructor(public payload: IKufangEntity) {}
}

/**
 * Remove Kufangs from Collection Action
 */
export class RemoveKufang implements Action {
  readonly type = SelectedKufangPageActionTypes.RemoveKufang;

  constructor(public payload: IKufangEntity) {}
}

export type SelectedKufangPageActionsUnion = AddKufang | RemoveKufang;

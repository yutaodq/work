import { Action } from "@ngrx/store";

export enum ViewKufangPageActionTypes {
  SelectKufang = "[View Kufang Page] Select Kufang"
}

export class SelectKufang implements Action {
  readonly type = ViewKufangPageActionTypes.SelectKufang;

  constructor(public payload: string) {}
}

export type ViewKufangPageActionsUnion = SelectKufang;

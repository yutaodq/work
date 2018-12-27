import { Action } from "@ngrx/store";

export enum FindKufangPageActionTypes {
  SearchKufangs = "[Find Kufang Page] Search Kufangs"
}

export class SearchBooks implements Action {
  readonly type = FindKufangPageActionTypes.SearchKufangs;

  constructor(public payload: string) {}
}

export type FindKufangPageActionsUnion = SearchBooks;

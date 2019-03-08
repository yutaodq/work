import { Action } from "@ngrx/store";
import { NavigationExtras } from "@angular/router";

export enum RouterActionTypes {
  HomePageRouter = "[App/Router] Home Page",
  AboutPageRouter = "[App/Router] About Page",
  GoPageRouter = "[App/Router] Go Page"
}
export class HomePageRouter implements Action {
  readonly type = RouterActionTypes.HomePageRouter;
}

export class AboutPageRouter implements Action {
  readonly type = RouterActionTypes.AboutPageRouter;
}

export class GoPageRouter implements Action {
  readonly type = RouterActionTypes.GoPageRouter;
  constructor(
    public payload: {
      path: any[];
      query?: Object;
      extras?: NavigationExtras;
    }
  ) {}
}
export type RouterActionUnion = HomePageRouter | AboutPageRouter | GoPageRouter;

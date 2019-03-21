import { Action } from "@ngrx/store";
import { IUserEntity } from "app/models";

export enum UserActionTypes {
  LOGIN = "[user] LOGIN",
  LOGIN_SUCCESS = "[user]  LOGIN_SUCCESS",
  LOGIN_FAIL = "[user] LOGIN_FAIL",

  LOGOUT = "[user] LOGOUT",
  LOGOUT_SUCCESS = "[user] LOGOUT_SUCCESS",
  LOGOUT_FAIL = "[user] LOGOUT_FAIL",

  GETUSER = "[user] GETUSER",
  GETUSER_SUCCESS = "[user] GETUSER_SUCCESS",
  GETUSER_FAIL = "[user] GETUSER_FAIL"
}

// define Actions class
export class LoginAction implements Action {
  readonly type = UserActionTypes.LOGIN;
  constructor(public payload: IUserEntity) {}
}

export class LoginSuccessAction implements Action {
  readonly type = UserActionTypes.LOGIN_SUCCESS;

  constructor(public payload: string) {}
}

export class LoginFailAction implements Action {
  readonly type = UserActionTypes.LOGIN_FAIL;

  constructor(public payload: any) {}
}

export class LogoutAction implements Action {
  readonly type = UserActionTypes.LOGOUT;
}

export class LogoutSuccessAction implements Action {
  readonly type = UserActionTypes.LOGOUT_SUCCESS;
}

export class LogoutFailAction implements Action {
  readonly type = UserActionTypes.LOGOUT_FAIL;
}

export class GetUserAction implements Action {
  readonly type = UserActionTypes.GETUSER;
}

export class GetUserSuccessAction implements Action {
  readonly type = UserActionTypes.GETUSER_SUCCESS;

  constructor(public payload: string) {} // username
}

export class GetUserFailAction implements Action {
  readonly type = UserActionTypes.GETUSER_FAIL;

  constructor(public payload: any) {}
}

export type UserActions =
  | LoginAction
  | LoginSuccessAction
  | LoginFailAction
  | LogoutAction
  | LogoutSuccessAction
  | LogoutFailAction
  | GetUserAction
  | GetUserSuccessAction
  | GetUserFailAction;

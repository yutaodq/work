import { ActionReducer, Action, ActionReducerMap } from "@ngrx/store";
import * as actions from "../actions";

export interface UsersState {
  isLogin: boolean;
  currentUser: string;
}

const initialState: UsersState = {
  isLogin: false,
  currentUser: ""
};

export function reducer(
  state: UsersState = initialState,
  action: actions.UserActions
): UsersState {
  switch (action.type) {
    case actions.UserActionTypes.LOGOUT:
      return initialState;
    case actions.UserActionTypes.LOGIN_SUCCESS:
      return { ...state, currentUser: action.payload, isLogin: true };
    default:
      return state;
  }
}

// for selector
export const getIsLogin = (state: UsersState) => state.isLogin;
export const getCurrentUser = (state: UsersState) => state.currentUser;

import { ActionReducer, Action, ActionReducerMap } from "@ngrx/store";
import * as actions from "../actions";

export interface State {
  isLogin: boolean;
  currentUser: string;
}

const initialState: State = {
  isLogin: false,
  currentUser: ""
};

export function reducer(
  state: State = initialState,
  action: actions.UserActions
): State {
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
export const getIsLogin = (state: State) => state.isLogin;
export const getCurrentUser = (state: State) => state.currentUser;

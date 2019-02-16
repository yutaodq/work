import {
  ActionReducerMap,
  createSelector,
  createFeatureSelector,
  ActionReducer,
  MetaReducer
} from "@ngrx/store";

import { environment } from "../../../../environments/environment";

import * as fromRouter from "@ngrx/router-store";

/**
 * storeFreeze防止状态发生突变
 * 当发生突变时，将引发异常
 * 这在开发模式中非常有用，可以确保所有的reducers accidentally不会意外地改变状态
 */
import { storeFreeze } from "../ngrx-store-freeze";
/**
 * Every reducer module's default export is the reducer function itself. In
 * addition, each module should export a type or interface that describes
 * the state of the reducer plus any selector functions. The `* as`
 * notation packages up all of the exports into a single object.
 */

// import * as fromLayout from "app/core/reducers/layout.reducer";
import { fromLayout } from "app/core/reducers";

/**
 * As mentioned, we treat each reducer like a table in a database. This means
 * our top level state interface is just a map of keys to inner state types.
 */
export interface State {
  layout: fromLayout.State;
  router: fromRouter.RouterReducerState;
}

/**
 * Our state is composed of a map of action reducer functions.
 * These reducer functions are called with each dispatched action
 * and the current or initial state and return a new immutable state.
 */
/*
根reducer:
使用const定义的变量 reducer是不可以再被赋值的，但是它定义的变量的内部属性是可以被修改的
ActionReducerMap接收一个由键和reducer组成的映射表（map）并返回一个新的reducer。
然后在应用模块中使用StoreModule来配置这个根reducer。
*/
export const reducers: ActionReducerMap<State> = {
  layout: fromLayout.reducer,
  router: fromRouter.routerReducer
};

/*
ActionReducer用来创建reducer，使用MetaReducer对它进行配置.
通过使用下面的代码，我们可以在控制台中获取每个action的状态和名称.
*/
export function logger(reducer: ActionReducer<State>): ActionReducer<State> {
  return (state: State, action: any): any => {
    const result = reducer(state, action);
    console.groupCollapsed(action.type);
    console.log("prev state", state);
    console.log("action", action);
    console.log("next state", result);
    console.groupEnd();

    return result;
  };
}

/**
 * By default, @ngrx/store uses combineReducers with the reducer map to compose
 * the root meta-reducer. To add more meta-reducers, provide an array of meta-reducers
 * that will be composed to form the root meta-reducer.
 */

/*
MetaReducer由我们所创建的一系列ActionReducer所组成。
在应用中使用StoreModule配置的MetaReducer构成了根meta-reducer。
@ngrx/store默认使用 combineReducers在创建根meta-reducer。
*/
export const metaReducers: MetaReducer<State>[] = !environment.production
  ? [logger, storeFreeze]
  : [];

/**
 * Layout Reducers
 */
export const getLayoutState = createFeatureSelector<State, fromLayout.State>(
  "layout"
);

export const getShowSidenav = createSelector(
  getLayoutState,
  fromLayout.getShowSidenav
);

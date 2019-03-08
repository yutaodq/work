import {
  createSelector,
  createFeatureSelector,
  ActionReducerMap
} from "@ngrx/store";
import * as fromKufangs from "app/xtwh/kufang/reducers/kufang.reducer";
import * as fromCollection from "app/xtwh/kufang/reducers/collection.reducer";
import * as fromRoot from "app/store/reducers";
import * as fromAdapter from "./kufang.adapter";

export interface KufangsState {
  // search: fromSearch.State;
  kufangs: fromKufangs.State;
  collection: fromCollection.State;
}

export interface State extends fromRoot.State {
  kufangs: KufangsState;
}

export const reducers: ActionReducerMap<KufangsState, any> = {
  // search: fromSearch.reducer,
  kufangs: fromKufangs.reducer,
  collection: fromCollection.reducer
};

/**
 * A selector function is a map function factory. We pass it parameters and it
 * returns a function that maps from the larger state tree into a smaller
 * piece of state. This selector simply selects the `books` state.
 *
 * Selectors are used with the `select` operator.
 *
 * ```ts
 * class MyComponent {
 *   constructor(state$: Observable<State>) {
 *     this.kufangsState$ = state$.pipe(select(getKufangsState));
 *   }
 * }
 *
 */

/**
 * createFeatureSelector函数从根状态对象中选择一段状态
 * 这用于选择急切加载或延迟加载的特性状态
 * This is used for selecting feature states that are loaded eagerly or lazily.
 */
export const getKufangsState = createFeatureSelector<State, KufangsState>(
  "kufangs"
);
// 每个reducer导出选择器函数(selector)，但是reducer不知道整个状态树。
// 为了使它们可用，我们需要创建包装它们的新选择器。
// createSelector函数创建了非常高效的选择器，这些选择器被记忆，只有在参数发生变化时才会重新计算。
// 创建的选择器还可以组合在一起以选择不同的状态块。

export const getKufangEntitiesState = createSelector(
  getKufangsState,
  state => state.kufangs
);

export const getSelectedKufangId = createSelector(
  getKufangEntitiesState,
  fromKufangs.getSelectedId
);

/**
 * Adapters created with @ngrx/kufang generate
 * commonly used selector functions including
 * getting all ids in the record set, a dictionary
 * of the records by id, an array of records and
 * the total number of records. This reduces boilerplate
 * in selecting records from the kufang state.
 */

// getSelectors 方法返回 NgRx EntitySelectors，它提供从实体集合中选择信息的功能。
// EntitySelectors 的功能如下：
// selectIds：选择 id 数组。
// selectEntities：选择实体字典。 我们可以用它来获取 id 的实体。
// selectAll：选择所有实体的数组。
// selectTotal：选择实体的总数。
export const {
  selectIds: getKufangIds,
  selectEntities: getKufangEntities,
  selectAll: getAllKufangs,
  selectTotal: getTotalKufangs
} = fromAdapter.adapter.getSelectors(getKufangEntitiesState);

export const getSelectedKufang = createSelector(
  getKufangEntities,
  getSelectedKufangId,
  (entities, selectedId) => {
    return selectedId && entities[selectedId];
  }
);

// /**
//  * Just like with the books selectors, we also have to compose the search
//  * reducer's and collection reducer's selectors.
//  */
// export const getSearchState = createSelector(
//   getBooksState,
//   (state: BooksState) => state.search
// );
//
// export const getSearchBookIds = createSelector(
//   getSearchState,
//   fromSearch.getIds
// );
// export const getSearchQuery = createSelector(
//   getSearchState,
//   fromSearch.getQuery
// );
// export const getSearchLoading = createSelector(
//   getSearchState,
//   fromSearch.getLoading
// );
// export const getSearchError = createSelector(
//   getSearchState,
//   fromSearch.getError
// );
//
// /**
//  * Some selector functions create joins across parts of state. This selector
//  * composes the search result IDs to return an array of books in the store.
//  */
// export const getSearchResults = createSelector(
//   getBookEntities,
//   getSearchBookIds,
//   (books, searchIds) => {
//     return searchIds.map(id => books[id]);
//   }
// );
//
export const getCollectionState = createSelector(
  getKufangsState,
  (state: KufangsState) => state.collection
);

// export const getCollectionLoaded = createSelector(
//   getCollectionState,
//   fromCollection.getLoaded
// );
// export const getCollectionLoading = createSelector(
//   getCollectionState,
//   fromCollection.getLoading
// );
export const getCollectionKufangIds = createSelector(
  getCollectionState,
  fromCollection.getIds
);

export const getKufangCollection = createSelector(
  getKufangEntities,
  getCollectionKufangIds,
  (entities, ids) => {
    return ids.map(id => entities[id]);
  }
);

// export const isSelectedBookInCollection = createSelector(
//   getCollectionBookIds,
//   getSelectedBookId,
//   (ids, selected) => {
//     return selected && ids.indexOf(selected) > -1;
//   }
// );

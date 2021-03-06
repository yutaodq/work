import { createEntityAdapter, EntityAdapter, EntityState } from "@ngrx/entity";
import { KufangEntity } from "app/models/kufang.model";
import {
  KufangActions,
  CollectionApiActions,
  ViewKufangPageActions,
  NewKufangPageActions
} from "app/xtwh/kufang/actions";
import * as fromAdapter from "./kufang.adapter";

/**
 * @ngrx/kufang provides a predefined interface for handling
 * a structured dictionary of records. This interface
 * includes an array of ids, and a dictionary of the provided
 * model type by id. This interface is extended to include
 * any additional interface properties.
 */
export interface State extends EntityState<KufangEntity> {
  selectedKufangId: number | null;
}

// /**
//  * createEntityAdapter creates an object of many helper
//  * functions for single or multiple operations
//  * against the dictionary of records. The configuration
//  * object takes a record id selector function and
//  * a sortComparer option which is set to a compare
//  * function if the records are to be sorted.
//  */
// export const adapter: EntityAdapter<KufangEntity> = createEntityAdapter<
//   KufangEntity
// >({
//   selectId: (kufang: KufangEntity) => kufang.id,
//   sortComparer: false
// });

/**
 * getInitialState returns the default initial state
 * for the generated kufang state. Initial state
 * additional properties can also be defined.
 */
export const initialState: State = fromAdapter.adapter.getInitialState({
  selectedKufangId: null
});

export function reducer(
  state = initialState,
  action:
    | KufangActions.KufangActionsUnion
    | CollectionApiActions.CollectionApiActionsUnion
    | ViewKufangPageActions.ViewKufangPageActionsUnion
    | NewKufangPageActions.NewKufangPageActionsUnion
): State {
  switch (action.type) {
    case CollectionApiActions.CollectionApiActionTypes.LoadKufangsSuccess: {
      /**
       * The addMany function provided by the created adapter
       * adds many records to the kufang dictionary
       * and returns a new state including those records. If
       * the collection is to be sorted, the adapter will
       * sort each record upon entry into the sorted array.
       */
      return fromAdapter.adapter.addMany(action.payload, state);
    }

    case KufangActions.KufangActionTypes.LoadKufang: {
      /**
       * The addOne function provided by the created adapter
       * adds one record to the kufang dictionary
       * and returns a new state including that records if it doesn't
       * exist already. If the collection is to be sorted, the adapter will
       * insert the new record into the sorted array.
       */
      return fromAdapter.adapter.addOne(action.payload, state);
    }

    case ViewKufangPageActions.ViewKufangPageActionTypes.SelectKufang: {
      return {
        ...state,
        selectedKufangId: action.payload
      };
    }
    case NewKufangPageActions.NewKufangPageActionTypes.CreateKufangSuccess: {
      return fromAdapter.adapter.addOne(action.payload, {
        ...state
      });
    }
    case CollectionApiActions.CollectionApiActionTypes.RemoveKufangSuccess: {
      return fromAdapter.adapter.removeOne(action.payload.id, state);
    }

    default: {
      return state;
    }
  }
}

/**
 * Because the data structure is defined within the reducer it is optimal to
 * locate our selector functions at this level. If store is to be thought of
 * as a database, and reducers the tables, selectors can be considered the
 * queries into said database. Remember to keep your selectors small and
 * focused so they can be combined and composed to fit each particular
 * use-case.
 */

export const getSelectedId = (state: State) => state.selectedKufangId;

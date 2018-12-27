import {
  SelectedKufangPageActions,
  CollectionPageActions,
  CollectionApiActions
} from "app/xtwh/kufang/actions";

export interface State {
  loaded: boolean;
  loading: boolean;
  ids: number[];
}

const initialState: State = {
  loaded: false,
  loading: false,
  ids: []
};

export function reducer(
  state = initialState,
  action:
    | SelectedKufangPageActions.SelectedKufangPageActionsUnion
    | CollectionPageActions.CollectionPageActionsUnion
    | CollectionApiActions.CollectionApiActionsUnion
): State {
  switch (action.type) {
    case CollectionPageActions.CollectionPageActionTypes.LoadCollection: {
      return {
        ...state,
        loading: true
      };
    }

    case CollectionApiActions.CollectionApiActionTypes.LoadKufangsSuccess: {
      return {
        loaded: true,
        loading: false,
        ids: action.payload.map(kufang => kufang.id)
      };
    }

    case CollectionApiActions.CollectionApiActionTypes.AddKufangSuccess:
    case CollectionApiActions.CollectionApiActionTypes.RemoveKufangFailure: {
      if (state.ids.indexOf(action.payload.id) > -1) {
        return state;
      }

      return {
        ...state,
        ids: [...state.ids, action.payload.id]
      };
    }

    case CollectionApiActions.CollectionApiActionTypes.RemoveKufangSuccess:
    case CollectionApiActions.CollectionApiActionTypes.AddKufangFailure: {
      return {
        ...state,
        ids: state.ids.filter(id => id !== action.payload.id)
      };
    }

    default: {
      return state;
    }
  }
}

export const getLoaded = (state: State) => state.loaded;

export const getLoading = (state: State) => state.loading;

export const getIds = (state: State) => state.ids;

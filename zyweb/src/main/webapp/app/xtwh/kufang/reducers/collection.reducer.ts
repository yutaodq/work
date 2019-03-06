import {
  SelectedKufangPageActions,
  CollectionPageActions,
  CollectionApiActions,
  NewKufangPageActions
} from "../actions";

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
    | NewKufangPageActions.NewKufangPageActionsUnion
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

    case NewKufangPageActions.NewKufangPageActionTypes.CreateKufangSuccess:
    case CollectionApiActions.CollectionApiActionTypes.RemoveKufangFailure: {
      // indexOf()返回找到的匹配项的索引，否则返回-1（如果未找到）
      if (state.ids.indexOf(action.payload.id) > -1) {
        return state;
      }

      return {
        ...state,
        ids: [...state.ids, action.payload.id]
      };
    }

    case CollectionApiActions.CollectionApiActionTypes.RemoveKufangSuccess:
    case NewKufangPageActions.NewKufangPageActionTypes.CreateKufangFailure: {
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

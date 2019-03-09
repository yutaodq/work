import { Injectable } from "@angular/core";
import { Actions, Effect, ofType } from "@ngrx/effects";
import { Action } from "@ngrx/store";
import { defer, Observable, of } from "rxjs";
import {
  catchError,
  map,
  mergeMap,
  switchMap,
  toArray,
  startWith
} from "rxjs/operators";

import { IKufangEntity, KufangEntity } from "app/models/kufang.model";
import {
  SelectedKufangPageActions,
  CollectionPageActions,
  CollectionApiActions,
  NewKufangPageActions
} from "../actions";
import { KufangService } from "../service";
import {
  CollectionApiActionsUnion,
  CollectionApiActionTypes
} from "app/xtwh/kufang/actions/collection-api.actions";

@Injectable()
export class CollectionEffects {
  /*
     * rxjs写法。loadCollection$ 是effect名，在外部没有用到，可以随便起。
     */
  @Effect()
  loadCollection$: Observable<Action> = this.actions$.pipe(
    ofType(CollectionPageActions.CollectionPageActionTypes.LoadCollection),
    switchMap(() =>
      this.kufangService.getAll().pipe(
        // toArray(),
        map(
          (kufangs: IKufangEntity[]) =>
            new CollectionApiActions.LoadKufangsSuccess(kufangs)
        ),
        catchError(error =>
          of(new CollectionApiActions.LoadKufangsFailure(error))
        )
      )
    )
  );

  // @Effect()
  // loadCollectionSuccess$: Observable<Action> = this.actions$.pipe(
  //   ofType(CollectionApiActions.CollectionApiActionTypes.LoadKufangsSuccess),
  //   map(() =>  this.kufangService.linkToKufang() )
  // );

  /*
 * 创建新库房记录
 */

  @Effect()
  createKufangToCollection$: Observable<Action> = this.actions$.pipe(
    ofType<NewKufangPageActions.CreateKufang>(
      NewKufangPageActions.NewKufangPageActionTypes.CreateKufang
    ),
    map(action => action.payload),
    mergeMap(kufang =>
      this.kufangService
        .create(kufang)
        .pipe(
          map(
            createdKufang =>
              new NewKufangPageActions.CreateKufangSuccess(createdKufang)
          ),
          catchError(createdKufang =>
            of(new NewKufangPageActions.CreateKufangFailure(createdKufang))
          )
        )
    )
  );

  @Effect()
  removeBookFromCollection$: Observable<Action> = this.actions$.pipe(
    ofType<SelectedKufangPageActions.RemoveKufang>(
      SelectedKufangPageActions.SelectedKufangPageActionTypes.RemoveKufang
    ),
    map(action => action.payload),
    mergeMap(kufang =>
      this.kufangService
        .delete(kufang.identifier)
        .pipe(
          map(() => new CollectionApiActions.RemoveKufangSuccess(kufang)),
          catchError(() =>
            of(new CollectionApiActions.RemoveKufangFailure(kufang))
          )
        )
    )
  );

  constructor(
    private actions$: Actions,
    private kufangService: KufangService
  ) {}
}

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

import {
  IKufangEntity,
  KufangEntity
} from "app/xtwh/kufang/models/kufang.model";
import {
  SelectedKufangPageActions,
  CollectionPageActions,
  CollectionApiActions,
  NewKufangPageActions
} from "../actions";
import { KufangService } from "../service";

@Injectable()
export class CollectionEffects {
  /**
   * This effect does not yield any actions back to the store. Set
   * `dispatch` to false to hint to @ngrx/effects that it should
   * ignore any elements of this effect stream.
   *
   * The `defer` observable accepts an observable factory function
   * that is called when the observable is subscribed to.
   * Wrapping the database open call in `defer` makes
   * effect easier to test.
   */
  /*
     * rxjs写法。loadCollection$ 是effect名，在外部没有用到，可以随便起。
     */
  @Effect()
  loadCollection$: Observable<Action> = this.actions$.pipe(
    ofType(CollectionPageActions.CollectionPageActionTypes.LoadCollection),
    switchMap(() =>
      this.kufangService.queryyu().pipe(
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
  /*
   * 删除记录
   */
  // @Effect()
  // destroy$: Observable<Action> = this.actions$.pipe(
  //   ofType(SelectedKufangPageActions.SelectedKufangPageActionTypes.RemoveKufang),
  //   map((action: SelectedKufangPageActions.RemoveKufang) => action.payload),
  //   switchMap(
  //     (kufang: IKufangEntity) => this.kufangService.delete(kufang.id).pipe(
  //       map(() => new CollectionApiActions.RemoveKufangSuccess(kufang))
  //     )
  //   )
  // );

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

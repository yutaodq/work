import { Injectable } from "@angular/core";
// import { Database } from '@ngrx/db';
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
  CollectionApiActions
} from "app/xtwh/kufang/actions";
import { KufangService } from "app/xtwh/kufang/service/kufang.service";

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
  // @Effect({ dispatch: false })
  // openDB$: Observable<any> = defer(() => {
  //   return this.db.open('books_app');
  // });
  @Effect()
  loadCollection$: Observable<Action> = this.actions$.pipe(
    ofType(
      CollectionPageActions.CollectionPageActionTypes.LoadCollection
    ) /* When [Contacts] LOAD ALL action is dispatched */,
    startWith(new CollectionPageActions.LoadCollection()),
    switchMap(() =>
      this.kufangService.queryyu()
    ) /* Hit the Contacts Index endpoint of our REST API */,
    /* Dispatch LoadAllSuccess action to the central store with id list returned by the backend as id*/
    /* 'Contacts Reducers' will take care of the rest */
    map(
      (kufangs: KufangEntity[]) =>
        new CollectionApiActions.LoadKufangsSuccess(kufangs)
    )
  );
  // @Effect()
  // loadAll$: Observable<Action> = this.actions$.pipe(
  //   ofType(ContactsActionTypes.LOAD_ALL), /* When [Contacts] LOAD ALL action is dispatched */
  //   startWith(new LoadAll()),
  //   switchMap(() => this.contactsService.index()), /* Hit the Contacts Index endpoint of our REST API */
  //   /* Dispatch LoadAllSuccess action to the central store with id list returned by the backend as id*/
  //   /* 'Contacts Reducers' will take care of the rest */
  //   map((contacts: Contact[]) => new LoadAllSuccess(contacts))
  // );

  // @Effect()
  // loadCollection$: Observable<Action> = this.actions$.pipe(
  //   ofType(CollectionPageActions.CollectionPageActionTypes.LoadCollection),
  //   switchMap(() =>
  //     this.kufangService.queryyu().pipe(
  //       toArray(),
  //       map(
  //         (kufangs: IKufangEntity[]) => new CollectionApiActions.LoadKufangsSuccess(kufangs)
  //       ),
  //       catchError(error =>
  //         of(new CollectionApiActions.LoadKufangsFailure(error))
  //       )
  //     )
  //   )
  // );

  // @Effect()
  // loadCollection$: Observable<Action> = this.actions$.pipe(
  //   ofType(
  //     CollectionPageActions.CollectionPageActionTypes.LoadCollection
  //   ) /* When [Contacts] LOAD ALL action is dispatched */,
  //   switchMap(() =>
  //     this.kufangService.queryyu()
  //   ) /* Hit the Contacts Index endpoint of our REST API */,
  //   /* Dispatch LoadAllSuccess action to the central store with id list returned by the backend as id*/
  //   /* 'Contacts Reducers' will take care of the rest */
  //   map(
  //     (kufangs: IKufangEntity[]) =>
  //       new CollectionApiActions.LoadKufangsSuccess(kufangs)
  //   )
  // );

  // @Effect()
  // addBookToCollection$: Observable<Action> = this.actions$.pipe(
  //   ofType<SelectedBookPageActions.AddBook>(
  //     SelectedBookPageActions.SelectedBookPageActionTypes.AddBook
  //   ),
  //   map(action => action.payload),
  //   mergeMap(book =>
  //     this.db.insert('books', [book]).pipe(
  //       map(() => new CollectionApiActions.AddBookSuccess(book)),
  //       catchError(() => of(new CollectionApiActions.AddBookFailure(book)))
  //     )
  //   )
  // );
  //
  // @Effect()
  // removeBookFromCollection$: Observable<Action> = this.actions$.pipe(
  //   ofType<SelectedBookPageActions.RemoveBook>(
  //     SelectedBookPageActions.SelectedBookPageActionTypes.RemoveBook
  //   ),
  //   map(action => action.payload),
  //   mergeMap(book =>
  //     this.db.executeWrite('books', 'delete', [book.id]).pipe(
  //       map(() => new CollectionApiActions.RemoveBookSuccess(book)),
  //       catchError(() => of(new CollectionApiActions.RemoveBookFailure(book)))
  //     )
  //   )
  // );

  constructor(
    private actions$: Actions,
    private kufangService: KufangService
  ) {}
}

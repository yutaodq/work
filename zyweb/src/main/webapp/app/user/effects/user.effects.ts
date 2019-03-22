import { Injectable } from "@angular/core";
import { Action } from "@ngrx/store";
import { Actions, Effect, ofType } from "@ngrx/effects";
import { Observable } from "rxjs/Observable";
import { of } from "rxjs/observable/of";
import { map, switchMap, filter, catchError } from "rxjs/operators";
import { UserService } from "../service";
// import { UtilsService } from "app/core";
import { IUserEntity } from "app/models";
import * as actions from "../actions";
import { Response } from "app/models";

@Injectable()
export class UserEffects {
  // @Effect()
  // loginEffect$: Observable<Action> = this.action$.pipe(
  //   ofType(actions.UserActionTypes.LOGIN),
  //   map((action: actions.LoginAction) => action.payload),
  //   switchMap((user: IUserEntity) => {
  //     return this.userService.login(user).pipe(
  //       map((res: Response) => {
  //         if (res.success) {
  //           if (user.rememberMe) {
  //             this.utilsService.writeToken(res.payload);
  //           }
  //           return new actions.LoginSuccessAction(user.username);
  //         } else {
  //           return new actions.LoginFailAction(res.payload);
  //         }
  //       }),
  //       catchError(err => of(new actions.LoginFailAction(err)))
  //     );
  //   })
  // );

  // @Effect()
  // logoutEffect$: Observable<Action> = this.action$.pipe(
  //   ofType(actions.UserActionTypes.LOGOUT),
  //   map(() => {
  //     // this.utilsService.removeToken();
  //     return new actions.LogoutSuccessAction();
  //   })
  // );

  // @Effect()
  // getUserEffect$: Observable<Action> = this.action$.pipe(
  //   ofType(actions.UserActionTypes.GETUSER),
  //   switchMap(() => {
  //     return this.userService
  //       .getUserFromServer()
  //       .pipe(
  //         filter(user => user !== null),
  //         map(
  //           (user: IUserEntity) =>
  //             new actions.GetUserSuccessAction(user.username)
  //         ),
  //         catchError(err => of(new actions.GetUserFailAction(err)))
  //       );
  //   })
  // );

  constructor(private action$: Actions) // private userService: UserService
  // private utilsService: UtilsService
  {}
}

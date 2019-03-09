// import { Injectable } from "@angular/core";
// import { Action } from "@ngrx/store";
// import { Effect, Actions } from "@ngrx/effects";
//
// import { Observable } from "rxjs/Observable";
// import { of } from "rxjs/observable/of";
// import { map, switchMap, filter, catchError } from "rxjs/operators";
//
// import { UserService } from "../../userrvice/user.service";
// import { UtilsService } from "../..rvices/utils.service";
// import { IUserEntity } from "app/core/model";
// import * as actions from "../actions";
//
// @Injectable()
// export class UserEffects {
//   constructor(
//     private action$: Actions,
//     private userService: UserService,
//     private utils: UtilsService
//   ) { }
//
//   @Effect()
//   loginEffect$: Observable<Action> = this.action$.ofType(actions.LOGIN).pipe(
//     map((action: actions.LoginAction) => action.payload),
//     switchMap((user: User) => {
//       return this.userService.loginServer(user).pipe(
//         map((res: Response) => {
//           if (res.success) {
//             if (user.rememberMe) {
//               this.utils.writeToken(res.payload);
//             }
//             return new actions.LoginSuccessAction(user.username);
//           } else {
//             return new actions.LoginFailAction(res.payload);
//           }
//         }),
//         catchError((err) => of(new actions.LoginFailAction(err))),
//       )
//     }),
//   );
//
//   @Effect()
//   logoutEffect$: Observable<Action> = this.action$.ofType(actions.LOGOUT).pipe(
//     map(() => {
//       this.utils.removeToken();
//       return (new actions.LogoutSuccessAction());
//     })
//   )
//
//   @Effect()
//   getUserEffect$: Observable<Action> = this.action$.ofType(actions.GETUSER).pipe(
//     switchMap(() => {
//       return this.userService.getUserFromServer().pipe(
//         filter(user => (user !== null)),
//         map((user: User) => new actions.GetUserSuccessAction(user.username)),
//         catchError(err => of(new actions.GetUserFailAction(err))),
//       )
//     })
//   )
// }

import { Injectable } from "@angular/core";

import { HttpClient } from "@angular/common/http";

import "rxjs/add/operator/map";
import { Store } from "@ngrx/store";
import * as fromUser from "../reducers";
import { Router } from "@angular/router";

@Injectable()
export class UserService {
  constructor(
    private _router: Router,
    private http: HttpClient,
    private store: Store<fromUser.State>
  ) {}

  login(username: string, password: string) {
    console.log("应用程序启动成功{}和{}" + username + password);
  }
  // constructor(
  //   private http: HttpClient,
  //   // private appConfig: AppConfig,
  //   private utils: UtilsService
  // ) {}
  //
  // loginServer(loginData): Observable<Response> {
  //   const username = loginData.username.trim();
  //   const password = loginData.password.trim();
  //   return this.http.post<Response>("/users/authenticate", {
  //     username: "username",
  //     password: "password"
  //   });
  // }
  //
  // // get user from server
  // getUserFromServer(): Observable<IUserEntity> {
  //   if (!this.utils.isTokenExpired()) {
  //     const token = this.utils.getToken();
  //     return this.http
  //       .post("/users/currentUser", { token: "token" })
  //       .map((res: Response) => {
  //         if (res.success) {
  //           return { username: res.payload };
  //         } else {
  //           return null;
  //         }
  //       });
  //   } else {
  //     return of(null);
  //   }
  // }
}

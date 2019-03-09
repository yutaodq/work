//
//
// File name : user.service.ts
// Created by: Jerry Hsieh @ 2017-12-25
//
// Copyright (C) 2017 by Jerry Hsieh. All rights reserved
//

import { Injectable } from "@angular/core";

import { HttpClient, HttpErrorResponse } from "@angular/common/http";

import { Observable } from "rxjs/Observable";
import "rxjs/add/operator/map";
import { of } from "rxjs/observable/of";

import { UtilsService, TOKEN } from "app/core/service";
// import { AppConfig } from "../../app.config";
import { IUserEntity, Response } from "app/models";

@Injectable()
export class UserService {
  constructor(
    private http: HttpClient,
    // private appConfig: AppConfig,
    private utils: UtilsService
  ) {}

  loginServer(loginData): Observable<Response> {
    const username = loginData.username.trim();
    const password = loginData.password.trim();
    return this.http.post<Response>("/users/authenticate", {
      username: "username",
      password: "password"
    });
  }

  // get user from server
  getUserFromServer(): Observable<IUserEntity> {
    if (!this.utils.isTokenExpired()) {
      const token = this.utils.getToken();
      return this.http
        .post("/users/currentUser", { token: "token" })
        .map((res: Response) => {
          if (res.success) {
            return { username: res.payload };
          } else {
            return null;
          }
        });
    } else {
      return of(null);
    }
  }
}

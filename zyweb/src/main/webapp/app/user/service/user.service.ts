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

import { UtilsService, TOKEN } from "../../helper/utils.service";
import { AppConfig } from "../../app.config";
import { IUserEntity, Response } from "app/models";

@Injectable()
export class UserService {
  constructor(
    private http: HttpClient,
    private appConfig: AppConfig,
    private utils: UtilsService
  ) {}

  loginServer(loginData): Observable<Response> {
    let username = loginData.username.trim();
    let password = loginData.password.trim();
    return this.http.post<Response>(
      this.appConfig.apiUrl + "/users/authenticate",
      { username: username, password: password }
    );
  }

  // get user from server
  getUserFromServer(): Observable<User> {
    if (!this.utils.isTokenExpired()) {
      const token = this.utils.getToken();
      return this.http
        .post(this.appConfig.apiUrl + "/users/currentUser", { token: token })
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

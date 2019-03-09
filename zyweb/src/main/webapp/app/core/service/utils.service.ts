//
//
// File name : utils.service.ts
// Created by: Jerry Hsieh @ 2017-12-26
// ngrx-auth
// Copyright (C) 2017 by Jerry Hsieh. All rights reserved
//

import { Injectable } from "@angular/core";

import { JwtHelperService } from "@auth0/angular-jwt";

export const TOKEN = "access_token";

@Injectable()
export class UtilsService {
  constructor(private jwtHelper: JwtHelperService) {}

  isTokenExpired(token: string = TOKEN): boolean {
    const jwtStr = localStorage.getItem(token);
    if (jwtStr) {
      return this.jwtHelper.isTokenExpired(jwtStr);
    } else {
      return true; // no token, token expired
    }
  }

  writeToken(token: string = TOKEN, value: string) {
    // this.jwtHelper.isTokenExpired(value);
    localStorage.setItem(token, value);
  }

  removeToken(token: string = TOKEN) {
    if (localStorage.getItem(token)) {
      localStorage.removeItem(token);
    }
  }

  getToken(token: string = TOKEN) {
    return localStorage.getItem(token);
  }
}

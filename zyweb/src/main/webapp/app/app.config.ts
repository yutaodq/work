//
//
// File name : app.config
// Created by: Jerry Hsieh @ 2018-01-04
//
// Copyright (C) 2018 by Jerry Hsieh. All rights reserved
//
import { Injectable } from "@angular/core";

@Injectable()
export class AppConfig {
  /*
     * apiUrl 可以在webpack.dev.js文件中配置
     * D:\yutao\work\zyweb\webpack\webpack.dev.js
     */
  public readonly apiUrl = "http://localhost:3000/api";
}

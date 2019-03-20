import { Component, OnInit } from "@angular/core";
import { Store } from "@ngrx/store";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import * as fromLogin from "../reducers";
import {
  DynamicFormControlModel,
  DynamicFormService
} from "@ng-dynamic-forms/core";
import { ActivatedRoute } from "@angular/router";
import { LoginFormModel } from "app/user/form/login-form.model";

@Component({
  selector: "zy-login-page",
  templateUrl: "./login-page.component.html"
})
export class LoginPageComponent implements OnInit {
  private _pageTitle: string;
  private _formModel: DynamicFormControlModel[];
  private _formGroup: FormGroup;

  constructor(
    private _store: Store<fromLogin.State>,
    private _activatedRoute: ActivatedRoute,
    private _formService: DynamicFormService
  ) {}

  ngOnInit() {
    this.initPageTitle();
    this.initFormGroup();
  }

  private initPageTitle() {
    this._activatedRoute.data.subscribe(data => {
      this._pageTitle = data.pageTitle;
    });
  }

  initFormGroup() {
    this._formModel = LoginFormModel.createFormModel();
    this._formGroup = this._formService.createFormGroup(this._formModel);
  }

  login() {
    console.log(`应用程序启动成功: login`);
  }

  cancel() {
    console.log(`应用程序启动成功: cancel`);
  }

  /*
   *设置属性
   */
  get pageTitle(): string {
    return this._pageTitle;
  }

  get formGroup() {
    return this._formGroup;
  }

  get formModel() {
    return this._formModel;
  }
}

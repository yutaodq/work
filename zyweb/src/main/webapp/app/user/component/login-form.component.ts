import { Component, Input, OnInit } from "@angular/core";
import {
  FormBuilder,
  FormGroup,
  FormControl,
  Validators
} from "@angular/forms";
// import { MatSnackBar } from '@angular/material';

import { Store } from "@ngrx/store";
import * as fromStore from "../../store";
import { DynamicFormControlModel } from "@ng-dynamic-forms/core";

@Component({
  selector: "zy-login-form",
  templateUrl: "./login-form.component.html"
})
export class LoginFormComponent implements OnInit {
  private _formGroup: FormGroup;
  private _formModel: DynamicFormControlModel[];

  constructor() {}

  ngOnInit() {}

  /*
   *设置属性
   */

  @Input()
  set formGroup(formGroup: FormGroup) {
    this._formGroup = formGroup;
  }
  get formGroup() {
    return this._formGroup;
  }

  @Input()
  set formModel(formModel: DynamicFormControlModel[]) {
    this._formModel = formModel;
  }
  get formModel() {
    return this._formModel;
  }

  get username() {
    return this.formGroup.get("username");
  }
  get password() {
    return this.formGroup.get("password");
  }
  get rememberMe() {
    return this.formGroup.get("rememberMe");
  }
}

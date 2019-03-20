import {
  DynamicFormControlModel,
  DynamicInputModel
} from "@ng-dynamic-forms/core";
export class LoginFormModel {
  static createFormModel(): DynamicFormControlModel[] {
    return [
      new DynamicInputModel({
        id: "username",
        label: "用户名",
        value: "",
        placeholder: "用户名"
      }),
      new DynamicInputModel({
        id: "password",
        label: "登录密码",
        value: "",
        placeholder: "登录密码"
      })
    ];
  }
}

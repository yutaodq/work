import {
  DynamicFormControlModel,
  DynamicInputModel
} from "@ng-dynamic-forms/core";

export const NG_BOOTSTRAP_LONGIN_FORM_MODEL: DynamicFormControlModel[] = [
  new DynamicInputModel({
    id: "username",
    label: "用户名",
    value: "",
    placeholder: "用户名"
  }),
  new DynamicInputModel({
    id: "password",
    label: "登陆密码",
    value: "",
    placeholder: "登陆密码"
  })
];

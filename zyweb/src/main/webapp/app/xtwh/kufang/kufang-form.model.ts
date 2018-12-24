import {
  DynamicCheckboxModel,
  DynamicCheckboxGroupModel,
  DynamicDatePickerModel,
  DynamicFormControlModel,
  DynamicFormGroupModel,
  DynamicInputModel,
  DynamicRadioGroupModel,
  DynamicRatingModel,
  DynamicSelectModel,
  DynamicTextAreaModel
} from "@ng-dynamic-forms/core";

import {
  myCustomValidator,
  kufangNameValidator
} from "./kufang-form.validator";
import { Injectable, OnInit } from "@angular/core";
import { KufangService } from "app/xtwh/kufang/index";
import { IKufangEntity } from "app/shared";

@Injectable()
export class KufangFormModel implements OnInit {
  constructor(private kufangService: KufangService) {}
  ngOnInit() {}

  createFormModel(kufang: IKufangEntity): DynamicFormControlModel[] {
    return [
      new DynamicInputModel({
        id: "name",
        label: "库房名称",
        placeholder: "库房名称",
        validators: {
          required: null,
          minLength: 3,
          validator: {
            name: myCustomValidator.name,
            args: "aaa"
          }
        },
        asyncValidators: {
          validator: {
            name: kufangNameValidator.name,
            args: this.kufangService
          }
        },
        errorMessages: {
          required: "请您填写：{{ label }} ",
          minLength: "{{ label }}不能少于三个字",
          myCustomValidator: "{{label}} cannot start with abc",
          kufangNameValidator: "您录入的{{ label }}已经使用"
        }
      }),
      new DynamicTextAreaModel({
        id: "bz",
        label: "库房说明",
        placeholder: "请在此处填写该库房的信息",
        rows: 5
      })
    ];
  }
}

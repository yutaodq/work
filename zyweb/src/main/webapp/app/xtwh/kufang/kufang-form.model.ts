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
  DynamicTextAreaModel,
  DynamicTimePickerModel,
  DynamicFormService
} from "@ng-dynamic-forms/core";

import {
  myCustomValidator,
  UniqueNameValidator,
  kufangNameValidator
} from "./kufang-form.validator";
import { Injectable, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { FormGroup } from "@angular/forms";
import { KufangService } from "app/xtwh/kufang/index";

@Injectable()
export class KufangFormModel implements OnInit {
  constructor(private kufangService: KufangService) {}
  ngOnInit() {}

  get formModel() {
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
          minLength: "库房名称不能少于三个字",
          myCustomValidator: "{{label}} cannot start with abc",
          kufangNameValidator: "您录入的库房名称已经使用"
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

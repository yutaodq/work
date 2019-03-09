import {
  DynamicFormControlModel,
  DynamicInputModel,
  DynamicTextAreaModel
} from "@ng-dynamic-forms/core";

import {
  myCustomValidator,
  kufangNameValidator
} from "./kufang-form.validator";
import { KufangService } from "app/xtwh/kufang";
import { IKufangEntity } from "app/models";

export class KufangFormModelService {
  createFormModel(
    kufang: IKufangEntity,
    kufangService: KufangService,
    disabledField = true
  ): DynamicFormControlModel[] {
    return [
      new DynamicInputModel({
        id: "name",
        label: "库房名称",
        value: kufang.name,
        disabled: disabledField,
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
            args: kufangService
          }
        },
        updateOn: "blur",
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
        value: kufang.bz,
        disabled: disabledField,
        placeholder: "请在此处填写该库房的信息",
        rows: 5
      })
    ];
  }
}

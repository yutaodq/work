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
  DynamicTimePickerModel
} from "@ng-dynamic-forms/core";
import {
  myCustomValidator,
  UniqueNameValidator,
  kufangNameValidator
} from "./kufang-form.validator";
import { KufangService } from "./kufang.service";
import { Validators } from "@angular/forms";

// const kufangService: KufangService = new KufangService();

export const KUFANG_FORM_MODEL: DynamicFormControlModel[] = [
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
      // asyncValidators: {
      //   name: UniqueNameValidator,
      //   args: null
      // }
    },
    asyncValidators: {
      validator: {
        name: kufangNameValidator.name,
        args: null
      }
    },
    // asyncValidators: [
    //   {
    //     name: kufangNameValidator.name,
    //     args: null
    //   }
    //   // {
    //   //   name: UniqueNameValidator.name,
    //   //   args: null
    //   // }
    // ],

    errorMessages: {
      required: "请您填写：{{ label }} ",
      minLength: "库房名称不能少于三个字",
      myCustomValidator: "{{label}} cannot start with abc",
      kufangNameValidator: "addfdsfdfsdsf"
    }
  }),
  new DynamicTextAreaModel({
    id: "bz",
    label: "库房说明",
    placeholder: "请在此处填写该库房的信息",
    rows: 5
  })
];

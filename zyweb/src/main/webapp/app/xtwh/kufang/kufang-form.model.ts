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

export const KUFANG_FORM_MODEL: DynamicFormControlModel[] = [
  new DynamicInputModel({
    id: "name",
    label: "库房名称",
    placeholder: "Last Name",
    validators: {
      required: null
    },
    errorMessages: {
      required: "{{ label }} is required"
    }
  }),
  new DynamicTextAreaModel({
    id: "bz",
    label: "库房说明",
    placeholder: "请在此处赶写该库房的信息",
    rows: 5
  })
];

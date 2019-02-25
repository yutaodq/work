import { DynamicFormControlModel } from "@ng-dynamic-forms/core";

export interface IZyFormModel<T> {
  createFormModel(entity: T, disabledField: boolean): DynamicFormControlModel[];
}

import { DynamicFormControlModel } from "@ng-dynamic-forms/core";
/*
 *  没有类使用这个接口了，可以删除了
 */
export interface IZyFormModel<T> {
  createFormModel(entity: T, disabledField: boolean): DynamicFormControlModel[];
}

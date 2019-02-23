import {
  DynamicFormControlModel,
  DynamicFormService
} from "@ng-dynamic-forms/core";
import { FormGroup } from "@angular/forms";
import { IZyFormModel } from "app/core/service/form/zy-form.model";
import { EventEmitter, Input, OnInit, Output } from "@angular/core";

export abstract class FormComponent<T> implements OnInit {
  private _entity: T;
  _isSaving: boolean;
  _formGroup: FormGroup;
  _formModel: DynamicFormControlModel[];

  constructor(
    private _formService: DynamicFormService,
    private _formModelService: IZyFormModel<T>
  ) {}

  ngOnInit() {
    this.initForm();
    this.isSaving = false;
  }

  /*
 * 通用方法
 */
  protected initForm() {
    this.formModel = this.formModelService.createFormModel(this.entity);
    this.formGroup = this.formService.createFormGroup(this.formModel);
  }

  restoreEntity() {
    this.initForm();
  }

  returnEntity(): T {
    this.entity = this.formGroup.value;
    return this.entity;
  }
  /*
   * 抽象方法
   */
  // abstract formModelToEntity();

  /*
   * 对象的访问器和设置器
   */
  protected get formModelService() {
    return this._formModelService;
  }

  protected get formService() {
    return this._formService;
  }

  set formGroup(formGroup: FormGroup) {
    this._formGroup = formGroup;
  }
  get formGroup() {
    return this._formGroup;
  }

  set formModel(formModel: DynamicFormControlModel[]) {
    this._formModel = formModel;
  }
  get formModel() {
    return this._formModel;
  }

  get isSaving() {
    return this._isSaving;
  }
  set isSaving(isSaving) {
    this._isSaving = isSaving;
  }

  @Input()
  set entity(entity: T) {
    this._entity = entity;
  }
  get entity() {
    return this._entity;
  }
}

import {
  DynamicFormControlModel,
  DynamicFormService
} from "@ng-dynamic-forms/core";
import { FormGroup } from "@angular/forms";
import { ActivatedRoute } from "@angular/router";
import { IZyFormModel } from "app/core/service/form/zy-form.model";

export abstract class NewComponent<T> {
  _entity: T;
  _isSaving: boolean;
  _pageTitle: string;
  _formGroup: FormGroup;
  _formModel: DynamicFormControlModel[];

  constructor(
    private _activatedRoute: ActivatedRoute,
    private _formService: DynamicFormService,
    private _formModelService: IZyFormModel<T>
  ) {}

  protected initForm() {
    this._formModel = this.formModelService.createFormModel(this._entity);
    this._formGroup = this.formService.createFormGroup(this._formModel);
  }

  protected get formModelService() {
    return this._formModelService;
  }

  protected get activatedRoute() {
    return this._activatedRoute;
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

  set pageTitle(pageTitle: string) {
    this._pageTitle = pageTitle;
  }
  get pageTitle() {
    return this._pageTitle;
  }
  get isSaving() {
    return this._isSaving;
  }

  set entity(entity: T) {
    this._entity = entity;
  }
  get entity() {
    return this._entity;
  }
}

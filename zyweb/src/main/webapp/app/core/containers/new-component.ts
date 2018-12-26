import {
  DynamicFormControlModel,
  DynamicFormService
} from "@ng-dynamic-forms/core";
import { FormGroup } from "@angular/forms";
import { ActivatedRoute } from "@angular/router";
import { IZyFormModel } from "app/core/service/form/zy-form.model";
import { OnInit } from "@angular/core";
import { HttpErrorResponse, HttpResponse } from "@angular/common/http";
import { Observable } from "rxjs/index";
import { IKufangEntity } from "app/shared";
// implements OnInit
export abstract class NewComponent<T> implements OnInit {
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

  ngOnInit() {
    console.log(`NewComponent - ngOnInit`);
    this.activatedRoute.data.subscribe(data => {
      this.pageTitle = data.pageTitle;
    });
    this.activatedRoute.data.subscribe(({ entity }) => {
      this.entity = entity;
      this.initForm();
    });
    this.isSaving = false;
  }
  /*
 * 通用方法
 */
  protected initForm() {
    this._formModel = this.formModelService.createFormModel(this._entity);
    this._formGroup = this.formService.createFormGroup(this._formModel);
  }
  //以前的状态 在表单中按返回键时调用的方法
  previousState() {
    window.history.back();
  }
  save() {
    this.isSaving = true;
    this.formModeltoEntity();
    // this.subscribeToSaveResponse(this.kufangService.create(this.entity));
  }

  protected subscribeToSaveResponse(
    result: Observable<HttpResponse<IKufangEntity>>
  ) {
    result.subscribe(
      (res: HttpResponse<IKufangEntity>) => this.onSaveSuccess(),
      (res: HttpErrorResponse) => this.onSaveError()
    );
  }

  private onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  private onSaveError() {
    this.isSaving = false;
  }

  /*
   * 抽象方法
   */
  abstract formModeltoEntity();

  /*
   * 对象的访问器和设置器
   */
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
  set isSaving(isSaving) {
    this._isSaving = isSaving;
  }

  set entity(entity: T) {
    this._entity = entity;
  }
  get entity() {
    return this._entity;
  }
}
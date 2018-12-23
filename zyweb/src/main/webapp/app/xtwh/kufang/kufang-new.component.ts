import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { HttpResponse, HttpErrorResponse } from "@angular/common/http";
import { Observable } from "rxjs";
import {
  DynamicFormControlModel,
  DynamicFormService,
  DynamicFormLayout,
  DynamicTextAreaModel,
  DynamicInputModel
} from "@ng-dynamic-forms/core";

import { IKufangEntity } from "app/shared";
import { KufangService } from "./";

import { FormGroup } from "@angular/forms";
import { KUFANG_FORM_MODEL } from "./kufang-form.model";
import { KUFANG_FORM_LAYOUT } from "./kufang-form.layout";
import { KufangFormService } from "app/xtwh/kufang/kufang-form.service";
import {
  kufangNameValidator,
  myCustomValidator
} from "app/xtwh/kufang/kufang-form.validator";

@Component({
  selector: "zy-kufang-new",
  templateUrl: "./kufang-new.component.html"
})
export class KufangNewComponent implements OnInit {
  kufang: IKufangEntity;
  isSaving: boolean;
  pageTitle: string;
  _formGroup: FormGroup;
  // formModel: DynamicFormControlModel[] = KUFANG_FORM_MODEL;

  formModel: DynamicFormControlModel[] = [
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
        kufangNameValidator: "存在相同的库房名称"
      }
    }),
    new DynamicTextAreaModel({
      id: "bz",
      label: "库房说明",
      placeholder: "请在此处填写该库房的信息",
      rows: 5
    })
  ];

  formLayout: DynamicFormLayout = KUFANG_FORM_LAYOUT;

  constructor(
    private kufangService: KufangService,
    private activatedRoute: ActivatedRoute,
    private formService: DynamicFormService
  ) // private formService: KufangFormService
  {
    this.activatedRoute.data.subscribe(data => {
      this.pageTitle = data.pageTitle;
    });
  }

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ kufang }) => {
      this.kufang = kufang;
      // this._form = this.itemCreateForm(kufang);
    });
    this._formGroup = this.initForm();
  }
  private initForm(): FormGroup {
    return this.formService.createFormGroup(this.formModel);
  }

  // private initForm() {
  //   return this.formService.formCreate();
  // }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    if (this.kufang.id !== undefined) {
      this.subscribeToSaveResponse(this.kufangService.update(this.kufang));
    } else {
      this.subscribeToSaveResponse(this.kufangService.create(this.kufang));
    }
  }

  private subscribeToSaveResponse(
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

  get formGroup() {
    return this._formGroup;
  }
}

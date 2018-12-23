import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { HttpResponse, HttpErrorResponse } from "@angular/common/http";
import { Observable } from "rxjs";
import {
  DynamicFormControlModel,
  DynamicFormService,
  DynamicFormLayout
} from "@ng-dynamic-forms/core";

import { IKufangEntity } from "app/shared";
import { KufangService } from "./";

import { FormGroup } from "@angular/forms";
import { KUFANG_FORM_MODEL } from "./kufang-form.model";
import { KUFANG_FORM_LAYOUT } from "./kufang-form.layout";
import { KufangFormService } from "app/xtwh/kufang/kufang-form.service";

@Component({
  selector: "zy-kufang-new",
  templateUrl: "./kufang-new.component.html"
})
export class KufangNewComponent implements OnInit {
  kufang: IKufangEntity;
  isSaving: boolean;
  pageTitle: string;
  _formGroup: FormGroup;
  formModel: DynamicFormControlModel[] = KUFANG_FORM_MODEL;
  formLayout: DynamicFormLayout = KUFANG_FORM_LAYOUT;

  constructor(
    private kufangService: KufangService,
    private activatedRoute: ActivatedRoute,
    private formService: KufangFormService
  ) {
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
  // private initForm(): FormGroup {
  //   return this.formService.createFormGroup(this.formModel);
  // }

  private initForm() {
    return this.formService.formCreate();
  }

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

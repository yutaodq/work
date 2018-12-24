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
import { KufangFormModel } from "./kufang-form.model";
import { KUFANG_FORM_LAYOUT } from "./kufang-form.layout";

@Component({
  selector: "zy-kufang-new",
  templateUrl: "./kufang-new.component.html"
})
export class KufangNewComponent implements OnInit {
  kufang: IKufangEntity;
  isSaving: boolean;
  pageTitle: string;
  _formGroup: FormGroup;
  formModel: DynamicFormControlModel[];

  formLayout: DynamicFormLayout = KUFANG_FORM_LAYOUT;
  constructor(
    private kufangService: KufangService,
    private activatedRoute: ActivatedRoute,
    private formService: DynamicFormService,
    private kufangFormModel: KufangFormModel
  ) {
    this.activatedRoute.data.subscribe(data => {
      this.pageTitle = data.pageTitle;
      // this.formModel = this.kufangFormModel.formModel;
    });
  }

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ kufang }) => {
      this.kufang = kufang;
    });
    this._formGroup = this.initForm();
  }

  private initForm(): FormGroup {
    this.formModel = this.kufangFormModel.formModel;
    return this.formService.createFormGroup(this.formModel);
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

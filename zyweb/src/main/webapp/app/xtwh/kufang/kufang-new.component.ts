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
  _isSaving: boolean;
  _pageTitle: string;
  _formGroup: FormGroup;
  _formModel: DynamicFormControlModel[];

  formLayout: DynamicFormLayout = KUFANG_FORM_LAYOUT;
  constructor(
    private kufangService: KufangService,
    private activatedRoute: ActivatedRoute,
    private formService: DynamicFormService,
    private kufangFormModel: KufangFormModel
  ) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(data => {
      this._pageTitle = data.pageTitle;
    });
    this.activatedRoute.data.subscribe(({ kufang }) => {
      this.kufang = kufang;
      this.initForm();
    });
    this._isSaving = false;
  }

  private initForm() {
    this._formModel = this.kufangFormModel.createFormModel(this.kufang);
    this._formGroup = this.formService.createFormGroup(this._formModel);
  }

  previousState() {
    window.history.back();
  }

  save() {
    this._isSaving = true;
    this.kufang.name = this.formGroup.value["name"];
    this.kufang.bz = this.formGroup.value["bz"];
    console.warn(this.formGroup.value);
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
    this._isSaving = false;
    this.previousState();
  }

  private onSaveError() {
    this._isSaving = false;
  }

  get formGroup() {
    return this._formGroup;
  }
  get pageTitle() {
    return this._pageTitle;
  }
  get isSaving() {
    return this._isSaving;
  }
}

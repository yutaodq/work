import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { HttpResponse, HttpErrorResponse } from "@angular/common/http";
import { Observable } from "rxjs";
import { JhiAlertService } from "ng-jhipster";

import { IKufangEntity } from "app/shared/model/kufang.model";
import { KufangService } from "./kufang.service";

import { FormControl, FormGroup, Validators } from "@angular/forms";
import { UniqueNameValidator } from "app/xtwh/kufang/kufang-form.validator";

@Component({
  selector: "zy-kufang-new",
  templateUrl: "./kufang-new.component.html"
})
export class KufangNewComponent implements OnInit {
  private kufang: IKufangEntity;
  isSaving: boolean;
  pageTitle: string;
  // form: KufangFormModel = new KufangFormModel();
  _form: FormGroup;

  constructor(
    private jhiAlertService: JhiAlertService,
    private kufangService: KufangService,
    private activatedRoute: ActivatedRoute,
    private uniqueNameValidator: UniqueNameValidator
  ) // private  formModel: KufangFormModel
  {
    this.activatedRoute.data.subscribe(data => {
      this.pageTitle = data.pageTitle;
    });
  }

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ kufang }) => {
      this.kufang = kufang;
    });
    this.formInit();
    // this.form = this.formModel.form;
  }

  formInit(): void {
    this._form = new FormGroup({
      name: new FormControl("", {
        validators: [Validators.required, Validators.minLength(3)],
        asyncValidators: [
          this.uniqueNameValidator.validate.bind(this.uniqueNameValidator)
        ],
        updateOn: "blur"
      }),
      bz: new FormControl("", {
        validators: [Validators.required, Validators.minLength(3)],
        asyncValidators: [
          this.uniqueNameValidator.validate.bind(this.uniqueNameValidator)
        ],
        updateOn: "blur"
      })
    });
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

  private onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }

  // get kufang() {
  //   return this.kufang;
  // }
  //
  // set kufang(kufang: IKufangEntity) {
  //   this.kufang = kufang;
  // }
  get form() {
    return this._form;
  }
}

import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { HttpResponse, HttpErrorResponse } from "@angular/common/http";
import { Observable } from "rxjs";

import { IKufangEntity } from "app/shared";
import { KufangService } from "./";
import { FormGroup } from "@angular/forms";
import { KufangFormService } from "./kufang-form.service";

@Component({
  selector: "zy-kufang-new",
  templateUrl: "./kufang-new.component.html"
})
export class KufangNewComponent implements OnInit {
  kufang: IKufangEntity;
  isSaving: boolean;
  pageTitle: string;
  _form: FormGroup;

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
      this._form = this.itemCreateForm(kufang);
    });
  }

  itemCreateForm(item: IKufangEntity) {
    const form = this.formService.formCreate(item);
    return form;
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

  // private onError(errorMessage: string) {
  //   this.jhiAlertService.error(errorMessage, null, null);
  // }

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

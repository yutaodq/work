import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { HttpResponse, HttpErrorResponse } from "@angular/common/http";
import { Observable } from "rxjs";
import { JhiAlertService } from "ng-jhipster";

import { IKufangEntity } from "app/shared/model/kufang.model";
import { KufangService } from "./kufang.service";

import { FormModel } from "./form.model";

@Component({
  selector: "zy-kufang-new",
  templateUrl: "./kufang-new.component.html"
})
export class KufangNewComponent implements OnInit {
  private _kufang: IKufangEntity;
  isSaving: boolean;
  pageTitle: string;
  form: FormModel = new FormModel();

  constructor(
    private jhiAlertService: JhiAlertService,
    private kufangService: KufangService,
    private activatedRoute: ActivatedRoute
  ) {
    this.activatedRoute.data.subscribe(data => {
      this.pageTitle = data.pageTitle;
    });
  }

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ kufang }) => {
      this.kufang = kufang;
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

  get kufang() {
    return this._kufang;
  }

  set kufang(kufang: IKufangEntity) {
    this._kufang = kufang;
  }
}

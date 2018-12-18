import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { FormGroup } from "@angular/forms";
import {
  DynamicFormService,
  DynamicFormControlModel,
  DynamicFormLayout
} from "@ng-dynamic-forms/core";
import { KUFANG_FORM_MODEL } from "./kufang-form.model";
import { KUFANG_FORM_LAYOUT } from "./kufang-form.layout";

@Component({
  // moduleId: module.id,
  selector: "zy-kufang-new",
  styleUrls: [],
  templateUrl: "./kufang-new.component.html",
  encapsulation: ViewEncapsulation.None
})
export class KufangNewComponent implements OnInit {
  formModel: DynamicFormControlModel[] = KUFANG_FORM_MODEL;
  formGroup: FormGroup;
  formLayout: DynamicFormLayout = KUFANG_FORM_LAYOUT;

  constructor(private formService: DynamicFormService) {}

  ngOnInit() {
    this.formGroup = this.formService.createFormGroup(this.formModel);
  }

  onBlur($event) {
    console.log(`NG Bootstrap blur event on: ${$event.model.id}: `, $event);
  }

  onChange($event) {
    console.log(`NG Bootstrap change event on: ${$event.model.id}: `, $event);
  }

  onFocus($event) {
    console.log(`NG Bootstrap focus event on: ${$event.model.id}: `, $event);
  }

  onNgbEvent($event) {
    console.log(
      `NG Bootstrap ${$event.type} event on: ${$event.model.id}: `,
      $event
    );
  }
}
//
// import { Component, OnInit } from "@angular/core";
// import { ActivatedRoute } from "@angular/router";
// import { HttpResponse, HttpErrorResponse } from "@angular/common/http";
// import { Observable } from "rxjs";
// import { DynamicFormControlModel, DynamicFormModel, DynamicFormService, DynamicFormLayout } from "@ng-dynamic-forms/core";
//
// import { IKufangEntity } from "app/shared";
// import { KufangService } from "./";
// import { FormGroup } from "@angular/forms";
// // import { KufangFormService } from "./kufang-form.service";
// import { KUFANG_FORM_MODEL } from "./kufang-form.model";
// import { KUFANG_FORM_LAYOUT } from "./kufang-form.layout";
//
// @Component({
//   selector: "zy-kufang-new",
//   templateUrl: "./kufang-new.component.html"
// })
//
// export class KufangNewComponent implements OnInit {
//   kufang: IKufangEntity;
//   isSaving: boolean;
//   pageTitle: string;
//   _form: FormGroup;
//   formGroup: FormGroup;
//   formModel: DynamicFormControlModel[] = KUFANG_FORM_MODEL;
//   formLayout: DynamicFormLayout = KUFANG_FORM_LAYOUT;
//
//   constructor(
//     private kufangService: KufangService,
//     private activatedRoute: ActivatedRoute,
//     private formService: DynamicFormService,
//     // private formService: KufangFormService
//   ) {
//     this.activatedRoute.data.subscribe(data => {
//       this.pageTitle = data.pageTitle;
//     });
//   }
//
//   ngOnInit() {
//     this.isSaving = false;
//     this.activatedRoute.data.subscribe(({ kufang }) => {
//       this.kufang = kufang;
//       // this._form = this.itemCreateForm(kufang);
//     });
//     this.formGroup = this.formService.createFormGroup(this.formModel);
//
//   }
//
//   // itemCreateForm(item: IKufangEntity) {
//   //   const form = this.formService.formCreate(item);
//   //   return form;
//   // }
//
//   previousState() {
//     window.history.back();
//   }
//
//   save() {
//     this.isSaving = true;
//     if (this.kufang.id !== undefined) {
//       this.subscribeToSaveResponse(this.kufangService.update(this.kufang));
//     } else {
//       this.subscribeToSaveResponse(this.kufangService.create(this.kufang));
//     }
//   }
//
//   private subscribeToSaveResponse(
//     result: Observable<HttpResponse<IKufangEntity>>
//   ) {
//     result.subscribe(
//       (res: HttpResponse<IKufangEntity>) => this.onSaveSuccess(),
//       (res: HttpErrorResponse) => this.onSaveError()
//     );
//   }
//
//   private onSaveSuccess() {
//     this.isSaving = false;
//     this.previousState();
//   }
//
//   private onSaveError() {
//     this.isSaving = false;
//   }
//
//   // private onError(errorMessage: string) {
//   //   this.jhiAlertService.error(errorMessage, null, null);
//   // }
//
//   // get kufang() {
//   //   return this.kufang;
//   // }
//   //
//   // set kufang(kufang: IKufangEntity) {
//   //   this.kufang = kufang;
//   // }
//   get form() {
//     return this._form;
//   }
// }

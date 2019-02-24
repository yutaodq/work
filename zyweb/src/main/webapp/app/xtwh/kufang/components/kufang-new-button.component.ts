import { Component } from "@angular/core";
import { NewPageButtonComponent } from "app/core/components";

@Component({
  selector: "zy-kufang-new-button",
  templateUrl: "../../../template/new-page-button.component.html"
})
export class KufangNewButtonComponent extends NewPageButtonComponent {
  onCancel() {
    this.previousState();
  }

  /*
   * 按钮的标题 改变默认值时使用
   */
  // get cancelButtonCaption(): string {
  //   return "取消创建";
  // }
  // get saveButtonCaption(): string {
  //   return "保存记录";
  // }
  // get recoverButtonCaption(): string {
  //   return "恢复初始值";
  // }
}

// 可以使用
// import { Component, OnInit } from "@angular/core";
// import { ActivatedRoute } from "@angular/router";
// import { DynamicFormService } from "@ng-dynamic-forms/core";
//
// import { IKufangEntity } from "app/xtwh/kufang/";
// import { KufangService } from "../";
//
// import { KufangFormModelService } from "../kufang-form-model.service";
// import { KUFANG_FORM_LAYOUT } from "../kufang-form.layout";
// import { FormComponent } from "app/core/containers/new-component";
//
// export class KufangNewButtonComponent extends FormComponent<IKufangEntity>
//   implements OnInit {
//   constructor(
//     activatedRoute: ActivatedRoute,
//     formService: DynamicFormService,
//     formModelService: KufangFormModelService,
//     kufangService: KufangService
//   ) {
//     super(activatedRoute, formService, formModelService, kufangService);
//   }
//
//   ngOnInit() {
//     console.log(`KufangNewButtonComponent - ngOnInit`);
//     super.ngOnInit();
//   }
//
//   formModelToEntity() {
//     this.kufang.name = this.formGroup.value["name"];
//     this.kufang.bz = this.formGroup.value["bz"];
//   }
// }

// 原始代码
// export class KufangNewButtonComponent implements OnInit {
//   _entity: IKufangEntity;
//   _isSaving: boolean;
//   _pageTitle: string;
//   _formGroup: FormGroup;
//   _formModel: DynamicFormControlModel[];
//
//   formLayout: DynamicFormLayout = KUFANG_FORM_LAYOUT;
//   constructor(
//     private kufangService: KufangService,
//     private activatedRoute: ActivatedRoute,
//     private formService: DynamicFormService,
//     private formModelService: KufangFormModelService
//   ) {}
//
//   ngOnInit() {
//     this.activatedRoute.data.subscribe(data => {
//       this._pageTitle = data.pageTitle;
//     });
//     this.activatedRoute.data.subscribe(({ kufang }) => {
//       this._entity = kufang;
//       this.initForm();
//     });
//     this._isSaving = false;
//   }
//
//   private initForm() {
//     this._formModel = this.formModelService.createFormModel(this._entity);
//     this._formGroup = this.formService.createFormGroup(this._formModel);
//   }
//
//   previousState() {
//     window.history.back();
//   }
//
//   save() {
//     this._isSaving = true;
//     this._entity.name = this.formGroup.value["name"];
//     this._entity.bz = this.formGroup.value["bz"];
//     console.warn(this.formGroup.value);
//     if (this._entity.id !== undefined) {
//       this.subscribeToSaveResponse(this.kufangService.update(this._entity));
//     } else {
//       this.subscribeToSaveResponse(this.kufangService.create(this._entity));
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
//     this._isSaving = false;
//     this.previousState();
//   }
//
//   private onSaveError() {
//     this._isSaving = false;
//   }
//
//   get formGroup() {
//     return this._formGroup;
//   }
//   get pageTitle() {
//     return this._pageTitle;
//   }
//   get isSaving() {
//     return this._isSaving;
//   }
//   get kufang() {
//     return this._entity;
//   }
// }

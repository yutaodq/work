import {
  Component,
  OnInit,
  OnChanges,
  Input,
  Output,
  EventEmitter
} from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { DynamicFormService } from "@ng-dynamic-forms/core";

import { IKufangEntity, KufangEntity } from "app/xtwh/kufang/";
import { KufangService } from "../";

import { KufangFormModelService } from "../form/kufang-form-model.service";
import { KUFANG_FORM_LAYOUT } from "../form/kufang-form.layout";
import { NewComponent } from "app/core/containers/new-component";
import { Observable } from "rxjs/index";

@Component({
  selector: "zy-kufang-new",
  templateUrl: "./kufang-new.component.html"
})
export class KufangNewComponent extends NewComponent<IKufangEntity>
  implements OnInit, OnChanges {
  @Input()
  kufangEntity: IKufangEntity = {
    id: undefined,
    identifier: "ggggggg",
    name: "",
    bz: ""
  };
  @Output() cancel = new EventEmitter<IKufangEntity>();
  @Output() save = new EventEmitter<IKufangEntity>();

  constructor(
    activatedRoute: ActivatedRoute,
    formService: DynamicFormService,
    formModelService: KufangFormModelService,
    kufangService: KufangService
  ) {
    super(activatedRoute, formService, formModelService, kufangService);
  }

  ngOnInit() {
    this._entity = this.kufangEntity;
    super.ngOnInit();
    console.log(`在控制台打印ppppp:{}`, this.kufangEntity.valueOf());
  }
  ngOnChanges() {
    // if (this.contact) {
    //   this.form.patchValue({...this.contact});
    // }
  }
  onCancel() {
    this.cancel.emit(this._entity);
  }

  onSave() {
    // this.entity.name = this.formGroup.value["name"];
    this.kufangEntity = this.formGroup.value;
    this.save.emit(this._entity);
  }

  formModelToEntity() {
    this.entity.name = this.formGroup.value["name"];
    this.entity.bz = this.formGroup.value["bz"];
  }
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
// import { NewComponent } from "app/core/containers/new-component";
//
// export class KufangNewComponent extends NewComponent<IKufangEntity>
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
//     console.log(`KufangNewComponent - ngOnInit`);
//     super.ngOnInit();
//   }
//
//   formModelToEntity() {
//     this.entity.name = this.formGroup.value["name"];
//     this.entity.bz = this.formGroup.value["bz"];
//   }
// }

// 原始代码
// export class KufangNewComponent implements OnInit {
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
//   get entity() {
//     return this._entity;
//   }
// }

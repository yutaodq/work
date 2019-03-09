import { Component, OnInit, OnChanges, Input } from "@angular/core";
import {
  DynamicFormControlModel,
  DynamicFormService
} from "@ng-dynamic-forms/core";

import { IKufangEntity, KufangEntity } from "app/models";

import { KufangFormModelService } from "../form";
import { KUFANG_FORM_LAYOUT } from "../form";
import { FormComponent } from "app/core/containers/form-component";
import { FormGroup } from "@angular/forms";

@Component({
  selector: "zy-kufang-form",
  templateUrl: "./kufang-form.component.html"
})
// export class KufangFormComponent extends FormComponent<IKufangEntity>
//   implements OnInit, OnChanges {
export class KufangFormComponent implements OnInit, OnChanges {
  private _formGroup: FormGroup;
  private _formModel: DynamicFormControlModel[];
  private _entity: IKufangEntity;
  // constructor(
  // ) {
  // }

  ngOnInit() {}

  ngOnChanges() {}

  // restoreEntity() {
  //   this.formGroup.reset(this.entity);
  // }
  //
  // returnEntity(): IKufangEntity {
  //   // // this.formGroup.get("name").value;
  //   // // this.entity.name = this.formGroup.value["name"];
  //   // this.entity = this.formGroup.value;
  //   // return this.entity;
  //   return this.formGroup.value;
  // }

  @Input()
  set formGroup(formGroup: FormGroup) {
    this._formGroup = formGroup;
  }
  get formGroup() {
    return this._formGroup;
  }

  @Input()
  set formModel(formModel: DynamicFormControlModel[]) {
    this._formModel = formModel;
  }
  get formModel() {
    return this._formModel;
  }

  @Input()
  set entity(entity: IKufangEntity) {
    this._entity = entity;
  }
  get entity() {
    return this._entity;
  }
}

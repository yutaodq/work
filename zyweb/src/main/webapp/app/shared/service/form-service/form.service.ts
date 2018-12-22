/*
 * https://github.com/Suwichada/consol_free/blob/a69af386fbcd3f8818d4e92ae83bdc7eb27fdb8d/src/i3e/form-service/form.service.ts
 * 学习使用
 */
import { FormGroup, FormBuilder } from "@angular/forms";

import "rxjs/add/observable/merge";

export abstract class FormService<T> {
  constructor(private _fb: FormBuilder) {}

  protected get fb() {
    return this._fb;
  }

  abstract formConfig(item: T): { [name: string]: any };

  abstract formAssignChanges(formGroup: FormGroup);

  protected formBuildFromConfig(config: { [name: string]: any }): FormGroup {
    return this.fb.group(config);
  }

  formBuild(item: T): FormGroup {
    return this.formBuildFromConfig(this.formConfig(item));
  }

  formCreate(item?: T): FormGroup {
    const formGroup = this.formBuild(item);
    return this.formAssignChanges(formGroup);
  }
}

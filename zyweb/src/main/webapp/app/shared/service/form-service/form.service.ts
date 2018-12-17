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

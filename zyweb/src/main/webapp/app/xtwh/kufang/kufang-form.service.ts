import {
  FormControl,
  FormGroup,
  Validators,
  FormBuilder
} from "@angular/forms";

import { UniqueNameValidator } from "app/xtwh/kufang/kufang-form.validator";
import { Injectable } from "@angular/core";
import { FormService, KufangEntity } from "app/shared";

@Injectable()
export class KufangFormService extends FormService<KufangEntity> {
  constructor(
    private uniqueNameValidator: UniqueNameValidator,
    fb: FormBuilder
  ) {
    super(fb);
  }

  formConfig(item?: KufangEntity): { [name: string]: any } {
    return {
      name: [
        "jjjjjj",
        [Validators.required, Validators.minLength(3)],
        [this.uniqueNameValidator.validate.bind(this.uniqueNameValidator)]
      ],
      bz: [
        "",
        [Validators.required, Validators.minLength(3)],
        [this.uniqueNameValidator.validate.bind(this.uniqueNameValidator)]
      ]
    };
  }

  formAssignChanges(formGroup: FormGroup): FormGroup {
    // this.accountFormService.formAssignChanges(_formGroup);
    //
    // _formGroup.get('individual').valueChanges.subscribe((value) => {
    //   _formGroup.get('name').setValue(value && value.name);
    // });

    return formGroup;
  }
}

/*
 * end KufangFormService
 */

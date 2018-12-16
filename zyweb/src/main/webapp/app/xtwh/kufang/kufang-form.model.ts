import {
  AsyncValidator,
  FormControl,
  FormGroup,
  Validators
} from "@angular/forms";

import { UniqueNameValidator } from "app/xtwh/kufang/kufang-form.validator";
import { Injectable, OnInit } from "@angular/core";

export class KufangFormControl extends FormControl {
  label: string;
  modelProperty: string;

  constructor(
    label: string,
    property: string,
    value?: any,
    validator?: any,
    asyncValidator?: any
  ) {
    // constructor(label: string,
    //             property: string,
    //             value?: any,
    //             validator?: ValidatorFn | ValidatorFn[] | AbstractControlOptions | null,
    //             asyncValidator?: AsyncValidatorFn | AsyncValidatorFn[] | null) {
    super(value, validator, asyncValidator);
    this.label = label;
    this.modelProperty = property;
  }

  getValidationMessages() {
    const messages: string[] = [];
    if (!this.errors) {
      return messages;
    }

    for (const errorName of Object.keys(this.errors)) {
      switch (errorName) {
        case "required":
          messages.push(`您必须填写： ${this.label}`);
          break;
        case "minlength":
          messages.push(` ${this.label} 至少填写
                            ${this.errors["minlength"].requiredLength}
                            字符`);
          break;
        case "maxlength":
          messages.push(` ${this.label} 不能超过
                            ${this.errors["maxlength"].requiredLength}
                            字符`);
          break;
        case "limit":
          messages.push(` ${this.label} cannot be more
                                than ${this.errors["limit"].limit}`);
          break;
        case "pattern":
          messages.push(`The ${this.label} 不符合格式要求`);
          break;
      }
    }
    return messages;
  }
}

@Injectable()
export class KufangFormModel implements OnInit {
  private _form: FormGroup;

  constructor(private uniqueNameValidator: UniqueNameValidator) {}

  ngOnInit(): void {
    this.formInit();
  }
  formInit(): void {
    this._form = new FormGroup({
      name: new FormControl("kkkkk", {
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

  formDefault(): FormGroup {
    return new FormGroup({
      name: new FormControl("kkkkk", {
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

  get form(): FormGroup {
    return this._form;
  }
}

// export class KufangFormModel extends FormGroup {
//
// constructor(private uniqueNameValidator: UniqueNameValidator) {
//     super({
//       name: new KufangFormControl(
//         "库房名称",
//         "name",
//         "",
//         Validators.compose([Validators.required, Validators.minLength(3)]),
//         { [uniqueNameValidator.validate.bind(uniqueNameValidator)], updateOn: 'blur'}
//       ),
//       // bz: new KufangFormControl("库房记录说明", "bz", "", "")
//     });
//   }
//   name=  new FormControl('aaa', {asyncValidators: [this.uniqueNameValidator.validate.bind(this.uniqueNameValidator)], updateOn: 'blur'});
//
//   get kufangControls(): KufangFormControl[] {
//     return Object.keys(this.controls).map(
//       k => this.controls[k] as KufangFormControl
//     );
//   }
//
//   getFormValidationMessages(form: any): string[] {
//     const messages: string[] = [];
//     this.kufangControls.forEach(c =>
//       c.getValidationMessages().forEach(m => messages.push(m))
//     );
//     return messages;
//   }
// }

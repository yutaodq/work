import { FormControl, FormGroup, Validators } from "@angular/forms";

export class KufangFormControl extends FormControl {
  label: string;
  modelProperty: string;

  constructor(label: string, property: string, value: any, validator: any) {
    super(value, validator);
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

export class KufangFormModel extends FormGroup {
  constructor() {
    super({
      name: new KufangFormControl(
        "库房名称",
        "name",
        "",
        Validators.compose([Validators.required, Validators.minLength(3)])
      ),
      bz: new KufangFormControl("库房记录说明", "bz", "", "")
    });
  }

  get kufangControls(): KufangFormControl[] {
    return Object.keys(this.controls).map(
      k => this.controls[k] as KufangFormControl
    );
  }

  getFormValidationMessages(form: any): string[] {
    const messages: string[] = [];
    this.kufangControls.forEach(c =>
      c.getValidationMessages().forEach(m => messages.push(m))
    );
    return messages;
  }
}

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
          messages.push(`You must enter a ${this.label}`);
          break;
        case "minlength":
          messages.push(`A ${this.label} must be at least
                            ${this.errors["minlength"].requiredLength}
                            characters`);
          break;
        case "maxlength":
          messages.push(`A ${this.label} must be no more than
                            ${this.errors["maxlength"].requiredLength}
                            characters`);
          break;
        case "limit":
          messages.push(`A ${this.label} cannot be more
                                than ${this.errors["limit"].limit}`);
          break;
        case "pattern":
          messages.push(`The ${this.label} contains
                             illegal characters`);
          break;
      }
    }
    return messages;
  }
}

export class FormModel extends FormGroup {
  constructor() {
    super({
      name: new KufangFormControl(
        "库房名称",
        "name",
        "",
        Validators.compose([Validators.required, Validators.minLength(3)])
      ),
      gg: new KufangFormControl("序号", "id", "", Validators.required),
      xh: new KufangFormControl("标识", "identifier", "", Validators.required)
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

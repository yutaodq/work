import {
  DynamicFormControlModel,
  DynamicInputModel,
  DynamicTextAreaModel
} from "@ng-dynamic-forms/core";

import {
  myCustomValidator,
  kufangNameValidator
} from "./kufang-form.validator";
import { Injectable } from "@angular/core";
import { KufangService } from "app/xtwh/kufang/index";
import { IKufangEntity } from "app/shared";
import { IZyFormModel } from "app/core/service/form/zy-form.model";

@Injectable()
export class KufangFormModelService implements IZyFormModel<IKufangEntity> {
  constructor(private kufangService: KufangService) {}

  createFormModel(kufang: IKufangEntity): DynamicFormControlModel[] {
    return [
      new DynamicInputModel({
        id: "name",
        label: "库房名称",
        value: kufang.name,
        placeholder: "库房名称",
        validators: {
          required: null,
          minLength: 3,
          validator: {
            name: myCustomValidator.name,
            args: "aaa"
          }
        },
        asyncValidators: {
          validator: {
            name: kufangNameValidator.name,
            args: this.kufangService
          }
        },
        errorMessages: {
          required: "请您填写：{{ label }} ",
          minLength: "{{ label }}不能少于三个字",
          myCustomValidator: "{{label}} cannot start with abc",
          kufangNameValidator: "您录入的{{ label }}已经使用"
        }
      }),
      new DynamicTextAreaModel({
        id: "bz",
        label: "库房说明",
        value: kufang.bz,
        placeholder: "请在此处填写该库房的信息",
        rows: 5
      })
    ];
  }
}

// @Injectable()
// export class KufangFormModelService implements OnInit {
//   constructor(private kufangService: KufangService) {}
//   ngOnInit() {}
//
//   createFormModel(kufang: IKufangEntity): DynamicFormControlModel[] {
//     return [
//       new DynamicInputModel({
//         id: "name",
//         label: "库房名称",
//         value: kufang.name,
//         placeholder: "库房名称",
//         validators: {
//           required: null,
//           minLength: 3,
//           validator: {
//             name: myCustomValidator.name,
//             args: "aaa"
//           }
//         },
//         asyncValidators: {
//           validator: {
//             name: kufangNameValidator.name,
//             args: this.kufangService
//           }
//         },
//         errorMessages: {
//           required: "请您填写：{{ label }} ",
//           minLength: "{{ label }}不能少于三个字",
//           myCustomValidator: "{{label}} cannot start with abc",
//           kufangNameValidator: "您录入的{{ label }}已经使用"
//         }
//       }),
//       new DynamicTextAreaModel({
//         id: "bz",
//         label: "库房说明",
//         value: kufang.bz,
//         placeholder: "请在此处填写该库房的信息",
//         rows: 5
//       })
//     ];
//   }
// }

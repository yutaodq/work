// import {
//   FormControl,
//   FormGroup,
//   Validators,
//   FormBuilder,
//   AsyncValidatorFn
// } from "@angular/forms";
//
// import { UniqueNameValidator } from "app/xtwh/kufang/form/kufang-form.validator";
// import { Injectable } from "@angular/core";
// import { FormService } from "app/shared/index";
// import { IKufangEntity, KufangEntity } from "../../../models";
//
// import { KufangService } from "../service";
// import {
//   kufangNameValidator,
//   myCustomValidator
// } from "./kufang-form.validator";
// /*保留这个文件，不要删除
// 使用 angular自身提供的响应式表单模型
//  */
// @Injectable()
// // export class KufangFormService extends FormService<KufangEntity> {
// export class KufangFormService {
//   constructor(
//     private uniqueNameValidator: UniqueNameValidator,
//     private kufangService: KufangService,
//     private fb: FormBuilder
//   ) {}
//
//   formCreate(): FormGroup {
//     return this.fb.group({
//       name: [
//         "",
//         {
//           validators: [
//             Validators.required,
//             Validators.minLength(3),
//             myCustomValidator("abc")
//           ],
//           asyncValidators: kufangNameValidator(this.kufangService),
//           updateOn: "blur"
//         }
//       ],
//       bz: [""]
//     });
//   }
//
//   formConfig(item?: KufangEntity): { [name: string]: any } {
//     return {
//       name: [
//         "",
//         [
//           Validators.required,
//           Validators.minLength(3),
//           myCustomValidator("abc")
//         ],
//         [kufangNameValidator(this.kufangService)]
//       ],
//       bz: ["", [Validators.required, Validators.minLength(3)], []]
//     };
//   }
//
//   formAssignChanges(formGroup: FormGroup): FormGroup {
//     // this.accountFormService.formAssignChanges(_formGroup);
//     //
//     // _formGroup.get('individual').valueChanges.subscribe((value) => {
//     //   _formGroup.get('name').setValue(value && value.name);
//     // });
//
//     return formGroup;
//   }
// }
//
// /*
//  * end KufangFormService
//  */

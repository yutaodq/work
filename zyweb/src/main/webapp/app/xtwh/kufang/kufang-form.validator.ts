import { Directive, forwardRef, Injectable } from "@angular/core";
import {
  ValidatorFn,
  AsyncValidatorFn,
  FormGroup,
  AsyncValidator,
  AbstractControl,
  ValidationErrors
} from "@angular/forms";
import { catchError, map } from "rxjs/operators";
import { KufangService } from "./kufang.service";
import { of } from "rxjs";
import { Observable } from "rxjs/Observable";

import "rxjs/add/operator/map";

export function kufangNameValidator(): AsyncValidatorFn {
  return (control: AbstractControl) => {
    return new Promise(resolve => {
      resolve({ forbiddenName: "jhhh" });
    });
    // new Promise((resolve, reject) => {
    //   console.log("async validation");
    //   resolve(null);
    // });
  };
}

// export function kufangNameValidator(): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> {
//   console.log(`异步验证ddd`);
//   return of(null);
// }
// formGroup: FormGroup,

// export function kufangNameValidator(name: string): Promise<ValidationErrors | null> {
//
//   return new Promise((resolve, reject) => {
//     console.log("async validation");
//     resolve(null);
//   });
// }

// export function kufangNameValidator(
//   formGroup: String
// ): Promise<ValidationErrors | null> {
//   return new Promise((resolve, reject) => {
//     console.log("async validation:" + formGroup);
//     resolve(null);
//   });
// }

// export function kufangNameValidator(kufangService: KufangService): AsyncValidatorFn {
//   console.log(`异步验证`);
//   return (
//     control: AbstractControl
//   ): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> => {
//     console.log(`异步验证dddddddddddddddddddd`);
//     return this.kufangService
//       .isNameTaken(control.value)
//       .pipe(
//         map(isTaken => (isTaken ? { kufangNameValidator: true } : null)),
//         catchError(() => null)
//       );
//   };
// }

// export function kufangNameValidator( ): AsyncValidatorFn {
//   console.log(`异步验证` );
//   console.log(`姓名`);
//   return null;
// }
//   export function kufangNameValidator(
//     control: AbstractControl
//   ): Promise<ValidationErrors | null> {
//     return new Promise((resolve, reject) => {
//       console.log("async validation" + control.value);
//       resolve(null);
//     });
//   }

// export function kufangNameValidator(): AsyncValidatorFn {
//   // name  = return (control: AbstractControl):  string | null => return control.value ;
//
//   console.log(`异步验证`);
//
//   return (control: AbstractControl):  Observable<ValidationErrors | null> => {
//     console.log(`异步验证ddddddddddddd` );
//     return null;
//   //   return null;
//   //   // return kufangService
//   //   //   .isNameTaken(control.value)
//   //   //   .pipe(
//   //   //     map(isTaken => (isTaken ? { uniqueName: true } : null)),
//   //   //     catchError(() => null)
//   //   //   );
//   };
// }

// export function kufangNameValidator( kufangService: KufangService): AsyncValidatorFn {
//   console.log(`异步验证`);
//   return (control: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> => {
//     return kufangService
//       .isNameTaken(control.value)
//       .pipe(
//         map(isTaken => (isTaken ? { uniqueName: true } : null)),
//         catchError(() => null)
//       );
//   };
// }

// #start async-validator
// @Injectable({ providedIn: "root" })

export class UniqueNameValidator implements AsyncValidator {
  constructor(private kufangService: KufangService) {}

  validate(
    ctrl: AbstractControl
  ): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> {
    return this.kufangService
      .isNameTaken(ctrl.value)
      .pipe(
        map(isTaken => (isTaken ? { uniqueName: true } : null)),
        catchError(() => null)
      );
  }
}

// #end async-validator

export function myCustomValidator(forbiddenValue: string): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const hasError = control.value
      ? (control.value as string).startsWith(forbiddenValue)
      : false;
    return hasError ? { myCustomValidator: true } : null;
  };
}

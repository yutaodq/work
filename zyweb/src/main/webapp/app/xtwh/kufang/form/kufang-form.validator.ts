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
import { KufangService } from "../service/kufang.service";
import { of } from "rxjs";
import { Observable } from "rxjs/Observable";

import "rxjs/add/operator/map";

export function kufangNameValidator(
  kufangService: KufangService
): AsyncValidatorFn {
  console.log(`异步验证`);
  return (
    control: AbstractControl
  ): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> => {
    console.log(`异步验证dddddddddddddddddddd:` + control.value);
    return kufangService
      .isNameTaken(control.value)
      .pipe(
        map(isTaken => (isTaken ? { kufangNameValidator: true } : null)),
        catchError(() => null)
      );
  };
}

// #start async-validator
// @Injectable({ providedIn: "root" })
@Injectable()
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
  console.log(`同步验证`);
  return (control: AbstractControl): ValidationErrors | null => {
    const hasError = control.value
      ? (control.value as string).startsWith(forbiddenValue)
      : false;
    return hasError ? { myCustomValidator: true } : null;
  };
}

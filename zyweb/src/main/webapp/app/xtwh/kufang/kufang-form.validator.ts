import { Directive, forwardRef, Injectable } from "@angular/core";
import {
  AsyncValidator,
  AbstractControl,
  NG_ASYNC_VALIDATORS,
  ValidationErrors
} from "@angular/forms";
import { catchError, map } from "rxjs/operators";
import { KufangService } from "./kufang.service";
import { Observable } from "rxjs";

// #start async-validator
@Injectable({ providedIn: "root" })
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

export function myCustomValidator(
  control: AbstractControl
): ValidationErrors | null {
  const hasError = control.value
    ? (control.value as string).startsWith("abc")
    : false;
  return hasError ? { myCustomValidator: true } : null;
}

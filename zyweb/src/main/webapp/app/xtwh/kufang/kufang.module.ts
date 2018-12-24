import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { RouterModule } from "@angular/router";
import { HttpClientModule } from "@angular/common/http";
import { ZyxtSharedModule } from "app/shared";
import { CoreModule } from "app/core";
import { NebularModule } from "app/core";
import { NgxDatatableModule } from "@swimlane/ngx-datatable";
import { NG_VALIDATORS, NG_ASYNC_VALIDATORS } from "@angular/forms";
import { DynamicFormsNGBootstrapUIModule } from "@ng-dynamic-forms/ui-ng-bootstrap";

import {
  Validator,
  ValidatorFactory,
  DYNAMIC_VALIDATORS
} from "@ng-dynamic-forms/core";

import {
  kufangRoute,
  KufangComponent,
  KufangDetailComponent,
  KufangNewComponent,
  KufangService,
  KufangFormService,
  KufangFormModel
} from "./";

import {
  myCustomValidator,
  UniqueNameValidator,
  kufangNameValidator
} from "./kufang-form.validator";

const ROUTE = [...kufangRoute];

const IMPORTS_MODULES = [
  HttpClientModule,
  ZyxtSharedModule,
  CoreModule,
  NebularModule,
  NgxDatatableModule,
  DynamicFormsNGBootstrapUIModule
];
const COMPONENT = [KufangComponent, KufangDetailComponent, KufangNewComponent];
const ENTRY_COMPONENTS = [KufangComponent, KufangDetailComponent];
const SERVICE = [
  KufangFormService,
  KufangService,
  UniqueNameValidator,
  KufangFormModel
];

@NgModule({
  imports: [...IMPORTS_MODULES, RouterModule.forChild(ROUTE)],
  declarations: [COMPONENT],
  entryComponents: [ENTRY_COMPONENTS],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [
    ...SERVICE,
    {
      provide: NG_VALIDATORS,
      useValue: myCustomValidator,
      multi: true
    },

    {
      provide: NG_ASYNC_VALIDATORS,
      useValue: kufangNameValidator,
      multi: true
    },
    {
      provide: DYNAMIC_VALIDATORS,
      useValue: new Map<string, Validator | ValidatorFactory>([
        ["myCustomValidator", myCustomValidator],
        ["kufangNameValidator", kufangNameValidator]
      ])
    }
  ]
})
export class KufangModule {}

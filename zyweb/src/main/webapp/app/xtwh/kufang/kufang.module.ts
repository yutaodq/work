import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { RouterModule } from "@angular/router";
import { HttpClientModule } from "@angular/common/http";
import { NG_VALIDATORS, NG_ASYNC_VALIDATORS } from "@angular/forms";

import { NgxDatatableModule } from "@swimlane/ngx-datatable";
import { DynamicFormsNGBootstrapUIModule } from "@ng-dynamic-forms/ui-ng-bootstrap";

import { StoreModule } from "@ngrx/store";
import { EffectsModule } from "@ngrx/effects";

import { reducers } from "app/xtwh/kufang/reducers";
import { CollectionEffects } from "app/xtwh/kufang/effects/collection.effects";

import { ZyxtSharedModule } from "app/shared";
import { CoreModule } from "app/core";
import { NebularModule } from "app/nebular";

import {
  Validator,
  ValidatorFactory,
  DYNAMIC_VALIDATORS
} from "@ng-dynamic-forms/core";

import {
  kufangRoute,
  KufangService,
  KufangFormService,
  KufangFormModelService
} from "./";

import {
  KufangListComponent,
  KufangSelectedButtonComponent,
  KufangFormComponent,
  KufangNewButtonComponent
} from "./components";

import {
  KufangComponent,
  SelectedKufangPageComponent,
  ViewKufangPageComponent,
  NewKufangPageComponent,
  EditKufangPageComponent
} from "./containers";

import {
  myCustomValidator,
  UniqueNameValidator,
  kufangNameValidator
} from "./form/kufang-form.validator";

const ROUTE = [...kufangRoute];

const IMPORTS_MODULES = [
  HttpClientModule,
  ZyxtSharedModule,
  CoreModule,
  NebularModule,
  NgxDatatableModule,
  DynamicFormsNGBootstrapUIModule
  // StoreModule.forFeature("kufangs", reducers)
];
const COMPONENT = [
  KufangComponent,
  KufangSelectedButtonComponent,
  KufangNewButtonComponent,
  KufangListComponent,
  KufangFormComponent,
  SelectedKufangPageComponent,
  ViewKufangPageComponent,
  NewKufangPageComponent,
  EditKufangPageComponent
];
const ENTRY_COMPONENTS = [KufangComponent, KufangSelectedButtonComponent];
const SERVICE = [
  KufangFormService,
  KufangService,
  UniqueNameValidator,
  KufangFormModelService
];

@NgModule({
  imports: [
    ...IMPORTS_MODULES,
    RouterModule.forChild(ROUTE),
    StoreModule.forFeature("kufangs", reducers),
    EffectsModule.forFeature([CollectionEffects])
  ],
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

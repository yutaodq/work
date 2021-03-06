import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { NG_VALIDATORS, NG_ASYNC_VALIDATORS } from "@angular/forms";

import { NgxDatatableModule } from "@swimlane/ngx-datatable";
import { DynamicFormsNGBootstrapUIModule } from "@ng-dynamic-forms/ui-ng-bootstrap";

import { StoreModule } from "@ngrx/store";
import { EffectsModule } from "@ngrx/effects";

import { reducers } from "./reducers";
import { CollectionEffects } from "./effects";

import { ZyxtSharedModule } from "app/shared";
import { CoreModule } from "app/core";
import { ThemeModule } from "app/theme";

import {
  Validator,
  ValidatorFactory,
  DYNAMIC_VALIDATORS
} from "@ng-dynamic-forms/core";
import { KufangRoutingModule } from "./kufang-route.module";
import { KufangService } from "./service";
// import { KufangFormService, KufangFormModel } from "./form";

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

const IMPORTS_MODULES = [
  ZyxtSharedModule,
  CoreModule,
  NgxDatatableModule,
  ThemeModule,
  DynamicFormsNGBootstrapUIModule,
  KufangRoutingModule
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
  // KufangFormService,
  KufangService,
  UniqueNameValidator
  // KufangFormModel
];

@NgModule({
  imports: [
    ...IMPORTS_MODULES,
    StoreModule.forFeature("kufangs", reducers),
    EffectsModule.forFeature([CollectionEffects])
  ],
  declarations: [...COMPONENT],
  entryComponents: [...ENTRY_COMPONENTS],
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

import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";

// import {
//   NbLayoutModule,
//   NbMenuModule,
//   NbSidebarModule
// } from "@nebular/theme";
// const NB_MODULES = [NbLayoutModule];

import {
  NbActionsModule,
  NbCardModule,
  NbLayoutModule,
  NbMenuModule,
  NbRouteTabsetModule,
  NbSearchModule,
  NbSidebarModule,
  NbTabsetModule,
  NbUserModule,
  NbCheckboxModule,
  NbPopoverModule,
  NbContextMenuModule,
  NbProgressBarModule,
  NbCalendarModule,
  NbCalendarRangeModule,
  NbStepperModule,
  NbButtonModule,
  NbInputModule,
  NbAccordionModule,
  NbDatepickerModule,
  NbDialogModule,
  NbWindowModule,
  NbListModule,
  NbToastrModule,
  NbAlertModule,
  NbSpinnerModule,
  NbRadioModule,
  NbSelectModule,
  NbChatModule,
  NbTooltipModule,
  NbCalendarKitModule
} from "@nebular/theme";
const NB_MODULES = [
  NbCardModule,
  NbLayoutModule,
  NbTabsetModule,
  NbRouteTabsetModule,
  NbMenuModule,
  NbUserModule,
  NbActionsModule,
  NbSearchModule,
  // NbSidebarModule,
  NbCheckboxModule,
  NbPopoverModule,
  NbContextMenuModule,
  NbProgressBarModule,
  NbCalendarModule,
  NbCalendarRangeModule,
  NbStepperModule,
  NbButtonModule,
  NbListModule,
  NbToastrModule,
  NbInputModule,
  NbAccordionModule,
  NbDatepickerModule,
  NbDialogModule,
  NbWindowModule,
  NbAlertModule,
  NbSpinnerModule,
  NbRadioModule,
  NbSelectModule,
  NbChatModule,
  NbTooltipModule,
  NbCalendarKitModule
];

import { AppComponent } from "./containers";

const CONTAINERS = [AppComponent];

import {
  SampleLayoutComponent,
  FooterComponent,
  HeaderComponent
} from "./components";

const COMPONENTS = [SampleLayoutComponent, FooterComponent, HeaderComponent];

import { AnalyticsService, UserService, LayoutService } from "app/core/service";
const SERVICE = [AnalyticsService, UserService, LayoutService];
@NgModule({
  imports: [
    RouterModule,
    // NbMenuModule.forRoot(),
    NbSidebarModule.forRoot(),
    ...NB_MODULES
  ],
  exports: [...COMPONENTS, ...NB_MODULES],
  declarations: [COMPONENTS, CONTAINERS],
  providers: [...SERVICE]
})
export class ZyxtCoreModule {
  constructor() {}
}

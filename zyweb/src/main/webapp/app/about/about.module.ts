import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ABOUT_ROUTE, AboutComponent } from './index';

@NgModule({
  imports: [ RouterModule.forChild([ABOUT_ROUTE])],

  declarations: [AboutComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ZyxtAboutModule {}




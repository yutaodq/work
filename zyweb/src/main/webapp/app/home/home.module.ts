import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HOME_ROUTE, HomeComponent } from './index';

@NgModule({
  imports: [ RouterModule.forChild([HOME_ROUTE])],

  declarations: [HomeComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ZyxtHomeModule {}




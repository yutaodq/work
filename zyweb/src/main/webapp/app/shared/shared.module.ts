import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgbDateAdapter } from '@ng-bootstrap/ng-bootstrap';

import { NgbDateMomentAdapter } from './util/datepicker-adapter';
import {ZyxtSharedLibsModule, ZyxtSharedCommonModule} from './index';

@NgModule({
    imports: [ZyxtSharedLibsModule, ZyxtSharedCommonModule],
    // declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
    providers: [{ provide: NgbDateAdapter, useClass: NgbDateMomentAdapter }],
    // entryComponents: [JhiLoginModalComponent],
  // exports: [ZyxtSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  exports: [ZyxtSharedCommonModule],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ZyxtSharedModule {}

import { NgModule } from '@angular/core';

import { ZyxtSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './index';
@NgModule({
    imports: [ZyxtSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [ZyxtSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class ZyxtSharedCommonModule {}

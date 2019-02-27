import { Component } from "@angular/core";
// import { NbDialogRef } from '@nebular/theme';
import { NbDialogRef } from "app/nebular/ne";

@Component({
  selector: "zy-remove-dialog",
  templateUrl: "./remove-dialog.component.html"
})
export class RemoveDialogComponent {
  constructor(protected ref: NbDialogRef<RemoveDialogComponent>) {}
  cancel() {
    this.ref.close("No");
  }
  submit(name) {
    this.ref.close("Yes");
  }
}

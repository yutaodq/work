import { Component } from "@angular/core";
import { NewPageButtonComponent } from "app/core/components";

@Component({
  selector: "zy-kufang-new-button",
  templateUrl: "../../../template/new-page-button.component.html"
})
export class KufangNewButtonComponent extends NewPageButtonComponent {
  onCancel() {
    this.previousState();
  }
}

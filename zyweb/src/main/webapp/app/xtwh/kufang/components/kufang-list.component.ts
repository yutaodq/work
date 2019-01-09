import { Component, Input } from "@angular/core";
import { IKufangEntity } from "../models";

@Component({
  selector: "zy-kufang-list",
  templateUrl: "./kufang-list.component.html"
})
export class KufangListComponent {
  @Input() kufangs: IKufangEntity[];
}

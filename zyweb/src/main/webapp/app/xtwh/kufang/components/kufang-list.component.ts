import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output
} from "@angular/core";
import { IKufangEntity } from "../models";

@Component({
  selector: "zy-kufang-list",
  templateUrl: "./kufang-list.component.html"
})
export class KufangListComponent implements OnInit {
  @Input() entities: IKufangEntity[];
  @Output() show = new EventEmitter<IKufangEntity>();
  constructor() {}

  ngOnInit() {}

  showDetails(entity: IKufangEntity) {
    this.show.emit(entity);
  }
}

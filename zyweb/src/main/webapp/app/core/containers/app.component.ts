import { ChangeDetectionStrategy, Component } from "@angular/core";

@Component({
  selector: "zy-app",
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: `./app.component.html`
})
export class AppComponent {
  constructor() {}
}

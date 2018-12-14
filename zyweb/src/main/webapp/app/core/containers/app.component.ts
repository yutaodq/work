import { ChangeDetectionStrategy, Component } from "@angular/core";
import { faCoffee } from "@fortawesome/free-solid-svg-icons";
import { MENU_ITEMS } from "./app-menu";

@Component({
  selector: "zy-app",
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: `./app.component.html`
})
export class AppComponent {
  menu = MENU_ITEMS;
}

import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

// import { HttpClientModule } from "@angular/common/http";

// import { ShareModule } from "../share/share.module";
import { ThemeModule } from "app/theme";
import { UserRoutingModule } from "./user-routing.module";
import { LoginComponent } from "./login/login.component";
import { UserService } from "./service/user.service";

@NgModule({
  imports: [CommonModule, UserRoutingModule, ThemeModule],
  // imports: [CommonModule, UserRoutingModule, HttpClientModule],

  declarations: [LoginComponent],
  providers: [UserService]
})
export class UserModule {}

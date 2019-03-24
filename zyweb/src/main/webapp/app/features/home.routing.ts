import { ModuleWithProviders } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { ContactComponent } from "./contact/contact.component";
import { ForgotComponent } from "./forgot/forgot.component";
import { NotfoundComponent } from "./errors/notfound.component";

export const routes: Routes = [
  {
    path: "",
    loadChildren: "./main/main.module#MainModule",
    pathMatch: "full"
  },
  {
    path: "main",
    loadChildren: "./main/main.module#MainModule"
  },
  {
    path: "login",
    loadChildren: "./login/login.module#LoginModule"
  },
  {
    path: "register",
    loadChildren: "./register/register.module#RegisterModule"
  },
  {
    path: "forgot-password",
    component: ForgotComponent,
    data: { pageTitle: "Forget Password" }
  },
  {
    path: "locked",
    loadChildren: "./locked/locked.module#LockedModule"
  },
  {
    path: "dashboard",
    loadChildren: "./dashboard/dashboard.module#DashboardModule",
    data: { pageTitle: "Dashboard" }
  },
  {
    path: "order",
    loadChildren: "./orders/orders.module#OrdersModule",
    data: { pageTitle: "User Orders" }
  },
  {
    path: "contact",
    component: ContactComponent
  },
  {
    path: "notfound",
    component: NotfoundComponent,
    data: { title: "404 Error" }
  }
];

export const routing = [RouterModule.forChild(routes)];

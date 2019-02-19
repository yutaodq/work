import { platformBrowserDynamic } from "@angular/platform-browser-dynamic";
import { ZyxtAppModule } from "./app.module";
import { ProdConfig } from "./blocks/config/prod.config";

ProdConfig();

if (module["hot"]) {
  module["hot"].accept();
}
console.log(`在控制台打印:`);

platformBrowserDynamic()
  .bootstrapModule(ZyxtAppModule, { preserveWhitespaces: true })
  .then(success => console.log(`应用程序启动成功`))
  .catch(err => console.error(`应用程序启动失败，错误如下：` + err));

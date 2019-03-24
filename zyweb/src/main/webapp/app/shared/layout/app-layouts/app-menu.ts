import { NbMenuItem } from "@nebular/theme";

export const MAIN_MENU_ITEMS: NbMenuItem[] = [
  {
    title: "主页",
    icon: "nb-e-commerce",
    link: "home",
    home: true
  },
  {
    title: "关于",
    icon: "nb-home",
    link: "about"
  },
  {
    title: "分组",
    group: true
  },
  {
    title: "系统维护",
    icon: "nb-star",
    children: [
      {
        title: "库房名称",
        link: "kufang"
      },
      {
        title: "工具名称",
        link: "product"
      }
    ]
  },
  {
    title: "Forms",
    icon: "nb-compose",
    children: [
      {
        title: "Form Inputs",
        link: "/pages/forms/inputs"
      }
    ]
  }
];

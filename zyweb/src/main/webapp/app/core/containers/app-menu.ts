import { NbMenuItem } from "@nebular/theme";

export const MENU_ITEMS: NbMenuItem[] = [
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
      },
      {
        title: "List",
        link: "/pages/extra-components/list"
      },
      {
        title: "Infinite List",
        link: "/pages/extra-components/infinite-list"
      },
      {
        title: "Accordion",
        link: "/pages/extra-components/accordion"
      },
      {
        title: "Progress Bar",
        link: "/pages/extra-components/progress-bar"
      },
      {
        title: "Spinner",
        link: "/pages/extra-components/spinner"
      },
      {
        title: "Alert",
        link: "/pages/extra-components/alert"
      },
      {
        title: "Tree",
        link: "/pages/extra-components/tree"
      },
      {
        title: "Tabs",
        link: "/pages/extra-components/tabs"
      },
      {
        title: "Calendar Kit",
        link: "/pages/extra-components/calendar-kit"
      },
      {
        title: "Chat",
        link: "/pages/extra-components/chat"
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
      },
      {
        title: "Form Layouts",
        link: "/pages/forms/layouts"
      },
      {
        title: "Buttons",
        link: "/pages/forms/buttons"
      },
      {
        title: "Datepicker",
        link: "/pages/forms/datepicker"
      }
    ]
  },
  {
    title: "UI Features",
    icon: "nb-keypad",
    link: "/pages/ui-features",
    children: [
      {
        title: "Grid",
        link: "/pages/ui-features/grid"
      },
      {
        title: "Icons",
        link: "/pages/ui-features/icons"
      },
      {
        title: "Typography",
        link: "/pages/ui-features/typography"
      },
      {
        title: "Animated Searches",
        link: "/pages/ui-features/search-fields"
      }
    ]
  },
  {
    title: "Modal & Overlays",
    icon: "nb-layout-default",
    children: [
      {
        title: "Dialog",
        link: "/pages/modal-overlays/dialog"
      },
      {
        title: "Window",
        link: "/pages/modal-overlays/window"
      },
      {
        title: "Popover",
        link: "/pages/modal-overlays/popover"
      },
      {
        title: "Toastr",
        link: "/pages/modal-overlays/toastr"
      },
      {
        title: "Tooltip",
        link: "/pages/modal-overlays/tooltip"
      }
    ]
  },
  {
    title: "Bootstrap",
    icon: "nb-gear",
    children: [
      {
        title: "Form Inputs",
        link: "/pages/bootstrap/inputs"
      },
      {
        title: "Buttons",
        link: "/pages/bootstrap/buttons"
      },
      {
        title: "Modal",
        link: "/pages/bootstrap/modal"
      }
    ]
  },
  {
    title: "Maps",
    icon: "nb-location",
    children: [
      {
        title: "Google Maps",
        link: "/pages/maps/gmaps"
      },
      {
        title: "Leaflet Maps",
        link: "/pages/maps/leaflet"
      },
      {
        title: "Bubble Maps",
        link: "/pages/maps/bubble"
      },
      {
        title: "Search Maps",
        link: "/pages/maps/searchmap"
      }
    ]
  },
  {
    title: "Charts",
    icon: "nb-bar-chart",
    children: [
      {
        title: "Echarts",
        link: "/pages/charts/echarts"
      },
      {
        title: "Charts.js",
        link: "/pages/charts/chartjs"
      },
      {
        title: "D3",
        link: "/pages/charts/d3"
      }
    ]
  },
  {
    title: "Editors",
    icon: "nb-title",
    children: [
      {
        title: "TinyMCE",
        link: "/pages/editors/tinymce"
      },
      {
        title: "CKEditor",
        link: "/pages/editors/ckeditor"
      }
    ]
  },
  {
    title: "Tables",
    icon: "nb-tables",
    children: [
      {
        title: "Smart Table",
        link: "/pages/tables/smart-table"
      }
    ]
  },
  {
    title: "Miscellaneous",
    icon: "nb-shuffle",
    children: [
      {
        title: "404",
        link: "/pages/miscellaneous/404"
      }
    ]
  },
  {
    title: "Auth",
    icon: "nb-locked",
    children: [
      {
        title: "Login",
        link: "/auth/component"
      },
      {
        title: "Register",
        link: "/auth/register"
      },
      {
        title: "Request Password",
        link: "/auth/request-password"
      },
      {
        title: "Reset Password",
        link: "/auth/reset-password"
      }
    ]
  }
];

import { Component, OnDestroy, ChangeDetectionStrategy } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Store } from "@ngrx/store";
import { Subscription } from "rxjs";
import { map } from "rxjs/operators";

import * as fromKufangs from "../reducers";
import { ViewKufangPageActions } from "../actions";

/**
 * 学习ngrx中的案例
 *zy-view-kufang-page页面的职责是将路由器参数映射到“new ViewKufangPageActions.SelectKufang(params.id)”操作。
 * 实际显示选中的库房记录仍然是SelectedKufangPageComponent的责任
 */
@Component({
  selector: "zy-view-kufang-page",
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `
     <zy-selected-kufang-page></zy-selected-kufang-page>
  `
})
export class ViewKufangPageComponent implements OnDestroy {
  /* actionsSubscription: Subscription 是订阅者
   * route.params是主题
   * 发出 ViewKufangPageActions.SelectKufang Action 交给其它 Effect 或者 Reducer 去处理
   */
  actionsSubscription: Subscription;
  constructor(store: Store<fromKufangs.State>, route: ActivatedRoute) {
    this.actionsSubscription = route.params
      .pipe(map(params => new ViewKufangPageActions.SelectKufang(params.id)))
      .subscribe(store);
  }

  ngOnDestroy() {
    this.actionsSubscription.unsubscribe();
  }
}

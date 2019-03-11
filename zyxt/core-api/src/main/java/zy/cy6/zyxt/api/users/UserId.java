package zy.cy6.zyxt.api.users;

import lombok.extern.slf4j.Slf4j;

import zy.cy6.zyxt.api.product.kufang.KufangId;
import zy.cy6.zyxt.common.domain.AbstractAggregateIdentifier;
import zy.cy6.zyxt.common.domain.AbstractAggregateIdentifierBuilder;
import zy.cy6.zyxt.common.domain.AggregateIdentifier;

/*
 * 使用方法
 * KufangId.builder().identifier(id).build()
 * KufangId.builder().build()
 */

@Slf4j
public final class UserId extends AbstractAggregateIdentifier {
  private UserId(String identifier) {
    super(identifier);
    log.info("新建库房标识：UserId");
  }

  public static UserId.UserIdBuilder builder() {
    return new UserId.UserIdBuilder();
  }

  @Override
  public String toString() {
    return "库房标识:" + super.toString();
  }

  /*
   * 静态类
   */
  public static class UserIdBuilder extends AbstractAggregateIdentifierBuilder<UserIdBuilder, UserId> {
    protected AggregateIdentifier createId() {
      return new UserId(getIdentifier());
    }
  }

}

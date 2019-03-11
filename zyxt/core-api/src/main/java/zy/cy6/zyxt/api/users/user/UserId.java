package zy.cy6.zyxt.api.users.user;

import lombok.extern.slf4j.Slf4j;

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

  public static UserIdBuilder builder() {
    return new UserIdBuilder();
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

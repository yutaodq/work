package zy.cy6.zyxt.api.users;

import lombok.extern.slf4j.Slf4j;

import zy.cy6.zyxt.common.domain.AbstractAggregateIdentifier;
import zy.cy6.zyxt.common.domain.AbstractAggregateIdentifierBuilder;


@Slf4j
public final class UserId extends AbstractAggregateIdentifier {

  private UserId(String identifier) {
    super(identifier);
    log.info("新建库房标识：KufangId");
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
  public static class UserIdBuilder extends AbstractAggregateIdentifierBuilder {
    public UserIdBuilder identifier(String identifier) {
      setIdentifier(identifier);
      return this;
    }

    public UserId build() {
      return new UserId(getIdentifier());
    }
  }
}

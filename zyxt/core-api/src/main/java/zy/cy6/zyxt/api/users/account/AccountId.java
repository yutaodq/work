package zy.cy6.zyxt.api.users.account;

import lombok.extern.slf4j.Slf4j;
import zy.cy6.zyxt.common.domain.AbstractAggregateIdentifier;
import zy.cy6.zyxt.common.domain.AbstractAggregateIdentifierBuilder;
import zy.cy6.zyxt.common.domain.AggregateIdentifier;

@Slf4j
public final class AccountId extends AbstractAggregateIdentifier {
  private AccountId(String identifier) {
    super(identifier);
    log.info("新建库房标识：UserId");
  }

  public static AccountIdBuilder builder() {
    return new AccountIdBuilder();
  }

  @Override
  public String toString() {
    return "库房标识:" + super.toString();
  }

  /*
   * 静态类
   */
  public static class AccountIdBuilder extends AbstractAggregateIdentifierBuilder<AccountIdBuilder, AccountId> {
    protected AggregateIdentifier createId() {
      return new AccountId(getIdentifier());
    }
  }

}

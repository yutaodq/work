package zy.cy6.zyxt.api.users.user.enent;

import lombok.Builder;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import zy.cy6.zyxt.api.users.account.AccountId;
import zy.cy6.zyxt.api.users.user.UserId;
import zy.cy6.zyxt.api.users.user.UserPasswordId;

@Value
@Builder

public class UserCreatedEvent {
  @TargetAggregateIdentifier
  private UserId userId;
  private AccountId accountId;
  private UserPasswordId userPasswordId;
}

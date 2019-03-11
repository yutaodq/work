package zy.cy6.zyxt.api.users.user.command;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import zy.cy6.zyxt.api.users.account.AccountId;
import zy.cy6.zyxt.api.users.user.UserId;
import zy.cy6.zyxt.api.users.user.UserPassword;
import zy.cy6.zyxt.api.users.user.UserPasswordId;
import zy.cy6.zyxt.api.users.user.Username;

@Value
@Builder
public class CreateUserCommand {
  @TargetAggregateIdentifier
  @NonNull
  private AccountId accountId;
  private UserPasswordId userPasswordId;
}

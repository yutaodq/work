package zy.cy6.zyxt.api.users;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
@Builder
public class CreateUserCommand {
  @TargetAggregateIdentifier
  @NonNull
  private UserId userId;
  @NonNull
  private Username username;
  private UserPassword userPassword;
  private String name;
}

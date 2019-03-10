package zy.cy6.zyxt.api.users;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import org.springframework.util.Assert;

@Value
@Builder

public class UserCreatedEvent {
  @TargetAggregateIdentifier
  private UserId userId;
  @NonNull
  private Username username;
  private UserPassword userPassword;
  private String name;

  public UserCreatedEvent(UserId userId, Username username, UserPassword userPassword, String name) {
    this.userId = userId;
    this.username = username;
    this.userPassword = userPassword;
    this.name = name;
    Assert.notNull(userId, "标识不能为空或null");

  }
}

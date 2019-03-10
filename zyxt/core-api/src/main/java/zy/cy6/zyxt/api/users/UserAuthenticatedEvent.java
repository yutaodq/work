package zy.cy6.zyxt.api.users;

import lombok.Builder;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
@Builder
public class UserAuthenticatedEvent {
  @TargetAggregateIdentifier
  private UserId userId;
}

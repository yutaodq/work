package zy.cy6.zyxt.api.users;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthenticateUserCommand {
  private UserId userId;
  private Username username;
  private UserPassword userPassword;
}

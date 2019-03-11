package zy.cy6.zyxt.api.users.user;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserPassword {
  private String password;

}

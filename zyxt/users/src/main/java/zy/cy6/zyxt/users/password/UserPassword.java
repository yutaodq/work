package zy.cy6.zyxt.users.password;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.DigestUtils;
import zy.cy6.zyxt.api.users.account.AccountId;
import zy.cy6.zyxt.api.users.password.command.BindUserToUserPasswordCommand;
import zy.cy6.zyxt.api.users.password.command.SignUpUserPasswordCommand;
import zy.cy6.zyxt.api.users.password.event.UserPasswordBoundUserEvent;
import zy.cy6.zyxt.api.users.password.event.UserPasswordSignedUpEvent;
import zy.cy6.zyxt.api.users.user.UserId;
import zy.cy6.zyxt.api.users.user.UserPasswordId;

import java.util.ArrayList;
import java.util.List;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class UserPassword {
  @AggregateIdentifier
  private UserPasswordId id;

  private String hashValue;

  private UserId userId;

  // 需要使用密码的账号
  private List<AccountId> accountIdList = new ArrayList<>();

  protected UserPassword() {
  }

  @CommandHandler
  public UserPassword(SignUpUserPasswordCommand command) {
    apply(UserPasswordSignedUpEvent.builder().userPasswordId(UserPasswordId.builder().build()).accountId(command.getAccountId()).hashValue(command.getPassword()).build());
  }

  @CommandHandler
  public void handler(BindUserToUserPasswordCommand command) {
    apply(UserPasswordBoundUserEvent.builder().userPasswordId(UserPasswordId.builder().build()).userId(command.getUserId()).build());
  }

  @EventSourcingHandler
  public void on(UserPasswordSignedUpEvent event) {
    this.id = event.getUserPasswordId();
    this.hashValue = event.getHashValue();
    this.accountIdList.add(event.getAccountId());
  }

  @EventSourcingHandler
  public void on(UserPasswordBoundUserEvent event) {
    this.userId = event.getUserId();
  }

  private String hashInputPassword(String input) {
    return DigestUtils.md5DigestAsHex(input.getBytes());
  }

  public Boolean validPassword(String password) {
    return this.hashValue.equals(hashInputPassword(password));
  }

  public UserPasswordId getId() {
    return id;
  }

  public String getHashValue() {
    return hashValue;
  }

  public UserId getUserId() {
    return userId;
  }

  public List<AccountId> getAccountIdList() {
    return accountIdList;
  }
}

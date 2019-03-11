package zy.cy6.zyxt.users.account;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import zy.cy6.zyxt.api.users.account.AccountId;
import zy.cy6.zyxt.api.users.account.command.BindUserPasswordToAccountCommand;
import zy.cy6.zyxt.api.users.account.command.BindUserToAccountCommand;
import zy.cy6.zyxt.api.users.account.command.SignUpAccountCommand;
import zy.cy6.zyxt.api.users.account.event.AccountBoundUserEvent;
import zy.cy6.zyxt.api.users.account.event.AccountBoundUserPasswordEvent;
import zy.cy6.zyxt.api.users.account.event.AccountSignedUpEvent;
import zy.cy6.zyxt.api.users.user.UserId;
import zy.cy6.zyxt.api.users.user.UserPasswordId;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Account {
  @AggregateIdentifier
  private AccountId id;

  private UserId userId;

  private UserPasswordId userPasswordId;

  /**
   * 对于可溯源的事件，需要提供一个无参构造函数，
   * axon框架会在使用过往事件回溯之前，使用这个构造函数进行对象实例化
   */
  protected Account() {
  }

  @CommandHandler
  public Account(SignUpAccountCommand command) {
    apply(AccountSignedUpEvent.builder().accountId(command.getAccountId()).build());
  }

  @CommandHandler
  public void handler(BindUserToAccountCommand command) {
    apply(AccountBoundUserEvent.builder().accountId(command.getAccountId()).userId(command.getUserId()).build());
  }

  @CommandHandler
  public void handler(BindUserPasswordToAccountCommand command) {
    apply(AccountBoundUserPasswordEvent.builder().accountId(command.getAccountId()).userPasswordId(command.getUserPasswordId()).build());
  }

  @EventSourcingHandler
  public void on(AccountSignedUpEvent event) {
    this.id = event.getAccountId();
  }

  @EventSourcingHandler
  public void on(AccountBoundUserEvent event) {
    this.userId = event.getUserId();
  }

  @EventSourcingHandler
  public void on(AccountBoundUserPasswordEvent event) {
    this.userPasswordId = event.getUserPasswordId();
  }

  public AccountId getId() {
    return id;
  }

  public UserId getUserId() {
    return userId;
  }

  public UserPasswordId getUserPasswordId() {
    return userPasswordId;
  }
}

/*
 * Copyright (c) 2010-2012. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package zy.cy6.zyxt.users.user;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import zy.cy6.zyxt.api.users.account.AccountId;
import zy.cy6.zyxt.api.users.user.UserId;
import zy.cy6.zyxt.api.users.user.UserPasswordId;
import zy.cy6.zyxt.api.users.user.command.CreateUserCommand;
import zy.cy6.zyxt.api.users.user.enent.UserCreatedEvent;

import java.util.ArrayList;
import java.util.List;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class User {
  @AggregateIdentifier
  private UserId id;
  private String realName;
  private List<AccountId> accountIdList = new ArrayList<>();
  private UserPasswordId userPasswordId;
  protected User() {
  }

  @CommandHandler
  public User(CreateUserCommand command) {
    apply( UserCreatedEvent.builder()
            .userId(UserId.builder().build())
            .accountId(command.getAccountId())
            .userPasswordId(command.getUserPasswordId())
            .build()
    );
  }

  @EventSourcingHandler
  public void on(UserCreatedEvent event) {
    this.id = event.getUserId();
    if (event.getAccountId() != null) {
      this.accountIdList.add(event.getAccountId());
    }

    if (event.getUserPasswordId() != null) {
      this.userPasswordId = event.getUserPasswordId();
    }
    this.accountIdList.add(event.getAccountId());
  }

  public UserId getId() {
    return id;
  }

  public String getRealName() {
    return realName;
  }

  public List<AccountId> getAccountIdList() {
    return accountIdList;
  }

  public UserPasswordId getUserPasswordId() {
    return userPasswordId;
  }
}

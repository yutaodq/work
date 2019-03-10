///*
// * Copyright (c) 2010-2012. Axon Framework
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package zy.cy6.zyxt.users.command;
//
//import org.axonframework.commandhandling.CommandHandler;
//import org.axonframework.commandhandling.model.AggregateIdentifier;
//import org.axonframework.eventsourcing.EventSourcingHandler;
//import org.axonframework.samples.trader.api.users.*;
//import org.axonframework.samples.trader.users.util.DigestUtils;
//import org.axonframework.spring.stereotype.Aggregate;
//import zy.cy6.zyxt.api.users.*;
//
//import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;
//
//@Aggregate
//public class User {
//
//  @AggregateIdentifier
//  private UserId userId;
//  private UserPassword passwordHash;
//
//  public User() {
//    // Required by Axon Framework
//  }
//
//  @CommandHandler
//  public User(CreateUserCommand cmd) {
//    apply(UserCreatedEvent.builder().userId(cmd.getUserId()).username(cmd.getUsername()).userPassword(cmd.getUserPassword()).name(cmd.getName()))
//  }
//
//  @CommandHandler
//  public boolean handle(AuthenticateUserCommand cmd) {
//    boolean success = this.passwordHash.equals(hashOf(cmd.getUserPassword()));
//    if (success) {
//      apply(new UserAuthenticatedEvent(userId));
//    }
//    return success;
//  }
//
//  @EventSourcingHandler
//  public void on(UserCreatedEvent event) {
//    this.userId = event.getUserId();
//    this.passwordHash = event.getUserPassword();
//  }
//
//  private String hashOf(char[] password) {
//    return DigestUtils.sha1(String.valueOf(password));
//  }
//}

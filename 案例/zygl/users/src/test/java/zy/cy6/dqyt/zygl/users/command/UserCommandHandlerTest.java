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

package zy.cy6.dqyt.zygl.users.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.Repository;
import zy.cy6.dqyt.zygl.query.users.repositories.UserQueryRepository;
import zy.cy6.dqyt.zygl.api.users.AuthenticateUserCommand;
import zy.cy6.dqyt.zygl.api.users.CreateUserCommand;
import zy.cy6.dqyt.zygl.api.users.UserAccount;
import zy.cy6.dqyt.zygl.api.users.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Jettro Coenradie
 */
@Component
public class UserCommandHandlerTest {

    private Repository<User> repository;

    private UserQueryRepository userQueryRepository;

    @CommandHandler
    public UserId handleCreateUser(CreateUserCommand command) throws Exception {
        UserId identifier = command.getUserId();
        repository.newInstance(() -> new User(identifier, command.getUsername(), command.getName(), command.getPassword()));
        return identifier;
    }

    @CommandHandler
    public UserAccount handleAuthenticateUser(AuthenticateUserCommand command) {
        UserAccount account = userQueryRepository.findByUsername(command.getUserName());
        if (account == null) {
            return null;
        }
        boolean success = onUser(account.getUserId()).invoke(user -> user.authenticate(command.getPassword()));
        return success ? account : null;
    }

    private Aggregate<User> onUser(String userId) {
        return repository.load(userId, null);
    }


    @Autowired
    @Qualifier("userRepository")
    public void setRepository(Repository<User> userRepository) {
        this.repository = userRepository;
    }

    @Autowired
    public void setUserRepository(UserQueryRepository userRepository) {
        this.userQueryRepository = userRepository;
    }
}

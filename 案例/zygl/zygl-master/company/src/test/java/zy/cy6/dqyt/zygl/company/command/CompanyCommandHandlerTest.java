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

package zy.cy6.dqyt.zygl.company.command;

import zy.cy6.dqyt.zygl.api.company.CompanyCreatedEvent;
import zy.cy6.dqyt.zygl.api.company.CompanyId;
import zy.cy6.dqyt.zygl.api.company.CreateCompanyCommand;
import zy.cy6.dqyt.zygl.api.users.UserId;
import zy.cy6.dqyt.zygl.company.command.Company;
import zy.cy6.dqyt.zygl.company.command.CompanyCommandHandler;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jettro Coenradie
 */
public class CompanyCommandHandlerTest {

    private AggregateTestFixture<Company> fixture;

    @Before
    public void setUp() {
        fixture = new AggregateTestFixture(Company.class);
        CompanyCommandHandler commandHandler = new CompanyCommandHandler();
        commandHandler.setRepository(fixture.getRepository());
        fixture.registerAnnotatedCommandHandler(commandHandler);
    }

    @Test
    public void testCreateCompany() {
        CompanyId aggregateIdentifier = new CompanyId();
        UserId userId = new UserId();
        CreateCompanyCommand command = new CreateCompanyCommand(aggregateIdentifier, userId, "TestItem", 1000, 10000);

        fixture.given()
                .when(command)
                .expectEvents(new CompanyCreatedEvent(aggregateIdentifier, "TestItem", 1000, 10000));
    }
}

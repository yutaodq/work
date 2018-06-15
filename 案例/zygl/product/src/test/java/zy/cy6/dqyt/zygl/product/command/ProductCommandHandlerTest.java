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

package zy.cy6.dqyt.zygl.product.command;

//import org.axonframework.samples.trader.company.command.Company;
//import org.axonframework.samples.trader.company.command.CompanyCommandHandler;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zy.cy6.dqyt.zygl.api.product.CreateProductCommand;
import zy.cy6.dqyt.zygl.api.product.ProductCreatedEvent;
import zy.cy6.dqyt.zygl.api.product.ProductId;
import zy.cy6.dqyt.zygl.api.product.ProductName;
import zy.cy6.dqyt.zygl.product.ProductApp;

/**
 * @author Jettro Coenradie
 */
public class ProductCommandHandlerTest {
    private static final Logger log = LoggerFactory.getLogger(ProductApp.class);

    private AggregateTestFixture<Product> fixture;

    @Before
    public void setUp() {
        fixture = new AggregateTestFixture<Product>(Product.class);
        ProductCommandHandler commandHandler = new ProductCommandHandler();
        commandHandler.setRepository(fixture.getRepository());
        fixture.registerAnnotatedCommandHandler(commandHandler);
    }

    

    @Test
    public void testCreateProduct() {
        ProductId aggregateIdentifier = (ProductId) ProductId.create();
        log.info("聚合根标识符："+aggregateIdentifier.identifier());
        ProductName productName = ProductName.create("name", "model", "size", "unit");
        CreateProductCommand command = CreateProductCommand.create(aggregateIdentifier, productName);
        

        fixture.given()
                .when(command)
                .expectEvents(ProductCreatedEvent.create(aggregateIdentifier, productName));
    }
}

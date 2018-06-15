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

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import zy.cy6.dqyt.zygl.api.product.CreateProductCommand;

/**
 * @author Jettro Coenradie
 */

public class ProductCommandHandler {

    private Repository<Product> repository;

    @CommandHandler
    public void handleCreateCompany(CreateProductCommand command) throws Exception {
        repository.newInstance(() -> {
            return new Product(command.getProductId(),
                        command.getProductName());
        });
    }


    @Autowired
    @Qualifier("productRepository")
    public void setRepository(Repository<Product> productRepository) {
        this.repository = productRepository;
    }
}

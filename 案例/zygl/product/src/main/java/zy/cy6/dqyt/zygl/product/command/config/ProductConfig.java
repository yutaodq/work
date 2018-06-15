/*
 * Copyright (c) 2010-2016. Axon Framework
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

package zy.cy6.dqyt.zygl.product.command.config;

import org.axonframework.commandhandling.model.Repository;
import org.axonframework.common.caching.Cache;
import org.axonframework.eventsourcing.AggregateFactory;
import org.axonframework.eventsourcing.CachingEventSourcingRepository;
import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition;
import org.axonframework.eventsourcing.Snapshotter;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.spring.eventsourcing.SpringPrototypeAggregateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import zy.cy6.dqyt.zygl.product.command.Product;
import zy.cy6.dqyt.zygl.product.command.ProductCommandHandler;
@Configuration
public class ProductConfig {

    @Autowired
    private EventStore eventStore;

    @Autowired
    private Snapshotter snapshotter;

    @Autowired
    private Cache cache;


    @Bean
    @Scope("prototype")
    public Product product() {
        return new Product();
    }

    @Bean
    public Repository<Product> productRepository() {
        EventCountSnapshotTriggerDefinition snapshotTriggerDefinition = new EventCountSnapshotTriggerDefinition(
                snapshotter,
                50);

        CachingEventSourcingRepository<Product> repository = new CachingEventSourcingRepository<>(
               productAggregateFactory(),
                eventStore,
                cache,
                snapshotTriggerDefinition);

        return repository;
    }

    @Bean
    public ProductCommandHandler productCommandHandler() {
        ProductCommandHandler productCommandHandler = new ProductCommandHandler();
        productCommandHandler.setRepository(productRepository());

        return productCommandHandler;
    }

    @Bean
    public AggregateFactory<Product> productAggregateFactory() {
        SpringPrototypeAggregateFactory<Product> springPrototypeAggregateFactory = new SpringPrototypeAggregateFactory<>();
        springPrototypeAggregateFactory.setPrototypeBeanName("product");

        return springPrototypeAggregateFactory;
    }

}
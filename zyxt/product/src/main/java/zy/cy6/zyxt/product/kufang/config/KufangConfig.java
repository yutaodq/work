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
package zy.cy6.zyxt.product.kufang.config;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.common.caching.Cache;
import org.axonframework.eventsourcing.AggregateFactory;
import org.axonframework.eventsourcing.CachingEventSourcingRepository;
import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition;
import org.axonframework.eventsourcing.SnapshotTriggerDefinition;
import org.axonframework.eventsourcing.Snapshotter;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.spring.config.AxonConfiguration;
import org.axonframework.spring.eventsourcing.SpringPrototypeAggregateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zy.cy6.zyxt.product.kufang.command.Kufang;
import zy.cy6.zyxt.product.kufang.command.KufangCommandHandler;
import org.axonframework.eventhandling.EventBus;

@Configuration
public class KufangConfig {
    @Autowired
    private AxonConfiguration axonConfiguration;
    @Autowired
    private EventBus eventBus;

//    @Bean
//    public KufangCommandHandler kufangCommandHandler() {
//        return new KufangCommandHandler(axonConfiguration.repository(Kufang.class), eventBus);
//    }
//    @Bean
//    public KufangCommandHandler kufangCommandHandler() {
//        KufangCommandHandler kufangCommandHandler = new KufangCommandHandler();
//        kufangCommandHandler.setRepository(kufangAggregateRepository());
//
//        return kufangCommandHandler;
//    }

//    private static final int SNAPSHOT_THRESHOLD = 50;
//
//    @Autowired
//    private EventStore eventStore;
//
//    @Autowired
//    private Snapshotter snapshotter;
//
//    @Autowired
//    private Cache cache;
//
//    //TODO #28 this should become an overall snapshot trigger definition i.o. in the company config
//    @Bean
//    public SnapshotTriggerDefinition snapshotTriggerDefinition(Snapshotter snapshotter) {
//        return new EventCountSnapshotTriggerDefinition(snapshotter, SNAPSHOT_THRESHOLD);
//    }
//
////    @Bean(name = "kufangAggregateRepository")
////    public Repository<Kufang> kufangAggregateRepository(AggregateFactory<Kufang> kufangAggregateFactory,
////                                                         EventStore eventStore,
////                                                         Cache cache,
////                                                         SnapshotTriggerDefinition snapshotTriggerDefinition) {
////        return new CachingEventSourcingRepository<>(kufangAggregateFactory,
////                eventStore,
////                cache,
////                snapshotTriggerDefinition);
////    }
//
//    @Bean(name = "kufangAggregateRepository")
//    public Repository<Kufang> kufangAggregateRepository() {
//        EventCountSnapshotTriggerDefinition snapshotTriggerDefinition = new EventCountSnapshotTriggerDefinition(
//                snapshotter,
//                50);
//
//        return new CachingEventSourcingRepository<>(
//                kufangAggregateFactory(),
//                eventStore,
//                cache,
//                snapshotTriggerDefinition);
//
//    }
//
//    @Bean
//    public AggregateFactory<Kufang> kufangAggregateFactory() {
//        SpringPrototypeAggregateFactory<Kufang> springPrototypeAggregateFactory = new SpringPrototypeAggregateFactory<>();
//        springPrototypeAggregateFactory.setPrototypeBeanName("kufang");
//        return springPrototypeAggregateFactory;
//    }
//    @Bean
//    public KufangCommandHandler kufangCommandHandler() {
//        KufangCommandHandler kufangCommandHandler = new KufangCommandHandler();
//        kufangCommandHandler.setRepository(kufangAggregateRepository());
//
//        return kufangCommandHandler;
//    }

}

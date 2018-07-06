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

package zy.cy6.zyxt.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactoryBean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


@Configuration
public class PersistenceInfrastructureConfig {

    @Bean
    public EmbeddedDatabaseFactoryBean dataSource() {
        EmbeddedDatabaseFactoryBean embeddedDatabaseFactoryBean = new EmbeddedDatabaseFactoryBean();
        embeddedDatabaseFactoryBean.setDatabaseType(EmbeddedDatabaseType.H2);
        return embeddedDatabaseFactoryBean;
    }
/*
    @Bean
    @Profile("mongodb")
    public MongoClient mongo() throws UnknownHostException {
        return new MongoClient("127.0.0.1", 27017);
    }

    @Bean
    @Profile("mongodb")
    public MongoTemplate mongoSpringTemplate() throws UnknownHostException {
        return new MongoTemplate(mongo(), "axontrader");
    }

    @Bean
    @Profile("mongodb")
    public org.axonframework.mongo.eventsourcing.eventstore.MongoTemplate mongoTemplate() throws UnknownHostException {
        return new DefaultMongoTemplate(mongo(), "axontrader", "domainevents", "snapshotevents");
    }

    @Bean
    @Profile("mongodb")
    public org.axonframework.mongo.eventhandling.saga.repository.MongoTemplate mongoSagaTemplate()
            throws UnknownHostException {
        return new org.axonframework.mongo.eventhandling.saga.repository.DefaultMongoTemplate(mongo(),
                                                                                              "axontrader",
                                                                                              "sagas");
    }
    */
}
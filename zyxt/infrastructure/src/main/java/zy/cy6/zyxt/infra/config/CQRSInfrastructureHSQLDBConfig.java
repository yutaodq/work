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

import org.springframework.context.annotation.Configuration;

@Configuration
public class CQRSInfrastructureHSQLDBConfig {

//    @Bean
//    public SpringDataSourceConnectionProvider springDataSourceConnectionProvider(DataSource dataSource) {
//        return new SpringDataSourceConnectionProvider(dataSource);
//    }
//
//
//    @Bean
//    public JpaEventStorageEngine eventStorageEngine(EntityManagerProvider entityManagerProvider) {
//
//        return new JpaEventStorageEngine(entityManagerProvider, NoTransactionManager.INSTANCE);
//    }
//
//    @Bean
//    public EntityManagerProvider entityManagerProvider() {
//        return new ContainerManagedEntityManagerProvider();
//    }
//
////    @Bean
////    public EventStore eventStore(EventStorageEngine eventStorageEngine) {
////        return new EmbeddedEventStore(eventStorageEngine);
////    }
//
//    @Bean
//    public EventStore eventStore(EntityManagerProvider entityManagerProvider) {
//        return new EmbeddedEventStore(eventStorageEngine(entityManagerProvider));
//    }
//
//    @Bean
//    public EventTableFactory eventSchemaFactory() {
//        return HsqlEventTableFactory.INSTANCE;
//    }
//
//    @Bean
//    public EventSchema eventSchema() {
//        return new EventSchema();
//    }
//
//    @Bean
//    public SagaSqlSchema sagaSqlSchema() {
//        return new HsqlSagaSqlSchema();
//    }
//
//    @Bean
//    public SagaStore<Object> sagaRepository(DataSource dataSource) {
//        return new JdbcSagaStore(dataSource, sagaSqlSchema());
//    }
}
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

import org.axonframework.common.jdbc.ConnectionProvider;
import org.axonframework.common.transaction.NoTransactionManager;
import org.axonframework.eventhandling.saga.repository.SagaStore;
import org.axonframework.eventhandling.saga.repository.jdbc.HsqlSagaSqlSchema;
import org.axonframework.eventhandling.saga.repository.jdbc.JdbcSagaStore;
import org.axonframework.eventhandling.saga.repository.jdbc.SagaSqlSchema;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.eventsourcing.eventstore.jdbc.EventSchema;
import org.axonframework.eventsourcing.eventstore.jdbc.EventTableFactory;
import org.axonframework.eventsourcing.eventstore.jdbc.HsqlEventTableFactory;
import org.axonframework.eventsourcing.eventstore.jdbc.JdbcEventStorageEngine;
import org.axonframework.spring.jdbc.SpringDataSourceConnectionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class CQRSInfrastructureHSQLDBConfig {

  @Bean
  public SpringDataSourceConnectionProvider springDataSourceConnectionProvider(DataSource dataSource) {
    return new SpringDataSourceConnectionProvider(dataSource);
  }

  @Bean
  public JdbcEventStorageEngine eventStorageEngine(ConnectionProvider connectionProvider) {
    return new JdbcEventStorageEngine(connectionProvider, NoTransactionManager.INSTANCE);
  }

  @Bean
  public EventStore eventStore(ConnectionProvider connectionProvider) {
    return new EmbeddedEventStore(eventStorageEngine(connectionProvider));
  }

  @Bean
  public EventTableFactory eventSchemaFactory() {
    return HsqlEventTableFactory.INSTANCE;
  }

  @Bean
  public EventSchema eventSchema() {
    return new EventSchema();
  }

  @Bean
  public SagaSqlSchema sagaSqlSchema() {
    return new HsqlSagaSqlSchema();
  }

  @Bean
  public SagaStore<Object> sagaRepository(DataSource dataSource) {
    return new JdbcSagaStore(dataSource, sagaSqlSchema());
  }
}

//import org.axonframework.common.jpa.ContainerManagedEntityManagerProvider;
//import org.axonframework.common.jpa.EntityManagerProvider;
//import org.axonframework.common.jpa.SimpleEntityManagerProvider;
//import org.axonframework.common.transaction.NoTransactionManager;
//import org.axonframework.eventhandling.saga.repository.SagaStore;
//import org.axonframework.eventhandling.saga.repository.jpa.JpaSagaStore;
//import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
//import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
//import org.axonframework.eventsourcing.eventstore.EventStore;
//import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine;
//import org.axonframework.serialization.Serializer;
//import org.axonframework.spring.jdbc.SpringDataSourceConnectionProvider;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//
//@Configuration
//public class CQRSInfrastructureHSQLDBConfig {
//
//  @Bean
//  public SpringDataSourceConnectionProvider springDataSourceConnectionProvider(DataSource dataSource) {
//    return new SpringDataSourceConnectionProvider(dataSource);
//  }
//  @Bean
//  public EntityManagerProvider entityManagerProvider() {
//    ContainerManagedEntityManagerProvider entityManagerprovider= new ContainerManagedEntityManagerProvider();
////    	 entityManagerprovider.setEntityManager(entityManager);
//    return entityManagerprovider;
//  }
//
//  @Bean
//  public EventStorageEngine eventStorageEngine(EntityManagerProvider entityManagerProvider) {
//    return new JpaEventStorageEngine(entityManagerProvider, NoTransactionManager.INSTANCE);
//  }
//
///*
// * EventStore 就是事件总线 eventBus
// */
//  @Bean
//public EventStore eventStore(EntityManagerProvider entityManagerProvider) {
//  return new EmbeddedEventStore(eventStorageEngine(entityManagerProvider));
//}
//
////  @Bean
////  public EventTableFactory eventSchemaFactory() {
////    return HsqlEventTableFactory.INSTANCE;
////  }
//
////  @Bean
////  public EventSchema eventSchema() {
////    return new EventSchema();
////  }
//
////  @Bean
////  public SagaSqlSchema sagaSqlSchema() {
////     return new  HsqlSagaSqlSchema();
////  }
//
////  @Bean
////  public SagaStore<Object> sagaStore(EntityManagerProvider provider) {
////    return new JpaSagaStore(provider);
////  }
//
//  @Bean
//  public SagaStore sagaStore(Serializer serializer, EntityManager entityManager) {
//    return new JpaSagaStore(serializer, new SimpleEntityManagerProvider(entityManager));
//  }
//
//}
//
//

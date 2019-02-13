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
import org.axonframework.config.Configurer;
import org.axonframework.config.DefaultConfigurer;
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
  /*
  Axon 提供了两个事件总线的实现：
  SimpleEventBus和EmbeddedEventStore。两个实现都支持订阅和跟踪处理器(processor)。
  EmbeddedEventStore持久化事件，它允许你在以后的阶段重放它们。
  SimpleEventBus有一个易失性存储器，然后一旦事件已经发布到订阅组件上，就会“忘记”它们。

  当使用配置API时，默认情况下使用SimpleEventBus。
  配置EmbeddedEventStore则相反，需要提供一个StorageEngine的实现，它对事件进行实际存储。

  Configurer configurer = DefaultConfigurer.defaultConfiguration();
configurer.configureEmbeddedEventStore(c -> new InMemoryEventStorageEngine());
*/
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


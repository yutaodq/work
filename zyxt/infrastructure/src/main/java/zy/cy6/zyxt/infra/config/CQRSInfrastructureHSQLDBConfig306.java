//package zy.cy6.zyxt.infra.config;
//
//import org.axonframework.common.jdbc.ConnectionProvider;
//import org.axonframework.common.transaction.NoTransactionManager;
//import org.axonframework.eventhandling.saga.repository.SagaStore;
//import org.axonframework.eventhandling.saga.repository.jdbc.HsqlSagaSqlSchema;
//import org.axonframework.eventhandling.saga.repository.jdbc.JdbcSagaStore;
//import org.axonframework.eventhandling.saga.repository.jdbc.SagaSqlSchema;
//import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
//import org.axonframework.eventsourcing.eventstore.EventStore;
//import org.axonframework.eventsourcing.eventstore.jdbc.EventSchema;
//import org.axonframework.eventsourcing.eventstore.jdbc.EventTableFactory;
//import org.axonframework.eventsourcing.eventstore.jdbc.HsqlEventTableFactory;
//import org.axonframework.eventsourcing.eventstore.jdbc.JdbcEventStorageEngine;
//import org.axonframework.spring.jdbc.SpringDataSourceConnectionProvider;
//import org.springframework.context.annotation.Bean;
//
//import javax.sql.DataSource;
//
//public class CQRSInfrastructureHSQLDBConfig306 {
//    @Bean
//    public SpringDataSourceConnectionProvider springDataSourceConnectionProvider(DataSource dataSource) {
//        return new SpringDataSourceConnectionProvider(dataSource);
//    }
//
//    @Bean
//    public JdbcEventStorageEngine eventStorageEngine(ConnectionProvider connectionProvider) {
//        return new JdbcEventStorageEngine(connectionProvider, NoTransactionManager.INSTANCE);
//    }
//
//    @Bean
//    public EventStore eventStore(ConnectionProvider connectionProvider) {
//        return new EmbeddedEventStore(eventStorageEngine(connectionProvider));
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
//}

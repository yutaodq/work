package zy.cy6.zyxt.web.init;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.saga.repository.jdbc.SagaSqlSchema;
import org.axonframework.eventsourcing.eventstore.jdbc.EventSchema;
import org.axonframework.eventsourcing.eventstore.jdbc.EventTableFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Initialisation of the Hsql datastore.
 */
@Component
@Slf4j
public class HsqlDBInit {
  private EventTableFactory eventTableFactory;
  private EventSchema eventSchema;
  private SagaSqlSchema sagaSqlSchema;
  private DataSource dataSource;

  @Autowired
  public HsqlDBInit(
                    EventTableFactory eventTableFactory,
                    EventSchema eventSchema,
                    SagaSqlSchema sagaSqlSchema, DataSource dataSource) {
    log.info("初始化：HsqlDBInit");
    this.eventTableFactory = eventTableFactory;
    this.eventSchema = eventSchema;
    this.sagaSqlSchema = sagaSqlSchema;
    this.dataSource = dataSource;
  }
  void initializeDB() {
    log.info("Initialize the hsqldb database.");
    // TODO jettro: Check and create schema, if exists empty the tables
    try {
      Connection connection = dataSource.getConnection();

//      sql_dropDomainEventEntryTable(connection).execute();
//      sql_dropSnapshotEventEntryTable(connection).execute();
//      sql_dropTableAssocValueEntry(connection).execute();
//      sql_dropTableSagaEntry(connection).execute();

//      connection.commit();

      eventTableFactory.createDomainEventTable(connection, eventSchema)
              .execute();
      eventTableFactory.createSnapshotEventTable(connection, eventSchema)
              .execute();
      sagaSqlSchema.sql_createTableSagaEntry(connection).execute();
      sagaSqlSchema.sql_createTableAssocValueEntry(connection).execute();

      connection.commit();

      connection.close();
    } catch (SQLException e) {
      log.error("Exception during database initialisation.", e);
    }
  }

}

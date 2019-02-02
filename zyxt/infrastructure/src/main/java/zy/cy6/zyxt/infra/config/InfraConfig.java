package zy.cy6.zyxt.infra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import({CQRSInfrastructureConfig.class, CQRSInfrastructureHSQLDBConfig.class, PersistenceInfrastructureConfig.class, DataSourceConfig.class, JpaConfig.class})
@Import({CQRSInfrastructureConfig.class, CQRSInfrastructureHSQLDBConfig.class, JpaConfig.class})
public class InfraConfig {
}

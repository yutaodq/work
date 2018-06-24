package zy.cy6.zyxt.infra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CQRSInfrastructureConfig.class,
        PersistenceInfrastructureConfig.class,
        DataSourceConfig.class,
        JpaConfig.class})
public class InfraConfig {
}

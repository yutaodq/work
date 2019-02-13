package zy.cy6.zyxt.infra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import({CQRSInfrastructureConfig.class, CQRSInfrastructureHSQLDBConfig.class})
@Import({CQRSInfrastructureConfig.class})
public class InfraConfig {
}

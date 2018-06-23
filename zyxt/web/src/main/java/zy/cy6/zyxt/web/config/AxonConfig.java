package zy.cy6.zyxt.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import zy.cy6.zyxt.infra.config.CQRSInfrastructureConfig;

@Configuration
@Import({CQRSInfrastructureConfig.class
//        PersistenceInfrastructureConfig.class,
//        TradeEngineConfig.class,
//        CompaniesConfig.class,
//        OrdersConfig.class,
//        ExternalListenersConfig.class,
//        UsersConfig.class,
//        UsersQueryConfig.class,
//        QueryConfig.class
})

public class AxonConfig {


}

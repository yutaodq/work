package zy.cy6.zyxt.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import zy.cy6.zyxt.infra.config.InfraConfig;
import zy.cy6.zyxt.infra.config.PersistenceInfrastructureConfig;
import zy.cy6.zyxt.product.config.ProductConfig;
import zy.cy6.zyxt.query.config.QueryConfig;
@Configuration
@Import({InfraConfig.class,
        PersistenceInfrastructureConfig.class,
        QueryConfig.class,
        ProductConfig.class})
public class AxonConfig {

}

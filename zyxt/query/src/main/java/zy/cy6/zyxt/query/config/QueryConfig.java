package zy.cy6.zyxt.query.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import({JpaConfig.class, H2Config.class})
@Import({ JpaConfig.class})

public class QueryConfig {

}

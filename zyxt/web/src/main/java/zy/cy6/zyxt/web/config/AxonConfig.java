package zy.cy6.zyxt.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import zy.cy6.zyxt.infra.config.InfraConfig;

@Configuration
@Import({InfraConfig.class})

public class AxonConfig {


}

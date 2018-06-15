package zy.cy6.dqyt.zygl.infra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import zy.cy6.dqyt.zygl.infra.config.jhipster.AsyncConfiguration;
import zy.cy6.dqyt.zygl.infra.config.jhipster.JHipsterProperties;


@Configuration
@Import({
	DataSourceConfig.class,
	CQRSInfrastructureConfig.class,
	AsyncConfiguration.class,
	JHipsterProperties.class,
})

public class InfrastructureConfig {

}

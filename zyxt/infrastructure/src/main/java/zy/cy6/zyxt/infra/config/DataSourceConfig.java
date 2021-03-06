package zy.cy6.zyxt.infra.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
/*多数据源的配制
 * 首先，我们必须在 application.yml 中声明两个数据源的配置，一个使用 spring.datasource ，
 * 另一个使用 spring.second-datasource ：
 *
 * spring:
    datasource:
        #datasource 使用HikariDataSource 时，一定是 jdbcUrl不能是url
        jdbcUrl: jdbc:h2:mem:zygl;DB_CLOSE_DELAY=-1
        #server模式  不使用HikariDataSource 时，url
        url: jdbc:h2:c:/temp/zygl;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=FALSE;MODE=ORACLE;TRACE_LEVEL_FILE=3;DB_CLOSE_ON_EXIT=FALSE
        username: sa
        password:
    second-datasource:
        jdbcUrl: jdbc:h2:mem:zyglsecond;DB_CLOSE_DELAY=-1
        username: sa
        password:
 */

@Configuration
@Slf4j
@Profile("dsjy")
public class DataSourceConfig {

  @Value("${spring.datasource.type}")
  private Class<? extends DataSource> dataSourceType;

  @Bean(name = "dataSource")
    @Primary
    @Qualifier("dataSource")
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    log.info("配制HikariDataSource数据源");
    return DataSourceBuilder.create().type(dataSourceType).build();
  }


//	第二个数据源

    @Qualifier("secondDatasource")
    @Bean(name = "secondDatasource")
    @ConfigurationProperties(prefix = "spring.second-datasource")
    public DataSource secondDataSource() {
	      return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

}
package zy.cy6.zyxt.query.config;
/*
 * 和QueryConfig的功能是一样的。
 * QueryConfig.java好用后，可删除这个文件
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//springboot 2.0 import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager",
        basePackages = {"zy.cy6.zyxt"})
// 设置Repository所在位置
public class JpaConfig {

  @Autowired
  @Qualifier("dataSource")
  private DataSource dataSource;



  @Bean(name = "entityManager")
  public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
    return entityManagerFactory(builder).getObject().createEntityManager();
  }

  @Bean(name = "entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
    return builder.dataSource(dataSource)
            .properties(getVendorProperties())
            .packages("zy.cy6.zyxt",
                    "org.axonframework.eventsourcing.eventstore.jpa",
                    "org.axonframework.eventhandling.tokenstore",
                    "org.axonframework.eventhandling.saga.repository.jpa"
            ) // 设置实体类所在位置
            .persistenceUnit("persistenceUnit").build();
  }

  @Autowired
  private JpaProperties jpaProperties;
  private Map<String, Object> getVendorProperties() {
    return jpaProperties.getHibernateProperties(new HibernateSettings());
  }

  @Bean(name = "transactionManager")
  public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
    return new JpaTransactionManager(entityManagerFactory(builder).getObject());
  }
}

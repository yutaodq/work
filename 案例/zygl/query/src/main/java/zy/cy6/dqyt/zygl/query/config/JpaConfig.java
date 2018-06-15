package zy.cy6.dqyt.zygl.query.config;

//import org.axonframework.boot.RegisterDefaultEntities;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
transactionManagerRef = "transactionManager", basePackages = {
		"zy.cy6.dqyt.zygl.query.*.repositories"}) // 设置Repository所在位置


public class JpaConfig {
	private static final Logger log = LoggerFactory.getLogger(JpaConfig.class);
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	

//	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		log.info("jpa实体管理器工厂");
		return builder.dataSource(dataSource).properties(getVendorProperties(dataSource))
				.packages("zy.cy6.dqyt.zygl.query","org.axonframework.eventsourcing.eventstore.jpa",
		        "org.axonframework.eventhandling.tokenstore",
		        "org.axonframework.eventhandling.saga.repository.jpa") 
				// 设置实体类所在位置
				.build();
	}

	@Autowired
	private JpaProperties jpaProperties;

	private Map<String, String> getVendorProperties(DataSource dataSource) {
		return jpaProperties.getHibernateProperties(dataSource);
	}
	
	
	//	@Primary
	@Bean(name = "entityManager")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		log.info("jpa实体管理器");
		return entityManagerFactory(builder).getObject().createEntityManager();
	}


//	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
		log.info("jpa事务管理器");
		return new JpaTransactionManager(entityManagerFactory(builder).getObject());
	}

}
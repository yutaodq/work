/////*
//// * Copyright (c) 2010-2016. Axon Framework
//// *
//// * Licensed under the Apache License, Version 2.0 (the "License");
//// * you may not use this file except in compliance with the License.
//// * You may obtain a copy of the License at
//// *
//// *     http://www.apache.org/licenses/LICENSE-2.0
//// *
//// * Unless required by applicable law or agreed to in writing, software
//// * distributed under the License is distributed on an "AS IS" BASIS,
//// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//// * See the License for the specific language governing permissions and
//// * limitations under the License.
//// */
////
//package zy.cy6.zyxt.query.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableJpaRepositories(
//        basePackages = "zy.cy6.zyxt.query.*",
//        transactionManagerRef = "jpaTransactionManager",
//        entityManagerFactoryRef = "entityManagerFactoryBean"
//)
//public class H2Config {
//    @Bean(name = "entityManagerFactoryBean")
//    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource) {
//        final LocalContainerEntityManagerFactoryBean container = new LocalContainerEntityManagerFactoryBean();
//        container.setDataSource(dataSource);
////        container.setPersistenceUnitName("trader");
//
//        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        adapter.setGenerateDdl(true);
//        container.setJpaVendorAdapter(adapter);
//
//        container.setJpaProperties(jpaProps());
//        return container;
//    }
//
//    @Bean(name = "jpaTransactionManager")
//    public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory emf) {
//        return new JpaTransactionManager(emf);
//    }
//
//    private Properties jpaProps() {
//        final Properties p = new Properties();
//        p.setProperty("hibernate.show_sql", "true");
//        p.setProperty("hibernate.generate_statistics", "false");
//        p.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
//        return p;
//    }
//}

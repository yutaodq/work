package zy.cy6.zyxt.infra.config;

import net.sf.ehcache.CacheManager;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.common.caching.EhCacheAdapter;
import org.axonframework.messaging.interceptors.BeanValidationInterceptor;
import org.axonframework.spring.config.CommandHandlerSubscriber;
import org.axonframework.spring.config.annotation.AnnotationCommandHandlerBeanPostProcessor;
import org.axonframework.spring.eventsourcing.SpringAggregateSnapshotterFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("zy.cy6.zyxt")
@Import({CQRSInfrastructureHSQLDBConfig306.class})
public class CQRSInfrastructureConfig306 {

    @Bean
    public CommandBus commandBus() {
        SimpleCommandBus commandBus = new SimpleCommandBus();
        commandBus.registerDispatchInterceptor(new BeanValidationInterceptor<>());

        return commandBus;
    }

    @Bean
    public AnnotationCommandHandlerBeanPostProcessor annotationCommandHandlerBeanPostProcessor() {
        return new AnnotationCommandHandlerBeanPostProcessor();
    }

    @Bean
    public CommandHandlerSubscriber commandHandlerSubscriber() {
        return new CommandHandlerSubscriber();
    }

    @Bean
    public SpringAggregateSnapshotterFactoryBean springAggregateSnapshotterFactoryBean() {
        return new SpringAggregateSnapshotterFactoryBean();
    }

    @Bean
    public EhCacheAdapter ehCache(CacheManager cacheManager) {
        return new EhCacheAdapter(cacheManager.getCache("testCache"));
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setShared(true);

        return ehCacheManagerFactoryBean;
    }
}
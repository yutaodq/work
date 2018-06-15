package zy.cy6.dqyt.zygl.infra.config;

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
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({ CQRSInfrastructureHSQLDBConfig.class })

public class CQRSInfrastructureConfig {

	/*
	 * AxonFramework命令拦截器 Axon Framework支持基于JSR 303 Bean Validation的验证。
	 * 这允许你用像@NotEmpty和@Pattern这样的注解，去注解命令上的字段。 你需要在你的类路径中include一个JSR
	 * 303实现(比如hibernate-Validator)。
	 * 然后，在命令总线上配置一个命令拦截器BeanValidationInterceptor，它会自动找到并配置你的验证器实现。
	 * 虽然它使用合理的默认值，但你可以根据具体需要调整它。
	 * 
	 *     compile "net.sf.ehcache:ehcache:${ehcache_version}"
	 */

	// BeanValidationInterceptor类使用了 javax.validation中的接口
	// 所以在.gradle中要引入  spring-boot-starter-validation
    @Bean
    public CommandBus commandBus() {
        SimpleCommandBus commandBus = new SimpleCommandBus();
        commandBus.registerDispatchInterceptor(new BeanValidationInterceptor<>());

        return commandBus;
    }

//    @Bean
//    public AnnotationCommandHandlerBeanPostProcessor annotationCommandHandlerBeanPostProcessor() {
//        return new AnnotationCommandHandlerBeanPostProcessor();
//    }


    
    

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
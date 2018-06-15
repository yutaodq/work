package zy.cy6.dqyt.zygl.infra.config.jhipster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.*;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import zy.cy6.dqyt.common.jhipster.ExceptionHandlingAsyncTaskExecutor;

import java.util.concurrent.Executor;

/*
 * 这个类中jhipster中的
 */
@Configuration
@EnableAsync
@EnableScheduling
public class AsyncConfiguration implements AsyncConfigurer {

	private final Logger log = LoggerFactory.getLogger(AsyncConfiguration.class);

	 @Autowired
	 private JHipsterProperties jHipsterProperties;

	@Override
	@Bean(name = "taskExecutor")
	public Executor getAsyncExecutor() {
		log.debug("Creating Async Task Executor");
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(jHipsterProperties.getAsync().getCorePoolSize());
		executor.setMaxPoolSize(jHipsterProperties.getAsync().getMaxPoolSize());
		executor.setQueueCapacity(jHipsterProperties.getAsync().getQueueCapacity());
		executor.setThreadNamePrefix("zy-Executor-");
		return new ExceptionHandlingAsyncTaskExecutor(executor);
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new SimpleAsyncUncaughtExceptionHandler();
	}
}

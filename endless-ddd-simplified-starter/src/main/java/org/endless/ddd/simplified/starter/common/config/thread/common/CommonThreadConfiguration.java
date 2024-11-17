package org.endless.ddd.simplified.starter.common.config.thread.common;

import org.endless.ddd.simplified.starter.common.config.thread.model.AbstractThreadConfiguration;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

/**
 * CommonThreadConfiguration
 * <p>
 * create 2024/11/10 15:23
 * <p>
 * update 2024/11/17 16:28
 *
 * @author Deng Haozhi
 * @see AbstractThreadConfiguration
 * @since 1.0.0
 */
@EnableAsync
@EnableConfigurationProperties(CommonThreadProperties.class)
public class CommonThreadConfiguration extends AbstractThreadConfiguration {

    public CommonThreadConfiguration(CommonThreadProperties threadProperties) {
        super(threadProperties);
    }

    @Bean("commonTaskExecutor")
    @Override
    public Executor getAsyncExecutor() {
        return super.getAsyncExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return super.getAsyncUncaughtExceptionHandler();
    }
}

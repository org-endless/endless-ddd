package org.endless.ddd.simplified.starter.common.config.thread.model;

import org.endless.ddd.simplified.starter.common.exception.config.ThreadException;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * AbstractThreadConfiguration
 * <p>
 * create 2024/11/10 14:56
 * <p>
 * update 2024/11/10 14:56
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class AbstractThreadConfiguration implements AsyncConfigurer {

    private final AbstractThreadProperties threadProperties;

    public AbstractThreadConfiguration(AbstractThreadProperties threadProperties) {
        this.threadProperties = threadProperties;
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(threadProperties.getCorePoolSize());
        threadPoolTaskExecutor.setMaxPoolSize(threadProperties.getMaxPoolSize());
        threadPoolTaskExecutor.setQueueCapacity(threadProperties.getQueueCapacity());
        threadPoolTaskExecutor.setThreadNamePrefix(threadProperties.getThreadNamePrefix());
        threadPoolTaskExecutor.setKeepAliveSeconds(threadProperties.getKeepAliveSeconds());
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(threadProperties.getAllowCoreThreadTimeOut());
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(threadProperties.getWaitForTasksToCompleteOnShutdown());
        threadPoolTaskExecutor.setAwaitTerminationSeconds(threadProperties.getAwaitTerminationSeconds());
        return setRejectedExecutionHandler(threadPoolTaskExecutor);
    }

    /**
     * 异步线程异常捕获
     * <p>Asynchronous thread exception catch
     *
     * @return org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> {
            throw new ThreadException(method.getName() + "，参数：" + Arrays.toString(objects) + "，异常：" + throwable.getMessage(), throwable);
        };
    }

    private ThreadPoolTaskExecutor setRejectedExecutionHandler(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        String rejectedExecutionHandler = threadProperties.getRejectedExecutionHandler();
        if (StringUtils.hasLength(rejectedExecutionHandler)) {
            if ("AbortPolicy".equals(rejectedExecutionHandler))
                threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
            if ("DiscardPolicy".equals(rejectedExecutionHandler))
                threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
            if ("DiscardOldestPolicy".equals(rejectedExecutionHandler))
                threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
            if ("CallerRunsPolicy".equals(rejectedExecutionHandler))
                threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        } else {
            threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        }
        return threadPoolTaskExecutor;
    }

    public Integer getCorePoolSize() {
        return threadProperties.getCorePoolSize();
    }
}

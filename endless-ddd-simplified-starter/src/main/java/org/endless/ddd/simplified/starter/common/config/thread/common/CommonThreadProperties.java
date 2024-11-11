package org.endless.ddd.simplified.starter.common.config.thread.common;

import org.endless.ddd.simplified.starter.common.config.thread.model.AbstractThreadProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * CommonThreadProperties
 * <p>
 * create 2024/11/10 15:24
 * <p>
 * update 2024/11/10 15:24
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@ConfigurationProperties(prefix = "spring.task.common-thread-pool")
public class CommonThreadProperties extends AbstractThreadProperties {

    @Override
    public Integer getCorePoolSize() {
        return super.getCorePoolSize();
    }

    @Override
    public Integer getMaxPoolSize() {
        return super.getMaxPoolSize();
    }

    @Override
    public Integer getQueueCapacity() {
        return super.getQueueCapacity();
    }

    @Override
    public String getThreadNamePrefix() {
        return super.getThreadNamePrefix();
    }

    @Override
    public Integer getKeepAliveSeconds() {
        return super.getKeepAliveSeconds();
    }

    @Override
    public Boolean getAllowCoreThreadTimeOut() {
        return super.getAllowCoreThreadTimeOut();
    }

    @Override
    public Boolean getWaitForTasksToCompleteOnShutdown() {
        return super.getWaitForTasksToCompleteOnShutdown();
    }

    @Override
    public Integer getAwaitTerminationSeconds() {
        return super.getAwaitTerminationSeconds();
    }

    @Override
    public String getRejectedExecutionHandler() {
        return super.getRejectedExecutionHandler();
    }

    @Override
    public void setCorePoolSize(Integer corePoolSize) {
        super.setCorePoolSize(corePoolSize);
    }

    @Override
    public void setMaxPoolSize(Integer maxPoolSize) {
        super.setMaxPoolSize(maxPoolSize);
    }

    @Override
    public void setQueueCapacity(Integer queueCapacity) {
        super.setQueueCapacity(queueCapacity);
    }

    @Override
    public void setThreadNamePrefix(String threadNamePrefix) {
        super.setThreadNamePrefix(threadNamePrefix);
    }

    @Override
    public void setKeepAliveSeconds(Integer keepAliveSeconds) {
        super.setKeepAliveSeconds(keepAliveSeconds);
    }

    @Override
    public void setAllowCoreThreadTimeOut(Boolean allowCoreThreadTimeOut) {
        super.setAllowCoreThreadTimeOut(allowCoreThreadTimeOut);
    }

    @Override
    public void setWaitForTasksToCompleteOnShutdown(Boolean waitForTasksToCompleteOnShutdown) {
        super.setWaitForTasksToCompleteOnShutdown(waitForTasksToCompleteOnShutdown);
    }

    @Override
    public void setAwaitTerminationSeconds(Integer awaitTerminationSeconds) {
        super.setAwaitTerminationSeconds(awaitTerminationSeconds);
    }

    @Override
    public void setRejectedExecutionHandler(String rejectedExecutionHandler) {
        super.setRejectedExecutionHandler(rejectedExecutionHandler);
    }
}

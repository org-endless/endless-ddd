package org.endless.ddd.starter.common.config.data.store.minio.okhttp;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.endless.ddd.starter.common.config.data.store.minio.okhttp.properties.OkHttpProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

/**
 * OkHttpClientConfiguration
 * <p>
 * create 2024/11/07 13:07
 * <p>
 * update 2024/11/07 13:07
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@EnableConfigurationProperties(OkHttpProperties.class)
public class OkHttpClientConfiguration {


    @Bean
    public OkHttpClient okHttpClient(OkHttpProperties properties) {
        // 获取超时时间（秒）
        int timeout = properties.getTimeout();
        // 配置 OkHttpClient
        return new OkHttpClient.Builder()
                // 配置连接池
                .connectionPool(new ConnectionPool(properties.getMaxIdle(), properties.getKeepAlive(), TimeUnit.MINUTES))
                // 设置读取超时
                .readTimeout(timeout, TimeUnit.SECONDS)
                // 设置连接超时
                .connectTimeout(timeout, TimeUnit.SECONDS)
                // 设置写入超时
                .writeTimeout(timeout, TimeUnit.SECONDS)
                // 设置连接失败时重试
                .retryOnConnectionFailure(true)
                .build();
    }
}

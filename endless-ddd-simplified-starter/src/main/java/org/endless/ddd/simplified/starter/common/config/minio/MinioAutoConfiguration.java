package org.endless.ddd.simplified.starter.common.config.minio;

import io.minio.MinioClient;
import okhttp3.OkHttpClient;
import org.endless.ddd.simplified.starter.common.config.minio.okhttp.OkHttpClientConfiguration;
import org.endless.ddd.simplified.starter.common.config.minio.properties.MinioProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * MinioAutoConfiguration
 * <p>
 * create 2024/08/09 10:09
 * <p>
 * update 2024/11/07 13:31
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@AutoConfiguration
@ConditionalOnClass(MinioClient.class)
@Import(OkHttpClientConfiguration.class)
@EnableConfigurationProperties(MinioProperties.class)
public class MinioAutoConfiguration {

    private final MinioProperties properties;

    private final OkHttpClient okHttpClient;

    public MinioAutoConfiguration(MinioProperties properties, OkHttpClient okHttpClient) {
        this.properties = properties;
        this.okHttpClient = okHttpClient;
    }

    @ConditionalOnMissingBean
    public @Bean MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(properties.getEndpoint())
                .credentials(properties.getAccessKey(), properties.getSecretKey())
                .httpClient(okHttpClient)  // 使用自定义的 OkHttpClient
                .build();
    }

    public String bucket() {
        return properties.getBucket();
    }
}

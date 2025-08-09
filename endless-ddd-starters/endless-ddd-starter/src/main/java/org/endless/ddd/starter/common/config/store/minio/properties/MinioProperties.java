package org.endless.ddd.starter.common.config.store.minio.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * MinioProperties
 * <p>
 * create 2024/08/09 11:13
 * <p>
 * update 2024/11/07 13:31
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    private String endpoint;

    private String accessKey;

    private String secretKey;

    private String bucket = "default-bucket";

    private String retentionDays = "180";
}

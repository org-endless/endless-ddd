package org.endless.ddd.starter.common.config.store.minio.okhttp.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * OkHttpProperties
 * <p>
 * create 2024/11/07 13:23
 * <p>
 * update 2024/11/07 13:23
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "minio.connect-pool")
public class OkHttpProperties {

    private Integer maxIdle;

    private Integer keepAlive;

    private Integer timeout;
}

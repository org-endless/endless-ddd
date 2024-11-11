package org.endless.ddd.simplified.starter.common.config.minio;

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
 * @since 2.0.0
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

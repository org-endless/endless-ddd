package org.endless.ddd.simplified.starter.common.config.endless;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * EndlessProperties
 * <p>
 * create 2024/11/09 19:38
 * <p>
 * update 2024/11/09 19:38
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "endless")
public class EndlessProperties {

    private String charset = "UTF-8";
}

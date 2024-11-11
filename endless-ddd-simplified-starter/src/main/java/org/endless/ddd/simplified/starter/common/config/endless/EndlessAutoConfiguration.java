package org.endless.ddd.simplified.starter.common.config.endless;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * EndlessAutoConfiguration
 * <p>
 * create 2024/11/09 19:39
 * <p>
 * update 2024/11/09 19:39
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Slf4j
@EnableConfigurationProperties(EndlessProperties.class)
public class EndlessAutoConfiguration {

    private final EndlessProperties properties;

    public EndlessAutoConfiguration(EndlessProperties properties) {
        this.properties = properties;
    }

    public void charset(){
        // retrun properties.getCharset();
    }
}

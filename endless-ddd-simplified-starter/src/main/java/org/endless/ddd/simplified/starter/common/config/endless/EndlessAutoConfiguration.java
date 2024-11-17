package org.endless.ddd.simplified.starter.common.config.endless;

import org.endless.ddd.simplified.starter.common.config.endless.properties.EndlessProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.nio.charset.Charset;

/**
 * EndlessAutoConfiguration
 * <p>
 * create 2024/11/09 19:39
 * <p>
 * update 2024/11/09 19:39
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@EnableConfigurationProperties(EndlessProperties.class)
public class EndlessAutoConfiguration {

    private final EndlessProperties properties;


    public EndlessAutoConfiguration(EndlessProperties properties) {
        this.properties = properties;
    }

    public Charset charset() {
        return properties.getCharset().getCharset();
    }

    public String[] jsonAllowedTypes() {
        return properties.getJsonAllowedTypes().toArray(new String[0]);
    }
}

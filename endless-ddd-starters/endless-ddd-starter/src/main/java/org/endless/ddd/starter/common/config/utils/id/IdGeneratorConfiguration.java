package org.endless.ddd.starter.common.config.utils.id;

import jakarta.annotation.PostConstruct;
import org.endless.ddd.starter.common.config.endless.properties.EndlessProperties;

/**
 * IdConfiguration
 * <p>
 * create 2025/08/21 02:37
 * <p>
 * update 2025/08/21 02:37
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class IdGeneratorConfiguration {

    private final EndlessProperties properties;

    public IdGeneratorConfiguration(EndlessProperties properties) {
        this.properties = properties;
    }

    @PostConstruct
    public void init() {
        IdGenerator.init(properties.getDataCenterId(), properties.getWorkerId());
    }
}

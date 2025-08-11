package org.endless.ddd.starter.common.config.error.code;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.AutoConfiguration;

/**
 * ErrorCodeAutoConfiguration
 * <p>
 * create 2025/08/11 17:11
 * <p>
 * update 2025/08/11 17:11
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@AutoConfiguration
public class ErrorCodeAutoConfiguration {

    @PostConstruct
    public void init() {
        ErrorCode.init();
    }
}

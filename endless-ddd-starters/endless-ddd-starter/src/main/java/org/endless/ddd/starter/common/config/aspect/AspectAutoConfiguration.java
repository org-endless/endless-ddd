package org.endless.ddd.starter.common.config.aspect;

import org.endless.ddd.starter.common.config.aspect.log.LogAspect;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * AspectAutoConfiguration
 * <p>
 * create 2025/08/10 03:04
 * <p>
 * update 2025/08/10 03:04
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@AutoConfiguration
@Import(LogAspect.class)
public class AspectAutoConfiguration {

}

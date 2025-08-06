package org.endless.ddd.starter.common.config.log;

import org.endless.ddd.starter.common.config.log.aspect.LogAspect;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * LogAutoConfiguration
 * <p>
 * create 2024/11/10 07:57
 * <p>
 * update 2024/11/10 07:57
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@AutoConfiguration
@Import(LogAspect.class)
public class LogAutoConfiguration {

}

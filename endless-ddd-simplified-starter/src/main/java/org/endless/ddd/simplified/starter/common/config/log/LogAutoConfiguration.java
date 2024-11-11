package org.endless.ddd.simplified.starter.common.config.log;

import org.endless.ddd.simplified.starter.common.config.log.aspect.LogAspect;
import org.springframework.context.annotation.Import;

/**
 * LogAutoConfiguration
 * <p>
 * create 2024/11/10 07:57
 * <p>
 * update 2024/11/10 07:57
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Import(LogAspect.class)
public class LogAutoConfiguration {

}

package org.endless.ddd.starter.common.config.rest.servlet;

import org.endless.ddd.starter.common.config.rest.servlet.undertow.UndertowConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * ServletConfiguration
 * <p>
 * create 2025/08/15 02:36
 * <p>
 * update 2025/08/15 02:36
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@AutoConfiguration
@Import({UndertowConfiguration.class})
public class ServletConfiguration {

}

package org.endless.ddd.starter.common.config.utils;

import org.endless.ddd.starter.common.config.utils.freemarker.FreemarkerConfiguration;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * UtilsAutoConfiguration
 * <p>
 * create 2024/12/25 15:15
 * <p>
 * update 2024/12/25 15:15
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@AutoConfiguration
@Import({IdGenerator.class, FreemarkerConfiguration.class})
public class UtilsAutoConfiguration {

}

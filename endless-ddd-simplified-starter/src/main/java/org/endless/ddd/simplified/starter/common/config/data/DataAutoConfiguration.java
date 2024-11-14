package org.endless.ddd.simplified.starter.common.config.data;

import org.endless.ddd.simplified.starter.common.config.data.cache.CacheConfiguration;
import org.endless.ddd.simplified.starter.common.config.data.persistence.mybatis.MybatisPlusConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * DataAutoConfiguration
 * <p>
 * create 2024/11/10 08:00
 * <p>
 * update 2024/11/10 08:00
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@AutoConfiguration
@Import({MybatisPlusConfiguration.class, CacheConfiguration.class})
public class DataAutoConfiguration {

}

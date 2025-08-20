package org.endless.ddd.starter.common.config.data.persistence;

import org.endless.ddd.starter.common.config.data.persistence.jpa.JpaConfiguration;
import org.endless.ddd.starter.common.config.data.persistence.mybatis.MybatisPlusConfiguration;
import org.springframework.context.annotation.Import;

/**
 * PersistenceConfiguration
 * <p>
 * create 2025/08/20 03:12
 * <p>
 * update 2025/08/20 03:12
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Import({MybatisPlusConfiguration.class, JpaConfiguration.class})
public class PersistenceConfiguration {

}

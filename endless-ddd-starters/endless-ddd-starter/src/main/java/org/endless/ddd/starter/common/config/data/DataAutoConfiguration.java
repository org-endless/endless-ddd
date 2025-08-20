package org.endless.ddd.starter.common.config.data;

import org.endless.ddd.starter.common.config.data.cache.CacheConfiguration;
import org.endless.ddd.starter.common.config.data.persistence.PersistenceConfiguration;
import org.endless.ddd.starter.common.config.data.store.StoreConfiguration;
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
 * @since 1.0.0
 */
@AutoConfiguration
@Import({CacheConfiguration.class, PersistenceConfiguration.class, StoreConfiguration.class})
public class DataAutoConfiguration {

}

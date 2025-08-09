package org.endless.ddd.starter.common.config.store;

import org.endless.ddd.starter.common.config.store.minio.MinioConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * StoreAutoConfiguration
 * <p>
 * create 2025/08/10 03:01
 * <p>
 * update 2025/08/10 03:01
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@AutoConfiguration
@Import({MinioConfiguration.class})
public class StoreAutoConfiguration {

}

package org.endless.ddd.starter.common.config.data.store;

import org.endless.ddd.starter.common.config.data.store.minio.MinioConfiguration;
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
@Import({MinioConfiguration.class})
public class StoreConfiguration {

}

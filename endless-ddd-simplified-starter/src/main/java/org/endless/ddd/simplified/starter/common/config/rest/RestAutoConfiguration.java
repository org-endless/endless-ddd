package org.endless.ddd.simplified.starter.common.config.rest;

import org.endless.ddd.simplified.starter.common.config.rest.client.RestClientConfiguration;
import org.endless.ddd.simplified.starter.common.config.rest.server.RestServerConfiguration;
import org.springframework.context.annotation.Import;

/**
 * RestAutoConfiguration
 * <p>
 * create 2024/11/09 19:48
 * <p>
 * update 2024/11/09 19:48
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Import({RestClientConfiguration.class, RestServerConfiguration.class})
public class RestAutoConfiguration {

}

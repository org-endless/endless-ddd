package org.endless.ddd.simplified.starter.common.config.rest.server;

import org.endless.ddd.simplified.starter.common.config.rest.converter.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * RestServerConfiguration
 * <p>
 * create 2024/11/09 19:23
 * <p>
 * update 2024/11/09 19:23
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class RestServerConfiguration implements WebMvcConfigurer {

    @Bean
    public HttpMessageConverter<Object> fastJsonHttpMessageConverter() {
        return new FastJsonHttpMessageConverter();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(fastJsonHttpMessageConverter());
    }
}

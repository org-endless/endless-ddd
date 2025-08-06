package org.endless.ddd.starter.common.config.rest.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.endless.ddd.starter.common.config.endless.EndlessAutoConfiguration;
import org.endless.ddd.starter.common.config.rest.converter.FastJson2HttpMessageConverter;
import org.endless.ddd.starter.common.config.rest.converter.FormHttpMessageConverter;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

/**
 * RestServerConfiguration
 * <p>
 * create 2024/11/09 19:23
 * <p>
 * update 2024/11/17 16:28
 *
 * @author Deng Haozhi
 * @see WebMvcConfigurer
 * @since 1.0.0
 */
@Import({FastJson2HttpMessageConverter.class, FormHttpMessageConverter.class})
public class RestServerConfiguration implements WebMvcConfigurer {

    private final EndlessAutoConfiguration configuration;

    public RestServerConfiguration(EndlessAutoConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void configureMessageConverters(@NonNull List<HttpMessageConverter<?>> converters) {
        converters.clear();
        converters.add(new ByteArrayHttpMessageConverter());
        FastJson2HttpMessageConverter<Object> converter = new FastJson2HttpMessageConverter<>(configuration);
        converter.setDefaultCharset(configuration.charset().getCharset());
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        converters.add(converter);
        converters.add(new MappingJackson2HttpMessageConverter(new ObjectMapper()));
    }
}

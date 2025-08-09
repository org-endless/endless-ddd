package org.endless.ddd.starter.common.config.rest.server;

import jakarta.validation.Validator;
import org.endless.ddd.starter.common.config.endless.EndlessAutoConfiguration;
import org.endless.ddd.starter.common.config.rest.converter.FastJson2HttpMessageConverter;
import org.endless.ddd.starter.common.config.rest.converter.FormHttpMessageConverter;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

    private final Validator validator;

    public RestServerConfiguration(EndlessAutoConfiguration configuration, Validator validator) {
        this.configuration = configuration;
        this.validator = validator;
    }

    @Override
    public void configureMessageConverters(@NonNull List<HttpMessageConverter<?>> converters) {
        // converters.clear();
        // converters.add(new ByteArrayHttpMessageConverter());
        // converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        // converters.add(new ResourceHttpMessageConverter());
        // converters.add(new ResourceRegionHttpMessageConverter());
        // converters.add(new AllEncompassingFormHttpMessageConverter());
        //
        // FastJson2HttpMessageConverter<Object> converter = new FastJson2HttpMessageConverter<>(configuration, validator);
        // converter.setDefaultCharset(configuration.charset().getCharset());
        // converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        // converters.add(converter);
    }
}

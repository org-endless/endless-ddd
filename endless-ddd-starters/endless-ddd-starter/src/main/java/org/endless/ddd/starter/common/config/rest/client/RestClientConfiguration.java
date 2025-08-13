package org.endless.ddd.starter.common.config.rest.client;

import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.config.endless.properties.EndlessProperties;
import org.endless.ddd.starter.common.config.rest.converter.FastJson2HttpMessageConverter;
import org.endless.ddd.starter.common.config.rest.converter.FormHttpMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;


/**
 * RestClientConfiguration
 * <p>
 * create 2024/11/09 19:47
 * <p>
 * update 2024/11/09 19:47
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Slf4j
public class RestClientConfiguration {

    private final EndlessProperties properties;

    public RestClientConfiguration(EndlessProperties properties) {
        this.properties = properties;
    }

    @Primary
    @ConditionalOnMissingBean
    public @Bean RestClient restClient() {
        RestTemplate restTemplate = new RestTemplate();
        // 清除默认的 Jackson 转换器
        restTemplate.getMessageConverters().removeIf(converter ->
                converter instanceof MappingJackson2HttpMessageConverter);
        // 添加 Fastjson2 转换器
        restTemplate.getMessageConverters().add(new FastJson2HttpMessageConverter<>(properties));
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter<>(properties));
        restTemplate.setErrorHandler(new RestClientResponseErrorHandler());
        return RestClient.create(restTemplate);
    }

    @ConditionalOnMissingBean(name = "sidecarRestClient")
    public @Bean RestClient sidecarRestClient(RestClient restClient, EndlessProperties properties) {
        return restClient.mutate()
                .baseUrl("http://" + properties.getSidecar().getHost() + ":" + properties.getSidecar().getPort())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE + ";charset=" + properties.getCharset())
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}

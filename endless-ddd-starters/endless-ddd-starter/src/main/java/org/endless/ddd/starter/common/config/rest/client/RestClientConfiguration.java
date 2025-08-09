package org.endless.ddd.starter.common.config.rest.client;

import jakarta.validation.Validator;
import org.endless.ddd.starter.common.config.endless.EndlessAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;


/**
 * RestClientConfigutration
 * <p>
 * create 2024/11/09 19:47
 * <p>
 * update 2024/11/09 19:47
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class RestClientConfiguration {

    private final EndlessAutoConfiguration configuration;

    private final Validator validator;

    public RestClientConfiguration(EndlessAutoConfiguration configuration, Validator validator) {
        this.configuration = configuration;
        this.validator = validator;
    }

    @ConditionalOnMissingBean
    public @Bean RestClient restClient() {
        RestTemplate restTemplate = new RestTemplate();
        // // 清除默认的 Jackson 转换器
        // restTemplate.getMessageConverters().removeIf(converter ->
        //         converter instanceof MappingJackson2HttpMessageConverter);
        // // 添加 Fastjson2 转换器
        // restTemplate.getMessageConverters().add(new FastJson2HttpMessageConverter<>(configuration, validator));
        // restTemplate.getMessageConverters().add(new FormHttpMessageConverter<>(configuration));
        // restTemplate.setErrorHandler(new RestClientResponseErrorHandler());
        return RestClient.create(restTemplate);
    }

    @ConditionalOnMissingBean(name = "sidecarRestClient")
    public @Bean RestClient sidecarRestClient(RestClient restClient) {
        return restClient.mutate()
                .baseUrl("http://" + configuration.sidecar().getHost() + ":" + configuration.sidecar().getPort())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE + ";charset=" + configuration.charset().getCode())
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}

package org.endless.ddd.simplified.starter.common.config.rest.client;

import org.endless.ddd.simplified.starter.common.config.rest.converter.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * RestClientConfigutration
 * <p>
 * create 2024/11/09 19:47
 * <p>
 * update 2024/11/09 19:47
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class RestClientConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // 清除默认的 Jackson 转换器
        restTemplate.getMessageConverters().removeIf(converter ->
                converter instanceof MappingJackson2HttpMessageConverter);
        // 添加 Fastjson2 转换器
        restTemplate.getMessageConverters().add(new FastJsonHttpMessageConverter());
        return restTemplate;
    }
}

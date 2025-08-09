package org.endless.ddd.starter.common.config.endless.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;

/**
 * EndlessProperties
 * <p>
 * create 2024/11/09 19:38
 * <p>
 * update 2024/11/09 19:38
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "endless")
public class EndlessProperties {

    @Value("${charset:UTF-8}")
    private String charset;

    @Value("${date.pattern:yyyy-MM-dd}")
    private String datePattern;

    @Value("${datetime.pattern:yyyy-MM-dd HH:mm:ss:SSS}")
    private String dateTimePattern;

    @Value("${server.data-center-id:1}")
    private Long dataCenterId;

    @Value("${server.worker-id:1}")
    private Long workerId;

    private Sidecar sidecar;

    private List<String> jsonAllowedTypes = Arrays.asList(
            "java.lang.String",
            "java.lang.Integer",
            "java.lang.Boolean",
            "java.util.List",
            "java.util.Map"
    );

    @Getter
    @Setter
    @ToString
    public static class Sidecar {

        @Value("${sidecar.host:localhost}")
        private String host;

        @Value("${sidecar.port:60500}")
        private Integer port;
    }
}

package org.endless.ddd.starter.common.config.endless.properties;

import lombok.Getter;
import lombok.Setter;
import org.endless.ddd.starter.common.ddd.domain.type.CharsetTypeEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;

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
@ConfigurationProperties(prefix = "endless")
public class EndlessProperties {

    @Setter
    private String charset = "UTF-8";

    @Setter
    private String datePattern = "yyyy-MM-dd";

    @Setter
    private String dateTimePattern = "yyyy-MM-dd HH:mm:ss:SSS";

    @Setter
    private Long dataCenterId = 1L;

    @Setter
    private Long workerId = 1L;

    private final Sidecar sidecar = new Sidecar();

    public CharsetTypeEnum charset() {
        return CharsetTypeEnum.fromCode(this.charset);
    }

    @Getter
    public static class Sidecar {

        @Setter
        private String host = "localhost";

        @Setter
        private Integer port = 60500;
    }
}

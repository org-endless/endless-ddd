package org.endless.domain.simplified.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * DomainSimplifiedApplication
 * <p>
 * create 2024/11/09 22:43
 * <p>
 * update 2024/11/09 22:43
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@EnableAsync
@SpringBootApplication
@MapperScan("org.endless.domain.simplified.server.common.**.mapper")
@MapperScan("org.endless.domain.simplified.server.supporting.**.mapper")
public class DomainSimplifiedApplication {
    public static void main(String[] args) {
        SpringApplication.run(DomainSimplifiedApplication.class, args);
    }
}

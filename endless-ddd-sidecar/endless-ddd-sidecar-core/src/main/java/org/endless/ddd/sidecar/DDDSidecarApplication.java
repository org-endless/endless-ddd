package org.endless.ddd.sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * DDDSidecarApplication
 * <p>
 * create 2025/08/14 03:26
 * <p>
 * update 2025/08/14 03:26
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@EnableAsync
@EnableAspectJAutoProxy
@SpringBootApplication
public class DDDSidecarApplication {

    public static void main(String[] args) {
        SpringApplication.run(DDDSidecarApplication.class, args);
    }
}

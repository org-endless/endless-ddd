package org.endless.ddd.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * DDDGeneratorApplication
 * <p>
 * create 2024/10/16 20:26
 * <p>
 * update 2024/10/16 20:26
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@EnableAsync
@EnableAspectJAutoProxy
@SpringBootApplication
@MapperScan("org.endless.ddd.**.mapper")
public class DDDGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DDDGeneratorApplication.class, args);
    }
}

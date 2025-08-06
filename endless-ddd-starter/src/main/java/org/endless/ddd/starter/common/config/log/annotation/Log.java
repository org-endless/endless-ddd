package org.endless.ddd.starter.common.config.log.annotation;

import org.endless.ddd.starter.common.config.log.type.LogLevel;

import java.lang.annotation.*;

/**
 * Log
 * <p>
 * create 2024/11/10 07:27
 * <p>
 * update 2024/11/10 07:27
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {

    /**
     * 日志信息
     *
     * @return {@link String }
     */
    String message() default "";

    /**
     * 日志中的参数，Spring EL表达式
     *
     * @return {@link String }
     */
    String value() default "";

    /**
     * 日志级别
     *
     * @return {@link LogLevel }
     */
    LogLevel level() default LogLevel.INFO;
}

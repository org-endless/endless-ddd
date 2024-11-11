package com.tansun.atp.starter.common.config.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Log
 * <p>
 * create 2024/11/10 07:27
 * <p>
 * update 2024/11/10 07:27
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
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
     * @return {@link String }
     */
    String level() default "INFO";
}

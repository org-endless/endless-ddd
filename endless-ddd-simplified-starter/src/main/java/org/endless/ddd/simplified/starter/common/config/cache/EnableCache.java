package org.endless.ddd.simplified.starter.common.config.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * EnableCache
 * <p>
 * create 2024/11/09 19:02
 * <p>
 * update 2024/11/09 19:02
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface EnableCache {

}

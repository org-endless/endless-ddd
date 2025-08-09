package org.endless.ddd.starter.common.annotation.validate.number.time;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Min;

import java.lang.annotation.*;

/**
 * TimeStampTools
 * <p>
 * create 2025/08/10 01:12
 * <p>
 * update 2025/08/10 01:12
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Min(value = 0, message = "时间戳不能小于0")
public @interface TimeStamp {

    String message() default "时间戳校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

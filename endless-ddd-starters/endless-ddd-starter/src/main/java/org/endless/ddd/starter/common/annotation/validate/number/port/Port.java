package org.endless.ddd.starter.common.annotation.validate.number.port;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.lang.annotation.*;

/**
 * Port
 * <p>
 * create 2025/08/10 00:25
 * <p>
 * update 2025/08/10 00:25
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Min(value = 0, message = "端口号不能小于0")
@Max(value = 65535, message = "端口号不能大于65535")
public @interface Port {

    String message() default "端口号校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

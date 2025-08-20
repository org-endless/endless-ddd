package org.endless.ddd.starter.common.annotation.validate.ddd;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.endless.ddd.starter.common.annotation.validator.validate.ddd.ValueConstraintValidator;

import java.lang.annotation.*;

/**
 * Value
 * <p>
 * create 2025/08/20 02:24
 * <p>
 * update 2025/08/20 02:24
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValueConstraintValidator.class)
public @interface Value {

    String message() default "值对象校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

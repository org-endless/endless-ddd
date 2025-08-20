package org.endless.ddd.starter.common.annotation.validate.ddd;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.endless.ddd.starter.common.annotation.validator.validate.ddd.AggregateConstraintValidator;

import java.lang.annotation.*;

/**
 * Aggregate
 * <p>
 * create 2025/08/07 23:37
 * <p>
 * update 2025/08/07 23:37
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AggregateConstraintValidator.class)
public @interface Aggregate {

    String message() default "领域聚合校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

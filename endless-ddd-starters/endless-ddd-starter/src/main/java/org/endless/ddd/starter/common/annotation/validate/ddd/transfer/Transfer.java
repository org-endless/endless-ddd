package org.endless.ddd.starter.common.annotation.validate.ddd.transfer;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Transfer
 * <p>
 * create 2025/08/07 23:16
 * <p>
 * update 2025/08/07 23:16
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TransferConstraintValidator.class)
public @interface Transfer {

    String message() default "传输对象校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

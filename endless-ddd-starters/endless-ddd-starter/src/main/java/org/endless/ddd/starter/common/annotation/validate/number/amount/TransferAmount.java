package org.endless.ddd.starter.common.annotation.validate.number.amount;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

/**
 * Amount
 * <p>
 * create 2025/08/07 23:37
 * <p>
 * update 2025/08/07 23:37
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "^-?\\d{1,15}(\\.\\d{1,2})?$", message = "金额必须符合Decimal(17,2)格式")
public @interface TransferAmount {

    String message() default "传输对象金额校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

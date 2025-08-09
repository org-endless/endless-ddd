package org.endless.ddd.starter.common.annotation.validate.number.amount;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

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
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@DecimalMin(value = "0.00", message = "金额不能为负")
@Digits(integer = 17, fraction = 2, message = "金额必须符合Decimal(17,2)格式")
public @interface Amount {

    String message() default "金额校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

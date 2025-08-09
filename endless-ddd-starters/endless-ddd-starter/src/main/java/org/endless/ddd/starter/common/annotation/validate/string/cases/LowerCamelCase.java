package org.endless.ddd.starter.common.annotation.validate.string.cases;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

/**
 * LowerCamelCase
 * <p>
 * create 2025/08/10 01:16
 * <p>
 * update 2025/08/10 01:16
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "^[a-z][a-z0-9]*([A-Z][a-z0-9]+)*$", message = "必须是小写字母开头的驼峰格式")
public @interface LowerCamelCase {

    String message() default "小驼峰格式校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

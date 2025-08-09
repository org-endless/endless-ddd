package org.endless.ddd.starter.common.annotation.validate.string.cases;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

/**
 * UpperCamelCase
 * <p>
 * create 2025/08/10 01:33
 * <p>
 * update 2025/08/10 01:33
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "^[A-Z][a-z0-9]*([A-Z][a-z0-9]+)*$", message = "必须是大写字母开头的驼峰格式")
public @interface UpperCamelCase {

    String message() default "大驼峰格式校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

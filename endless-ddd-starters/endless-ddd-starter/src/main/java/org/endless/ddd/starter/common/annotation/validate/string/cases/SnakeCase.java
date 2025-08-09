package org.endless.ddd.starter.common.annotation.validate.string.cases;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

/**
 * SnakeCase
 * <p>
 * create 2025/08/10 01:27
 * <p>
 * update 2025/08/10 01:27
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "^[a-z][a-z0-9]*(_[a-z0-9]+)*$", message = "必须以小写字母开头，由小写字母、数字和\"_\"组成")
public @interface SnakeCase {

    String message() default "\"_\"" + "分隔校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

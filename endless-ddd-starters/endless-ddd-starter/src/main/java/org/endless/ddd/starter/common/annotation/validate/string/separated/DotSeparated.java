package org.endless.ddd.starter.common.annotation.validate.string.separated;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

/**
 * DotSeparated
 * <p>
 * create 2025/08/10 01:25
 * <p>
 * update 2025/08/10 01:25
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*$", message = "必须由字母、数字和\".\"组成")
public @interface DotSeparated {

    String message() default "\".\"" + "分隔校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

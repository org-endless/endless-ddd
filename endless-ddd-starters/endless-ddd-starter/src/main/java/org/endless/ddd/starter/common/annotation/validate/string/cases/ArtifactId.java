package org.endless.ddd.starter.common.annotation.validate.string.cases;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

/**
 * ArtifactId
 * <p>
 * create 2025/08/10 07:14
 * <p>
 * update 2025/08/10 07:14
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(
        regexp = "^[a-z][a-z0-9\\-]{1,49}$",
        message = "构建ID必须为小写字母开头，且仅包含小写字母、数字或连字符，长度2-50"
)
public @interface ArtifactId {

    String message() default "构建ID校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

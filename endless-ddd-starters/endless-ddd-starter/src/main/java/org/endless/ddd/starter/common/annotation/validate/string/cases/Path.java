package org.endless.ddd.starter.common.annotation.validate.string.cases;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

/**
 * Path
 * <p>
 * create 2025/08/10 02:26
 * <p>
 * update 2025/08/10 02:26
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "^([A-Za-z]:/([a-zA-Z0-9._\\u4e00-\\u9fa5 -]+(/)?)+)|(/([a-zA-Z0-9._\\u4e00-\\u9fa5 -]+(/)?)+)$",
        message = "路径格式错误，支持 Windows 盘符或 Unix 绝对路径，路径段仅允许汉字、字母、数字、._-和空格，使用正斜杠分隔")
public @interface Path {

    String message() default "路径格式校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

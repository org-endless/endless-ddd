package org.endless.ddd.starter.common.annotation.validate.ddd;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.endless.ddd.starter.common.annotation.validator.validate.ddd.DataRecordConstraintValidator;

import java.lang.annotation.*;

/**
 * DataRecord
 * <p>
 * create 2025/08/07 23:33
 * <p>
 * update 2025/08/07 23:33
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DataRecordConstraintValidator.class)
public @interface DataRecord {

    String message() default "数据仓储实体校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

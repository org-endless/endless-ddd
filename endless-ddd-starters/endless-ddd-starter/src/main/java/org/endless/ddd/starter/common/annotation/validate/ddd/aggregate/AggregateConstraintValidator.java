package org.endless.ddd.starter.common.annotation.validate.ddd.aggregate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;

/**
 * AggregateConstraintValidator
 * <p>
 * create 2025/08/07 23:48
 * <p>
 * update 2025/08/07 23:58
 *
 * @author Deng Haozhi
 * @see ConstraintValidator
 * @since 1.0.0
 */
public class AggregateConstraintValidator implements ConstraintValidator<Aggregate, Object> {

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object instanceof org.endless.ddd.starter.common.ddd.domain.entity.Aggregate aggregate) {
            aggregate.validate();
            return true;
        } else {
            throw new AggregateValidateException("@AggregateValidate注解必须在领域聚合根上使用");
        }
    }
}

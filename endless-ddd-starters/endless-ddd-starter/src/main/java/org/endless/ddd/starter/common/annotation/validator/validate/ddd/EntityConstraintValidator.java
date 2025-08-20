package org.endless.ddd.starter.common.annotation.validator.validate.ddd;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.endless.ddd.starter.common.annotation.validate.ddd.Entity;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.entity.EntityValidateException;

/**
 * EntityConstraintValidator
 * <p>
 * create 2025/08/07 23:48
 * <p>
 * update 2025/08/07 23:58
 *
 * @author Deng Haozhi
 * @see ConstraintValidator
 * @since 1.0.0
 */
public class EntityConstraintValidator implements ConstraintValidator<Entity, Object> {

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object instanceof org.endless.ddd.starter.common.ddd.domain.entity.Entity entity) {
            entity.validate();
            return true;
        } else {
            throw new EntityValidateException("@Entity注解必须在领域实体上使用");
        }
    }
}

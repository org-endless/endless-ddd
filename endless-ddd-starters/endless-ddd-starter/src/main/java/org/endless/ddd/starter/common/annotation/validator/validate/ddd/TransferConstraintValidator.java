package org.endless.ddd.starter.common.annotation.validator.validate.ddd;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.ddd.starter.common.exception.ddd.common.TransferValidateException;

/**
 * TransferConstraintValidator
 * <p>
 * create 2025/08/07 23:20
 * <p>
 * update 2025/08/07 23:58
 *
 * @author Deng Haozhi
 * @see ConstraintValidator
 * @since 1.0.0
 */
public class TransferConstraintValidator implements ConstraintValidator<Transfer, Object> {

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object instanceof org.endless.ddd.starter.common.ddd.common.transfer.Transfer transfer) {
            transfer.validate();
            return true;
        } else {
            throw new TransferValidateException("@Transfer注解必须在传输对象上使用");
        }
    }
}

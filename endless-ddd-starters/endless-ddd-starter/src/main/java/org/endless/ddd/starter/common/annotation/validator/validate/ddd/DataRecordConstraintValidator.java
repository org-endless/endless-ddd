package org.endless.ddd.starter.common.annotation.validator.validate.ddd;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.endless.ddd.starter.common.annotation.validate.ddd.DataRecord;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;

/**
 * DataRecordConstraintValidator
 * <p>
 * create 2025/08/07 23:34
 * <p>
 * update 2025/08/07 23:58
 *
 * @author Deng Haozhi
 * @see ConstraintValidator
 * @since 1.0.0
 */
public class DataRecordConstraintValidator implements ConstraintValidator<DataRecord, Object> {

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object instanceof org.endless.ddd.starter.common.ddd.infrastructure.data.record.DataRecord<?> dataRecord) {
            dataRecord.validate();
            return true;
        } else {
            throw new DataRecordValidateException("@DataRecord注解必须在数据仓储实体上使用");
        }
    }
}

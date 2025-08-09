package org.endless.ddd.generator.components.generator.domain.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.generator.common.model.infrastructure.data.record.DDDGeneratorRecord;
import org.endless.ddd.generator.components.generator.domain.domain.entity.AggregateFieldEntity;
import org.endless.ddd.generator.components.generator.domain.domain.type.AggregateFieldTypeEnum;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.springframework.util.StringUtils;

/**
 * AggregateFieldRecord
 * <p>聚合根字段数据库记录实体
 * <p>
 * create 2025/08/07 16:57
 * <p>
 * update 2025/08/07 16:57
 *
 * @author Deng Haozhi
 * @see DDDGeneratorRecord
 * @since 1.0.0
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "generator_aggregate_field")
public class AggregateFieldRecord implements DDDGeneratorRecord<AggregateFieldEntity> {

    /**
     * 聚合根字段ID
     */
    @TableId
    private String aggregateFieldId;

    /**
     * 领域ID
     */
    private String domainId;

    /**
     * 聚合根字段名称
     */
    private String name;

    /**
     * 聚合根字段类型
     */
    private AggregateFieldTypeEnum type;

    /**
     * 聚合根字段类型对象名称
     */
    private String typeObjectName;

    /**
     * 聚合根字段描述
     */
    private String description;

    /**
     * 聚合根字段是否必填
     */
    private Boolean isRequired;

    /**
     * 聚合根字段顺序
     */
    private Integer fieldOrder;

    /**
     * 创建者ID
     */
    private String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createAt;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long modifyAt;

    /**
     * 删除时间
     */
    private Long removeAt;

    public static AggregateFieldRecord from(AggregateFieldEntity entity, String domainId) {
        return AggregateFieldRecord.builder()
                .aggregateFieldId(entity.getAggregateFieldId())
                .domainId(domainId)
                .name(entity.getName())
                .type(entity.getType())
                .typeObjectName(entity.getTypeObjectName())
                .description(entity.getDescription())
                .isRequired(entity.getIsRequired())
                .fieldOrder(entity.getFieldOrder())
                .createUserId(entity.getCreateUserId())
                .modifyUserId(entity.getModifyUserId())
                .isRemoved(entity.getIsRemoved())
                .build()
                .validate();
    }

    protected AggregateFieldEntity to() {
        validate();
        return AggregateFieldEntity.builder()
                .aggregateFieldId(aggregateFieldId)
                .name(name)
                .type(type)
                .typeObjectName(typeObjectName)
                .description(description)
                .isRequired(isRequired)
                .fieldOrder(fieldOrder)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public AggregateFieldRecord validate() {
        validateAggregateFieldId();
        validateDomainId();
        validateName();
        validateType();
        validateDescription();
        validateIsRequired();
        validateFieldOrder();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateAggregateFieldId() {
        if (!StringUtils.hasText(aggregateFieldId)) {
            throw new DataRecordValidateException("聚合根字段ID不能为空");
        }
    }

    private void validateDomainId() {
        if (!StringUtils.hasText(domainId)) {
            throw new DataRecordValidateException("领域ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new DataRecordValidateException("聚合根字段名称不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new DataRecordValidateException("聚合根字段类型不能为 null ");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new DataRecordValidateException("聚合根字段描述不能为空");
        }
    }

    private void validateIsRequired() {
        if (isRequired == null) {
            throw new DataRecordValidateException("聚合根字段是否必填不能为 null ");
        }
    }

    private void validateFieldOrder() {
        if (fieldOrder == null || fieldOrder < 0) {
            throw new DataRecordValidateException("聚合根字段顺序不能为 null 或小于 0，当前值为: " + fieldOrder);
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DataRecordValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new DataRecordValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new DataRecordValidateException("是否已删除不能为 null ");
        }
    }
}

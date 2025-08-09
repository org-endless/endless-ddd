package org.endless.ddd.generator.components.generator.domain.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorEntity;
import org.endless.ddd.generator.components.generator.domain.domain.type.AggregateFieldTypeEnum;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.EntityRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.EntityValidateException;
import org.springframework.util.StringUtils;

/**
 * AggregateFieldEntity
 * <p>聚合根字段实体
 * <p>
 * create 2025/08/07 16:57
 * <p>
 * update 2025/08/07 16:57
 *
 * @author Deng Haozhi
 * @see DDDGeneratorEntity
 * @since 1.0.0
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class AggregateFieldEntity implements DDDGeneratorEntity {

    /**
     * 聚合根字段ID
     */
    private final String aggregateFieldId;

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
    private final String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    public static AggregateFieldEntity create(AggregateFieldEntityBuilder builder) {
        return builder
                .aggregateFieldId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    protected AggregateFieldEntity remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new EntityRemoveException("已经被删除的实体<聚合根字段实体>不能再次删除, ID: " + aggregateFieldId);
        }
        if (!canRemove()) {
            throw new EntityRemoveException("实体<聚合根字段实体>处于不可删除状态, ID: " + aggregateFieldId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public AggregateFieldEntity validate() {
        validateAggregateFieldId();
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
            throw new EntityValidateException("聚合根字段ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new EntityValidateException("聚合根字段名称不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new EntityValidateException("聚合根字段类型不能为 null ");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new EntityValidateException("聚合根字段描述不能为空");
        }
    }

    private void validateIsRequired() {
        if (isRequired == null) {
            throw new EntityValidateException("聚合根字段是否必填不能为 null ");
        }
    }

    private void validateFieldOrder() {
        if (fieldOrder == null || fieldOrder < 0) {
            throw new EntityValidateException("聚合根字段顺序不能为 null 或小于 0，当前值为: " + fieldOrder);
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new EntityValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new EntityValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new EntityValidateException("是否已删除不能为 null ");
        }
    }
}

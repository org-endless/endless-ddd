package org.endless.ddd.generator.components.generator.domain.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorAggregate;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.AggregateAddItemException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.AggregateRemoveItemException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.AggregateValidateException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * DomainAggregate
 * <p>领域聚合根
 * <p>
 * create 2025/08/07 16:48
 * <p>
 * update 2025/08/07 16:48
 *
 * @author Deng Haozhi
 * @see DDDGeneratorAggregate
 * @since 1.0.0
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class DomainAggregate implements DDDGeneratorAggregate {

    /**
     * 领域ID
     */
    private final String domainId;

    /**
     * 限界上下文ID
     */
    private String contextId;

    /**
     * 领域名称
     */
    private String name;

    /**
     * 领域描述
     */
    private String description;

    /**
     * 领域版本
     */
    private String version;

    /**
     * 领域作者
     */
    private String author;

    /**
     * 聚合根字段列表
     */
    private final List<AggregateFieldEntity> fields;

    /**
     * 领域创建时间
     */
    private Long createAt;

    /**
     * 领域修改时间
     */
    private Long modifyAt;

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

    public static DomainAggregate create(DomainAggregateBuilder builder) {
        return builder
                .domainId(IdGenerator.of())
                .fields(builder.fields == null ? new ArrayList<>() : new ArrayList<>(builder.fields))
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public DomainAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<领域聚合根>不能再次删除, ID: " + domainId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<领域聚合根>处于不可删除状态, ID: " + domainId);
        }
        this.fields.forEach(fields -> fields.remove(modifyUserId));
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    public DomainAggregate addField(AggregateFieldEntity field, String modifyUserId) {
        if (field == null) {
            throw new AggregateAddItemException("聚合根要添加的子实体 AggregateFieldEntity 不能为 null");
        }
        this.fields.add(field);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public DomainAggregate addFields(List<AggregateFieldEntity> fields, String modifyUserId) {
        if (CollectionUtils.isEmpty(fields)) {
            throw new AggregateAddItemException("聚合根要添加的子实体列表 List<AggregateFieldEntity> 不能为空");
        }
        this.fields.addAll(fields);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public DomainAggregate removeField(AggregateFieldEntity field, String modifyUserId) {
        if (field == null) {
            throw new AggregateRemoveItemException("聚合根要删除的子实体 AggregateFieldEntity 不能为 null");
        }
        this.fields.stream()
                .filter(exist -> exist.getAggregateFieldId().equals(field.getAggregateFieldId()))
                .findFirst()
                .orElseThrow(() -> new AggregateRemoveItemException("未找到要删除的子实体 AggregateFieldEntity ID: " + field.getAggregateFieldId()))
                .remove(modifyUserId);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public DomainAggregate removeFields(List<AggregateFieldEntity> fields, String modifyUserId) {
        if (CollectionUtils.isEmpty(fields)) {
            throw new AggregateRemoveItemException("聚合根要删除的子实体列表 List<AggregateFieldEntity> 不能为空");
        }
        Set<String> existIds = this.fields.stream()
                .map(AggregateFieldEntity::getAggregateFieldId)
                .collect(Collectors.toSet());
        fields.forEach(remove -> {
            if (!existIds.contains(remove.getAggregateFieldId())) {
                throw new AggregateRemoveItemException("要删除的子实体列表 List<AggregateFieldEntity> 中包含不存在的子实体 ID: " + remove.getAggregateFieldId());
            }
            this.fields.stream()
                    .filter(exist -> exist.getAggregateFieldId().equals(remove.getAggregateFieldId()))
                    .findFirst()
                    .ifPresent(field -> field.remove(modifyUserId));
        });
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public DomainAggregate validate() {
        validateDomainId();
        validateContextId();
        validateName();
        validateDescription();
        validateVersion();
        validateAuthor();
        validateFields();
        validateCreateAt();
        validateModifyAt();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateDomainId() {
        if (!StringUtils.hasText(domainId)) {
            throw new AggregateValidateException("领域ID不能为空");
        }
    }

    private void validateContextId() {
        if (!StringUtils.hasText(contextId)) {
            throw new AggregateValidateException("限界上下文ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new AggregateValidateException("领域名称不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new AggregateValidateException("领域描述不能为空");
        }
    }

    private void validateVersion() {
        if (!StringUtils.hasText(version)) {
            throw new AggregateValidateException("领域版本不能为空");
        }
    }

    private void validateAuthor() {
        if (!StringUtils.hasText(author)) {
            throw new AggregateValidateException("领域作者不能为空");
        }
    }

    private void validateFields() {
        if (CollectionUtils.isEmpty(fields)) {
            throw new AggregateValidateException("聚合根字段列表不能为空");
        }
    }

    private void validateCreateAt() {
        if (createAt == null || createAt < 0) {
            throw new AggregateValidateException("领域创建时间不能为 null 或小于 0，当前值为: " + createAt);
        }
    }

    private void validateModifyAt() {
        if (modifyAt == null || modifyAt < 0) {
            throw new AggregateValidateException("领域修改时间不能为 null 或小于 0，当前值为: " + modifyAt);
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new AggregateValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new AggregateValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new AggregateValidateException("是否已删除不能为 null ");
        }
    }
}

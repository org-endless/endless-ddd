package org.endless.ddd.generator.components.generator.domain.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.generator.common.model.infrastructure.data.record.DDDGeneratorRecord;
import org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordAddItemException;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DomainRecord
 * <p>领域数据库记录实体
 * <p>
 * create 2025/08/07 16:48
 * <p>
 * update 2025/08/07 16:48
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
@TableName(value = "generator_domain")
public class DomainRecord implements DDDGeneratorRecord<DomainAggregate> {

    /**
     * 领域ID
     */
    @TableId
    private String domainId;

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
    @TableField(exist = false)
    @Builder.Default
    private final List<AggregateFieldRecord> fields = new ArrayList<>();

    /**
     * 领域创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createAt;

    /**
     * 领域修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long modifyAt;

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
     * 删除时间
     */
    private Long removeAt;

    public static DomainRecord from(DomainAggregate aggregate) {
        String domainId = aggregate.getDomainId();
        return DomainRecord.builder()
                .domainId(domainId)
                .contextId(aggregate.getContextId())
                .name(aggregate.getName())
                .description(aggregate.getDescription())
                .version(aggregate.getVersion())
                .author(aggregate.getAuthor())
                .fields(aggregate.getFields() == null ? new ArrayList<>() : aggregate.getFields().stream()
                        .map(record -> AggregateFieldRecord.from(record, domainId)).collect(Collectors.toList()))
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public DomainAggregate to() {
        validate();
        return DomainAggregate.builder()
                .domainId(domainId)
                .contextId(contextId)
                .name(name)
                .description(description)
                .version(version)
                .author(author)
                .fields(fields == null ? new ArrayList<>() : fields.stream()
                        .map(AggregateFieldRecord::to).collect(Collectors.toList()))
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    public DomainRecord addField(AggregateFieldRecord field) {
        if (field == null) {
            throw new DataRecordAddItemException("数据库实体要添加的子实体 AggregateFieldRecord 不能为 null");
        }
        this.fields.add(field);
        return this;
    }

    public DomainRecord addFields(List<AggregateFieldRecord> fields) {
        if (CollectionUtils.isEmpty(fields)) {
            throw new DataRecordAddItemException("数据库实体要添加的子实体列表 List<AggregateFieldRecord> 不能为空");
        }
        this.fields.addAll(fields);
        return this;
    }

    @Override
    public DomainRecord validate() {
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
            throw new DataRecordValidateException("领域ID不能为空");
        }
    }

    private void validateContextId() {
        if (!StringUtils.hasText(contextId)) {
            throw new DataRecordValidateException("限界上下文ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new DataRecordValidateException("领域名称不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new DataRecordValidateException("领域描述不能为空");
        }
    }

    private void validateVersion() {
        if (!StringUtils.hasText(version)) {
            throw new DataRecordValidateException("领域版本不能为空");
        }
    }

    private void validateAuthor() {
        if (!StringUtils.hasText(author)) {
            throw new DataRecordValidateException("领域作者不能为空");
        }
    }

    private void validateFields() {
        if (CollectionUtils.isEmpty(fields)) {
            throw new DataRecordValidateException("聚合根字段列表不能为空");
        }
    }

    private void validateCreateAt() {
        if (createAt == null || createAt < 0) {
            throw new DataRecordValidateException("领域创建时间不能为 null 或小于 0，当前值为: " + createAt);
        }
    }

    private void validateModifyAt() {
        if (modifyAt == null || modifyAt < 0) {
            throw new DataRecordValidateException("领域修改时间不能为 null 或小于 0，当前值为: " + modifyAt);
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

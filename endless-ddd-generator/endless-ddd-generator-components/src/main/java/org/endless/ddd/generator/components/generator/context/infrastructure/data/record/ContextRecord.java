package org.endless.ddd.generator.components.generator.context.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.generator.common.model.infrastructure.data.record.DDDGeneratorRecord;
import org.endless.ddd.generator.components.generator.context.domain.entity.ContextAggregate;
import org.endless.ddd.generator.components.generator.context.domain.type.ContextTypeEnum;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.springframework.util.StringUtils;

/**
 * ContextRecord
 * <p>限界上下文数据库记录实体
 * <p>
 * create 2025/08/07 16:42
 * <p>
 * update 2025/08/07 16:42
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
@TableName(value = "generator_context")
public class ContextRecord implements DDDGeneratorRecord<ContextAggregate> {

    /**
     * 限界上下文ID
     */
    @TableId
    private String contextId;

    /**
     * 服务ID
     */
    private String serviceId;

    /**
     * 限界上下文名称
     */
    private String name;

    /**
     * 限界上下文描述
     */
    private String description;

    /**
     * 限界上下文版本
     */
    private String version;

    /**
     * 限界上下文作者
     */
    private String author;

    /**
     * 限界上下文根路径
     */
    private String rootPath;

    /**
     * 限界上下文基础包名
     */
    private String basePackage;

    /**
     * 限界上下文类型
     */
    private ContextTypeEnum type;

    /**
     * 限界上下文创建时间
     */
    private Long createAt;

    /**
     * 限界上下文修改时间
     */
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

    public static ContextRecord from(ContextAggregate aggregate) {
        String contextId = aggregate.getContextId();
        return ContextRecord.builder()
                .contextId(contextId)
                .serviceId(aggregate.getServiceId())
                .name(aggregate.getName())
                .description(aggregate.getDescription())
                .version(aggregate.getVersion())
                .author(aggregate.getAuthor())
                .rootPath(aggregate.getRootPath())
                .basePackage(aggregate.getBasePackage())
                .type(aggregate.getType())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public ContextAggregate to() {
        validate();
        return ContextAggregate.builder()
                .contextId(contextId)
                .serviceId(serviceId)
                .name(name)
                .description(description)
                .version(version)
                .author(author)
                .rootPath(rootPath)
                .basePackage(basePackage)
                .type(type)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public ContextRecord validate() {
        validateContextId();
        validateServiceId();
        validateName();
        validateDescription();
        validateVersion();
        validateAuthor();
        validateRootPath();
        validateBasePackage();
        validateType();
        validateCreateAt();
        validateModifyAt();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateContextId() {
        if (!StringUtils.hasText(contextId)) {
            throw new DataRecordValidateException("限界上下文ID不能为空");
        }
    }

    private void validateServiceId() {
        if (!StringUtils.hasText(serviceId)) {
            throw new DataRecordValidateException("服务ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new DataRecordValidateException("限界上下文名称不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new DataRecordValidateException("限界上下文描述不能为空");
        }
    }

    private void validateVersion() {
        if (!StringUtils.hasText(version)) {
            throw new DataRecordValidateException("限界上下文版本不能为空");
        }
    }

    private void validateAuthor() {
        if (!StringUtils.hasText(author)) {
            throw new DataRecordValidateException("限界上下文作者不能为空");
        }
    }

    private void validateRootPath() {
        if (!StringUtils.hasText(rootPath)) {
            throw new DataRecordValidateException("限界上下文根路径不能为空");
        }
    }

    private void validateBasePackage() {
        if (!StringUtils.hasText(basePackage)) {
            throw new DataRecordValidateException("限界上下文基础包名不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new DataRecordValidateException("限界上下文类型不能为 null ");
        }
    }

    private void validateCreateAt() {
        if (createAt == null || createAt < 0) {
            throw new DataRecordValidateException("限界上下文创建时间不能为 null 或小于 0，当前值为: " + createAt);
        }
    }

    private void validateModifyAt() {
        if (modifyAt == null || modifyAt < 0) {
            throw new DataRecordValidateException("限界上下文修改时间不能为 null 或小于 0，当前值为: " + modifyAt);
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

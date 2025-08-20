package org.endless.ddd.generator.components.generator.context.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorAggregate;
import org.endless.ddd.generator.components.generator.context.domain.type.ContextTypeEnum;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.ddd.starter.common.utils.model.time.TimestampTools;
import org.springframework.util.StringUtils;

/**
 * ContextAggregate
 * <p>限界上下文聚合根
 * <p>
 * create 2025/08/07 16:42
 * <p>
 * update 2025/08/07 16:42
 *
 * @author Deng Haozhi
 * @see DDDGeneratorAggregate
 * @since 1.0.0
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class ContextAggregate implements DDDGeneratorAggregate {

    /**
     * 限界上下文ID
     */
    private final String contextId;

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
    private final String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    public static ContextAggregate create(ContextAggregateBuilder builder) {
        Long now = TimestampTools.now();
        return builder
                .contextId(IdGenerator.of())
                .createAt(now)
                .modifyAt(now)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public ContextAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<限界上下文聚合根>不能再次删除, ID: " + contextId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<限界上下文聚合根>处于不可删除状态, ID: " + contextId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    public ContextAggregate modify(ContextAggregateBuilder builder) {
        this.serviceId = builder.serviceId == null ? this.serviceId : builder.serviceId;
        this.name = builder.name == null ? this.name : builder.name;
        this.description = builder.description == null ? this.description : builder.description;
        this.version = builder.version == null ? this.version : builder.version;
        this.author = builder.author == null ? this.author : builder.author;
        this.rootPath = builder.rootPath == null ? this.rootPath : builder.rootPath;
        this.basePackage = builder.basePackage == null ? this.basePackage : builder.basePackage;
        this.type = builder.type == null ? this.type : builder.type;
        this.modifyAt = TimestampTools.now();
        this.modifyUserId = builder.modifyUserId;
        return this.validate();
    }

    @Override
    public ContextAggregate validate() {
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

    private boolean canRemove() {
        return true;
    }

    private void validateContextId() {
        if (!StringUtils.hasText(contextId)) {
            throw new AggregateValidateException("限界上下文ID不能为空");
        }
    }

    private void validateServiceId() {
        if (!StringUtils.hasText(serviceId)) {
            throw new AggregateValidateException("服务ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new AggregateValidateException("限界上下文名称不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new AggregateValidateException("限界上下文描述不能为空");
        }
    }

    private void validateVersion() {
        if (!StringUtils.hasText(version)) {
            throw new AggregateValidateException("限界上下文版本不能为空");
        }
    }

    private void validateAuthor() {
        if (!StringUtils.hasText(author)) {
            throw new AggregateValidateException("限界上下文作者不能为空");
        }
    }

    private void validateRootPath() {
        if (!StringUtils.hasText(rootPath)) {
            throw new AggregateValidateException("限界上下文根路径不能为空");
        }
    }

    private void validateBasePackage() {
        if (!StringUtils.hasText(basePackage)) {
            throw new AggregateValidateException("限界上下文基础包名不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new AggregateValidateException("限界上下文类型不能为 null ");
        }
    }

    private void validateCreateAt() {
        if (createAt == null || createAt < 0) {
            throw new AggregateValidateException("限界上下文创建时间不能为 null 或小于 0，当前值为: " + createAt);
        }
    }

    private void validateModifyAt() {
        if (modifyAt == null || modifyAt < 0) {
            throw new AggregateValidateException("限界上下文修改时间不能为 null 或小于 0，当前值为: " + modifyAt);
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

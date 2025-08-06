package org.endless.ddd.generator.components.generator.service.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorAggregate;
import org.endless.ddd.generator.components.generator.service.domain.type.ServiceTypeEnum;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.model.domain.entity.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.model.domain.entity.AggregateValidateException;
import org.endless.ddd.starter.common.utils.model.time.TimeStamp;
import org.springframework.util.StringUtils;

/**
 * ServiceAggregate
 * <p>服务聚合根
 * <p>
 * create 2025/08/05 22:32
 * <p>
 * update 2025/08/05 22:32
 *
 * @author Deng Haozhi
 * @see DDDGeneratorAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class ServiceAggregate implements DDDGeneratorAggregate {

    /**
     * 服务ID
     */
    private final String serviceId;

    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 服务构件ID
     */
    private String serviceArtifactId;

    /**
     * 服务组织ID
     */
    private String groupId;

    /**
     * 服务名称
     */
    private String name;

    /**
     * 服务描述
     */
    private String description;

    /**
     * 服务版本号
     */
    private String version;

    /**
     * 服务作者
     */
    private String author;

    /**
     * 服务根路径
     */
    private String rootPath;

    /**
     * 服务基础包名
     */
    private String basePackage;

    /**
     * 服务类名前缀
     */
    private String classNamePrefix;

    /**
     * 服务类型
     */
    private ServiceTypeEnum type;

    /**
     * 服务端口
     */
    private Integer port;

    /**
     * 服务创建时间
     */
    private Long createAt;

    /**
     * 服务更新时间
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

    public static ServiceAggregate create(ServiceAggregateBuilder builder) {
        Long now = TimeStamp.now();
        return builder
                .serviceId(IdGenerator.of())
                .createAt(now)
                .modifyAt(now)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public ServiceAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<服务聚合根>不能再次删除, ID: " + serviceId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<服务聚合根>处于不可删除状态, ID: " + serviceId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    public ServiceAggregate modify(ServiceAggregateBuilder builder) {
        this.projectId = builder.projectId == null ? this.projectId : builder.projectId;
        this.serviceArtifactId = builder.serviceArtifactId == null ? this.serviceArtifactId : builder.serviceArtifactId;
        this.groupId = builder.groupId == null ? this.groupId : builder.groupId;
        this.name = builder.name == null ? this.name : builder.name;
        this.description = builder.description == null ? this.description : builder.description;
        this.version = builder.version == null ? this.version : builder.version;
        this.author = builder.author == null ? this.author : builder.author;
        this.rootPath = builder.rootPath == null ? this.rootPath : builder.rootPath;
        this.basePackage = builder.basePackage == null ? this.basePackage : builder.basePackage;
        this.classNamePrefix = builder.classNamePrefix == null ? this.classNamePrefix : builder.classNamePrefix;
        this.type = builder.type == null ? this.type : builder.type;
        this.port = builder.port == null ? this.port : builder.port;
        this.modifyAt = TimeStamp.now();
        this.modifyUserId = builder.modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public ServiceAggregate validate() {
        validateServiceId();
        validateProjectId();
        validateServiceArtifactId();
        validateGroupId();
        validateName();
        validateDescription();
        validateVersion();
        validateAuthor();
        validateRootPath();
        validateBasePackage();
        validateClassNamePrefix();
        validateType();
        validatePort();
        validateCreateAt();
        validateModifyAt();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateServiceId() {
        if (!StringUtils.hasText(serviceId)) {
            throw new AggregateValidateException("服务ID不能为空");
        }
    }

    private void validateProjectId() {
        if (!StringUtils.hasText(projectId)) {
            throw new AggregateValidateException("项目ID不能为空");
        }
    }

    private void validateServiceArtifactId() {
        if (!StringUtils.hasText(serviceArtifactId)) {
            throw new AggregateValidateException("服务构件ID不能为空");
        }
    }

    private void validateGroupId() {
        if (!StringUtils.hasText(groupId)) {
            throw new AggregateValidateException("服务组织ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new AggregateValidateException("服务名称不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new AggregateValidateException("服务描述不能为空");
        }
    }

    private void validateVersion() {
        if (!StringUtils.hasText(version)) {
            throw new AggregateValidateException("服务版本号不能为空");
        }
    }

    private void validateAuthor() {
        if (!StringUtils.hasText(author)) {
            throw new AggregateValidateException("服务作者不能为空");
        }
    }

    private void validateRootPath() {
        if (!StringUtils.hasText(rootPath)) {
            throw new AggregateValidateException("服务根路径不能为空");
        }
    }

    private void validateBasePackage() {
        if (!StringUtils.hasText(basePackage)) {
            throw new AggregateValidateException("服务基础包名不能为空");
        }
    }

    private void validateClassNamePrefix() {
        if (!StringUtils.hasText(classNamePrefix)) {
            throw new AggregateValidateException("服务类名前缀不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new AggregateValidateException("服务类型不能为 null ");
        }
    }

    private void validatePort() {
        if (port == null || port < 0) {
            throw new AggregateValidateException("服务端口不能为 null 或小于 0，当前值为: " + port);
        }
    }

    private void validateCreateAt() {
        if (createAt == null || createAt < 0) {
            throw new AggregateValidateException("服务创建时间不能为 null 或小于 0，当前值为: " + createAt);
        }
    }

    private void validateModifyAt() {
        if (modifyAt == null || modifyAt < 0) {
            throw new AggregateValidateException("服务更新时间不能为 null 或小于 0，当前值为: " + modifyAt);
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

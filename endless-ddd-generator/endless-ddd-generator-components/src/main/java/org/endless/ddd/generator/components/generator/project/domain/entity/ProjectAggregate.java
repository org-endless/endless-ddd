package org.endless.ddd.generator.components.generator.project.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorAggregate;
import org.endless.ddd.generator.components.generator.project.domain.type.ProjectDatabaseTypeEnum;
import org.endless.ddd.generator.components.generator.project.domain.type.ProjectJavaVersionEnum;
import org.endless.ddd.generator.components.generator.project.domain.type.ProjectLoggingFrameworkEnum;
import org.endless.ddd.generator.components.generator.project.domain.type.ProjectPersistenceFrameworkEnum;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.ddd.starter.common.utils.model.time.TimeStampTools;
import org.springframework.util.StringUtils;

/**
 * ProjectAggregate
 * <p>项目聚合根
 * <p>
 * create 2025/08/05 21:18
 * <p>
 * update 2025/08/05 21:18
 *
 * @author Deng Haozhi
 * @see DDDGeneratorAggregate
 * @since 1.0.0
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class ProjectAggregate implements DDDGeneratorAggregate {

    /**
     * 项目ID
     */
    private final String projectId;

    /**
     * 项目构件ID
     */
    private String projectArtifactId;

    /**
     * 项目组织ID
     */
    private String groupId;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目描述
     */
    private String description;

    /**
     * 项目版本号
     */
    private String version;

    /**
     * 项目作者
     */
    private String author;

    /**
     * 项目根路径
     */
    private String rootPath;

    /**
     * 项目基础包名
     */
    private String basePackage;

    /**
     * 是否启用Spring Doc
     */
    private Boolean enableSpringDoc;

    /**
     * 项目Java版本
     */
    private ProjectJavaVersionEnum javaVersion;

    /**
     * 项目日志框架
     */
    private ProjectLoggingFrameworkEnum loggingFramework;

    /**
     * 项目持久化框架
     */
    private ProjectPersistenceFrameworkEnum persistenceFramework;

    /**
     * 项目数据库类型
     */
    private ProjectDatabaseTypeEnum databaseType;

    /**
     * 项目创建时间
     */
    private final Long createAt;

    /**
     * 项目修改时间
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

    public static ProjectAggregate create(ProjectAggregateBuilder builder) {
        Long now = TimeStampTools.now();
        return builder
                .projectId(IdGenerator.of())
                .createAt(now)
                .modifyAt(now)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public ProjectAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<项目聚合根>不能再次删除, ID: " + projectId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<项目聚合根>处于不可删除状态, ID: " + projectId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    public ProjectAggregate modify(ProjectAggregateBuilder builder) {
        this.projectArtifactId = builder.projectArtifactId == null ? this.projectArtifactId : builder.projectArtifactId;
        this.groupId = builder.groupId == null ? this.groupId : builder.groupId;
        this.name = builder.name == null ? this.name : builder.name;
        this.description = builder.description == null ? this.description : builder.description;
        this.version = builder.version == null ? this.version : builder.version;
        this.author = builder.author == null ? this.author : builder.author;
        this.rootPath = builder.rootPath == null ? this.rootPath : builder.rootPath;
        this.basePackage = builder.basePackage == null ? this.basePackage : builder.basePackage;
        this.enableSpringDoc = builder.enableSpringDoc == null ? this.enableSpringDoc : builder.enableSpringDoc;
        this.javaVersion = builder.javaVersion == null ? this.javaVersion : builder.javaVersion;
        this.loggingFramework = builder.loggingFramework == null ? this.loggingFramework : builder.loggingFramework;
        this.persistenceFramework = builder.persistenceFramework == null ? this.persistenceFramework : builder.persistenceFramework;
        this.databaseType = builder.databaseType == null ? this.databaseType : builder.databaseType;
        this.modifyAt = TimeStampTools.now();
        this.modifyUserId = builder.modifyUserId;
        return this.validate();
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public ProjectAggregate validate() {
        validateProjectId();
        validateProjectArtifactId();
        validateGroupId();
        validateName();
        validateDescription();
        validateVersion();
        validateAuthor();
        validateRootPath();
        validateBasePackage();
        validateEnableSpringDoc();
        validateJavaVersion();
        validateLoggingFramework();
        validatePersistenceFramework();
        validateDatabaseType();
        validateCreateAt();
        validateModifyAt();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateProjectId() {
        if (!StringUtils.hasText(projectId)) {
            throw new AggregateValidateException("项目ID不能为空");
        }
    }

    private void validateProjectArtifactId() {
        if (!StringUtils.hasText(projectArtifactId)) {
            throw new AggregateValidateException("项目构件ID不能为空");
        }
    }

    private void validateGroupId() {
        if (!StringUtils.hasText(groupId)) {
            throw new AggregateValidateException("项目组织ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new AggregateValidateException("项目名称不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new AggregateValidateException("项目描述不能为空");
        }
    }

    private void validateVersion() {
        if (!StringUtils.hasText(version)) {
            throw new AggregateValidateException("项目版本号不能为空");
        }
    }

    private void validateAuthor() {
        if (!StringUtils.hasText(author)) {
            throw new AggregateValidateException("项目作者不能为空");
        }
    }

    private void validateRootPath() {
        if (!StringUtils.hasText(rootPath)) {
            throw new AggregateValidateException("项目根路径不能为空");
        }
    }

    private void validateBasePackage() {
        if (!StringUtils.hasText(basePackage)) {
            throw new AggregateValidateException("项目基础包名不能为空");
        }
    }

    private void validateEnableSpringDoc() {
        if (enableSpringDoc == null) {
            throw new AggregateValidateException("是否启用Spring Doc不能为 null ");
        }
    }

    private void validateJavaVersion() {
        if (javaVersion == null) {
            throw new AggregateValidateException("项目Java版本不能为 null ");
        }
    }

    private void validateLoggingFramework() {
        if (loggingFramework == null) {
            throw new AggregateValidateException("项目日志框架不能为 null ");
        }
    }

    private void validatePersistenceFramework() {
        if (persistenceFramework == null) {
            throw new AggregateValidateException("项目持久化框架不能为 null ");
        }
    }

    private void validateDatabaseType() {
        if (databaseType == null) {
            throw new AggregateValidateException("项目数据库类型不能为 null ");
        }
    }

    private void validateCreateAt() {
        if (createAt == null || createAt < 0) {
            throw new AggregateValidateException("项目创建时间不能为 null 或小于 0，当前值为: " + createAt);
        }
    }

    private void validateModifyAt() {
        if (modifyAt == null || modifyAt < 0) {
            throw new AggregateValidateException("项目修改时间不能为 null 或小于 0，当前值为: " + modifyAt);
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

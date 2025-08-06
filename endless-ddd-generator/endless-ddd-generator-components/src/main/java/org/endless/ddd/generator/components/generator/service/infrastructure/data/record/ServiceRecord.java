package org.endless.ddd.generator.components.generator.service.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.generator.common.model.infrastructure.data.record.DDDGeneratorRecord;
import org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate;
import org.endless.ddd.generator.components.generator.service.domain.type.ServiceTypeEnum;
import org.endless.ddd.starter.common.exception.model.infrastructure.data.record.DataRecordValidateException;
import org.springframework.util.StringUtils;

/**
 * ServiceRecord
 * <p>服务数据库记录实体
 * <p>
 * create 2025/08/05 22:32
 * <p>
 * update 2025/08/05 22:32
 *
 * @author Deng Haozhi
 * @see DDDGeneratorRecord
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "generator_service")
public class ServiceRecord implements DDDGeneratorRecord<ServiceAggregate> {

    /**
     * 服务ID
     */
    @TableId
    private String serviceId;

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
     * 服务修改时间
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

    public static ServiceRecord from(ServiceAggregate aggregate) {
        String serviceId = aggregate.getServiceId();
        return ServiceRecord.builder()
                .serviceId(serviceId)
                .projectId(aggregate.getProjectId())
                .serviceArtifactId(aggregate.getServiceArtifactId())
                .groupId(aggregate.getGroupId())
                .name(aggregate.getName())
                .description(aggregate.getDescription())
                .author(aggregate.getAuthor())
                .rootPath(aggregate.getRootPath())
                .basePackage(aggregate.getBasePackage())
                .classNamePrefix(aggregate.getClassNamePrefix())
                .type(aggregate.getType())
                .port(aggregate.getPort())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public ServiceAggregate to() {
        validate();
        return ServiceAggregate.builder()
                .serviceId(serviceId)
                .projectId(projectId)
                .serviceArtifactId(serviceArtifactId)
                .groupId(groupId)
                .name(name)
                .description(description)
                .author(author)
                .rootPath(rootPath)
                .basePackage(basePackage)
                .classNamePrefix(classNamePrefix)
                .type(type)
                .port(port)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public ServiceRecord validate() {
        validateServiceId();
        validateProjectId();
        validateServiceArtifactId();
        validateGroupId();
        validateName();
        validateDescription();
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
            throw new DataRecordValidateException("服务ID不能为空");
        }
    }

    private void validateProjectId() {
        if (!StringUtils.hasText(projectId)) {
            throw new DataRecordValidateException("项目ID不能为空");
        }
    }

    private void validateServiceArtifactId() {
        if (!StringUtils.hasText(serviceArtifactId)) {
            throw new DataRecordValidateException("服务构件ID不能为空");
        }
    }

    private void validateGroupId() {
        if (!StringUtils.hasText(groupId)) {
            throw new DataRecordValidateException("服务组织ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new DataRecordValidateException("服务名称不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new DataRecordValidateException("服务描述不能为空");
        }
    }

    private void validateAuthor() {
        if (!StringUtils.hasText(author)) {
            throw new DataRecordValidateException("服务作者不能为空");
        }
    }

    private void validateRootPath() {
        if (!StringUtils.hasText(rootPath)) {
            throw new DataRecordValidateException("服务根路径不能为空");
        }
    }

    private void validateBasePackage() {
        if (!StringUtils.hasText(basePackage)) {
            throw new DataRecordValidateException("服务基础包名不能为空");
        }
    }

    private void validateClassNamePrefix() {
        if (!StringUtils.hasText(classNamePrefix)) {
            throw new DataRecordValidateException("服务类名前缀不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new DataRecordValidateException("服务类型不能为 null ");
        }
    }

    private void validatePort() {
        if (port == null || port < 0) {
            throw new DataRecordValidateException("服务端口不能为 null 或小于 0，当前值为: " + port);
        }
    }

    private void validateCreateAt() {
        if (createAt == null || createAt < 0) {
            throw new DataRecordValidateException("服务创建时间不能为 null 或小于 0，当前值为: " + createAt);
        }
    }

    private void validateModifyAt() {
        if (modifyAt == null || modifyAt < 0) {
            throw new DataRecordValidateException("服务修改时间不能为 null 或小于 0，当前值为: " + modifyAt);
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

package org.endless.ddd.generator.components.generator.project.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorReqCommandTransfer;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ProjectCreateReqCTransferReq
 * <p>项目创建命令请求传输对象
 * <p>
 * create 2025/08/05 21:18
 * <p>
 * update 2025/08/05 21:18
 *
 * @param projectArtifactId    项目构件ID
 * @param groupId              项目组织ID
 * @param name                 项目名称
 * @param description          项目描述
 * @param version              项目版本号
 * @param author               项目作者
 * @param rootPath             项目根路径
 * @param basePackage          项目基础包名
 * @param enableSpringDoc      项目是否启用Spring Doc
 * @param javaVersion          项目Java版本
 * @param loggingFramework     项目日志框架
 * @param persistenceFramework 项目持久化框架
 * @param databaseType         项目数据库类型
 * @author Deng Haozhi
 * @see DDDGeneratorReqCommandTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"projectArtifactId", "groupId", "name", "description", "version", "author", "rootPath", "basePackage", "enableSpringDoc", "javaVersion", "loggingFramework", "persistenceFramework", "databaseType"})
public record ProjectCreateReqCTransferReq(
        String projectArtifactId, String groupId, String name, String description,
        String version, String author, String rootPath, String basePackage,
        Boolean enableSpringDoc, String javaVersion, String loggingFramework,
        String persistenceFramework,
        String databaseType) implements DDDGeneratorReqCommandTransfer {

    @Override
    public ProjectCreateReqCTransferReq validate() {
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
        return this;
    }

    private void validateProjectArtifactId() {
        if (!StringUtils.hasText(projectArtifactId)) {
            throw new CommandReqTransferValidateException("项目构件ID不能为空");
        }
    }

    private void validateGroupId() {
        if (!StringUtils.hasText(groupId)) {
            throw new CommandReqTransferValidateException("项目组织ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new CommandReqTransferValidateException("项目名称不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new CommandReqTransferValidateException("项目描述不能为空");
        }
    }

    private void validateVersion() {
        if (!StringUtils.hasText(version)) {
            throw new CommandReqTransferValidateException("项目版本号不能为空");
        }
    }

    private void validateAuthor() {
        if (!StringUtils.hasText(author)) {
            throw new CommandReqTransferValidateException("项目作者不能为空");
        }
    }

    private void validateRootPath() {
        if (!StringUtils.hasText(rootPath)) {
            throw new CommandReqTransferValidateException("项目根路径不能为空");
        }
    }

    private void validateBasePackage() {
        if (!StringUtils.hasText(basePackage)) {
            throw new CommandReqTransferValidateException("项目基础包名不能为空");
        }
    }

    private void validateEnableSpringDoc() {
        if (enableSpringDoc == null) {
            throw new CommandReqTransferValidateException("项目是否启用Spring Doc不能为 null ");
        }
    }

    private void validateJavaVersion() {
        if (!StringUtils.hasText(javaVersion)) {
            throw new CommandReqTransferValidateException("项目Java版本不能为空");
        }
    }

    private void validateLoggingFramework() {
        if (!StringUtils.hasText(loggingFramework)) {
            throw new CommandReqTransferValidateException("项目日志框架不能为空");
        }
    }

    private void validatePersistenceFramework() {
        if (!StringUtils.hasText(persistenceFramework)) {
            throw new CommandReqTransferValidateException("项目持久化框架不能为空");
        }
    }

    private void validateDatabaseType() {
        if (!StringUtils.hasText(databaseType)) {
            throw new CommandReqTransferValidateException("项目数据库类型不能为空");
        }
    }
}

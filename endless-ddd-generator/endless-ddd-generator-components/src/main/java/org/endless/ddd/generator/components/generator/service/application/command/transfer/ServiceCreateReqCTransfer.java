package org.endless.ddd.generator.components.generator.service.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorCommandTransfer;
import org.endless.ddd.starter.common.exception.model.application.command.transfer.CommandTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ServiceCreateReqCTransfer
 * <p>服务创建命令请求传输对象
 * <p>
 * create 2025/08/06 23:53
 * <p>
 * update 2025/08/06 23:53
 *
 * @param projectId         项目ID
 * @param serviceArtifactId 服务构件ID
 * @param groupId           服务组织ID
 * @param name              服务名称
 * @param description       服务描述
 * @param author            服务作者
 * @param rootPath          服务根路径
 * @param basePackage       服务基础包名
 * @param classNamePrefix   服务类名前缀
 * @param type              服务类型
 * @param port              服务端口
 * @author Deng Haozhi
 * @see DDDGeneratorCommandTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"projectId", "serviceArtifactId", "groupId", "name", "description", "version", "author", "rootPath", "basePackage", "classNamePrefix", "type", "port"})
public record ServiceCreateReqCTransfer(
        String projectId, String serviceArtifactId, String groupId, String name,
        String description, String author, String rootPath,
        String basePackage, String classNamePrefix, String type, Integer port)
        implements DDDGeneratorCommandTransfer {

    @Override
    public ServiceCreateReqCTransfer validate() {
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
        return this;
    }

    private void validateProjectId() {
        if (!StringUtils.hasText(projectId)) {
            throw new CommandTransferValidateException("项目ID不能为空");
        }
    }

    private void validateServiceArtifactId() {
        if (!StringUtils.hasText(serviceArtifactId)) {
            throw new CommandTransferValidateException("服务构件ID不能为空");
        }
    }

    private void validateGroupId() {
        if (!StringUtils.hasText(groupId)) {
            throw new CommandTransferValidateException("服务组织ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new CommandTransferValidateException("服务名称不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new CommandTransferValidateException("服务描述不能为空");
        }
    }

    private void validateAuthor() {
        if (!StringUtils.hasText(author)) {
            throw new CommandTransferValidateException("服务作者不能为空");
        }
    }

    private void validateRootPath() {
        if (!StringUtils.hasText(rootPath)) {
            throw new CommandTransferValidateException("服务根路径不能为空");
        }
    }

    private void validateBasePackage() {
        if (!StringUtils.hasText(basePackage)) {
            throw new CommandTransferValidateException("服务基础包名不能为空");
        }
    }

    private void validateClassNamePrefix() {
        if (!StringUtils.hasText(classNamePrefix)) {
            throw new CommandTransferValidateException("服务类名前缀不能为空");
        }
    }

    private void validateType() {
        if (!StringUtils.hasText(type)) {
            throw new CommandTransferValidateException("服务类型不能为空");
        }
    }

    private void validatePort() {
        if (port == null || port < 0) {
            throw new CommandTransferValidateException("服务端口不能为 null 或小于 0，当前值为: " + port);
        }
    }
}

package org.endless.ddd.generator.components.generator.context.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorCommandTransfer;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ContextCreateReqCTransfer
 * <p>限界上下文创建命令请求传输对象
 * <p>
 * create 2025/08/07 16:42
 * <p>
 * update 2025/08/07 16:42
 *
 * @param serviceId   服务ID
 * @param name        限界上下文名称
 * @param description 限界上下文描述
 * @param version     限界上下文版本
 * @param author      限界上下文作者
 * @param rootPath    限界上下文根路径
 * @param basePackage 限界上下文基础包名
 * @param type        限界上下文类型
 * @author Deng Haozhi
 * @see DDDGeneratorCommandTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"serviceId", "name", "description", "version", "author", "rootPath", "basePackage", "type"})
public record ContextCreateReqCTransfer(
        String serviceId, String name, String description, String version,
        String author, String rootPath, String basePackage, String type)
        implements DDDGeneratorCommandTransfer {

    @Override
    public ContextCreateReqCTransfer validate() {
        validateServiceId();
        validateName();
        validateDescription();
        validateVersion();
        validateAuthor();
        validateRootPath();
        validateBasePackage();
        validateType();
        return this;
    }

    private void validateServiceId() {
        if (!StringUtils.hasText(serviceId)) {
            throw new CommandTransferValidateException("服务ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new CommandTransferValidateException("限界上下文名称不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new CommandTransferValidateException("限界上下文描述不能为空");
        }
    }

    private void validateVersion() {
        if (!StringUtils.hasText(version)) {
            throw new CommandTransferValidateException("限界上下文版本不能为空");
        }
    }

    private void validateAuthor() {
        if (!StringUtils.hasText(author)) {
            throw new CommandTransferValidateException("限界上下文作者不能为空");
        }
    }

    private void validateRootPath() {
        if (!StringUtils.hasText(rootPath)) {
            throw new CommandTransferValidateException("限界上下文根路径不能为空");
        }
    }

    private void validateBasePackage() {
        if (!StringUtils.hasText(basePackage)) {
            throw new CommandTransferValidateException("限界上下文基础包名不能为空");
        }
    }

    private void validateType() {
        if (!StringUtils.hasText(type)) {
            throw new CommandTransferValidateException("限界上下文类型不能为空");
        }
    }
}

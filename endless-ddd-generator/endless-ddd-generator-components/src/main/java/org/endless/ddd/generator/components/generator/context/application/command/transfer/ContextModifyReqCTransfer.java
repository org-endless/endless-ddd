package org.endless.ddd.generator.components.generator.context.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorCommandTransfer;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ContextModifyReqCTransfer
 * <p>限界上下文修改命令请求传输对象
 * <p>
 * create 2025/08/07 16:42
 * <p>
 * update 2025/08/07 16:42
 *
 * @param contextId   限界上下文ID
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
@JSONType(orders = {"contextId", "serviceId", "name", "description", "version", "author", "rootPath", "basePackage", "type"})
public record ContextModifyReqCTransfer(
        String contextId, String serviceId, String name, String description,
        String version, String author, String rootPath, String basePackage, String type)
        implements DDDGeneratorCommandTransfer {

    @Override
    public ContextModifyReqCTransfer validate() {
        validateContextId();
        validateVersion();
        return this;
    }

    private void validateContextId() {
        if (!StringUtils.hasText(contextId)) {
            throw new CommandTransferValidateException("限界上下文ID不能为空");
        }
    }

    private void validateVersion() {
        if (!StringUtils.hasText(version)) {
            throw new CommandTransferValidateException("限界上下文版本不能为空");
        }
    }
}

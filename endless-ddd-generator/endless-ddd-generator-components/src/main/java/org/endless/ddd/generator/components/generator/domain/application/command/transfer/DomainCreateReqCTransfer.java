package org.endless.ddd.generator.components.generator.domain.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorCommandTransfer;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandTransferValidateException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * DomainCreateReqCTransfer
 * <p>领域创建命令请求传输对象
 * <p>
 * create 2025/08/07 16:48
 * <p>
 * update 2025/08/07 16:48
 *
 * @param contextId   限界上下文ID
 * @param name        领域名称
 * @param description 领域描述
 * @param version     领域版本
 * @param author      领域作者
 * @param fields      聚合根字段列表
 * @author Deng Haozhi
 * @see DDDGeneratorCommandTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"contextId", "name", "description", "version", "author", "fields"})
public record DomainCreateReqCTransfer(
        String contextId, String name, String description, String version, String author,
        List<AggregateFieldReqCTransfer> fields) implements DDDGeneratorCommandTransfer {

    @Override
    public DomainCreateReqCTransfer validate() {
        validateContextId();
        validateName();
        validateDescription();
        validateVersion();
        validateAuthor();
        validateFields();
        return this;
    }

    private void validateContextId() {
        if (!StringUtils.hasText(contextId)) {
            throw new CommandTransferValidateException("限界上下文ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new CommandTransferValidateException("领域名称不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new CommandTransferValidateException("领域描述不能为空");
        }
    }

    private void validateVersion() {
        if (!StringUtils.hasText(version)) {
            throw new CommandTransferValidateException("领域版本不能为空");
        }
    }

    private void validateAuthor() {
        if (!StringUtils.hasText(author)) {
            throw new CommandTransferValidateException("领域作者不能为空");
        }
    }

    private void validateFields() {
        if (CollectionUtils.isEmpty(fields)) {
            throw new CommandTransferValidateException("聚合根字段列表不能为空");
        }
    }
}

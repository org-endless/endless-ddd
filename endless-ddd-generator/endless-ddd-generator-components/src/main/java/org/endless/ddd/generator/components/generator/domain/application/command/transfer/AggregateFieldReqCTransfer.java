package org.endless.ddd.generator.components.generator.domain.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorCommandTransfer;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * AggregateFieldReqCTransfer
 * <p>聚合字段命令请求传输对象
 * <p>
 * create 2025/08/07 16:57
 * <p>
 * update 2025/08/07 16:57
 *
 * @param name           聚合根字段名称
 * @param type           聚合根字段类型
 * @param typeObjectName 聚合根字段类型对象名称
 * @param description    聚合根字段描述
 * @param isRequired     聚合根字段是否必填
 * @param fieldOrder     聚合根字段顺序
 * @author Deng Haozhi
 * @see DDDGeneratorCommandTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"name", "type", "typeObjectName", "description", "isRequired", "fieldOrder"})
public record AggregateFieldReqCTransfer(
        String name, String type, String typeObjectName, String description,
        Boolean isRequired, Integer fieldOrder)
        implements DDDGeneratorCommandTransfer {

    @Override
    public AggregateFieldReqCTransfer validate() {
        validateName();
        validateType();
        validateDescription();
        validateIsRequired();
        validateFieldOrder();
        return this;
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new CommandTransferValidateException("聚合根字段名称不能为空");
        }
    }

    private void validateType() {
        if (!StringUtils.hasText(type)) {
            throw new CommandTransferValidateException("聚合根字段类型不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new CommandTransferValidateException("聚合根字段描述不能为空");
        }
    }

    private void validateIsRequired() {
        if (isRequired == null) {
            throw new CommandTransferValidateException("聚合根字段是否必填不能为 null ");
        }
    }

    private void validateFieldOrder() {
        if (fieldOrder == null || fieldOrder < 0) {
            throw new CommandTransferValidateException("聚合根字段顺序不能为 null 或小于 0，当前值为: " + fieldOrder);
        }
    }
}

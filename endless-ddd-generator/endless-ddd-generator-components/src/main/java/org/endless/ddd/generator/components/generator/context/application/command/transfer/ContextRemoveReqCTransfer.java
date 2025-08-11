package org.endless.ddd.generator.components.generator.context.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.generator.common.model.application.command.transfer.DDDGeneratorCommandTransfer;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ContextRemoveReqCTransfer
 * <p>限界上下文删除命令请求传输对象
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @param contextId 限界上下文ID
 * @author Deng Haozhi
 * @see DDDGeneratorCommandTransfer
 * @since 1.0.0
 */
@Builder
@JSONType(orders = {"contextId"})
public record ContextRemoveReqCTransfer(String contextId) implements DDDGeneratorCommandTransfer {

    @Override
    public ContextRemoveReqCTransfer validate() {
        validateContextId();
        return this;
    }

    private void validateContextId() {
        if (!StringUtils.hasText(contextId)) {
            throw new CommandReqTransferValidateException("限界上下文ID不能为空");
        }
    }
}

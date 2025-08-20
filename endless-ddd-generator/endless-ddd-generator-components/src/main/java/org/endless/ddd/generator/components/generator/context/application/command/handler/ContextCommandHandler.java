package org.endless.ddd.generator.components.generator.context.application.command.handler;

import org.endless.ddd.generator.common.model.application.command.handler.DDDGeneratorCommandHandler;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextCreateReqCTransferReq;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextModifyReqCTransferReq;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextRemoveReqCTransferReq;
import org.endless.ddd.generator.components.generator.context.domain.entity.ContextAggregate;

/**
 * ContextCommandHandler
 * <p>限界上下文领域命令处理器
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @author Deng Haozhi
 * @see DDDGeneratorCommandHandler < ContextAggregate >
 * @since 1.0.0
 */
public interface ContextCommandHandler extends DDDGeneratorCommandHandler<ContextAggregate> {

    void create(ContextCreateReqCTransferReq command);

    void remove(ContextRemoveReqCTransferReq command);

    void modify(ContextModifyReqCTransferReq command);
}

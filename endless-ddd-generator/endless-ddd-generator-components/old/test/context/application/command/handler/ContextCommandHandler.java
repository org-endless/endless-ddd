package org.endless.ddd.generator.components.generator.context.application.command.handler;

import org.endless.ddd.generator.common.model.application.command.handler.DDDGeneratorCommandHandler;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.context.domain.entity.ContextAggregate;

/**
 * ContextCommandHandler
 * <p>
 * 上下文领域命令处理器
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:21
 *
 * @author Deng Haozhi
 * @see DDDGeneratorCommandHandler
 * @since 0.0.1
 */
public interface ContextCommandHandler extends DDDGeneratorCommandHandler<ContextAggregate> {

    void create(ContextCreateReqCTransfer command);

}

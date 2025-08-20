package org.endless.ddd.generator.components.generator.domain.application.command.handler;

import org.endless.ddd.generator.common.model.application.command.handler.DDDGeneratorCommandHandler;
import org.endless.ddd.generator.components.generator.domain.application.command.transfer.DomainCreateReqCTransferReq;
import org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate;

/**
 * DomainCommandHandler
 * <p>领域领域命令处理器
 * <p>
 * create 2025/08/07 16:48
 * <p>
 * update 2025/08/07 16:48
 *
 * @author Deng Haozhi
 * @see DDDGeneratorCommandHandler < DomainAggregate >
 * @since 1.0.0
 */
public interface DomainCommandHandler extends DDDGeneratorCommandHandler<DomainAggregate> {

    void create(DomainCreateReqCTransferReq command);

}

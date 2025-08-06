package org.endless.ddd.generator.components.generator.domain.application.command.handler;

import org.endless.ddd.generator.common.model.application.command.handler.DDDGeneratorCommandHandler;
import org.endless.ddd.generator.components.generator.domain.application.command.transfer.DomainCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate;

/**
 * DomainCommandHandler
 * <p>
 * 领域命令处理器
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:21
 *
 * @author Deng Haozhi
 * @see DDDGeneratorCommandHandler
 * @since 0.0.1
 */
public interface DomainCommandHandler extends DDDGeneratorCommandHandler<DomainAggregate> {

    void create(DomainCreateReqCTransfer command);

}

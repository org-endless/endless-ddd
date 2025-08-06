package org.endless.ddd.generator.components.generator.service.application.command.handler;

import org.endless.ddd.generator.common.model.application.command.handler.DDDGeneratorCommandHandler;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceGenerateReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate;

/**
 * ServiceCommandHandler
 * <p>
 * 服务领域命令处理器
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:21
 *
 * @author Deng Haozhi
 * @see DDDGeneratorCommandHandler
 * @since 0.0.1
 */
public interface ServiceCommandHandler extends DDDGeneratorCommandHandler<ServiceAggregate> {

    void create(ServiceCreateReqCTransfer command);

    void remove(ServiceRemoveReqCTransfer command);

    void modify(ServiceModifyReqCTransfer command);

    void generate(ServiceGenerateReqCTransfer command);

}

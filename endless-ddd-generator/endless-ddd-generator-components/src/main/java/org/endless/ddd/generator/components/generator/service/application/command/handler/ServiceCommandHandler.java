package org.endless.ddd.generator.components.generator.service.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
 * @since 1.0.0
 */
public interface ServiceCommandHandler extends DDDGeneratorCommandHandler<ServiceAggregate> {

    void create(
            @NotNull(message = "服务创建命令请求对象不能为空")
            @Valid ServiceCreateReqCTransfer command
    );

    void remove(
            @NotNull(message = "服务删除命令请求对象不能为空")
            @Valid ServiceRemoveReqCTransfer command
    );

    void modify(
            @NotNull(message = "服务修改命令请求对象不能为空")
            @Valid ServiceModifyReqCTransfer command
    );

    void generate(
            @NotNull(message = "服务生成命令请求对象不能为空")
            @Valid ServiceGenerateReqCTransfer command
    );

}

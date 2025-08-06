package org.endless.ddd.generator.components.generator.service.facade.adapter.spring;

import org.endless.ddd.generator.components.generator.service.application.command.handler.ServiceCommandHandler;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceGenerateReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.query.handler.ServiceQueryHandler;
import org.endless.ddd.generator.components.generator.service.facade.adapter.ServiceDrivingAdapter;

/**
 * SpringServiceDrivingAdapter
 * <p>
 * 服务领域主动适配器Spring实现类
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:16
 *
 * @author Deng Haozhi
 * @see ServiceDrivingAdapter
 * @since 0.0.1
 */
public class SpringServiceDrivingAdapter implements ServiceDrivingAdapter {

    /**
     * 服务领域命令处理器
     */
    private final ServiceCommandHandler serviceCommandHandler;

    /**
     * 服务领域查询处理器
     */
    private final ServiceQueryHandler serviceQueryHandler;

    public SpringServiceDrivingAdapter(
            ServiceCommandHandler serviceCommandHandler,
            ServiceQueryHandler serviceQueryHandler) {
        this.serviceCommandHandler = serviceCommandHandler;
        this.serviceQueryHandler = serviceQueryHandler;
    }

    @Override
    public void create(ServiceCreateReqCTransfer command) {
        serviceCommandHandler.create(command);
    }

    @Override
    public void remove(ServiceRemoveReqCTransfer command) {
        serviceCommandHandler.remove(command);
    }

    @Override
    public void modify(ServiceModifyReqCTransfer command) {
        serviceCommandHandler.modify(command);
    }

    @Override
    public void generate(ServiceGenerateReqCTransfer command) {
        serviceCommandHandler.generate(command);
    }
}

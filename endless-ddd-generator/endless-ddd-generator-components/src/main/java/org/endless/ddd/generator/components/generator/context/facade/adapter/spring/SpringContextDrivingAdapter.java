package org.endless.ddd.generator.components.generator.context.facade.adapter.spring;

import org.endless.ddd.generator.components.generator.context.application.command.handler.ContextCommandHandler;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.context.application.query.handler.ContextQueryHandler;
import org.endless.ddd.generator.components.generator.context.application.query.transfer.ContextFindByServiceIdReqQTransfer;
import org.endless.ddd.generator.components.generator.context.application.query.transfer.ContextFindSimpleProfilesRespQTransfer;
import org.endless.ddd.generator.components.generator.context.facade.adapter.ContextDrivingAdapter;

/**
 * SpringContextDrivingAdapter
 * <p>限界上下文领域主动适配器Spring实现类
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @author Deng Haozhi
 * @see ContextDrivingAdapter
 * @since 1.0.0
 */
public class SpringContextDrivingAdapter implements ContextDrivingAdapter {

    /**
     * 限界上下文领域命令处理器
     */
    private final ContextCommandHandler contextCommandHandler;

    /**
     * 限界上下文领域查询处理器
     */
    private final ContextQueryHandler contextQueryHandler;

    public SpringContextDrivingAdapter(ContextCommandHandler contextCommandHandler, ContextQueryHandler contextQueryHandler) {
        this.contextCommandHandler = contextCommandHandler;
        this.contextQueryHandler = contextQueryHandler;
    }

    @Override
    public void create(ContextCreateReqCTransfer command) {
        contextCommandHandler.create(command);
    }

    @Override
    public void remove(ContextRemoveReqCTransfer command) {
        contextCommandHandler.remove(command);
    }

    @Override
    public void modify(ContextModifyReqCTransfer command) {
        contextCommandHandler.modify(command);
    }

    @Override
    public ContextFindSimpleProfilesRespQTransfer findSimpleProfilesByServiceId(ContextFindByServiceIdReqQTransfer query) {
        return contextQueryHandler.findSimpleProfilesByServiceId(query);
    }
}

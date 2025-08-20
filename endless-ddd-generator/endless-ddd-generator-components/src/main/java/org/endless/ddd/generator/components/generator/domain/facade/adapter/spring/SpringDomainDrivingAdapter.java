package org.endless.ddd.generator.components.generator.domain.facade.adapter.spring;

import org.endless.ddd.generator.components.generator.domain.application.command.handler.DomainCommandHandler;
import org.endless.ddd.generator.components.generator.domain.application.command.transfer.DomainCreateReqCTransferReq;
import org.endless.ddd.generator.components.generator.domain.application.query.handler.DomainQueryHandler;
import org.endless.ddd.generator.components.generator.domain.facade.adapter.DomainDrivingAdapter;

/**
 * SpringDomainDrivingAdapter
 * <p>领域领域主动适配器Spring实现类
 * <p>
 * create 2025/08/07 16:48
 * <p>
 * update 2025/08/07 16:48
 *
 * @author Deng Haozhi
 * @see DomainDrivingAdapter
 * @since 1.0.0
 */
public class SpringDomainDrivingAdapter implements DomainDrivingAdapter {

    /**
     * 领域领域命令处理器
     */
    private final DomainCommandHandler domainCommandHandler;

    /**
     * 领域领域查询处理器
     */
    private final DomainQueryHandler domainQueryHandler;

    public SpringDomainDrivingAdapter(DomainCommandHandler domainCommandHandler, DomainQueryHandler domainQueryHandler) {
        this.domainCommandHandler = domainCommandHandler;
        this.domainQueryHandler = domainQueryHandler;
    }

    @Override
    public void create(DomainCreateReqCTransferReq command) {
        domainCommandHandler.create(command);
    }
}

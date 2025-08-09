package org.endless.ddd.generator.components.generator.domain.application.command.handler.impl;

import org.endless.ddd.generator.components.generator.domain.application.command.handler.DomainCommandHandler;
import org.endless.ddd.generator.components.generator.domain.application.command.transfer.DomainCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.domain.domain.anticorruption.DomainRepository;

/**
 * DomainCommandHandlerImpl
 * <p>领域领域命令处理器
 * <p>
 * create 2025/08/07 16:48
 * <p>
 * update 2025/08/07 16:48
 *
 * @author Deng Haozhi
 * @see DomainCommandHandler
 * @since 1.0.0
 */
public class DomainCommandHandlerImpl implements DomainCommandHandler {

    /**
     * 领域聚合仓储接口
     */
    private final DomainRepository domainRepository;

    public DomainCommandHandlerImpl(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    @Override
    public void create(DomainCreateReqCTransfer command) {

    }
}

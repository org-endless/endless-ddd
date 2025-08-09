package org.endless.ddd.generator.components.generator.domain.application.query.handler.impl;

import org.endless.ddd.generator.components.generator.domain.application.query.anticorruption.AggregateFieldQueryRepository;
import org.endless.ddd.generator.components.generator.domain.application.query.anticorruption.DomainQueryRepository;
import org.endless.ddd.generator.components.generator.domain.application.query.handler.DomainQueryHandler;

/**
 * DomainQueryHandlerImpl
 * <p>领域领域查询处理器
 * <p>
 * create 2025/08/07 16:48
 * <p>
 * update 2025/08/07 16:48
 *
 * @author Deng Haozhi
 * @see DomainQueryHandler
 * @since 1.0.0
 */
public class DomainQueryHandlerImpl implements DomainQueryHandler {

    /**
     * 领域聚合查询仓储接口
     */
    private final DomainQueryRepository domainQueryRepository;

    /**
     * 聚合根字段实体查询仓储接口
     */
    private final AggregateFieldQueryRepository aggregateFieldQueryRepository;

    public DomainQueryHandlerImpl(DomainQueryRepository domainQueryRepository, AggregateFieldQueryRepository aggregateFieldQueryRepository) {
        this.domainQueryRepository = domainQueryRepository;
        this.aggregateFieldQueryRepository = aggregateFieldQueryRepository;
    }
}

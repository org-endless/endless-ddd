package org.endless.ddd.generator.components.generator.domain.infrastructure.data.manager;

import org.endless.ddd.generator.common.model.infrastructure.data.manager.DDDGeneratorAggregateDataManager;
import org.endless.ddd.generator.components.generator.domain.application.query.anticorruption.DomainQueryRepository;
import org.endless.ddd.generator.components.generator.domain.domain.anticorruption.DomainRepository;
import org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate;
import org.endless.ddd.generator.components.generator.domain.infrastructure.data.persistence.mapper.AggregateFieldMapper;
import org.endless.ddd.generator.components.generator.domain.infrastructure.data.persistence.mapper.DomainMapper;
import org.endless.ddd.generator.components.generator.domain.infrastructure.data.record.DomainRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * DomainDataManager
 * <p>领域聚合数据管理器
 * <p>
 * create 2025/08/07 16:48
 * <p>
 * update 2025/08/07 16:48
 *
 * @author Deng Haozhi
 * @see DomainRepository
 * @see DomainQueryRepository
 * @see DDDGeneratorAggregateDataManager
 * @since 1.0.0
 */
@Lazy
@Component
public class DomainDataManager implements DomainRepository, DomainQueryRepository, DDDGeneratorAggregateDataManager<DomainRecord, DomainAggregate> {

    /**
     * 领域聚合 Mybatis-Plus 数据访问对象
     */
    private final DomainMapper domainMapper;

    /**
     * 聚合根字段实体 Mybatis-Plus 数据访问对象
     */
    private final AggregateFieldMapper aggregateFieldMapper;

    public DomainDataManager(DomainMapper domainMapper, AggregateFieldMapper aggregateFieldMapper) {
        this.domainMapper = domainMapper;
        this.aggregateFieldMapper = aggregateFieldMapper;
    }

    @Override
    public DomainAggregate save(DomainAggregate aggregate) {
        return null;
    }

    @Override
    public void remove(DomainAggregate aggregate) {

    }

    @Override
    public DomainAggregate modify(DomainAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<DomainAggregate> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<DomainAggregate> findByIdForUpdate(String id) {
        return Optional.empty();
    }
}

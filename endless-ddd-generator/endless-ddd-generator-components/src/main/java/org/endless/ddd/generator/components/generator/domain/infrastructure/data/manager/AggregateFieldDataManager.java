package org.endless.ddd.generator.components.generator.domain.infrastructure.data.manager;

import org.endless.ddd.generator.common.model.infrastructure.data.manager.DDDGeneratorEntityDataManager;
import org.endless.ddd.generator.components.generator.domain.application.query.anticorruption.AggregateFieldQueryRepository;
import org.endless.ddd.generator.components.generator.domain.domain.entity.AggregateFieldEntity;
import org.endless.ddd.generator.components.generator.domain.infrastructure.data.persistence.mapper.AggregateFieldMapper;
import org.endless.ddd.generator.components.generator.domain.infrastructure.data.record.AggregateFieldRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * AggregateFieldDataManager
 * <p>聚合根字段实体数据管理器
 * <p>
 * create 2025/08/07 16:48
 * <p>
 * update 2025/08/07 16:48
 *
 * @author Deng Haozhi
 * @see AggregateFieldQueryRepository
 * @see DDDGeneratorEntityDataManager
 * @since 1.0.0
 */
@Lazy
@Component
public class AggregateFieldDataManager implements AggregateFieldQueryRepository, DDDGeneratorEntityDataManager<AggregateFieldRecord, AggregateFieldEntity> {

    /**
     * 聚合根字段实体 Mybatis-Plus 数据访问对象
     */
    private final AggregateFieldMapper aggregateFieldMapper;

    public AggregateFieldDataManager(AggregateFieldMapper aggregateFieldMapper) {
        this.aggregateFieldMapper = aggregateFieldMapper;
    }
}

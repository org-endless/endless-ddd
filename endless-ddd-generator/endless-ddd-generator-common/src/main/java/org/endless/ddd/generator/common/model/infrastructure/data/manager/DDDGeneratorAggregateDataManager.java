package org.endless.ddd.generator.common.model.infrastructure.data.manager;

import org.endless.ddd.generator.common.model.application.query.anticorruption.DDDGeneratorQueryRepository;
import org.endless.ddd.generator.common.model.domain.anticorruption.DDDGeneratorRepository;
import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorAggregate;
import org.endless.ddd.generator.common.model.infrastructure.data.record.DDDGeneratorRecord;
import org.endless.ddd.starter.common.ddd.infrastructure.data.manager.AggregateDataManager;

/**
 * DDDGeneratorAggregateDataManager
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/11/03 19:03
 *
 * @author Deng Haozhi
 * @see DDDGeneratorRepository
 * @see DDDGeneratorQueryRepository
 * @see AggregateDataManager
 * @since 1.0.0
 */
public interface DDDGeneratorAggregateDataManager<R extends DDDGeneratorRecord<A>, A extends DDDGeneratorAggregate>
        extends DDDGeneratorRepository<A>, DDDGeneratorQueryRepository<A>, AggregateDataManager<R, A> {

}

package org.endless.ddd.generator.common.model.infrastructure.data.manager;

import org.endless.ddd.generator.common.model.application.query.anticorruption.DDDGeneratorQueryRepository;
import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorEntity;
import org.endless.ddd.generator.common.model.infrastructure.data.record.DDDGeneratorRecord;
import org.endless.ddd.starter.common.ddd.infrastructure.data.manager.EntityDataManager;

/**
 * DDDGeneratorEntityDataManager
 * <p>
 * create 2024/09/03 12:25
 * <p>
 * update 2024/11/03 19:03
 *
 * @author Deng Haozhi
 * @see DDDGeneratorQueryRepository
 * @see EntityDataManager
 * @since 1.0.0
 */
public interface DDDGeneratorEntityDataManager<R extends DDDGeneratorRecord<E>, E extends DDDGeneratorEntity>
        extends DDDGeneratorQueryRepository<E>, EntityDataManager<R, E> {

}

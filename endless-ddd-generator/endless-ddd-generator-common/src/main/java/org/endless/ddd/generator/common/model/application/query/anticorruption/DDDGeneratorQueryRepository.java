package org.endless.ddd.generator.common.model.application.query.anticorruption;

import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorEntity;
import org.endless.ddd.starter.common.model.application.query.anticorruption.QueryRepository;

/**
 * DDDGeneratorQueryRepository
 * <p>
 * create 2024/09/10 13:52
 * <p>
 * update 2024/11/03 18:50
 *
 * @author Deng Haozhi
 * @see QueryRepository
 * @since 1.0.0
 */
public interface DDDGeneratorQueryRepository<E extends DDDGeneratorEntity> extends QueryRepository<E> {

}

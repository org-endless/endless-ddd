package org.endless.ddd.generator.common.model.domain.anticorruption;

import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorAggregate;
import org.endless.ddd.starter.common.model.domain.anticorruption.Repository;

/**
 * DDDGeneratorRepository
 * <p>
 * create 2025/08/02 19:31
 * <p>
 * update 2025/08/02 19:32
 *
 * @author Deng Haozhi
 * @see Repository
 * @since 1.0.0
 */
public interface DDDGeneratorRepository
        <A extends DDDGeneratorAggregate> extends Repository<A> {

}

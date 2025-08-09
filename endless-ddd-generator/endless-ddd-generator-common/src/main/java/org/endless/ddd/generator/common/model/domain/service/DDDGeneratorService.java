package org.endless.ddd.generator.common.model.domain.service;

import org.endless.ddd.generator.common.model.domain.entity.DDDGeneratorAggregate;
import org.endless.ddd.starter.common.ddd.domain.service.Service;

/**
 * DDDGeneratorService
 * <p>
 * create 2024/02/11 22:04
 * <p>
 * update 2024/08/30 09:08
 *
 * @author Deng Haozhi
 * @see Service
 * @since 1.0.0
 */
public interface DDDGeneratorService<A extends DDDGeneratorAggregate>
        extends Service<A> {

}

package org.endless.ddd.generator.components.generator.domain.domain.anticorruption;

import org.endless.ddd.generator.common.model.domain.anticorruption.DDDGeneratorDrivenAdapter;
import org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate;

/**
 * AggregateDrivenAdapter
 * <p>
 * 领域被动适配器
 * <p>
 * create 2025/07/29 21:13
 * <p>
 * update 2025/07/29 21:13
 *
 * @author Deng Haozhi
 * @see DDDGeneratorDrivenAdapter
 * @since 1.0.0
 */
public interface DomainDrivenAdapter extends DDDGeneratorDrivenAdapter {

    void save(DomainAggregate aggregate);

}

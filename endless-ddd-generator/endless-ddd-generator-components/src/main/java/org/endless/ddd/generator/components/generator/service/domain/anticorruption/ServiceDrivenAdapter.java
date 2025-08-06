package org.endless.ddd.generator.components.generator.service.domain.anticorruption;

import org.endless.ddd.generator.common.model.domain.anticorruption.DDDGeneratorDrivenAdapter;
import org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate;

/**
 * ServiceDrivenAdapter
 * <p>
 * 服务领域被动适配器
 * <p>
 * create 2025/07/29 21:13
 * <p>
 * update 2025/07/29 21:13
 *
 * @author Deng Haozhi
 * @see DDDGeneratorDrivenAdapter
 * @since 1.0.0
 */
public interface ServiceDrivenAdapter extends DDDGeneratorDrivenAdapter {

    void generate(ServiceAggregate aggregate);

}

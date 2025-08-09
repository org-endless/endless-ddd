package org.endless.ddd.generator.components.generator.service.infrastructure.adapter.generator;

import org.endless.ddd.generator.common.model.infrastructure.adapter.DDDGeneratorContentDrivenAdapter;
import org.endless.ddd.generator.components.generator.service.domain.anticorruption.ServiceGeneratorDrivenAdapter;
import org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * ServiceGeneratorDrivenAdapterImpl
 * <p>
 * create 2025/08/01 15:26
 * <p>
 * update 2025/08/01 15:26
 *
 * @author Deng Haozhi
 * @see ServiceGeneratorDrivenAdapter
 * @since 1.0.0
 */
@Lazy
@Component
public class ServiceGeneratorDrivenAdapterImpl implements ServiceGeneratorDrivenAdapter, DDDGeneratorContentDrivenAdapter {


    @Override
    public void generate(ServiceAggregate aggregate) {
        DDDGeneratorContentDrivenAdapter.super.yaml(aggregate);
    }
}

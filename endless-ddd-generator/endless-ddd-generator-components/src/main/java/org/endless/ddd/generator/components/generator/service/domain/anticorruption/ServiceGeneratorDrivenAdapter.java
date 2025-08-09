package org.endless.ddd.generator.components.generator.service.domain.anticorruption;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.generator.common.model.domain.anticorruption.DDDGeneratorDrivenAdapter;
import org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate;

/**
 * ServiceGeneratorDrivenAdapter
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
public interface ServiceGeneratorDrivenAdapter extends DDDGeneratorDrivenAdapter {

    void generate(
            @NotNull(message = "服务聚合对象不能为空")
            @Valid ServiceAggregate aggregate
    );
}

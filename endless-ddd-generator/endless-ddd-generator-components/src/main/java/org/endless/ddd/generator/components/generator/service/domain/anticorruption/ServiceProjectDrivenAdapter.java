package org.endless.ddd.generator.components.generator.service.domain.anticorruption;

import jakarta.validation.constraints.NotBlank;
import org.endless.ddd.generator.common.model.domain.anticorruption.DDDGeneratorDrivenAdapter;

/**
 * ServiceProjectDrivenAdapter
 * <p>
 * create 2025/08/09 09:25
 * <p>
 * update 2025/08/09 09:28
 * update 2025/08/09 09:29
 *
 * @author Deng Haozhi
 * @see DDDGeneratorDrivenAdapter
 * @since 1.0.0
 */
public interface ServiceProjectDrivenAdapter extends DDDGeneratorDrivenAdapter {

    void existsById(
            @NotBlank(message = "项目ID不能为空") String projectId
    );

}

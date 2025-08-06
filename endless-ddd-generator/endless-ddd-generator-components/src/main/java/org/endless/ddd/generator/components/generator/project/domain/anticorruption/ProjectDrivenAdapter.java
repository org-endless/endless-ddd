package org.endless.ddd.generator.components.generator.project.domain.anticorruption;

import org.endless.ddd.generator.common.model.domain.anticorruption.DDDGeneratorDrivenAdapter;
import org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate;

/**
 * ProjectDrivenAdapter
 * <p>
 * create 2025/07/29 21:13
 * <p>
 * update 2025/07/29 21:13
 *
 * @author Deng Haozhi
 * @see DDDGeneratorDrivenAdapter
 * @since 1.0.0
 */
public interface ProjectDrivenAdapter extends DDDGeneratorDrivenAdapter {

    void generate(ProjectAggregate aggregate);
}

package org.endless.ddd.generator.components.generator.context.application.query.anticorruption;

import org.endless.ddd.generator.common.model.application.query.anticorruption.DDDGeneratorQueryRepository;
import org.endless.ddd.generator.components.generator.context.application.query.transfer.ContextFindSimpleProfileRespQTransfer;
import org.endless.ddd.generator.components.generator.context.domain.anticorruption.ContextRepository;
import org.endless.ddd.generator.components.generator.context.domain.entity.ContextAggregate;

import java.util.List;

/**
 * ContextQueryRepository
 * <p>限界上下文聚合查询仓储接口
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @author Deng Haozhi
 * @see ContextRepository
 * @see DDDGeneratorQueryRepository
 * @since 1.0.0
 */
public interface ContextQueryRepository extends ContextRepository, DDDGeneratorQueryRepository<ContextAggregate> {

    List<ContextFindSimpleProfileRespQTransfer> findSimpleProfilesByServiceId(String serviceId);

}

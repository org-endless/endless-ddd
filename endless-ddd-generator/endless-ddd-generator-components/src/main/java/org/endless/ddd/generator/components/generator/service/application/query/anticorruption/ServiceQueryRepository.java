package org.endless.ddd.generator.components.generator.service.application.query.anticorruption;

import org.endless.ddd.generator.common.model.application.query.anticorruption.DDDGeneratorQueryRepository;
import org.endless.ddd.generator.components.generator.service.application.query.transfer.ServiceFindSimpleProfileRespQTransfer;
import org.endless.ddd.generator.components.generator.service.domain.anticorruption.ServiceRepository;
import org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate;

import java.util.List;

/**
 * ServiceQueryRepository
 * <p>服务聚合查询仓储接口
 * <p>
 * create 2025/08/05 22:32
 * <p>
 * update 2025/08/05 22:32
 *
 * @author Deng Haozhi
 * @see ServiceRepository
 * @see DDDGeneratorQueryRepository
 * @since 0.0.1
 */
public interface ServiceQueryRepository extends ServiceRepository, DDDGeneratorQueryRepository<ServiceAggregate> {

    List<ServiceFindSimpleProfileRespQTransfer> findSimpleProfilesByProjectId(String projectId);

}

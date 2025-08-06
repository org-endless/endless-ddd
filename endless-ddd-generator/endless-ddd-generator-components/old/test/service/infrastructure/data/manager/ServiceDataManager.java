package org.endless.ddd.generator.components.generator.service.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.*;
import org.endless.tianyan.metadata.common.model.infrastructure.data.manager.*;
import org.endless.tianyan.metadata.components.generator.service.application.query.anticorruption.*;
import org.endless.tianyan.metadata.components.generator.service.domain.anticorruption.*;
import org.endless.tianyan.metadata.components.generator.service.domain.entity.*;
import org.endless.tianyan.metadata.components.generator.service.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.metadata.components.generator.service.infrastructure.data.record.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * ServiceDataManager
 * <p>服务聚合数据管理器
 * <p>
 * create 2025/08/05 22:32
 * <p>
 * update 2025/08/05 22:32
 *
 * @author Deng Haozhi
 * @see ServiceRepository
 * @see ServiceQueryRepository
 * @see DDDGeneratorAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class ServiceDataManager implements ServiceRepository, ServiceQueryRepository, DDDGeneratorAggregateDataManager<ServiceRecord, ServiceAggregate> {

    /**
     * 服务聚合 Mybatis-Plus 数据访问对象
     */
    private final ServiceMapper serviceMapper;

    public ServiceDataManager(ServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }
}

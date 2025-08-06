package org.endless.ddd.generator.components.generator.service.infrastructure.data.manager;

import org.endless.ddd.generator.common.model.infrastructure.data.manager.DDDGeneratorAggregateDataManager;
import org.endless.ddd.generator.components.generator.service.application.query.anticorruption.ServiceQueryRepository;
import org.endless.ddd.generator.components.generator.service.application.query.transfer.ServiceFindSimpleProfileRespQTransfer;
import org.endless.ddd.generator.components.generator.service.domain.anticorruption.ServiceRepository;
import org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate;
import org.endless.ddd.generator.components.generator.service.infrastructure.data.persistence.mapper.ServiceMapper;
import org.endless.ddd.generator.components.generator.service.infrastructure.data.record.ServiceRecord;
import org.endless.ddd.starter.common.config.log.annotation.Log;
import org.endless.ddd.starter.common.config.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.model.infrastructure.data.manager.DataManagerRequestNullException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

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

    @Override
    @Log(message = "保存服务聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public ServiceAggregate save(ServiceAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(ServiceAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存服务聚合数据不能为空"));
        serviceMapper.save(ServiceRecord.from(aggregate));
        return aggregate;
    }

    @Override
    @Log(message = "删除服务聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(ServiceAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .orElseThrow(() -> new DataManagerRequestNullException("删除服务聚合数据不能为空"));
        serviceMapper.remove(ServiceRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改服务聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public ServiceAggregate modify(ServiceAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(ServiceAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("修改服务聚合数据不能为空"));
        serviceMapper.modify(ServiceRecord.from(aggregate));
        return aggregate;
    }

    @Override
    @Log(message = "根据ID查询服务聚合数据", value = "#serviceId", level = LogLevel.TRACE)
    public Optional<ServiceAggregate> findById(String serviceId) {
        Optional.ofNullable(serviceId)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DataManagerRequestNullException("服务聚合ID不能为空"));
        return serviceMapper.findById(serviceId).map(ServiceRecord::to);
    }

    @Override
    public Optional<ServiceAggregate> findByIdForUpdate(String id) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据项目ID查询项目基本信息列表数据", value = "#projectId", level = LogLevel.TRACE)
    public List<ServiceFindSimpleProfileRespQTransfer> findSimpleProfilesByProjectId(String projectId) {
        Optional.ofNullable(projectId)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DataManagerRequestNullException("项目ID不能为空"));
        return serviceMapper.findSimpleProfilesByProjectId(projectId).stream()
                .map(record -> ServiceFindSimpleProfileRespQTransfer.builder()
                        .serviceId(record.getServiceId())
                        .name(record.getName())
                        .build().validate())
                .toList();
    }
}

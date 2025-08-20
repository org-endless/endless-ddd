package org.endless.ddd.generator.components.generator.context.infrastructure.data.manager;

import org.endless.ddd.generator.common.model.infrastructure.data.manager.DDDGeneratorAggregateDataManager;
import org.endless.ddd.generator.components.generator.context.application.query.anticorruption.ContextQueryRepository;
import org.endless.ddd.generator.components.generator.context.application.query.transfer.ContextFindSimpleProfileRespQTransferReq;
import org.endless.ddd.generator.components.generator.context.domain.anticorruption.ContextRepository;
import org.endless.ddd.generator.components.generator.context.domain.entity.ContextAggregate;
import org.endless.ddd.generator.components.generator.context.infrastructure.data.persistence.mapper.ContextMapper;
import org.endless.ddd.generator.components.generator.context.infrastructure.data.record.ContextRecord;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager.DataManagerParameterNullException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * ContextDataManager
 * <p>限界上下文聚合数据管理器
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @author Deng Haozhi
 * @see ContextRepository
 * @see ContextQueryRepository
 * @see DDDGeneratorAggregateDataManager
 * @since 1.0.0
 */
@Lazy
@Component
public class ContextDataManager implements ContextRepository, ContextQueryRepository, DDDGeneratorAggregateDataManager<ContextRecord, ContextAggregate> {

    /**
     * 限界上下文聚合 Mybatis-Plus 数据访问对象
     */
    private final ContextMapper contextMapper;

    public ContextDataManager(ContextMapper contextMapper) {
        this.contextMapper = contextMapper;
    }

    @Override
    @Log(message = "保存限界上下文聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public ContextAggregate save(ContextAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(ContextAggregate::validate)
                .orElseThrow(() -> new DataManagerParameterNullException("保存限界上下文聚合数据不能为空"));
        contextMapper.save(ContextRecord.from(aggregate));
        return aggregate;
    }

    @Override
    @Log(message = "删除限界上下文聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(ContextAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .orElseThrow(() -> new DataManagerParameterNullException("删除限界上下文聚合数据不能为空"));
        contextMapper.remove(ContextRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改限界上下文聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public ContextAggregate modify(ContextAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(ContextAggregate::validate)
                .orElseThrow(() -> new DataManagerParameterNullException("修改限界上下文聚合数据不能为空"));
        contextMapper.modify(ContextRecord.from(aggregate));
        return aggregate;
    }

    @Override
    @Log(message = "根据ID查询限界上下文聚合数据", value = "#contextId", level = LogLevel.TRACE)
    public Optional<ContextAggregate> findById(String contextId) {
        Optional.ofNullable(contextId)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DataManagerParameterNullException("限界上下文ID不能为空"));
        return contextMapper.findById(contextId).map(ContextRecord::to);
    }

    @Override
    public Optional<ContextAggregate> findByIdForUpdate(String id) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据服务ID查询限界上下文基本信息列表数据", value = "#serviceId", level = LogLevel.TRACE)
    public List<ContextFindSimpleProfileRespQTransferReq> findSimpleProfilesByServiceId(String serviceId) {
        Optional.ofNullable(serviceId)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DataManagerParameterNullException("服务ID不能为空"));
        return contextMapper.findSimpleProfilesByServiceId(serviceId).stream()
                .map(record -> ContextFindSimpleProfileRespQTransferReq.builder()
                        .contextId(record.getContextId())
                        .name(record.getName())
                        .build().validate())
                .toList();
    }
}

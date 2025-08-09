package org.endless.ddd.generator.components.generator.context.application.query.handler.impl;

import org.endless.ddd.generator.components.generator.context.application.query.anticorruption.ContextQueryRepository;
import org.endless.ddd.generator.components.generator.context.application.query.handler.ContextQueryHandler;
import org.endless.ddd.generator.components.generator.context.application.query.transfer.ContextFindByServiceIdReqQTransfer;
import org.endless.ddd.generator.components.generator.context.application.query.transfer.ContextFindSimpleProfilesRespQTransfer;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferNullException;

import java.util.Optional;

/**
 * ContextQueryHandlerImpl
 * <p>限界上下文领域查询处理器
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @author Deng Haozhi
 * @see ContextQueryHandler
 * @since 1.0.0
 */
public class ContextQueryHandlerImpl implements ContextQueryHandler {

    /**
     * 限界上下文聚合查询仓储接口
     */
    private final ContextQueryRepository contextQueryRepository;

    public ContextQueryHandlerImpl(ContextQueryRepository contextQueryRepository) {
        this.contextQueryRepository = contextQueryRepository;
    }

    @Override
    @Log(message = "根据服务ID查询限界上下文基本信息列表", value = "#query", level = LogLevel.TRACE)
    public ContextFindSimpleProfilesRespQTransfer findSimpleProfilesByServiceId(ContextFindByServiceIdReqQTransfer query) {
        Optional.ofNullable(query)
                .map(ContextFindByServiceIdReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("根据项目ID查询项目基本信息列表参数不能为空"));
        return ContextFindSimpleProfilesRespQTransfer.builder()
                .simpleProfiles(contextQueryRepository.findSimpleProfilesByServiceId(query.serviceId()))
                .build().validate();
    }
}

package org.endless.ddd.generator.components.generator.service.application.query.handler.impl;

import org.endless.ddd.generator.components.generator.service.application.query.anticorruption.ServiceQueryRepository;
import org.endless.ddd.generator.components.generator.service.application.query.handler.ServiceQueryHandler;
import org.endless.ddd.generator.components.generator.service.application.query.transfer.ServiceFindByProjectIdReqQTransfer;
import org.endless.ddd.generator.components.generator.service.application.query.transfer.ServiceFindSimpleProfilesRespQTransfer;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferNullException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * ServiceQueryHandlerImpl
 * <p>
 * 服务领域查询处理器实现类
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:16
 *
 * @author Deng Haozhi
 * @see ServiceQueryHandler
 * @since 1.0.0
 */
@Lazy
@Service
@Validated
public class ServiceQueryHandlerImpl implements ServiceQueryHandler {

    /**
     * 服务聚合查询仓储接口
     */
    private final ServiceQueryRepository serviceQueryRepository;

    public ServiceQueryHandlerImpl(ServiceQueryRepository serviceQueryRepository) {
        this.serviceQueryRepository = serviceQueryRepository;
    }

    @Override
    @Log(message = "根据项目ID查询服务基本信息列表", value = "#query", level = LogLevel.TRACE)
    public ServiceFindSimpleProfilesRespQTransfer findSimpleProfilesByProjectId(ServiceFindByProjectIdReqQTransfer query) {
        Optional.ofNullable(query)
                .map(ServiceFindByProjectIdReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("根据项目ID查询项目基本信息列表参数不能为空"));
        return ServiceFindSimpleProfilesRespQTransfer.builder()
                .simpleProfiles(serviceQueryRepository.findSimpleProfilesByProjectId(query.projectId()))
                .build().validate();
    }
}

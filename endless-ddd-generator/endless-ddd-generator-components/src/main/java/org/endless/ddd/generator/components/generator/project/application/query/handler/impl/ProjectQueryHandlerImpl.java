package org.endless.ddd.generator.components.generator.project.application.query.handler.impl;

import org.endless.ddd.generator.components.generator.project.application.query.anticorruption.ProjectQueryRepository;
import org.endless.ddd.generator.components.generator.project.application.query.handler.ProjectQueryHandler;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindByIdReqQTransferReq;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindByIdsReqQTransferReq;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindSimpleProfilesRespQTransferReq;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.query.handler.QueryNotFoundException;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferNullException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ProjectQueryHandlerImpl
 * <p>项目领域查询处理器
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:16
 *
 * @author Deng Haozhi
 * @see ProjectQueryHandler
 * @since 1.0.0
 */
@Service
public class ProjectQueryHandlerImpl implements ProjectQueryHandler {

    /**
     * 项目查询仓储接口
     */
    private final ProjectQueryRepository projectQueryRepository;

    public ProjectQueryHandlerImpl(ProjectQueryRepository projectQueryRepository) {
        this.projectQueryRepository = projectQueryRepository;
    }

    @Override
    @Log(message = "根据ID列表查询项目基本信息列表", value = "#query", level = LogLevel.TRACE)
    public ProjectFindSimpleProfilesRespQTransferReq findSimpleProfilesByIds(ProjectFindByIdsReqQTransferReq query) {
        Optional.ofNullable(query)
                .map(ProjectFindByIdsReqQTransferReq::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("根据ID列表查询项目基本信息列表参数不能为空"));
        return ProjectFindSimpleProfilesRespQTransferReq.builder()
                .simpleProfiles(projectQueryRepository.findSimpleProfilesByIds(query.projectIds()))
                .build().validate();
    }

    @Override
    @Log(message = "根据ID查询项目是否存在", value = "#query", level = LogLevel.TRACE)
    public void existsById(ProjectFindByIdReqQTransferReq query) {
        Optional.ofNullable(query)
                .map(ProjectFindByIdReqQTransferReq::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("根据ID查询项目是否存在参数不能为空"));
        if (!projectQueryRepository.existsById(query.projectId())) {
            throw new QueryNotFoundException("根据ID查询项目不存在");
        }
    }
}

package org.endless.ddd.generator.components.generator.project.infrastructure.data.manager;

import org.endless.ddd.generator.common.model.infrastructure.data.manager.DDDGeneratorAggregateDataManager;
import org.endless.ddd.generator.components.generator.project.application.query.anticorruption.ProjectQueryRepository;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindSimpleProfileRespQTransfer;
import org.endless.ddd.generator.components.generator.project.domain.anticorruption.ProjectRepository;
import org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate;
import org.endless.ddd.generator.components.generator.project.infrastructure.data.persistence.mapper.ProjectMapper;
import org.endless.ddd.generator.components.generator.project.infrastructure.data.record.ProjectRecord;
import org.endless.ddd.starter.common.config.log.annotation.Log;
import org.endless.ddd.starter.common.config.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.model.infrastructure.data.manager.DataManagerRequestNullException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * ProjectDataManager
 * <p>项目聚合数据管理器
 * <p>
 * create 2025/08/02 20:02
 * <p>
 * update 2025/08/02 20:02
 *
 * @author Deng Haozhi
 * @see ProjectRepository
 * @see ProjectQueryRepository
 * @see DDDGeneratorAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class ProjectDataManager implements ProjectRepository, ProjectQueryRepository, DDDGeneratorAggregateDataManager<ProjectRecord, ProjectAggregate> {

    /**
     * 项目聚合 Mybatis-Plus 数据访问对象
     */
    private final ProjectMapper projectMapper;

    public ProjectDataManager(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    @Log(message = "保存项目聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public ProjectAggregate save(ProjectAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(ProjectAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存项目聚合数据不能为空"));
        projectMapper.save(ProjectRecord.from(aggregate));
        return aggregate;
    }

    @Override
    @Log(message = "删除项目聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(ProjectAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .orElseThrow(() -> new DataManagerRequestNullException("删除项目聚合数据不能为空"));
        projectMapper.remove(ProjectRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改项目聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public ProjectAggregate modify(ProjectAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(ProjectAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("修改项目聚合数据不能为空"));
        projectMapper.modify(ProjectRecord.from(aggregate));
        return aggregate;
    }

    @Override
    @Log(message = "根据ID查询项目聚合数据", value = "#projectId", level = LogLevel.TRACE)
    public Optional<ProjectAggregate> findById(String projectId) {
        Optional.ofNullable(projectId)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DataManagerRequestNullException("项目聚合ID不能为空"));
        return projectMapper.findById(projectId).map(ProjectRecord::to);
    }

    @Override
    public Optional<ProjectAggregate> findByIdForUpdate(String projectId) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据ID列表查询项目基本信息列表数据", value = "#projectIds", level = LogLevel.TRACE)
    public List<ProjectFindSimpleProfileRespQTransfer> findSimpleProfilesByIds(List<String> projectIds) {
        return projectMapper.findSimpleProfilesByIds(projectIds).stream()
                .map(record -> ProjectFindSimpleProfileRespQTransfer.builder()
                        .projectId(record.getProjectId())
                        .name(record.getName())
                        .build().validate())
                .toList();
    }
}

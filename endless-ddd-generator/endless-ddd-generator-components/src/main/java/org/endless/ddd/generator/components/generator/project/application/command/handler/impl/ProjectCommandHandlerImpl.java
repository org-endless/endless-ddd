package org.endless.ddd.generator.components.generator.project.application.command.handler.impl;

import org.endless.ddd.generator.components.generator.project.application.command.handler.ProjectCommandHandler;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectGenerateReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.project.domain.anticorruption.ProjectDrivenAdapter;
import org.endless.ddd.generator.components.generator.project.domain.anticorruption.ProjectRepository;
import org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate;
import org.endless.ddd.generator.components.generator.project.domain.type.ProjectDatabaseTypeEnum;
import org.endless.ddd.generator.components.generator.project.domain.type.ProjectJavaVersionEnum;
import org.endless.ddd.generator.components.generator.project.domain.type.ProjectLoggingFrameworkEnum;
import org.endless.ddd.generator.components.generator.project.domain.type.ProjectPersistenceFrameworkEnum;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.handler.CommandNotFoundException;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * ProjectCommandHandlerImpl
 * <p>项目领域命令处理器
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:16
 *
 * @author Deng Haozhi
 * @see ProjectCommandHandler
 * @since 1.0.0
 */
@Service
public class ProjectCommandHandlerImpl implements ProjectCommandHandler {

    /**
     * 项目仓储接口
     */
    private final ProjectRepository projectRepository;

    /**
     * 项目被动适配器接口
     */
    private final ProjectDrivenAdapter projectDrivenAdapter;

    public ProjectCommandHandlerImpl(ProjectRepository projectRepository, ProjectDrivenAdapter projectDrivenAdapter) {
        this.projectRepository = projectRepository;
        this.projectDrivenAdapter = projectDrivenAdapter;
    }

    @Override
    @Transactional
    @Log(message = "项目创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(ProjectCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ProjectCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("项目创建命令参数不能为空"));
        ProjectAggregate aggregate = ProjectAggregate.create(ProjectAggregate.builder()
                .projectArtifactId(command.projectArtifactId())
                .groupId(command.groupId())
                .name(command.name())
                .description(command.description())
                .version(command.version())
                .author(command.author())
                .rootPath(command.rootPath())
                .basePackage(command.basePackage())
                .enableSpringDoc(command.enableSpringDoc())
                .javaVersion(ProjectJavaVersionEnum.fromCode(command.javaVersion()))
                .loggingFramework(ProjectLoggingFrameworkEnum.fromCode(command.loggingFramework()))
                .persistenceFramework(ProjectPersistenceFrameworkEnum.fromCode(command.persistenceFramework()))
                .databaseType(ProjectDatabaseTypeEnum.fromCode(command.databaseType()))
                .createUserId(DDD_SIMPLIFIED_GENERATOR_USER_ID));
        projectRepository.save(aggregate);
    }

    @Override
    @Transactional
    @Log(message = "项目删除命令", value = "#command", level = LogLevel.TRACE)
    public void remove(ProjectRemoveReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ProjectRemoveReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("项目删除命令参数不能为空"));
        ProjectAggregate aggregate = projectRepository.findById(command.projectId())
                .orElseThrow(() -> new CommandNotFoundException("项目不存在"));
        projectRepository.remove(aggregate.remove(DDD_SIMPLIFIED_GENERATOR_USER_ID));
        //     删除项目下所有类型
    }

    @Override
    @Transactional
    @Log(message = "项目修改命令", value = "#command", level = LogLevel.TRACE)
    public void modify(ProjectModifyReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ProjectModifyReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("项目修改命令参数不能为空"));
        ProjectAggregate aggregate = projectRepository.findById(command.projectId())
                .orElseThrow(() -> new CommandNotFoundException("项目不存在"));
        projectRepository.modify(aggregate.modify(ProjectAggregate.builder()
                .projectArtifactId(command.projectArtifactId())
                .groupId(command.groupId())
                .name(command.name())
                .description(command.description())
                .version(command.version())
                .author(command.author())
                .rootPath(command.rootPath())
                .basePackage(command.basePackage())
                .enableSpringDoc(command.enableSpringDoc())
                .javaVersion(ProjectJavaVersionEnum.fromCode(command.javaVersion()))
                .loggingFramework(ProjectLoggingFrameworkEnum.fromCode(command.loggingFramework()))
                .persistenceFramework(ProjectPersistenceFrameworkEnum.fromCode(command.persistenceFramework()))
                .databaseType(ProjectDatabaseTypeEnum.fromCode(command.databaseType()))
                .modifyUserId(DDD_SIMPLIFIED_GENERATOR_USER_ID)));
    }

    @Override
    @Transactional
    @Log(message = "项目生成命令", value = "#command", level = LogLevel.TRACE)
    public void generate(ProjectGenerateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ProjectGenerateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("项目删除命令参数不能为空"));
        ProjectAggregate aggregate = projectRepository.findById(command.projectId())
                .orElseThrow(() -> new CommandNotFoundException("项目不存在"));
        projectDrivenAdapter.generate(aggregate);
    }
}

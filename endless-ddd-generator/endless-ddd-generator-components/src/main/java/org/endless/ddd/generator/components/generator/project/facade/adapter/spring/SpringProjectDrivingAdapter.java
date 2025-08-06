package org.endless.ddd.generator.components.generator.project.facade.adapter.spring;

import org.endless.ddd.generator.components.generator.project.application.command.handler.ProjectCommandHandler;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectGenerateReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.query.handler.ProjectQueryHandler;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindByIdsReqQTransfer;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindSimpleProfilesRespQTransfer;
import org.endless.ddd.generator.components.generator.project.facade.adapter.ProjectDrivingAdapter;

/**
 * SpringProjectDrivingAdapter
 * <p>项目领域主动适配器Spring实现类
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:16
 *
 * @param projectCommandHandler 项目领域命令处理器
 * @param projectQueryHandler   项目领域查询处理器
 * @author Deng Haozhi
 * @see ProjectDrivingAdapter
 * @since 0.0.1
 */
public class SpringProjectDrivingAdapter implements ProjectDrivingAdapter {

    /**
     * 项目领域命令处理器
     */
    private final ProjectCommandHandler projectCommandHandler;

    /**
     * 项目领域查询处理器
     */
    private final ProjectQueryHandler projectQueryHandler;

    public SpringProjectDrivingAdapter(ProjectCommandHandler projectCommandHandler, ProjectQueryHandler projectQueryHandler) {
        this.projectCommandHandler = projectCommandHandler;
        this.projectQueryHandler = projectQueryHandler;
    }

    @Override
    public void create(ProjectCreateReqCTransfer command) {
        projectCommandHandler.create(command);
    }

    @Override
    public void remove(ProjectRemoveReqCTransfer command) {
        projectCommandHandler.remove(command);
    }

    @Override
    public void modify(ProjectModifyReqCTransfer command) {
        projectCommandHandler.modify(command);
    }

    @Override
    public void generate(ProjectGenerateReqCTransfer command) {
        projectCommandHandler.generate(command);
    }

    @Override
    public ProjectFindSimpleProfilesRespQTransfer findSimpleProfilesByIds(ProjectFindByIdsReqQTransfer query) {
        return projectQueryHandler.findSimpleProfilesByIds(query);
    }
}

package org.endless.ddd.generator.components.generator.project.application.command.handler;

import org.endless.ddd.generator.common.model.application.command.handler.DDDGeneratorCommandHandler;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectGenerateReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate;

/**
 * ProjectCommandHandler
 * <p>项目领域命令处理器
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:21
 *
 * @author Deng Haozhi
 * @see DDDGeneratorCommandHandler
 * @since 0.0.1
 */
public interface ProjectCommandHandler extends DDDGeneratorCommandHandler<ProjectAggregate> {

    void create(ProjectCreateReqCTransfer command);

    void remove(ProjectRemoveReqCTransfer command);

    void modify(ProjectModifyReqCTransfer command);

    void generate(ProjectGenerateReqCTransfer command);
}

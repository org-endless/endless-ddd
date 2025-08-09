package org.endless.ddd.generator.components.generator.project.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
 * @since 1.0.0
 */
public interface ProjectCommandHandler extends DDDGeneratorCommandHandler<ProjectAggregate> {

    void create(
            @NotNull(message = "项目创建命令请求对象不能为空")
            @Valid ProjectCreateReqCTransfer command
    );

    void remove(
            @NotNull(message = "项目删除命令请求对象不能为空")
            @Valid ProjectRemoveReqCTransfer command
    );

    void modify(
            @NotNull(message = "项目修改命令请求对象不能为空")
            @Valid ProjectModifyReqCTransfer command
    );

    void generate(
            @NotNull(message = "项目生成命令请求对象不能为空")
            @Valid ProjectGenerateReqCTransfer command
    );
}

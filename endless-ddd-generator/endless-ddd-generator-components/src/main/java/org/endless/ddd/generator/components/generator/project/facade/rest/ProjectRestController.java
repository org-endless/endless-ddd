package org.endless.ddd.generator.components.generator.project.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.generator.common.model.facade.rest.DDDGeneratorRestController;
import org.endless.ddd.generator.components.generator.project.application.command.handler.ProjectCommandHandler;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectGenerateReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.query.handler.ProjectQueryHandler;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindByIdsReqQTransfer;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectRestController
 * <p>
 * 项目领域Rest控制器
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:16
 *
 * @author Deng Haozhi
 * @see DDDGeneratorRestController
 * @since 1.0.0
 */
@Lazy
@RestController
@RequestMapping("/generator/project")
public class ProjectRestController implements DDDGeneratorRestController {

    /**
     * 项目领域命令处理器
     */
    private final ProjectCommandHandler projectCommandHandler;

    /**
     * 项目领域查询处理器
     */
    private final ProjectQueryHandler projectQueryHandler;

    public ProjectRestController(ProjectCommandHandler projectCommandHandler, ProjectQueryHandler projectQueryHandler) {
        this.projectCommandHandler = projectCommandHandler;
        this.projectQueryHandler = projectQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "项目创建", value = "#command")
    public ResponseEntity<RestResponse> create(
            @NotNull(message = "项目创建请求对象不能为空")
            @Valid @RequestBody ProjectCreateReqCTransfer command) {
        projectCommandHandler.create(command);
        return response().success("项目创建成功");
    }

    @PostMapping("/command/remove")
    @Log(message = "项目删除", value = "#command")
    public ResponseEntity<RestResponse> remove(
            @NotNull(message = "项目删除请求对象不能为空")
            @Valid @RequestBody ProjectRemoveReqCTransfer command) {
        projectCommandHandler.remove(command);
        return response().success("项目删除成功");
    }

    @PostMapping("/command/modify")
    @Log(message = "项目修改", value = "#command")
    public ResponseEntity<RestResponse> modify(
            @NotNull(message = "项目修改请求对象不能为空")
            @Valid @RequestBody ProjectModifyReqCTransfer command) {
        projectCommandHandler.modify(command);
        return response().success("项目修改成功");
    }

    @PostMapping("/command/generate")
    @Log(message = "项目生成", value = "#command")
    public ResponseEntity<RestResponse> generate(
            @NotNull(message = "项目生成请求对象不能为空")
            @Valid @RequestBody ProjectGenerateReqCTransfer command) {
        projectCommandHandler.generate(command);
        return response().success("项目生成成功");
    }

    @PostMapping("/query/find_simple_profiles_by_ids")
    @Log(message = "根据ID列表查询项目基本信息列表", value = "#query")
    public ResponseEntity<RestResponse> findSimpleProfilesByIds(
            @NotNull(message = "根据ID列表查询项目基本信息列表请求对象不能为空")
            @Valid @RequestBody ProjectFindByIdsReqQTransfer query) {
        return response().success("根据ID列表查询项目名称列表成功", projectQueryHandler.findSimpleProfilesByIds(query));
    }
}

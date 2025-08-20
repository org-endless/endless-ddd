package org.endless.ddd.generator.components.generator.service.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.generator.common.model.facade.rest.DDDGeneratorRestController;
import org.endless.ddd.generator.components.generator.service.application.command.handler.ServiceCommandHandler;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceGenerateReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.query.handler.ServiceQueryHandler;
import org.endless.ddd.generator.components.generator.service.application.query.transfer.ServiceFindByProjectIdReqQTransferReq;
import org.endless.ddd.generator.components.generator.service.application.query.transfer.ServiceFindSimpleProfilesRespQTransfer;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ServiceRestController
 * <p>
 * 服务领域Rest控制器
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
@RequestMapping("/generator/service")
public class ServiceRestController implements DDDGeneratorRestController {

    /**
     * 服务领域命令处理器
     */
    private final ServiceCommandHandler serviceCommandHandler;

    /**
     * 服务领域查询处理器
     */
    private final ServiceQueryHandler serviceQueryHandler;

    public ServiceRestController(ServiceCommandHandler serviceCommandHandler, ServiceQueryHandler serviceQueryHandler) {
        this.serviceCommandHandler = serviceCommandHandler;
        this.serviceQueryHandler = serviceQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "服务创建", value = "#command")
    public ResponseEntity<RestResponse<Void>> create(
            @NotNull(message = "服务创建请求对象不能为空")
            @Valid @RequestBody ServiceCreateReqCTransfer command) {
        serviceCommandHandler.create(command);
        return response().success("服务创建执行成功");
    }


    @PostMapping("/command/remove")
    @Log(message = "服务删除", value = "#command")
    public ResponseEntity<RestResponse<Void>> remove(
            @NotNull(message = "服务删除请求对象不能为空")
            @Valid @RequestBody ServiceRemoveReqCTransfer command) {
        serviceCommandHandler.remove(command);
        return response().success("服务删除执行成功");
    }

    @PostMapping("/command/modify")
    @Log(message = "服务修改", value = "#command")
    public ResponseEntity<RestResponse<Void>> modify(
            @NotNull(message = "服务修改请求对象不能为空")
            @Valid @RequestBody ServiceModifyReqCTransfer command) {
        serviceCommandHandler.modify(command);
        return response().success("服务修改执行成功");
    }

    @PostMapping("/command/generate")
    @Log(message = "服务生成", value = "#command")
    public ResponseEntity<RestResponse<Void>> generate(
            @NotNull(message = "服务生成请求对象不能为空")
            @Valid @RequestBody ServiceGenerateReqCTransfer command) {
        serviceCommandHandler.generate(command);
        return response().success("服务生成成功");
    }

    @PostMapping("/query/find_simple_profiles_by_project_id")
    @Log(message = "根据项目ID查询项目基本信息列表", value = "#query")
    public ResponseEntity<RestResponse<ServiceFindSimpleProfilesRespQTransfer>> findSimpleProfilesByProjectId(
            @NotNull(message = "根据项目ID查询项目基本信息列表请求对象不能为空")
            @Valid @RequestBody ServiceFindByProjectIdReqQTransferReq query) {
        return response(serviceQueryHandler.findSimpleProfilesByProjectId(query)).success("根据项目ID查询项目基本信息列表成功");
    }
}

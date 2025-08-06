package org.endless.ddd.generator.components.generator.service.sidecar.rest;

import com.alibaba.fastjson2.JSONException;
import org.endless.ddd.generator.common.model.sidecar.rest.DDDGeneratorRestController;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceGenerateReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.query.transfer.ServiceFindByProjectIdReqQTransfer;
import org.endless.ddd.generator.components.generator.service.facade.adapter.ServiceDrivingAdapter;
import org.endless.ddd.starter.common.config.log.annotation.Log;
import org.endless.ddd.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.starter.common.exception.model.application.query.transfer.QueryReqTransferNullException;
import org.endless.ddd.starter.common.exception.model.sidecar.rest.RestErrorException;
import org.endless.ddd.starter.common.model.sidecar.rest.RestResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/generator/service")
public class ServiceRestController implements DDDGeneratorRestController {

    /**
     * 服务领域主动适配器
     */
    private final ServiceDrivingAdapter serviceDrivingAdapter;

    public ServiceRestController(ServiceDrivingAdapter serviceDrivingAdapter) {
        this.serviceDrivingAdapter = serviceDrivingAdapter;
    }

    @PostMapping("/command/create")
    @Log(message = "服务创建", value = "#command")
    public ResponseEntity<RestResponse> create(@RequestBody ServiceCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ServiceCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("服务创建参数不能为空"));
        try {
            serviceDrivingAdapter.create(command);
            return response().success("服务创建成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("服务创建失败", e);
        }
    }

    @PostMapping("/command/remove")
    @Log(message = "服务删除", value = "#command")
    public ResponseEntity<RestResponse> remove(@RequestBody ServiceRemoveReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ServiceRemoveReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("服务删除参数不能为空"));
        try {
            serviceDrivingAdapter.remove(command);
            return response().success("服务删除成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("服务删除失败", e);
        }
    }

    @PostMapping("/command/modify")
    @Log(message = "服务修改", value = "#command")
    public ResponseEntity<RestResponse> modify(@RequestBody ServiceModifyReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ServiceModifyReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("服务修改参数不能为空"));
        try {
            serviceDrivingAdapter.modify(command);
            return response().success("服务修改成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("服务修改失败", e);
        }
    }

    @PostMapping("/command/generate")
    @Log(message = "服务生成", value = "#command")
    public ResponseEntity<RestResponse> generate(@RequestBody ServiceGenerateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ServiceGenerateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("服务生成参数不能为空"));
        try {
            serviceDrivingAdapter.generate(command);
            return response().success("服务生成成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("服务生成失败", e);
        }
    }

    @PostMapping("/query/find_simple_profiles_by_project_id")
    @Log(message = "根据项目ID查询项目基本信息列表", value = "#query")
    public ResponseEntity<RestResponse> findSimpleProfilesByProjectId(@RequestBody ServiceFindByProjectIdReqQTransfer query) {
        Optional.ofNullable(query)
                .map(ServiceFindByProjectIdReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("根据项目ID查询项目基本信息列表参数不能为空"));
        try {
            return response().success("根据项目ID查询项目基本信息列表成功", serviceDrivingAdapter.findSimpleProfilesByProjectId(query));
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("根据项目ID查询项目基本信息列表失败", e);
        }
    }
}

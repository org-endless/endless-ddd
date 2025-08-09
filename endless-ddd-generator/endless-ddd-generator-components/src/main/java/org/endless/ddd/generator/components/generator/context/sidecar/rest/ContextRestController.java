package org.endless.ddd.generator.components.generator.context.sidecar.rest;

import com.alibaba.fastjson2.JSONException;
import org.endless.ddd.generator.common.model.facade.rest.DDDGeneratorRestController;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.context.application.query.transfer.ContextFindByServiceIdReqQTransfer;
import org.endless.ddd.generator.components.generator.context.facade.adapter.ContextDrivingAdapter;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.ddd.facade.rest.RestResponse;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferNullException;
import org.endless.ddd.starter.common.exception.ddd.sidecar.rest.RestErrorException;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * ContextRestController
 * <p>限界上下文领域Rest控制器
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @author Deng Haozhi
 * @see DDDGeneratorRestController
 * @since 1.0.0
 */
@Lazy
@RestController
@RequestMapping("/generator/context")
public class ContextRestController implements DDDGeneratorRestController {

    /**
     * 限界上下文领域主动适配器
     */
    private final ContextDrivingAdapter contextDrivingAdapter;

    public ContextRestController(ContextDrivingAdapter contextDrivingAdapter) {
        this.contextDrivingAdapter = contextDrivingAdapter;
    }

    @PostMapping("/command/create")
    @Log(message = "限界上下文创建", value = "#command")
    public ResponseEntity<RestResponse> create(@RequestBody ContextCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ContextCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("限界上下文创建参数不能为空"));
        try {
            contextDrivingAdapter.create(command);
            return response().success("限界上下文创建成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("限界上下文创建失败", e);
        }
    }

    @PostMapping("/command/remove")
    @Log(message = "限界上下文删除", value = "#command")
    public ResponseEntity<RestResponse> remove(@RequestBody ContextRemoveReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ContextRemoveReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("限界上下文删除参数不能为空"));
        try {
            contextDrivingAdapter.remove(command);
            return response().success("限界上下文删除成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("限界上下文删除失败", e);
        }
    }

    @PostMapping("/command/modify")
    @Log(message = "限界上下文修改", value = "#command")
    public ResponseEntity<RestResponse> modify(@RequestBody ContextModifyReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ContextModifyReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("限界上下文修改参数不能为空"));
        try {
            contextDrivingAdapter.modify(command);
            return response().success("限界上下文修改成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("限界上下文修改失败", e);
        }
    }

    @PostMapping("/query/find_simple_profiles_by_service_id")
    @Log(message = "根据服务ID查询限界上下文基本信息列表", value = "#query")
    public ResponseEntity<RestResponse> findSimpleProfilesByServiceId(@RequestBody ContextFindByServiceIdReqQTransfer query) {
        Optional.ofNullable(query)
                .map(ContextFindByServiceIdReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("根据项目ID查询限界上下文基本信息列表参数不能为空"));
        try {
            return response().success("根据项目ID查询限界上下文基本信息列表成功", contextDrivingAdapter.findSimpleProfilesByServiceId(query));
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("根据项目ID查询限界上下文基本信息列表失败", e);
        }
    }
}

package org.endless.ddd.generator.components.generator.project.sidecar.rest;

import com.alibaba.fastjson2.JSONException;
import org.endless.ddd.generator.common.model.sidecar.rest.DDDGeneratorRestController;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectGenerateReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.command.transfer.ProjectRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.project.application.query.transfer.ProjectFindByIdsReqQTransfer;
import org.endless.ddd.generator.components.generator.project.facade.adapter.ProjectDrivingAdapter;
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
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/generator/project")
public class ProjectRestController implements DDDGeneratorRestController {

    /**
     * 项目领域主动适配器
     */
    private final ProjectDrivingAdapter projectDrivingAdapter;

    public ProjectRestController(ProjectDrivingAdapter projectDrivingAdapter) {
        this.projectDrivingAdapter = projectDrivingAdapter;
    }

    @PostMapping("/command/create")
    @Log(message = "项目创建", value = "#command")
    public ResponseEntity<RestResponse> create(@RequestBody ProjectCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ProjectCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("项目创建参数不能为空"));
        try {
            projectDrivingAdapter.create(command);
            return response().success("项目创建成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("项目创建失败", e);
        }
    }

    @PostMapping("/command/remove")
    @Log(message = "项目删除", value = "#command")
    public ResponseEntity<RestResponse> remove(@RequestBody ProjectRemoveReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ProjectRemoveReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("项目删除参数不能为空"));
        try {
            projectDrivingAdapter.remove(command);
            return response().success("项目删除成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("项目删除失败", e);
        }
    }

    @PostMapping("/command/modify")
    @Log(message = "项目修改", value = "#command")
    public ResponseEntity<RestResponse> modify(@RequestBody ProjectModifyReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ProjectModifyReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("项目修改参数不能为空"));
        try {
            projectDrivingAdapter.modify(command);
            return response().success("项目修改成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("项目修改失败", e);
        }
    }

    @PostMapping("/command/generate")
    @Log(message = "项目生成", value = "#command")
    public ResponseEntity<RestResponse> generate(@RequestBody ProjectGenerateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ProjectGenerateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("项目生成参数不能为空"));
        try {
            projectDrivingAdapter.generate(command);
            return response().success("项目生成成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("项目生成失败", e);
        }
    }

    @PostMapping("/query/find_simple_profiles_by_ids")
    @Log(message = "根据ID列表查询项目基本信息列表", value = "#query")
    public ResponseEntity<RestResponse> findSimpleProfilesByIds(@RequestBody ProjectFindByIdsReqQTransfer query) {
        Optional.ofNullable(query)
                .map(ProjectFindByIdsReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("根据ID列表查询项目名称列表参数不能为空"));
        try {
            return response().success("根据ID列表查询项目名称列表成功", projectDrivingAdapter.findSimpleProfilesByIds(query));
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("根据ID列表查询项目名称列表失败", e);
        }
    }
}

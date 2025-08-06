<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="domain" type="org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign domainPackage = "${servicePackage}.${domain.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${domainPackage}.sidecar.rest;

import com.alibaba.fastjson2.JSONException;
import ${domainPackage}.common.model.sidecar.rest.${domain.getName()}RestController;
import ${domainPackage}.application.command.transfer.${domain.getName()}CreateReqCTransfer;
import ${domainPackage}.application.command.transfer.${domain.getName()}ModifyReqCTransfer;
import ${domainPackage}.facade.adapter.${domain.getName()}DrivingAdapter;
import ${endlessPackage}.config.log.annotation.Log;
import ${endlessPackage}.exception.model.application.command.transfer.CommandReqTransferNullException;
import ${endlessPackage}.exception.model.sidecar.rest.RestErrorException;
import ${endlessPackage}.model.sidecar.rest.RestResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * ${domain.getName()}RestController
 * <p>
 * ${domain.getDescription()}领域Rest控制器
 * <p>
 * create ${domain.getCreateAt()}
 * <p>
 * update ${domain.getModifyAt()}
 *
 * @author ${domain.getAuthor()}
 * @see ${domain.getName()}RestController
 * @since ${domain.getVersion()}
 */
@Lazy
@RestController
@RequestMapping("/generator/${domain.getName()?lower_case}")
public class ${domain.getName()}RestController implements ${domain.getName()}RestController {

    /**
     * ${domain.getName()}领域主动适配器
     */
    private final ${domain.getName()}DrivingAdapter ${domain.getName()?uncap_first}DrivingAdapter;

    public ${domain.getName()}RestController(${domain.getName()}DrivingAdapter ${domain.getName()?uncap_first}DrivingAdapter) {
        this.${domain.getName()?uncap_first}DrivingAdapter = ${domain.getName()?uncap_first}DrivingAdapter;
    }

    @PostMapping("/command/create")
    @Log(message = "${domain.getName()}创建", value = "#command")
    public ResponseEntity<RestResponse> create(@RequestBody ${domain.getName()}CreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(${domain.getName()}CreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("${domain.getName()}创建参数不能为空"));
        try {
            ${domain.getName()?uncap_first}DrivingAdapter.create(command);
            return response().success("${domain.getName()}创建成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("${domain.getName()}创建失败", e);
        }
    }

    @PostMapping("/command/modify")
    @Log(message = "${domain.getName()}修改", value = "#command")
    public ResponseEntity<RestResponse> modify(@RequestBody ${domain.getName()}ModifyReqCTransfer command) {
        Optional.ofNullable(command)
                .map(${domain.getName()}ModifyReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("${domain.getName()}修改参数不能为空"));
        try {
            ${domain.getName()?uncap_first}DrivingAdapter.modify(command);
            return response().success("${domain.getName()}修改成功");
        } catch (JSONException | NullPointerException e) {
            throw new RestErrorException("${domain.getName()}修改失败", e);
        }
    }
} 

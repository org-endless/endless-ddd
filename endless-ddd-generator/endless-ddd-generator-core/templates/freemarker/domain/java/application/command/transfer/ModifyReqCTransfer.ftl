<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="domain" type="org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign domainPackage = "${servicePackage}.${domain.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${domainPackage}.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import ${domainPackage}.common.model.application.command.transfer.${domain.getName()}CommandTransfer;

/**
 * ${domain.getName()}ModifyReqCTransfer
 * <p>${domain.getDescription()}修改命令请求传输对象
 * <p>
 * create ${domain.getCreateAt()}
 * <p>
 * update ${domain.getModifyAt()}
 *
 * @param name        ${domain.getName()}名称
 * @param description ${domain.getName()}描述
 * @param version     ${domain.getName()}版本号
 * @param author      ${domain.getName()}作者
 * @author ${domain.getAuthor()}
 * @see ${domain.getName()}CommandTransfer
 * @since ${domain.getVersion()}
 */
@Builder
@JSONType(orders = {"name", "description", "version", "author"})
public record ${domain.getName()}ModifyReqCTransfer(
        String name, String description, String version, String author) implements ${domain.getName()}CommandTransfer {

    @Override
    public ${domain.getName()}ModifyReqCTransfer validate() {
        return this;
    }
} 

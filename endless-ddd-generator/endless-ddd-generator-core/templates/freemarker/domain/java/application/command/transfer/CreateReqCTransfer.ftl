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
import ${endlessPackage}.exception.model.application.command.transfer.CommandTransferValidateException;
import org.springframework.util.StringUtils;

/**
 * ${domain.getName()}CreateReqCTransfer
 * <p>${domain.getDescription()}创建命令请求传输对象
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
public record ${domain.getName()}CreateReqCTransfer(
        String name, String description, String version, String author) implements ${domain.getName()}CommandTransfer {

    @Override
    public ${domain.getName()}CreateReqCTransfer validate() {
        validateName();
        validateDescription();
        validateVersion();
        validateAuthor();
        return this;
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new CommandTransferValidateException("${domain.getName()}名称不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new CommandTransferValidateException("${domain.getName()}描述不能为空");
        }
    }

    private void validateVersion() {
        if (!StringUtils.hasText(version)) {
            throw new CommandTransferValidateException("${domain.getName()}版本号不能为空");
        }
    }

    private void validateAuthor() {
        if (!StringUtils.hasText(author)) {
            throw new CommandTransferValidateException("${domain.getName()}作者不能为空");
        }
    }
} 

<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="domain" type="org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign domainPackage = "${servicePackage}.${domain.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${domainPackage}.application.command.handler.impl;

import ${domainPackage}.application.command.handler.${domain.getName()}CommandHandler;
import ${domainPackage}.application.command.transfer.${domain.getName()}CreateReqCTransfer;
import ${domainPackage}.application.command.transfer.${domain.getName()}ModifyReqCTransfer;
import ${domainPackage}.domain.anticorruption.${domain.getName()}DrivenAdapter;
import ${domainPackage}.domain.anticorruption.${domain.getName()}Repository;
import ${domainPackage}.domain.entity.${domain.getName()}Aggregate;
import ${endlessPackage}.config.log.annotation.Log;
import ${endlessPackage}.config.log.type.LogLevel;
import ${endlessPackage}.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * ${domain.getName()}CommandHandlerImpl
 * <p>${domain.getDescription()}领域命令处理器
 * <p>
 * create ${domain.getCreateAt()}
 * <p>
 * update ${domain.getModifyAt()}
 *
 * @author ${domain.getAuthor()}
 * @see ${domain.getName()}CommandHandler
 * @since ${domain.getVersion()}
 */
public class ${domain.getName()}CommandHandlerImpl implements ${domain.getName()}CommandHandler {

    /**
     * ${domain.getName()}仓储
     */
    private final ${domain.getName()}Repository ${domain.getName()?uncap_first}Repository;

    /**
     * ${domain.getName()}被动适配器
     */
    private final ${domain.getName()}DrivenAdapter ${domain.getName()?uncap_first}DrivenAdapter;

    public ${domain.getName()}CommandHandlerImpl(${domain.getName()}Repository ${domain.getName()?uncap_first}Repository, ${domain.getName()}DrivenAdapter ${domain.getName()?uncap_first}DrivenAdapter) {
        this.${domain.getName()?uncap_first}Repository = ${domain.getName()?uncap_first}Repository;
        this.${domain.getName()?uncap_first}DrivenAdapter = ${domain.getName()?uncap_first}DrivenAdapter;
    }

    @Override
    @Transactional
    @Log(message = "${domain.getName()}创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(${domain.getName()}CreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(${domain.getName()}CreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("${domain.getName()}创建命令参数不能为空"));

        ${domain.getName()}Aggregate aggregate = ${domain.getName()}Aggregate.create(${domain.getName()}Aggregate.builder()
                .name(command.name())
                .description(command.description())
                .version(command.version())
                .author(command.author())
                .createUserId(DDD_SIMPLIFIED_GENERATOR_USER_ID));
        ${domain.getName()?uncap_first}Repository.save(aggregate);
        // ${domain.getName()}相关文件生成
        ${domain.getName()?uncap_first}DrivenAdapter.freemarker(aggregate, "${domain.getName()?lower_case}.java", "domain/${domain.getName()}.ftl");
    }

    @Override
    public void modify(${domain.getName()}ModifyReqCTransfer command) {

    }
} 

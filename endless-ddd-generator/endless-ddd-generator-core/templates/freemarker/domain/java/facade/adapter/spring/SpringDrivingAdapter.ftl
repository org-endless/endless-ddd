<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="domain" type="org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign domainPackage = "${servicePackage}.${domain.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${domainPackage}.facade.adapter.spring;

import ${domainPackage}.application.command.handler.${domain.getName()}CommandHandler;
import ${domainPackage}.application.command.transfer.${domain.getName()}CreateReqCTransfer;
import ${domainPackage}.application.command.transfer.${domain.getName()}ModifyReqCTransfer;
import ${domainPackage}.application.query.handler.${domain.getName()}QueryHandler;
import ${domainPackage}.facade.adapter.${domain.getName()}DrivingAdapter;

/**
 * Spring${domain.getName()}DrivingAdapter
 * <p>${domain.getDescription()}领域主动适配器Spring实现类
 * <p>
 * create ${domain.getCreateAt()}
 * <p>
 * update ${domain.getModifyAt()}
 *
 * @param ${domain.getName()?uncap_first}CommandHandler ${domain.getName()}领域命令处理器
 * @param ${domain.getName()?uncap_first}QueryHandler   ${domain.getName()}领域查询处理器
 * @author ${domain.getAuthor()}
 * @see ${domain.getName()}DrivingAdapter
 * @since ${domain.getVersion()}
 */
public class Spring${domain.getName()}DrivingAdapter implements ${domain.getName()}DrivingAdapter {

    /**
     * ${domain.getName()}领域命令处理器
     */
    private final ${domain.getName()}CommandHandler ${domain.getName()?uncap_first}CommandHandler;

    /**
     * ${domain.getName()}领域查询处理器
     */
    private final ${domain.getName()}QueryHandler ${domain.getName()?uncap_first}QueryHandler;

    public Spring${domain.getName()}DrivingAdapter(${domain.getName()}CommandHandler ${domain.getName()?uncap_first}CommandHandler, ${domain.getName()}QueryHandler ${domain.getName()?uncap_first}QueryHandler) {
        this.${domain.getName()?uncap_first}CommandHandler = ${domain.getName()?uncap_first}CommandHandler;
        this.${domain.getName()?uncap_first}QueryHandler = ${domain.getName()?uncap_first}QueryHandler;
    }

    @Override
    public void create(${domain.getName()}CreateReqCTransfer command) {
        ${domain.getName()?uncap_first}CommandHandler.create(command);
    }

    @Override
    public void modify(${domain.getName()}ModifyReqCTransfer command) {
        ${domain.getName()?uncap_first}CommandHandler.modify(command);
    }
} 

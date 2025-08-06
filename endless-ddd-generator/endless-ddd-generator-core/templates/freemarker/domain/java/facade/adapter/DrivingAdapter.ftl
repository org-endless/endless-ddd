<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="domain" type="org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign domainPackage = "${servicePackage}.${domain.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${domainPackage}.facade.adapter;

import ${domainPackage}.common.model.facade.adapter.${domain.getName()}DrivingAdapter;
import ${domainPackage}.application.command.transfer.${domain.getName()}CreateReqCTransfer;
import ${domainPackage}.application.command.transfer.${domain.getName()}ModifyReqCTransfer;

/**
 * ${domain.getName()}DrivingAdapter
 * <p>${domain.getDescription()}领域主动适配器
 * <p>
 * create ${domain.getCreateAt()}
 * <p>
 * update ${domain.getModifyAt()}
 *
 * @author ${domain.getAuthor()}
 * @see ${domain.getName()}DrivingAdapter
 * @since ${domain.getVersion()}
 */
public interface ${domain.getName()}DrivingAdapter extends ${domain.getName()}DrivingAdapter {

    void create(${domain.getName()}CreateReqCTransfer command);

    void modify(${domain.getName()}ModifyReqCTransfer command);

} 

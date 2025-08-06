<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="domain" type="org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign domainPackage = "${servicePackage}.${domain.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${servicePackage}.application.command.handler;

import ${servicePackage}.common.model.application.command.handler.${service.getName()}CommandHandler;
import ${domainPackage}.application.command.transfer.*;
import ${domainPackage}.domain.entity.*;

/**
 * ${domain.getName()}CommandHandler
 * <p>${domain.getDescription()}领域命令处理器
 * <p>
 * create ${domain.getCreateAt()}
 * <p>
 * update ${domain.getModifyAt()}
 *
 * @author ${domain.getAuthor()}
 * @see ${service.getName()}CommandHandler
 * @since ${domain.getVersion()}
 */
public interface ${domain.getName()}CommandHandler extends ${service.getName()}CommandHandler&lt;${domain.getName()}Aggregate&gt; {


} 

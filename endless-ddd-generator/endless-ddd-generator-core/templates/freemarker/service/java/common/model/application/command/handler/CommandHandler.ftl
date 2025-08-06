<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${servicePackage}.application.command.handler;

import ${servicePackage}.domain.entity.${service.getName()}Aggregate;
import ${endlessPackage}.application.command.handler.CommandHandler;

/**
 * ${service.getName()}CommandHandler
 * <p>
 * create ${service.getCreateAt()}
 * <p>
 * update ${service.getModifyAt()}
 *
 * @author ${service.getAuthor()}
 * @see CommandHandler
 * @since ${service.getVersion()}
 */
public interface ${service.getName()}CommandHandler&lt;A extends ${service.getName()}Aggregate&gt;
        extends CommandHandler&lt;A&gt; {

}

<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${servicePackage}.domain.anticorruption;

import ${servicePackage}.domain.entity.${service.getName()}Aggregate;
import ${endlessPackage}.domain.anticorruption.Repository;

/**
 * ${service.getName()}Repository
 * <p>
 * create ${service.getCreateAt()}
 * <p>
 * update ${service.getModifyAt()}
 *
 * @author ${service.getAuthor()}
 * @see Repository
 * @since ${service.getVersion()}
 */
public interface ${service.getName()}Repository&lt;A extends ${service.getName()}Aggregate&gt; extends Repository&lt;A&gt; {

}

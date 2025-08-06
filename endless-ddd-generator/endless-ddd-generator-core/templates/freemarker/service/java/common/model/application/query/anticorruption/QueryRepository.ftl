<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${servicePackage}.application.query.anticorruption;

import ${servicePackage}.domain.entity.${service.getName()}Entity;
import ${endlessPackage}.application.query.anticorruption.QueryRepository;

/**
 * ${service.getName()}QueryRepository
 * <p>
 * create ${service.getCreateAt()}
 * <p>
 * update ${service.getModifyAt()}
 *
 * @author ${service.getAuthor()}
 * @see QueryRepository
 * @since ${service.getVersion()}
 */
public interface ${service.getName()}QueryRepository&lt;E extends ${service.getName()}Entity&gt; extends QueryRepository&lt;E&gt; {

}

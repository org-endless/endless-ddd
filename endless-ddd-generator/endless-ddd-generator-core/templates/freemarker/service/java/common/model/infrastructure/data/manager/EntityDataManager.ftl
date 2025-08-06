<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${servicePackage}.infrastructure.data.manager;

import ${servicePackage}.application.query.anticorruption.${service.getName()}QueryRepository;
import ${servicePackage}.domain.entity.${service.getName()}Entity;
import ${servicePackage}.infrastructure.data.record.${service.getName()}Record;
import ${endlessPackage}.infrastructure.data.manager.EntityDataManager;

/**
 * ${service.getName()}EntityDataManager
 * <p>
 * create ${service.getCreateAt()}
 * <p>
 * update ${service.getModifyAt()}
 *
 * @author ${service.getAuthor()}
 * @see ${service.getName()}QueryRepository
 * @see EntityDataManager
 * @since ${service.getVersion()}
 */
public interface ${service.getName()}EntityDataManager&lt;R extends ${service.getName()}Record&lt;E&gt;, E extends ${service.getName()}Entity&gt;
        extends ${service.getName()}QueryRepository&lt;E&gt;, EntityDataManager&lt;R, E&gt; {

} 

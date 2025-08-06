<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${servicePackage}.infrastructure.data.manager;

import ${servicePackage}.application.query.anticorruption.${service.getName()}QueryRepository;
import ${servicePackage}.domain.anticorruption.${service.getName()}Repository;
import ${servicePackage}.domain.entity.${service.getName()}Aggregate;
import ${servicePackage}.infrastructure.data.record.${service.getName()}Record;
import ${endlessPackage}.infrastructure.data.manager.DataManager;

/**
 * ${service.getName()}DataManager
 * <p>
 * create ${service.getCreateAt()}
 * <p>
 * update ${service.getModifyAt()}
 *
 * @author ${service.getAuthor()}
 * @see ${service.getName()}Repository
 * @see ${service.getName()}QueryRepository
 * @see AggregateDataManager
 * @since ${service.getVersion()}
 */
public interface ${service.getName()}AggregateDataManager&lt;R extends ${service.getName()}Record&lt;A&gt;, A extends ${service.getName()}Aggregate&gt;
        extends ${service.getName()}Repository&lt;A&gt;, ${service.getName()}QueryRepository&lt;A&gt;, AggregateDataManager&lt;R, A&gt; {

} 

<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${servicePackage}.infrastructure.data.record;

import ${servicePackage}.domain.entity.${service.getName()}Entity;
import ${endlessPackage}.infrastructure.data.record.DataRecord;

/**
 * ${service.getName()}Record
 * <p>
 * create ${service.getCreateAt()}
 * <p>
 * update ${service.getModifyAt()}
 *
 * @author ${service.getAuthor()}
 * @see DataRecord
 * @since ${service.getVersion()}
 */
public interface ${service.getName()}Record&lt;E extends ${service.getName()}Entity&gt;
        extends DataRecord&lt;E&gt; {

} 

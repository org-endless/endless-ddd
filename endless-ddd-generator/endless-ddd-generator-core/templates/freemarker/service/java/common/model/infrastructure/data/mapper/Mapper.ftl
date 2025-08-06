<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${servicePackage}.infrastructure.data.mapper;

import ${servicePackage}.domain.entity.${service.getName()}Entity;
import ${servicePackage}.infrastructure.data.record.${service.getName()}Record;
import ${endlessPackage}.infrastructure.data.persistence.mapper.DataMapper;

/**
 * ${service.getName()}Mapper
 * <p>
 * create ${service.getCreateAt()}
 * <p>
 * update ${service.getModifyAt()}
 *
 * @author ${service.getAuthor()}
 * @see DataMapper
 * @since ${service.getVersion()}
 */
public interface ${service.getName()}Mapper&lt;R extends ${service.getName()}Record&lt;? extends ${service.getName()}Entity&gt;&gt;
        extends DataMapper&lt;R&gt; {

} 

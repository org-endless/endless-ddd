<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="domain" type="org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign domainPackage = "${servicePackage}.${domain.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${domainPackage}.domain.anticorruption;

import ${domainPackage}.common.model.domain.anticorruption.${domain.getName()}DrivenAdapter;
import ${domainPackage}.domain.entity.${domain.getName()}Aggregate;

/**
 * ${domain.getName()}DrivenAdapter
 * <p>
 * create ${domain.getCreateAt()}
 * <p>
 * update ${domain.getModifyAt()}
 *
 * @author ${domain.getAuthor()}
 * @see ${domain.getName()}DrivenAdapter
 * @since ${domain.getVersion()}
 */
public interface ${domain.getName()}DrivenAdapter extends ${domain.getName()}DrivenAdapter {

    void freemarker(${domain.getName()}Aggregate aggregate, String fileName, String templateFileName);
} 

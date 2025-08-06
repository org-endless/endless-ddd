<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="domain" type="org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign domainPackage = "${servicePackage}.${domain.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${domainPackage}.infrastructure.data.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import ${domainPackage}.common.model.infrastructure.data.mapper.${domain.getName()}Mapper;
import ${domainPackage}.infrastructure.data.record.${domain.getName()}Record;
import org.springframework.context.annotation.Lazy;

/**
 * ${domain.getName()}Mapper
 * <p>${domain.getDescription()}聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create ${domain.getCreateAt()}
 * <p>
 * update ${domain.getModifyAt()}
 *
 * @author ${domain.getAuthor()}
 * @see ${domain.getName()}Mapper
 * @since ${domain.getVersion()}
 */
@Lazy
@Mapper
public interface ${domain.getName()}Mapper extends ${domain.getName()}Mapper<${domain.getName()}Record> {

} 

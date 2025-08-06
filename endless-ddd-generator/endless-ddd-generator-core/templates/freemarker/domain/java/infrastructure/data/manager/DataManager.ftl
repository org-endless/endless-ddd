<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="domain" type="org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign domainPackage = "${servicePackage}.${domain.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${domainPackage}.infrastructure.data.manager;

import ${domainPackage}.common.model.infrastructure.data.manager.${domain.getName()}AggregateDataManager;
import ${domainPackage}.application.query.anticorruption.${domain.getName()}QueryRepository;
import ${domainPackage}.domain.anticorruption.${domain.getName()}Repository;
import ${domainPackage}.domain.entity.${domain.getName()}Aggregate;
import ${domainPackage}.infrastructure.data.persistence.mapper.${domain.getName()}Mapper;
import ${domainPackage}.infrastructure.data.record.${domain.getName()}Record;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * ${domain.getName()}DataManager
 * <p>${domain.getDescription()}聚合数据管理器
 * <p>
 * create ${domain.getCreateAt()}
 * <p>
 * update ${domain.getModifyAt()}
 *
 * @author ${domain.getAuthor()}
 * @see ${domain.getName()}Repository
 * @see ${domain.getName()}QueryRepository
 * @see ${domain.getName()}AggregateDataManager
 * @since ${domain.getVersion()}
 */
@Lazy
@Component
public class ${domain.getName()}DataManager implements ${domain.getName()}Repository, ${domain.getName()}QueryRepository, ${domain.getName()}AggregateDataManager<${domain.getName()}Record, ${domain.getName()}Aggregate> {

    /**
     * ${domain.getName()}聚合 Mybatis-Plus 数据访问对象
     */
    private final ${domain.getName()}Mapper ${domain.getName()?uncap_first}Mapper;

    public ${domain.getName()}DataManager(${domain.getName()}Mapper ${domain.getName()?uncap_first}Mapper) {
        this.${domain.getName()?uncap_first}Mapper = ${domain.getName()?uncap_first}Mapper;
    }

    @Override
    public ${domain.getName()}Aggregate save(${domain.getName()}Aggregate aggregate) {
        return null;
    }

    @Override
    public void remove(${domain.getName()}Aggregate aggregate) {

    }

    @Override
    public ${domain.getName()}Aggregate modify(${domain.getName()}Aggregate aggregate) {
        return null;
    }

    @Override
    public Optional<${domain.getName()}Aggregate> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<${domain.getName()}Aggregate> findByIdForUpdate(String id) {
        return Optional.empty();
    }
} 

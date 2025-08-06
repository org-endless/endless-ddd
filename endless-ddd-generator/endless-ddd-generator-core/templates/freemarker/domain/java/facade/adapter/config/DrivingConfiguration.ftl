<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="domain" type="org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign domainPackage = "${servicePackage}.${domain.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${domainPackage}.facade.adapter.config;

import ${domainPackage}.application.command.handler.${domain.getName()}CommandHandler;
import ${domainPackage}.application.command.handler.impl.${domain.getName()}CommandHandlerImpl;
import ${domainPackage}.application.query.handler.${domain.getName()}QueryHandler;
import ${domainPackage}.application.query.handler.impl.${domain.getName()}QueryHandlerImpl;
import ${domainPackage}.domain.anticorruption.${domain.getName()}DrivenAdapter;
import ${domainPackage}.domain.anticorruption.${domain.getName()}Repository;
import ${domainPackage}.facade.adapter.${domain.getName()}DrivingAdapter;
import ${domainPackage}.facade.adapter.spring.Spring${domain.getName()}DrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * ${domain.getName()}DrivingConfiguration
 * <p>${domain.getDescription()}领域主动适配器配置类
 * <p>
 * create ${domain.getCreateAt()}
 * <p>
 * update ${domain.getModifyAt()}
 *
 * @author ${domain.getAuthor()}
 * @since ${domain.getVersion()}
 */
@Lazy
@Configuration
public class ${domain.getName()}DrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean ${domain.getName()}DrivingAdapter spring${domain.getName()}DrivingAdapter(${domain.getName()}CommandHandler commandHandler, ${domain.getName()}QueryHandler queryHandler) {
        return new Spring${domain.getName()}DrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean ${domain.getName()}CommandHandler ${domain.getName()?uncap_first}CommandHandler(${domain.getName()}Repository ${domain.getName()?uncap_first}Repository, ${domain.getName()}DrivenAdapter ${domain.getName()?uncap_first}DrivenAdapter) {
        return new ${domain.getName()}CommandHandlerImpl(${domain.getName()?uncap_first}Repository, ${domain.getName()?uncap_first}DrivenAdapter);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean ${domain.getName()}QueryHandler ${domain.getName()?uncap_first}QueryHandler() {
        return new ${domain.getName()}QueryHandlerImpl();
    }
} 

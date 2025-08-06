<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="domain" type="org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign domainPackage = "${servicePackage}.${domain.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${domainPackage}.infrastructure.adapter.spring;

import freemarker.template.Configuration;
import ${domainPackage}.common.model.infrastructure.adapter.${domain.getName()}ContentDrivenAdapter;
import ${domainPackage}.common.model.infrastructure.adapter.${domain.getName()}FileDrivenAdapter;
import ${domainPackage}.domain.anticorruption.${domain.getName()}DrivenAdapter;
import ${domainPackage}.domain.entity.${domain.getName()}Aggregate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring${domain.getName()}DrivenAdapter
 * <p>
 * create ${domain.getCreateAt()}
 * <p>
 * update ${domain.getModifyAt()}
 *
 * @author ${domain.getAuthor()}
 * @see ${domain.getName()}DrivenAdapter
 * @since ${domain.getVersion()}
 */
@Lazy
@Component
public class Spring${domain.getName()}DrivenAdapter implements ${domain.getName()}DrivenAdapter, ${domain.getName()}ContentDrivenAdapter, ${domain.getName()}FileDrivenAdapter {

    private final Configuration freemarkerConfig;

    public Spring${domain.getName()}DrivenAdapter(Configuration freemarkerConfig) {
        this.freemarkerConfig = freemarkerConfig;
    }

    @Override
    public void freemarker(${domain.getName()}Aggregate aggregate, String fileName, String templateFileName) {
        Map<String, Object> model = new HashMap<>();
        model.put("${domain.getName()?uncap_first}Aggregate", aggregate);
        String content = ${domain.getName()}ContentDrivenAdapter.super.freemarker(freemarkerConfig, model, templateFileName);
        if (StringUtils.hasText(content)) {
            write(aggregate.getRootPath(), content, fileName);
        }
    }
} 

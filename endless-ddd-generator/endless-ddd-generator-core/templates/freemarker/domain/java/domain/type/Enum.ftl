<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="domain" type="org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign domainPackage = "${servicePackage}.${domain.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${domainPackage}.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import ${domainPackage}.common.model.domain.type.${domain.getName()}Enum;
import ${endlessPackage}.exception.model.domain.type.EnumException;

/**
 * ${domain.getName()}Enum
 * <p>
 * create ${domain.getCreateAt()}
 * <p>
 * update ${domain.getModifyAt()}
 *
 * @author ${domain.getAuthor()}
 * @see Enum
 * @see ${domain.getName()}Enum
 * @since ${domain.getVersion()}
 */
@Getter
@AllArgsConstructor
@ToString
public enum ${domain.getName()}Enum implements ${domain.getName()}Enum {

    TYPE1("TYPE1", "类型1"),
    TYPE2("TYPE2", "类型2");

    private final String code;

    private final String description;

    public static ${domain.getName()}Enum fromCode(String code) {
        for (${domain.getName()}Enum type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的${domain.getName()}枚举: " + code);
    }
} 

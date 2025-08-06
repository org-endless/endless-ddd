<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="domain" type="org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign domainPackage = "${servicePackage}.${domain.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${domainPackage}.domain.entity;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import ${domainPackage}.common.model.domain.entity.${domain.getName()}Aggregate;
import ${endlessPackage}.config.utils.id.IdGenerator;
import ${endlessPackage}.exception.model.domain.entity.AggregateRemoveException;
import ${endlessPackage}.exception.model.domain.entity.AggregateValidateException;
import org.springframework.util.StringUtils;

/**
 * ${domain.getName()}Aggregate
 * <p>${domain.getDescription()}聚合根
 * <p>
 * create ${domain.getCreateAt()}
 * <p>
 * update ${domain.getModifyAt()}
 *
 * @author ${domain.getAuthor()}
 * @see ${domain.getName()}Aggregate
 * @since ${domain.getVersion()}
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
@JSONType(orders = {"${domain.getName()?uncap_first}Id", "name", "description", "version", "author", "createUserId", "modifyUserId", "isRemoved"})
public class ${domain.getName()}Aggregate implements ${domain.getName()}Aggregate {

    /**
     * ${domain.getName()}ID
     */
    private final String ${domain.getName()?uncap_first}Id;

    /**
     * ${domain.getName()}名称
     */
    private String name;

    /**
     * ${domain.getName()}描述
     */
    private String description;

    /**
     * ${domain.getName()}版本号
     */
    private String version;

    /**
     * ${domain.getName()}作者
     */
    private String author;

    /**
     * 创建者ID
     */
    private final String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    public static ${domain.getName()}Aggregate create(${domain.getName()}AggregateBuilder builder) {
        return builder
                .${domain.getName()?uncap_first}Id(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public ${domain.getName()}Aggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<${domain.getName()}聚合根>不能再次删除, ID: " + ${domain.getName()?uncap_first}Id);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<${domain.getName()}聚合根>处于不可删除状态, ID: " + ${domain.getName()?uncap_first}Id);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public ${domain.getName()}Aggregate validate() {
        validate${domain.getName()}Id();
        validateName();
        validateDescription();
        validateVersion();
        validateAuthor();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validate${domain.getName()}Id() {
        if (!StringUtils.hasText(${domain.getName()?uncap_first}Id)) {
            throw new AggregateValidateException("${domain.getName()}ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new AggregateValidateException("${domain.getName()}名称不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new AggregateValidateException("${domain.getName()}描述不能为空");
        }
    }

    private void validateVersion() {
        if (!StringUtils.hasText(version)) {
            throw new AggregateValidateException("${domain.getName()}版本号不能为空");
        }
    }

    private void validateAuthor() {
        if (!StringUtils.hasText(author)) {
            throw new AggregateValidateException("${domain.getName()}作者不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new AggregateValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new AggregateValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new AggregateValidateException("是否已删除不能为 null ");
        }
    }
} 

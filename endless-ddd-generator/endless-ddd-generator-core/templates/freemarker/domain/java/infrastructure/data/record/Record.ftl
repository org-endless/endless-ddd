<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="domain" type="org.endless.ddd.generator.components.generator.domain.domain.entity.DomainAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign domainPackage = "${servicePackage}.${domain.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${domainPackage}.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import ${domainPackage}.common.model.infrastructure.data.record.${domain.getName()}Record;
import ${domainPackage}.domain.entity.${domain.getName()}Aggregate;
import ${endlessPackage}.exception.model.infrastructure.data.record.DataRecordValidateException;
import org.springframework.util.StringUtils;

/**
 * ${domain.getName()}Record
 * <p>${domain.getDescription()}数据库记录实体
 * <p>
 * create ${domain.getCreateAt()}
 * <p>
 * update ${domain.getModifyAt()}
 *
 * @author ${domain.getAuthor()}
 * @see ${domain.getName()}Record
 * @since ${domain.getVersion()}
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "generator_${domain.getName()?lower_case}")
public class ${domain.getName()}Record implements ${domain.getName()}Record<${domain.getName()}Aggregate> {

    /**
     * ${domain.getName()}ID
     */
    @TableId
    private String ${domain.getName()?uncap_first}Id;

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
    private String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createAt;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long modifyAt;

    /**
     * 删除时间
     */
    private Long removeAt;

    public static ${domain.getName()}Record from(${domain.getName()}Aggregate aggregate) {
        String ${domain.getName()?uncap_first}Id = aggregate.get${domain.getName()}Id();
        return ${domain.getName()}Record.builder()
                .${domain.getName()?uncap_first}Id(${domain.getName()?uncap_first}Id)
                .name(aggregate.getName())
                .description(aggregate.getDescription())
                .version(aggregate.getVersion())
                .author(aggregate.getAuthor())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public ${domain.getName()}Aggregate to() {
        validate();
        return ${domain.getName()}Aggregate.builder()
                .${domain.getName()?uncap_first}Id(${domain.getName()?uncap_first}Id)
                .name(name)
                .description(description)
                .version(version)
                .author(author)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public ${domain.getName()}Record validate() {
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
            throw new DataRecordValidateException("${domain.getName()}ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new DataRecordValidateException("${domain.getName()}名称不能为空");
        }
    }

    private void validateDescription() {
        if (!StringUtils.hasText(description)) {
            throw new DataRecordValidateException("${domain.getName()}描述不能为空");
        }
    }

    private void validateVersion() {
        if (!StringUtils.hasText(version)) {
            throw new DataRecordValidateException("${domain.getName()}版本号不能为空");
        }
    }

    private void validateAuthor() {
        if (!StringUtils.hasText(author)) {
            throw new DataRecordValidateException("${domain.getName()}作者不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DataRecordValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new DataRecordValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new DataRecordValidateException("是否已删除不能为 null ");
        }
    }
} 

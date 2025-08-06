<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${servicePackage}.sidecar.rest;

import ${endlessPackage}.sidecar.rest.RestController;

/**
 * ${service.getName()}RestController
 * <p>
 * create ${service.getCreateAt()}
 * <p>
 * update ${service.getModifyAt()}
 *
 * @author ${service.getAuthor()}
 * @see RestController
 * @since ${service.getVersion()}
 */
public interface ${service.getName()}RestController extends RestController {

    default ${service.getName()}RestResponse response() {
        return ${service.getName()}RestResponse.builder().build();
    }
} 

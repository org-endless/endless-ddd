<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#assign servicePackage = "${project.getBasePackage()}.${service.getBasePackage()}.common.model">
<#assign endlessPackage = "org.endless.ddd.starter.common.model">
package ${servicePackage}.sidecar.rest;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ${endlessPackage}.sidecar.rest.AbstractRestResponse;

/**
 * ${service.getName()}RestResponse
 * <p>
 * create ${service.getCreateAt()}
 * <p>
 * update ${service.getModifyAt()}
 *
 * @author ${service.getAuthor()}
 * @see AbstractRestResponse
 * @since ${service.getVersion()}
 */
@Getter
@SuperBuilder
public class ${service.getName()}RestResponse extends AbstractRestResponse {

    private static final String SERVICE_DESCRIPTION = "${service.getName()}";

    @Override
    public ${service.getName()}RestResponse createInstance(String status, String errorCode, String message, Object data) {
        return ${service.getName()}RestResponse.builder().status(status).errorCode(errorCode).message(message).data(data).build();
    }

    @Override
    public String getServiceDescription() {
        return SERVICE_DESCRIPTION;
    }
} 

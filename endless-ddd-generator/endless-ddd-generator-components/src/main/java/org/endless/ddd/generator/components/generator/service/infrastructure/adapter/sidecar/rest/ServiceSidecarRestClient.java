package org.endless.ddd.generator.components.generator.service.infrastructure.adapter.sidecar.rest;

import jakarta.validation.constraints.NotBlank;
import org.endless.ddd.generator.common.model.infrastructure.adapter.rest.DDDGeneratorRestClient;

/**
 * ServiceSidecarRestClient
 * <p>
 * create 2025/08/09 23:31
 * <p>
 * update 2025/08/09 23:33
 *
 * @author Deng Haozhi
 * @see DDDGeneratorRestClient
 * @since 1.0.0
 */
public interface ServiceSidecarRestClient extends DDDGeneratorRestClient {

    void projectExistsById(@NotBlank(message = "项目ID不能为空") String projectId);
}

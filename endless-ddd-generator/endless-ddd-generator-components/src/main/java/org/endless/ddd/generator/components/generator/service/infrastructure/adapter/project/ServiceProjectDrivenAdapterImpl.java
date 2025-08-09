package org.endless.ddd.generator.components.generator.service.infrastructure.adapter.project;

import org.endless.ddd.generator.components.generator.service.domain.anticorruption.ServiceProjectDrivenAdapter;
import org.endless.ddd.generator.components.generator.service.infrastructure.adapter.sidecar.rest.ServiceSidecarRestClient;
import org.springframework.stereotype.Component;

/**
 * ServiceProjectDrivenAdapterImpl
 * <p>
 * create 2025/08/09 09:32
 * <p>
 * update 2025/08/09 09:32
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Component
public class ServiceProjectDrivenAdapterImpl implements ServiceProjectDrivenAdapter {

    private final ServiceSidecarRestClient serviceSidecarRestClient;

    public ServiceProjectDrivenAdapterImpl(ServiceSidecarRestClient serviceSidecarRestClient) {
        this.serviceSidecarRestClient = serviceSidecarRestClient;
    }

    @Override
    public void existsById(String projectId) {
        serviceSidecarRestClient.projectExistsById(projectId);
    }
}

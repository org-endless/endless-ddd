package org.endless.ddd.starter.common.config.rest.servlet.undertow;

import io.undertow.server.handlers.resource.ResourceManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

/**
 * UndertowConfiguration
 * <p>
 * create 2025/08/15 02:37
 * <p>
 * update 2025/08/17 04:22
 *
 * @author Deng Haozhi
 * @see WebServerFactoryCustomizer
 * @since 1.0.0
 */
@ConditionalOnClass(io.undertow.Undertow.class)
public class UndertowConfiguration implements WebServerFactoryCustomizer<UndertowServletWebServerFactory> {

    @Override
    public void customize(UndertowServletWebServerFactory factory) {
        factory.addDeploymentInfoCustomizers(deploymentInfo -> {
            deploymentInfo.getWelcomePages().clear();
            deploymentInfo.getErrorPages().clear();
            deploymentInfo.setResourceManager(ResourceManager.EMPTY_RESOURCE_MANAGER);
            deploymentInfo.addInitialHandlerChainWrapper(next -> next);
        });
    }
}

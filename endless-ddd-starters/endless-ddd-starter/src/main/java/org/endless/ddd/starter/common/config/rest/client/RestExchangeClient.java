package org.endless.ddd.starter.common.config.rest.client;

import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.RestClientAdapter;
import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.exchange.RestExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestClient;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * RestExchangeAdapter
 * <p>
 * create 2025/08/25 22:46
 * <p>
 * update 2025/08/25 22:56
 *
 * @author Deng Haozhi
 * @see RestClientAdapter
 * @since 1.0.0
 */
public class RestExchangeClient implements RestClientAdapter {

    @Qualifier("sidecarRestClient")
    private final RestClient restClient;

    public RestExchangeClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public <E extends RestExchange> E exchange(Class<E> exchangeClass) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(org.springframework.web.client.support.RestClientAdapter.create(restClient))
                .build();
        return factory.createClient(exchangeClass);
    }
}

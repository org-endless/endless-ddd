package org.endless.domain.simplified.server.common.handler.exception.rest;

import org.endless.ddd.simplified.starter.common.handler.exception.rest.AbstractRestAdapterExceptionHandler;
import org.endless.domain.simplified.server.common.model.sidecar.rest.DomainSimplifiedServerRestResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * DomainSimplifiedServerRestExceptionHandler
 * <p>
 * create 2024/11/02 06:53
 * <p>
 * update 2024/11/03 14:33
 *
 * @author Deng Haozhi
 * @see AbstractRestAdapterExceptionHandler
 * @since 2.0.0
 */
@RestControllerAdvice
public class DomainSimplifiedServerRestAdapterExceptionHandler extends AbstractRestAdapterExceptionHandler {

    @Override
    public DomainSimplifiedServerRestResponse response() {
        return DomainSimplifiedServerRestResponse.builder().build();
    }
}

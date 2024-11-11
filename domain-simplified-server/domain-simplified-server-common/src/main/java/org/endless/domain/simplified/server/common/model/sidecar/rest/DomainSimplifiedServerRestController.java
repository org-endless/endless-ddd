package org.endless.domain.simplified.server.common.model.sidecar.rest;


import org.endless.ddd.simplified.starter.common.model.sidecar.rest.RestController;

/**
 * DomainSimplifiedServerRestController
 * <p>
 * create 2024/09/06 15:29
 * <p>
 * update 2024/09/11 00:59
 *
 * @author Deng Haozhi
 * @see RestController
 * @since 2.0.0
 */
public interface DomainSimplifiedServerRestController extends RestController {

    default DomainSimplifiedServerRestResponse response() {
        return DomainSimplifiedServerRestResponse.builder().build();
    }
}

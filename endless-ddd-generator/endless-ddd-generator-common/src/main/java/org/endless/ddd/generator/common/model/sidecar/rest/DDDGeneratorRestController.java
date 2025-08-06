package org.endless.ddd.generator.common.model.sidecar.rest;

import org.endless.ddd.starter.common.model.sidecar.rest.RestController;

/**
 * DDDGeneratorRestController
 * <p>
 * create 2024/09/06 15:29
 * <p>
 * update 2024/09/11 00:59
 *
 * @author Deng Haozhi
 * @see RestController
 * @since 1.0.0
 */
public interface DDDGeneratorRestController extends RestController {

    default DDDGeneratorRestResponse response() {
        return DDDGeneratorRestResponse.builder().build();
    }
}

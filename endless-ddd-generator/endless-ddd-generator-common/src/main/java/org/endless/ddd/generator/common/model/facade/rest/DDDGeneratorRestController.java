package org.endless.ddd.generator.common.model.facade.rest;

import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.ddd.common.transfer.RespTransfer;
import org.endless.ddd.starter.common.ddd.facade.rest.RestController;

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

    default <R extends RespTransfer> RestResponse<R> response(R response) {
        return RestResponse.<R>builder().serviceDescription("DDD代码生成器").build();
    }

    default RestResponse<Void> response() {
        return RestResponse.<Void>builder().serviceDescription("DDD代码生成器").build();
    }
}

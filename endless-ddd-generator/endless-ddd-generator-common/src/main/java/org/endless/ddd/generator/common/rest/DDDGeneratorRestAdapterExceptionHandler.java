package org.endless.ddd.generator.common.rest;

import org.endless.ddd.generator.common.model.sidecar.rest.DDDGeneratorRestResponse;
import org.endless.ddd.starter.common.handler.exception.rest.AbstractRestAdapterExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * DDDGeneratorRestExceptionHandler
 * <p>
 * create 2024/11/02 06:53
 * <p>
 * update 2024/11/03 14:33
 *
 * @author Deng Haozhi
 * @see AbstractRestAdapterExceptionHandler
 * @since 1.0.0
 */
@RestControllerAdvice
public class DDDGeneratorRestAdapterExceptionHandler extends AbstractRestAdapterExceptionHandler {

    @Override
    public DDDGeneratorRestResponse response() {
        return DDDGeneratorRestResponse.builder().build();
    }
}

package org.endless.ddd.generator.common.exception.handler;

import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.AbstractRestExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * DDDGeneratorRestExceptionHandler
 * <p>
 * create 2024/11/02 06:53
 * <p>
 * update 2024/11/03 14:33
 *
 * @author Deng Haozhi
 * @see AbstractRestExceptionHandler
 * @since 1.0.0
 */
@RestControllerAdvice
public class DDDGeneratorRestExceptionHandler extends AbstractRestExceptionHandler {

    public RestResponse<Void> response() {
        return RestResponse.<Void>builder().serviceDescription("DDD代码生成器").build();
    }
}

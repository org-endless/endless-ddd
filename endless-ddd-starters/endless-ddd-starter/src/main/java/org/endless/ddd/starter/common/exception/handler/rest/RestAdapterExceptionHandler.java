package org.endless.ddd.starter.common.exception.handler.rest;

import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.handler.common.ExceptionHandler;

/**
 * RestAdapterExceptionHandler
 * <p>
 * create 2024/11/02 05:30
 * <p>
 * update 2024/11/17 16:32
 *
 * @author Deng Haozhi
 * @see ExceptionHandler
 * @since 1.0.0
 */
public interface RestAdapterExceptionHandler extends ExceptionHandler {

    RestResponse response();
}

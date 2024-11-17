package org.endless.ddd.simplified.starter.common.handler.exception.rest;

import org.endless.ddd.simplified.starter.common.handler.exception.common.ExceptionHandler;
import org.endless.ddd.simplified.starter.common.model.sidecar.rest.RestResponse;

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

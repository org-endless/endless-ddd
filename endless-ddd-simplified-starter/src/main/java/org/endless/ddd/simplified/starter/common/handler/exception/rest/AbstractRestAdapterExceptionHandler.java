package org.endless.ddd.simplified.starter.common.handler.exception.rest;

import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.filesystem.FileSystemException;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.MapperException;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.RestBadRequestException;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.RestNotFoundException;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.RestUnauthorizedException;
import org.endless.ddd.simplified.starter.common.model.sidecar.rest.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * AbstractRestAdapterExceptionHandler
 * <p>
 * create 2024/11/02 04:19
 * <p>
 * update 2024/11/02 06:56
 *
 * @author Deng Haozhi
 * @see RestAdapterExceptionHandler
 * @since 1.0.0
 */
@Slf4j
public abstract class AbstractRestAdapterExceptionHandler implements RestAdapterExceptionHandler {

    // TODO 实现策略模式

    @ExceptionHandler(RestUnauthorizedException.class)
    public ResponseEntity<RestResponse> handleRestUnauthorizedException(RestUnauthorizedException e) {
        log.error("[身份认证失败]{}", e.getMessage(), e);
        return response().unauthorized(e.getMessage());
    }

    @ExceptionHandler(RestBadRequestException.class)
    public ResponseEntity<RestResponse> handleRestBadRequestException(RestBadRequestException e) {
        log.error("[请求格式或参数错误]{}", e.getMessage(), e);
        return response().badRequest(e.getMessage());
    }

    @ExceptionHandler(RestNotFoundException.class)
    public ResponseEntity<RestResponse> handleRestNotFoundException(RestNotFoundException e) {
        log.error("[未找到相关数据]{}", e.getMessage(), e);
        return response().notFound(e.getMessage());
    }

    @ExceptionHandler(MapperException.class)
    public ResponseEntity<RestResponse> handleMapperException(MapperException e) {
        log.error("[服务调用异常，状态未知]{}", e.getMessage(), e);
        return response().internalServerError(e.getMessage());
    }

    @ExceptionHandler(FileSystemException.class)
    public ResponseEntity<RestResponse> handleFileSystemException(FileSystemException e) {
        log.error("[服务调用异常，状态未知]{}", e.getMessage(), e);
        return response().internalServerError(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestResponse> handleException(Exception e) {
        log.error("[服务调用失败]{}", e.getMessage(), e);
        return response().error(e.getMessage());
    }
}

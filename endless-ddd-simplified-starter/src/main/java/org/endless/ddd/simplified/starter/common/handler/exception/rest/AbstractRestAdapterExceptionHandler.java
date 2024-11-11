package org.endless.ddd.simplified.starter.common.handler.exception.rest;

import org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper.MapperModifyFailedException;
import org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper.MapperRemoveFailedException;
import org.endless.ddd.simplified.starter.common.exception.sidecar.rest.RestBadRequestException;
import org.endless.ddd.simplified.starter.common.exception.sidecar.rest.RestErrorException;
import org.endless.ddd.simplified.starter.common.exception.sidecar.rest.RestNotFoundException;
import org.endless.ddd.simplified.starter.common.exception.sidecar.rest.RestUnauthorizedException;
import org.endless.ddd.simplified.starter.common.exception.validate.ValidateException;
import org.endless.ddd.simplified.starter.common.model.sidecar.rest.RestResponse;
import lombok.extern.slf4j.Slf4j;
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
 * @since 2.0.0
 */
@Slf4j
public abstract class AbstractRestAdapterExceptionHandler implements RestAdapterExceptionHandler {

    // TODO 实现策略模式
    @ExceptionHandler(RestErrorException.class)
    public ResponseEntity<RestResponse> handleRestErrorException(RestErrorException e) {
        log.error("服务调用失败 : ", e);
        return response().error(e.getMessage());
    }

    @ExceptionHandler(MapperModifyFailedException.class)
    public ResponseEntity<RestResponse> handleMapperModifyFailedException(MapperModifyFailedException e) {
        log.error("服务调用失败 :  ", e);
        return response().error(e.getMessage());
    }

    @ExceptionHandler(MapperRemoveFailedException.class)
    public ResponseEntity<RestResponse> handleMapperRemoveFailedException(MapperRemoveFailedException e) {
        log.error("服务调用失败 : ", e);
        return response().error(e.getMessage());
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity<RestResponse> handleRestErrorException(ValidateException e) {
        log.error("服务调用失败 : ", e);
        return response().error(e.getMessage());
    }

    @ExceptionHandler(RestUnauthorizedException.class)
    public ResponseEntity<RestResponse> handleRestUnauthorizedException(RestUnauthorizedException e) {
        log.error("身份认证失败 : ", e);
        return response().unauthorized(e.getMessage());
    }

    @ExceptionHandler(RestBadRequestException.class)
    public ResponseEntity<RestResponse> handleRestBadRequestException(RestBadRequestException e) {
        log.error("请求格式或参数错误 : ", e);
        return response().badRequest(e.getMessage());
    }

    @ExceptionHandler(RestNotFoundException.class)
    public ResponseEntity<RestResponse> handleRestNotFoundException(RestNotFoundException e) {
        log.error("未找到相关数据 : ", e);
        return response().notFound(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestResponse> handleAllExceptions(Exception e) {
        log.error("服务调用异常，状态未知 : ", e);
        return response().internalServerError(e.getMessage());
    }
}

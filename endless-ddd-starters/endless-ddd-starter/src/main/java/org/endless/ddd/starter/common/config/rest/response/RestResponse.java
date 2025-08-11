package org.endless.ddd.starter.common.config.rest.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.endless.ddd.starter.common.config.error.code.ErrorCode;
import org.endless.ddd.starter.common.ddd.common.Response;
import org.endless.ddd.starter.common.exception.config.rest.RestResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.endless.ddd.starter.common.utils.model.string.StringTools.addBrackets;

/**
 * RestResponse
 * <p>Rest响应
 * <p>Service Mesh Sidecar
 * <p>用于处理对领域外部Rest请求通讯的响应信息
 * <p>
 * create 2024/09/06 13:02
 * <p>
 * update 2024/09/06 13:04
 *
 * @author Deng Haozhi
 * @see Response
 * @since 1.0.0
 */
@Schema(description = "通用的响应格式", name = "Response", implementation = AbstractRestResponse.class)
public interface RestResponse extends Response {

    Logger log = LoggerFactory.getLogger(RestResponse.class);

    RestResponse createInstance(String status, String errorCode, String message, Object data);

    String getErrorCode();

    String getMessage();

    Object getData();

    String getServiceDescription();


    default Object validate() {
        if (getErrorCode() != null && getErrorCode().equals(ErrorCode.of("SUCCESS").getCode())) {
            log.trace("[REST响应成功]: {}", this);
            return getData();
        } else {
            throw new RestResponseException("[REST响应失败]: " + this);
        }
    }

    default ResponseEntity<RestResponse> response(String status, String errorCode, String message, Object data) {
        message = addBrackets(message);
        return new ResponseEntity<>(createInstance(status, errorCode, message, data), HttpStatus.valueOf(Integer.parseInt(status)));
    }

    default ResponseEntity<RestResponse> success() {
        String message = "[" + ErrorCode.of("SUCCESS").getDescription() + "]";
        return response(String.valueOf(HttpStatus.OK.value()), ErrorCode.of("SUCCESS").getCode(), message, null);
    }

    default ResponseEntity<RestResponse> success(String message) {
        message = "[" + ErrorCode.of("SUCCESS").getDescription() + "]" + addBrackets(message);
        return response(String.valueOf(HttpStatus.OK.value()), ErrorCode.of("SUCCESS").getCode(), message, null);
    }

    default ResponseEntity<RestResponse> success(Object data) {
        String message = "[" + ErrorCode.of("SUCCESS").getDescription() + "]";
        return response(String.valueOf(HttpStatus.OK.value()), ErrorCode.of("SUCCESS").getCode(), message, data);
    }

    default ResponseEntity<RestResponse> success(String message, Object data) {
        message = "[" + ErrorCode.of("SUCCESS").getDescription() + "]" + addBrackets(message);
        return response(String.valueOf(HttpStatus.OK.value()), ErrorCode.of("SUCCESS").getCode(), message, data);
    }

    default ResponseEntity<RestResponse> failure(String method, ErrorCode errorCode) {
        String message = "[" + method + "]" + addBrackets(errorCode.getDescription());
        return response(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), errorCode.getCode(), message, null);
    }

    default ResponseEntity<RestResponse> failure(String method, ErrorCode errorCode, String message) {
        message = "[" + method + "]" + addBrackets(message);
        return response(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), errorCode.getCode(), message, null);
    }

    default ResponseEntity<RestResponse> failure(String method, ErrorCode errorCode, Object data) {
        String message = "[" + method + "]" + addBrackets(errorCode.getDescription());
        return response(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), errorCode.getCode(), message, data);
    }

    default ResponseEntity<RestResponse> failure(String method, ErrorCode errorCode, String message, Object data) {
        message = "[" + method + "]" + addBrackets(message);
        return response(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), errorCode.getCode(), message, data);
    }

    default ResponseEntity<RestResponse> unavailable(String method, ErrorCode errorCode) {
        String message = "[" + method + "]" + addBrackets(errorCode.getDescription());
        return response(String.valueOf(HttpStatus.SERVICE_UNAVAILABLE.value()), errorCode.getCode(), message, null);
    }

    default ResponseEntity<RestResponse> unavailable(String method, ErrorCode errorCode, String message) {
        message = "[" + method + "]" + addBrackets(message);
        return response(String.valueOf(HttpStatus.SERVICE_UNAVAILABLE.value()), errorCode.getCode(), message, null);
    }

    default ResponseEntity<RestResponse> unavailable(String method, ErrorCode errorCode, Object data) {
        String message = "[" + method + "]" + addBrackets(errorCode.getDescription());
        return response(String.valueOf(HttpStatus.SERVICE_UNAVAILABLE.value()), errorCode.getCode(), message, data);
    }

    default ResponseEntity<RestResponse> unavailable(String method, ErrorCode errorCode, String message, Object data) {
        message = "[" + method + "]" + addBrackets(message);
        return response(String.valueOf(HttpStatus.SERVICE_UNAVAILABLE.value()), errorCode.getCode(), message, data);
    }

    default ResponseEntity<RestResponse> unauthorized(String method, ErrorCode errorCode) {
        String message = "[" + method + "]" + addBrackets(errorCode.getDescription());
        return response(String.valueOf(HttpStatus.UNAUTHORIZED.value()), errorCode.getCode(), message, null);
    }

    default ResponseEntity<RestResponse> unauthorized(String method, ErrorCode errorCode, String message) {
        message = "[" + method + "]" + addBrackets(message);
        return response(String.valueOf(HttpStatus.UNAUTHORIZED.value()), errorCode.getCode(), message, null);
    }

    default ResponseEntity<RestResponse> unauthorized(String method, ErrorCode errorCode, Object data) {
        String message = "[" + method + "]" + addBrackets(errorCode.getDescription());
        return response(String.valueOf(HttpStatus.UNAUTHORIZED.value()), errorCode.getCode(), message, data);
    }

    default ResponseEntity<RestResponse> unauthorized(String method, ErrorCode errorCode, String message, Object data) {
        message = "[" + method + "]" + addBrackets(message);
        return response(String.valueOf(HttpStatus.UNAUTHORIZED.value()), errorCode.getCode(), message, data);
    }

    default ResponseEntity<RestResponse> badRequest(String method, ErrorCode errorCode) {
        String message = "[" + method + "]" + addBrackets(errorCode.getDescription());
        return response(String.valueOf(HttpStatus.BAD_REQUEST.value()), errorCode.getCode(), message, null);
    }

    default ResponseEntity<RestResponse> badRequest(String method, ErrorCode errorCode, String message) {
        message = "[" + method + "]" + addBrackets(message);
        return response(String.valueOf(HttpStatus.BAD_REQUEST.value()), errorCode.getCode(), message, null);
    }

    default ResponseEntity<RestResponse> badRequest(String method, ErrorCode errorCode, Object data) {
        String message = "[" + method + "]" + addBrackets(errorCode.getDescription());
        return response(String.valueOf(HttpStatus.BAD_REQUEST.value()), errorCode.getCode(), message, data);
    }

    default ResponseEntity<RestResponse> badRequest(String method, ErrorCode errorCode, String message, Object data) {
        message = "[" + method + "]" + addBrackets(message);
        return response(String.valueOf(HttpStatus.BAD_REQUEST.value()), errorCode.getCode(), message, data);
    }

    default ResponseEntity<RestResponse> notFound(String method, ErrorCode errorCode) {
        String message = "[" + method + "]" + addBrackets(errorCode.getDescription());
        return response(String.valueOf(HttpStatus.NOT_FOUND.value()), errorCode.getCode(), message, null);
    }

    default ResponseEntity<RestResponse> notFound(String method, ErrorCode errorCode, String message) {
        message = "[" + method + "]" + addBrackets(message);
        return response(String.valueOf(HttpStatus.NOT_FOUND.value()), errorCode.getCode(), message, null);
    }

    default ResponseEntity<RestResponse> notFound(String method, ErrorCode errorCode, Object data) {
        String message = "[" + method + "]" + addBrackets(errorCode.getDescription());
        return response(String.valueOf(HttpStatus.NOT_FOUND.value()), errorCode.getCode(), message, data);
    }

    default ResponseEntity<RestResponse> notFound(String method, ErrorCode errorCode, String message, Object data) {
        message = "[" + method + "]" + addBrackets(message);
        return response(String.valueOf(HttpStatus.NOT_FOUND.value()), errorCode.getCode(), message, data);
    }

    default ResponseEntity<RestResponse> forbidden(String method, ErrorCode errorCode) {
        String message = "[" + method + "]" + addBrackets(errorCode.getDescription());
        return response(String.valueOf(HttpStatus.FORBIDDEN.value()), errorCode.getCode(), message, null);
    }

    default ResponseEntity<RestResponse> forbidden(String method, ErrorCode errorCode, String message) {
        message = "[" + method + "]" + addBrackets(message);
        return response(String.valueOf(HttpStatus.FORBIDDEN.value()), errorCode.getCode(), message, null);
    }

    default ResponseEntity<RestResponse> forbidden(String method, ErrorCode errorCode, Object data) {
        String message = "[" + method + "]" + addBrackets(errorCode.getDescription());
        return response(String.valueOf(HttpStatus.FORBIDDEN.value()), errorCode.getCode(), message, data);
    }

    default ResponseEntity<RestResponse> forbidden(String method, ErrorCode errorCode, String message, Object data) {
        message = "[" + method + "]" + addBrackets(message);
        return response(String.valueOf(HttpStatus.FORBIDDEN.value()), errorCode.getCode(), message, data);
    }
}

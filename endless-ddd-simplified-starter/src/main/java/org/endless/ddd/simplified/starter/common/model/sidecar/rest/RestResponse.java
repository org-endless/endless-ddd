package org.endless.ddd.simplified.starter.common.model.sidecar.rest;

import org.endless.ddd.simplified.starter.common.model.common.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * RestResponse
 * <p>Service Mesh Sidecar
 * <p>Rest通讯响应信息模版
 * <p>
 * create 2024/09/06 13:02
 * <p>
 * update 2024/09/06 13:04
 *
 * @author Deng Haozhi
 * @see Response
 * @since 1.0.0
 */
public interface RestResponse extends Response {

    Logger log = LoggerFactory.getLogger(RestResponse.class);

    String DEFAULT_SUCCESS_MSG = "服务调用成功";
    String DEFAULT_PAGE_SUCCESS_MSG = "分页查询服务调用成功";
    String DEFAULT_ERROR_MSG = "服务调用失败";
    String DEFAULT_UNAUTHORIZED_MSG = "身份认证失败";
    String DEFAULT_BAD_REQUEST_MSG = "请求格式或参数错误";
    String DEFAULT_NOT_FOUND_MSG = "未找到相关数据";
    String DEFAULT_INTERNAL_SERVER_ERROR_MSG = "服务调用异常，状态未知";

    String DEFAULT_DATA_NULL_MSG = "返回数据为空";
    String DEFAULT_UNKNOWN_ERROR_MSG = "未知Rest响应异常";

    RestResponse createInstance(int code, String msg, Object data);

    RestResponse createInstance(int code, String msg, List<Object> rows, Long total);

    String getServiceDescription();

    default ResponseEntity<RestResponse> response(int code, String msg, Object data) {

        if (code < 100 || code > 599) {
            code = 400; // 设置默认值为 400
            msg = "[" + getServiceDescription() + "]" + DEFAULT_ERROR_MSG;
        } else {
            msg = "[" + getServiceDescription() + "]" + msg;
        }

        if (data != null) {
            log.trace(data.toString());
        }

        return new ResponseEntity<>(createInstance(code, msg, data), HttpStatus.valueOf(code));
    }


    default ResponseEntity<RestResponse> page(List<Object> rows, Long total) {
        return page(RestResponse.DEFAULT_PAGE_SUCCESS_MSG, rows, total);
    }


    default ResponseEntity<RestResponse> page(String msg, List<Object> rows, Long total) {
        msg = "[" + getServiceDescription() + "]" + msg;
        log.trace(rows.toString());
        return new ResponseEntity<>(createInstance(HttpStatus.OK.value(), msg, rows, total), HttpStatus.OK);
    }

    default ResponseEntity<RestResponse> success() {
        return response(HttpStatus.OK.value(), "[" + DEFAULT_SUCCESS_MSG + "]", null);
    }

    default ResponseEntity<RestResponse> success(String msg) {
        return response(HttpStatus.OK.value(), "[" + DEFAULT_SUCCESS_MSG + "]" + msg, null);
    }

    default ResponseEntity<RestResponse> success(Object data) {
        return response(HttpStatus.OK.value(), "[" + DEFAULT_SUCCESS_MSG + "]", data);
    }

    default ResponseEntity<RestResponse> success(String msg, Object data) {
        return response(HttpStatus.OK.value(), "[" + DEFAULT_SUCCESS_MSG + "]" + msg, data);
    }

    default ResponseEntity<RestResponse> error() {
        return response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[" + DEFAULT_ERROR_MSG + "]", null);
    }

    default ResponseEntity<RestResponse> error(String msg) {
        return response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[" + DEFAULT_ERROR_MSG + "]" + msg, null);
    }

    default ResponseEntity<RestResponse> error(Object data) {
        return response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[" + DEFAULT_ERROR_MSG + "]", data);
    }

    default ResponseEntity<RestResponse> error(String msg, Object data) {
        return response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[" + DEFAULT_ERROR_MSG + "]" + msg, data);
    }

    default ResponseEntity<RestResponse> unauthorized() {
        return response(HttpStatus.UNAUTHORIZED.value(), "[" + DEFAULT_UNAUTHORIZED_MSG + "]", null);
    }

    default ResponseEntity<RestResponse> unauthorized(String msg) {
        return response(HttpStatus.UNAUTHORIZED.value(), "[" + DEFAULT_UNAUTHORIZED_MSG + "]" + msg, null);
    }

    default ResponseEntity<RestResponse> unauthorized(Object data) {
        return response(HttpStatus.UNAUTHORIZED.value(), "[" + DEFAULT_UNAUTHORIZED_MSG + "]", data);
    }

    default ResponseEntity<RestResponse> unauthorized(String msg, Object data) {
        return response(HttpStatus.UNAUTHORIZED.value(), "[" + DEFAULT_UNAUTHORIZED_MSG + "]" + msg, data);
    }

    default ResponseEntity<RestResponse> badRequest() {
        return response(HttpStatus.BAD_REQUEST.value(), "[" + DEFAULT_BAD_REQUEST_MSG + "]", null);
    }

    default ResponseEntity<RestResponse> badRequest(String msg) {
        return response(HttpStatus.BAD_REQUEST.value(), "[" + DEFAULT_BAD_REQUEST_MSG + "]" + msg, null);
    }

    default ResponseEntity<RestResponse> badRequest(Object data) {
        return response(HttpStatus.BAD_REQUEST.value(), "[" + DEFAULT_BAD_REQUEST_MSG + "]", data);
    }

    default ResponseEntity<RestResponse> badRequest(String msg, Object data) {
        return response(HttpStatus.BAD_REQUEST.value(), "[" + DEFAULT_BAD_REQUEST_MSG + "]" + msg, data);
    }

    default ResponseEntity<RestResponse> notFound() {
        return response(HttpStatus.NOT_FOUND.value(), "[" + DEFAULT_NOT_FOUND_MSG + "]", null);
    }

    default ResponseEntity<RestResponse> notFound(String msg) {
        return response(HttpStatus.NOT_FOUND.value(), "[" + DEFAULT_NOT_FOUND_MSG + "]" + msg, null);
    }

    default ResponseEntity<RestResponse> notFound(Object data) {
        return response(HttpStatus.NOT_FOUND.value(), "[" + DEFAULT_NOT_FOUND_MSG + "]", data);
    }

    default ResponseEntity<RestResponse> notFound(String msg, Object data) {
        return response(HttpStatus.NOT_FOUND.value(), "[" + DEFAULT_NOT_FOUND_MSG + "]" + msg, data);
    }

    default ResponseEntity<RestResponse> internalServerError() {
        return response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[" + DEFAULT_INTERNAL_SERVER_ERROR_MSG + "]", null);
    }

    default ResponseEntity<RestResponse> internalServerError(String msg) {
        return response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[" + DEFAULT_INTERNAL_SERVER_ERROR_MSG + "]" + msg, null);
    }

    default ResponseEntity<RestResponse> internalServerError(Object data) {
        return response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[" + DEFAULT_INTERNAL_SERVER_ERROR_MSG + "]", data);
    }

    default ResponseEntity<RestResponse> internalServerError(String msg, Object data) {
        return response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[" + DEFAULT_INTERNAL_SERVER_ERROR_MSG + "]" + msg, data);
    }
}

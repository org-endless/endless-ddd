package org.endless.ddd.starter.common.config.rest.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.ddd.common.Response;
import org.endless.ddd.starter.common.exception.config.rest.RestServerResponseFailedException;
import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

import static org.endless.ddd.starter.common.utils.error.message.exception.ExceptionErrorParser.addBrackets;

/**
 * RestResponse
 * <p>Rest响应
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
@Slf4j
@Getter
@Builder
@ToString
@Validated
@Schema(description = "通用的响应格式", name = "RestResponse")
public class RestResponse<R> implements Response {

    @Schema(description = "响应状态", example = "200")
    private String status;

    @Schema(description = "响应错误码", example = "SUCCESS")
    private String errorCode;

    @Schema(description = "响应信息", example = "服务处理响应成功")
    private String message;

    @Schema(description = "响应数据", implementation = Object.class)
    private final Serializable data;

    @Schema(description = "服务描述", example = "DDD服务")
    @NotBlank(message = "服务描述不能为空")
    private final String serviceDescription;

    @Schema(description = "领域描述", example = "DDD领域")
    private final String domainDescription;

    public ResponseEntity<RestResponse<R>> success(String message) {
        this.message = message;
        return success();
    }

    public ResponseEntity<RestResponse<R>> success() {
        this.status = String.valueOf(HttpStatus.OK.value());
        this.errorCode = ErrorCode.SUCCESS.getCode();
        this.message = "[" + ErrorCode.SUCCESS.getDescription() + "]" + addBrackets(message);
        return new ResponseEntity<>(this, HttpStatus.OK);
    }

    public ResponseEntity<RestResponse<R>> badRequest(ErrorCode errorCode, String message) {
        this.status = String.valueOf(HttpStatus.BAD_REQUEST.value());
        this.errorCode = errorCode.getCode();
        this.message = message;
        return new ResponseEntity<>(this, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<RestResponse<R>> failure(ErrorCode errorCode, String message) {
        this.status = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
        this.errorCode = errorCode.getCode();
        this.message = message;
        return new ResponseEntity<>(this, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<RestResponse<R>> forbidden(ErrorCode errorCode, String message) {
        this.status = String.valueOf(HttpStatus.FORBIDDEN.value());
        this.errorCode = errorCode.getCode();
        this.message = message;
        return new ResponseEntity<>(this, HttpStatus.FORBIDDEN);
    }

    public ResponseEntity<RestResponse<R>> notFound(ErrorCode errorCode, String message) {
        this.status = String.valueOf(HttpStatus.NOT_FOUND.value());
        this.errorCode = errorCode.getCode();
        this.message = message;
        return new ResponseEntity<>(this, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<RestResponse<R>> unauthorized(ErrorCode errorCode, String message) {
        this.status = String.valueOf(HttpStatus.UNAUTHORIZED.value());
        this.errorCode = errorCode.getCode();
        this.message = message;
        return new ResponseEntity<>(this, HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<RestResponse<R>> unavailable(ErrorCode errorCode, String message) {
        this.status = String.valueOf(HttpStatus.SERVICE_UNAVAILABLE.value());
        this.errorCode = errorCode.getCode();
        this.message = message;
        return new ResponseEntity<>(this, HttpStatus.SERVICE_UNAVAILABLE);
    }

    public R validate() {
        return validate(null);
    }

    @NotNull(message = "响应数据不能为空")
    public R validate(Class<R> clazz) {
        if (StringUtils.hasText(errorCode) && ErrorCode.SUCCESS.getCode().equals(errorCode)) {
            if (clazz == null) {
                return null;
            }
            log.trace("[REST响应成功]: {}", this);
            return ObjectTools.of(data, clazz);
        } else {
            this.message = this.message.replaceAll("\\s", "");
            throw new RestServerResponseFailedException("[REST响应失败]: " + this);
        }
    }
}

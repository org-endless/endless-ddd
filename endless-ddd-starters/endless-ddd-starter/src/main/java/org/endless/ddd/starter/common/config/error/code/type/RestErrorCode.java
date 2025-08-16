package org.endless.ddd.starter.common.config.error.code.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * RestErrorCode
 * <p>
 * create 2025/08/11 17:21
 * <p>
 * update 2025/08/11 17:22
 *
 * @author Deng Haozhi
 * @see Enum
 * @see ErrorCode
 * @since 1.0.0
 */
@Getter
@ToString
@AllArgsConstructor
public enum RestErrorCode implements ErrorCode {

    // REST 错误码
    RES0000("RES0000", "REST处理失败"),
    RES0010("RES0010", "REST请求处理失败"),
    RES0020("RES0020", "REST响应处理失败"),
    // REST 服务错误
    RES0100("RES0100", "REST服务处理失败"),
    RES0200("RES0200", "REST服务请求处理失败"),
    RES0201("RES0201", "REST服务请求路径不存在"),
    RES0202("RES0202", "REST服务请求方法不支持"),
    RES0250("RES0250", "REST服务请求体为空或格式错误"),
    RES0251("RES0251", "REST服务请求体校验失败"),
    RES0300("RES0300", "REST服务响应处理失败"),
    // REST 客户端错误
    RES0500("RES0500", "REST客户端处理失败"),
    RES0600("RES0600", "REST客户端请求处理失败"),
    RES0700("RES0700", "REST客户端响应处理失败"),
    // REST 状态未知
    RES9000("RES9000", "REST服务处理状态未知"),
    RES9500("RES9500", "REST客户端处理状态未知");

    private final String code;

    private final String description;

    public static void register() {
        for (RestErrorCode value : values()) {
            ErrorCode.register(value);
        }
    }
}

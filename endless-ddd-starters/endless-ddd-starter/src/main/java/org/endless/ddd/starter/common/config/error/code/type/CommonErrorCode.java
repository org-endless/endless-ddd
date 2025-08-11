package org.endless.ddd.starter.common.config.error.code.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * CommonErrorCode
 * <p>
 * create 2025/08/11 17:15
 * <p>
 * update 2025/08/11 17:21
 *
 * @author Deng Haozhi
 * @see Enum
 * @see ErrorCode
 * @since 1.0.0
 */
@Getter
@ToString
@AllArgsConstructor
public enum CommonErrorCode implements ErrorCode {

    // 公共错误码
    SUCCESS("SUCCESS", "服务处理成功"),
    FAILURE("FAILURE", "服务处理失败"),
    UNKNOWN("UNKNOWN", "服务处理状态未知"),
    UN_AUTH("UN_AUTH", "身份认证失败"),
    BAD_REQ("BAD_REQ", "请求参数错误"),
    NOT_FND("NOT_FND", "未找到相关资源"),
    FORBIDN("FORBIDN", "服务访问被拒绝");

    private final String code;

    private final String description;

    public static void register() {
        for (CommonErrorCode value : values()) {
            ErrorCode.register(value);
        }
    }
}

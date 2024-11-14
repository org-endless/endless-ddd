package org.endless.ddd.simplified.starter.common.handler.result.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.domain.type.EnumException;

/**
 * ErrorCode
 * <p>
 * create 2024/11/15 00:31
 * <p>
 * update 2024/11/15 00:31
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Getter
@ToString
@AllArgsConstructor
public enum ErrorCode {


    // 业务错误码
    SUCCESS("SUCCESS", "业务处理成功"),
    FAILURE("FAILURE", "业务处理失败");

    private final String code;

    private final String description;

    public static ErrorCode fromCode(String code) {
        for (ErrorCode type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的错误码: " + code);
    }
}

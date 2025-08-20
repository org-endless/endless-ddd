package org.endless.ddd.starter.common.config.error.code.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * SecurityErrorCode
 * <p>
 * create 2025/08/21 01:40
 * <p>
 * update 2025/08/21 01:41
 *
 * @author Deng Haozhi
 * @see Enum
 * @see ErrorCode
 * @since 1.0.0
 */
@Getter
@ToString
@AllArgsConstructor
public enum SecurityErrorCode implements ErrorCode {

    // 安全模块错误码
    SEC0000("SEC0000", "安全模块处理失败"),
    SEC0011("SEC0011", "用户名为空"),
    SEC0020("SEC0020", "密码处理失败"),
    SEC0021("SEC0021", "密码为空"),
    SEC0022("SEC0022", "密码错误"),
    SEC0023("SEC0023", "密码格式错误"),
    SEC0024("SEC0024", "初始密码无法使用"),
    SEC0030("SEC0030", "令牌处理失败"),
    SEC0031("SEC0031", "令牌生成失败"),
    SEC0032("SEC0032", "令牌刷新失败"),
    SEC0033("SEC0033", "令牌验证失败"),
    SEC0034("SEC0034", "令牌已过期"),
    SEC0040("SEC0040", "用户登出失败"),
    SEC0051("SEC0051", "HTTP指纹生成失败"),
    // 身份认证
    SEC1000("SEC1000", "身份认证处理失败"),
    SEC1001("SEC1001", "未身份认证");

    private final String code;

    private final String description;

    public static void register() {
        for (SecurityErrorCode value : values()) {
            ErrorCode.Cache.register(value);
        }
    }
}

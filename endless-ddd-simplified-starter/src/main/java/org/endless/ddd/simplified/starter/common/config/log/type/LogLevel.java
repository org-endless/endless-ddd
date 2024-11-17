package org.endless.ddd.simplified.starter.common.config.log.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.domain.type.EnumException;

/**
 * LogLevel
 * <p>
 * create 2024/11/15 00:54
 * <p>
 * update 2024/11/15 00:54
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Getter
@ToString
@AllArgsConstructor
public enum LogLevel {

    TRACE("TRACE", "跟踪日志"),
    DEBUG("DEBUG", "调试日志"),
    INFO("INFO", "信息日志"),
    WARN("WARN", "警告日志"),
    ERROR("ERROR", "错误日志"),
    FATAL("FATAL", "致命错误日志");

    private final String code;

    private final String description;

    public static LogLevel fromCode(String code) {
        for (LogLevel type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的日志级别: " + code);
    }
}

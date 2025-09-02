package org.endless.ddd.starter.common.utils.error.message.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.endless.ddd.starter.common.exception.error.code.ErrorCode;
import org.springframework.util.StringUtils;

/**
 * ValidateErrorParser
 * <p>
 * create 2025/08/09 03:33
 * <p>
 * update 2025/08/09 03:33
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionErrorParser {

    public static String parse(String method, ErrorCode errorCode, String message) {
        if (errorCode == null) {
            throw new IllegalArgumentException("错误代码不能为空");
        }
        if (StringUtils.hasText(message)) {
            if (StringUtils.hasText(method)) {
                return "[" + method + "]" + addBrackets(message);
            } else {
                return "[" + errorCode.getDescription() + "]" + addBrackets(message);
            }
        } else {
            if (StringUtils.hasText(method)) {
                return "[" + method + "]" + "[" + errorCode.getDescription() + "]";
            } else {
                return "[" + errorCode.getDescription() + "]";
            }
        }
    }

    public static String addBrackets(String string) {
        if (StringUtils.hasText(string)) {
            if (string.startsWith("[") && string.endsWith("]")) {
                return string;
            } else if (string.startsWith("<") && string.endsWith(">")) {
                return string;
            } else if ((string.startsWith("[") && string.contains("]"))) {
                return string;
            } else {
                return "<" + string + ">";
            }
        }
        return "<" + string + ">";
    }
}

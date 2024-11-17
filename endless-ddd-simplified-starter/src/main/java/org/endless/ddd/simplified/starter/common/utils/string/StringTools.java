package org.endless.ddd.simplified.starter.common.utils.string;

import org.springframework.util.StringUtils;

/**
 * StringTools
 * <p>
 * create 2024/11/01 23:14
 * <p>
 * update 2024/11/01 23:14
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class StringTools {

    /**
     * 工具方法：驼峰转蛇形
     *
     * @param string 字符串
     * @return {@link String }
     */
    public static String toSnake(String string) {
        if (StringUtils.hasText(string)) {
            return string.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
        }
        return string;
    }

    public static String addBrackets(String string) {
        if (StringUtils.hasText(string)) {
            if (string.startsWith("[") && string.endsWith("]")) {
                return string;
            } else if (string.startsWith("[") && string.endsWith(">")) {
                return string;
            } else {
                return "<" + string + ">";
            }
        }
        return string;
    }
}

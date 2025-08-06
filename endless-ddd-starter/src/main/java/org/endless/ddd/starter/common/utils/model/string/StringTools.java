package org.endless.ddd.starter.common.utils.model.string;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.endless.ddd.starter.common.config.endless.constant.EndlessConstant.SENSITIVE_KEYS;

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

    public static Boolean isEmailAddress(String string) {
        if (!StringUtils.hasText(string)) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(emailRegex, string);
    }

    public static boolean isMobilePhoneNumber(String mobile) {
        if (!StringUtils.hasText(mobile)) {
            return false;
        }
        String regex = "^1[3-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }

    /**
     * 中文字符及允许的全角间隔符“·”，长度限制为 2-50 个字符
     *
     * @param nameZh 中文名称
     * @return {@link Boolean }
     */
    public static Boolean isNameZh(String nameZh) {
        if (!StringUtils.hasText(nameZh)) {
            return false;
        }
        String regex = "^[\\u4e00-\\u9fa5·]{2,50}$";
        return nameZh.matches(regex);
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

    /**
     * 判断是否包含任意敏感字段
     *
     * @param string 待判断字符串
     * @return 如果 key 包含任意敏感字段，返回 true；否则返回 false
     */
    public static boolean containsSensitive(String string) {
        return SENSITIVE_KEYS.stream().anyMatch(string.toLowerCase()::contains);
    }

    public static String duplicateMessage(String message) {
        String regex = "Duplicate entry '(.+?)' for key '(.+?)'";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            String duplicateValue = matcher.group(1);
            String keyName = matcher.group(2);
            return String.format("存在相同的 '%s' 为 '%s' 的记录", keyName, duplicateValue);
        }
        return message;
    }

    /**
     * 工具方法: 移除后缀
     *
     * @param string 字符串
     * @param suffix 后缀
     * @return {@link String }
     */
    public static String removeSuffix(String string, String suffix) {
        if (string != null && string.endsWith(suffix)) {
            return string.substring(0, string.length() - suffix.length());
        }
        return string;
    }

    /**
     * 工具方法: 替换后缀
     *
     * @param string    字符串
     * @param oldSuffix 旧后缀
     * @param newSuffix 新后缀
     * @return {@link String }
     */
    public static String exchangeSuffix(String string, String oldSuffix, String newSuffix) {
        return removeSuffix(string, oldSuffix) + newSuffix;
    }

    /**
     * 工具方法: 移除前缀
     *
     * @param string 字符串
     * @param prefix 前缀
     * @return {@link String }
     */
    public static String removePrefix(String string, String prefix) {
        if (string != null && string.startsWith(prefix)) {
            return string.substring(prefix.length());
        }
        return string;
    }

    /**
     * 工具方法: 替换前缀
     *
     * @param string    字符串
     * @param oldPrefix 旧前缀
     * @param newPrefix 新前缀
     * @return {@link String }
     */
    public static String exchangePrefix(String string, String oldPrefix, String newPrefix) {
        return newPrefix + removePrefix(string, oldPrefix);
    }

    /**
     * 工具方法: 获取泛型
     *
     * @param string 字符串
     * @return {@link String }
     */
    public static String generics(String string) {
        if (string == null || !string.contains("<") || !string.contains(">")) {
            return string;
        }
        return string.substring(string.indexOf('<') + 1, string.indexOf('>'));
    }

    /**
     * 工具方法: 驼峰转下划线
     *
     * @param camelCase 驼峰形式
     * @return {@link String }
     */
    public static String convertToSnake(String camelCase) {
        return convertToSeparator(camelCase, "_");
    }

    /**
     * 工具方法:  将驼峰形式转换为点号形式
     *
     * @param camelCase 驼峰形式
     * @return {@link String }
     */
    public static String convertToDot(String camelCase) {
        return convertToSeparator(camelCase, ".");
    }

    /**
     * 工具方法:  将驼峰形式的类名转换为/形式
     *
     * @param camelCase 驼峰形式
     * @return {@link String }
     */
    public static String convertToSlash(String camelCase) {
        return convertToSeparator(camelCase, "/");
    }

    /**
     * 工具方法:  将驼峰形式的类名转换为指定分隔符形式
     *
     * @param camelCase 驼峰形式
     * @param separator 分隔符
     * @return {@link String }
     */
    public static String convertToSeparator(String camelCase, String separator) {
        StringBuilder result = new StringBuilder();

        // 将第一个字母转换为小写并添加到结果中
        result.append(Character.toLowerCase(camelCase.charAt(0)));

        // 遍历剩下的字符
        for (int i = 1; i < camelCase.length(); i++) {
            char ch = camelCase.charAt(i);
            if (Character.isUpperCase(ch)) {
                result.append(separator);
                result.append(Character.toLowerCase(ch));
            } else {
                // 否则直接添加
                result.append(ch);
            }
        }
        return result.toString();
    }
}

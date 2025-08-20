package org.endless.ddd.starter.common.utils.model.string;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MySQLTools
 * <p>
 * create 2025/08/05 07:59
 * <p>
 * update 2025/08/05 07:59
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MySQLTools {

    public static String getLength(String description) {
        String regex = "\\((\\d+)B\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(description);
        if (matcher.find()) {
            return String.valueOf(Integer.parseInt(matcher.group(1)));
        } else {
            return "255";
        }
    }

    public static Map<String, Integer> toDecimal(String decimal) {
        String regex = "\\((\\d+),\\s*(\\d+)\\)|\\((\\d+),(\\d+)\\)"; // 两种情况
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(decimal);
        Map<String, Integer> result = toDecimal(matcher);
        if (result != null) {
            return result;
        }
        throw new IllegalArgumentException("请在描述中添加正确的BigDecimal类型，格式为：(M, D) 或 (M,D)");
    }

    private static Map<String, Integer> toDecimal(Matcher matcher) {
        if (matcher.find()) {
            if (matcher.group(1) != null && matcher.group(2) != null) {
                Integer M = Integer.parseInt(matcher.group(1));
                Integer D = Integer.parseInt(matcher.group(2));
                Map<String, Integer> result = new HashMap<>();
                result.put("precision", M);
                result.put("scale", D);
                return result;
            } else if (matcher.group(3) != null && matcher.group(4) != null) {
                Integer M = Integer.parseInt(matcher.group(3));
                Integer D = Integer.parseInt(matcher.group(4));
                Map<String, Integer> result = new HashMap<>();
                result.put("precision", M);
                result.put("scale", D);
                return result;
            }
        }
        return null;
    }
}

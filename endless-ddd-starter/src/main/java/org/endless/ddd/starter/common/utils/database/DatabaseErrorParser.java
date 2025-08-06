package org.endless.ddd.starter.common.utils.database;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DatabaseErrorParser
 * <p>
 * create 2025/08/06 22:14
 * <p>
 * update 2025/08/06 22:14
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class DatabaseErrorParser {

    private static final List<DatabaseRecognizer> recognizers = List.of(
            // MySQL 错误识别
            new DatabaseRecognizer(
                    msg -> msg.contains("doesn't exist") || msg.contains("Data too long"),
                    List.of(
                            new ErrorPattern("Table '(.+?)' doesn't exist", m -> String.format("数据库表 '%s' 不存在", m.group(1))),
                            new ErrorPattern("Unknown column '(.+?)'", m -> String.format("字段 '%s' 不存在，请检查字段名是否正确", m.group(1))),
                            new ErrorPattern("Field '(.+?)' doesn't have a default value", m -> String.format("字段 '%s' 不能为空", m.group(1))),
                            new ErrorPattern("Data too long for column '(.+?)'", m -> String.format("字段 '%s' 超长", m.group(1)))
                    )
            ),
            // SQLite 错误识别
            new DatabaseRecognizer(
                    msg -> msg.contains("SQLITE"),
                    List.of(
                            new ErrorPattern(
                                    "UNIQUE constraint failed: (.+)",
                                    m -> {
                                        String fields = m.group(1);
                                        String[] parts = fields.split("\\s*,\\s*");
                                        List<String> filtered = Arrays.stream(parts)
                                                .filter(f -> !f.contains(".remove_at"))
                                                .toList();
                                        if (filtered.isEmpty()) {
                                            return "唯一键冲突，但无可识别字段";
                                        }
                                        return filtered.size() == 1
                                                ? String.format("字段 '%s' 的值已存在", filtered.getFirst())
                                                : String.format("以下字段的值组合已存在：%s", String.join("，", filtered));
                                    }
                            ),
                            new ErrorPattern("column \"(.+?)\" does not exist", m -> String.format("字段 '%s' 不存在", m.group(1)))
                    )
            ),

            // PostgreSQL 错误识别
            new DatabaseRecognizer(
                    msg -> msg.contains("does not exist") || msg.contains("syntax error at"),
                    List.of(
                            new ErrorPattern("relation \"(.+?)\" does not exist", m -> String.format("表 '%s' 不存在", m.group(1))),
                            new ErrorPattern("column \"(.+?)\" does not exist", m -> String.format("字段 '%s' 不存在", m.group(1)))
                    )
            ),

            // Oracle
            new DatabaseRecognizer(
                    msg -> msg.contains("ORA-"),
                    List.of(
                            new ErrorPattern("ORA-00942: table or view does not exist", m -> "表或视图不存在"),
                            new ErrorPattern("ORA-00904: \"(.+?)\": invalid identifier", m -> String.format("字段 '%s' 无效", m.group(1)))
                    )
            )
    );

    public static String parse(String message) {
        for (DatabaseRecognizer recognizer : recognizers) {
            if (recognizer.recognizer().test(message)) {
                for (ErrorPattern pattern : recognizer.patterns()) {
                    Matcher matcher = pattern.pattern.matcher(message);
                    if (matcher.find()) {
                        return pattern.handler.apply(matcher);
                    }
                }
            }
        }
        return message; // 未识别则原样返回
    }

    private record DatabaseRecognizer(
            Predicate<String> recognizer,
            List<ErrorPattern> patterns
    ) {

    }

    private static class ErrorPattern {

        public final Pattern pattern;

        public final Function<Matcher, String> handler;

        public ErrorPattern(String regex, Function<Matcher, String> handler) {
            this.pattern = Pattern.compile(regex);
            this.handler = handler;
        }
    }
}

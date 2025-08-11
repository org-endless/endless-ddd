package org.endless.ddd.starter.common.utils.error.message.database.recognizer;

import org.endless.ddd.starter.common.utils.model.pattern.PatternHandler;

import java.util.Arrays;
import java.util.List;

/**
 * MySQLRecognizer
 * <p>
 * create 2025/08/09 03:45
 * <p>
 * update 2025/08/09 03:45
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class SQLiteRecognizer {

    public static final DatabaseRecognizer recognizer =
            new DatabaseRecognizer(
                    message -> message.contains("SQLITE"),
                    List.of(
                            new PatternHandler(
                                    "UNIQUE constraint failed: ",
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
                                        return String.format("字段 '%s' 的值已存在", String.join("，", filtered));
                                    }
                            ),
                            new PatternHandler("NOT NULL constraint failed: ", "NOT NULL constraint failed: ([a-zA-Z0-9_]+\\.[a-zA-Z0-9_]+)", m -> String.format("字段 '%s' 不能为空", m.group(1))),
                            new PatternHandler(" does not exist", "column \"(.+?)\" does not exist", m -> String.format("字段 '%s' 不存在", m.group(1)))
                    )
            );
}

package org.endless.ddd.starter.common.utils.error.message.database.recognizer;

import org.endless.ddd.starter.common.utils.model.pattern.PatternHandler;

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
public class MySQLRecognizer {

    public static final DatabaseRecognizer recognizer =
            new DatabaseRecognizer(
                    message -> message.contains("MySQL"),
                    List.of(
                            new PatternHandler(" doesn't exist", "Table '(.+?)' doesn't exist", m -> String.format("数据库表 '%s' 不存在", m.group(1))),
                            new PatternHandler("Unknown column ", "Unknown column '(.+?)'", m -> String.format("字段 '%s' 不存在，请检查字段名是否正确", m.group(1))),
                            new PatternHandler("doesn't have a default value", "Field '(.+?)' doesn't have a default value", m -> String.format("字段 '%s' 不能为空", m.group(1))),
                            new PatternHandler("Data too long for column ", "Data too long for column '(.+?)'", m -> String.format("字段 '%s' 超长", m.group(1)))
                    )
            );
}

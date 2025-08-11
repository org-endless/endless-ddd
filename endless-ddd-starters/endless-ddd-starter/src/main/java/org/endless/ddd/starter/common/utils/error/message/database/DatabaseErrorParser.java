package org.endless.ddd.starter.common.utils.error.message.database;

import org.endless.ddd.starter.common.utils.error.message.database.recognizer.DatabaseRecognizer;
import org.endless.ddd.starter.common.utils.error.message.database.recognizer.MySQLRecognizer;
import org.endless.ddd.starter.common.utils.error.message.database.recognizer.SQLiteRecognizer;
import org.endless.ddd.starter.common.utils.model.pattern.PatternHandler;

import java.util.List;
import java.util.regex.Matcher;

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
            MySQLRecognizer.recognizer,
            // SQLite 错误识别
            SQLiteRecognizer.recognizer
    );

    public static String parse(String message) {
        for (DatabaseRecognizer recognizer : recognizers) {
            if (recognizer.recognizer().test(message)) {
                for (PatternHandler pattern : recognizer.patterns()) {
                    if (!message.contains(pattern.index)) continue;
                    Matcher matcher = pattern.pattern.matcher(message);
                    if (matcher.find()) {
                        return pattern.handler.apply(matcher);
                    }
                }
            }
        }
        return message;
    }
}

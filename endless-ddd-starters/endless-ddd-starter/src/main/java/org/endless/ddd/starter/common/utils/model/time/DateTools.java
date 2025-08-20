package org.endless.ddd.starter.common.utils.model.time;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.endless.ddd.starter.common.exception.utils.model.time.DateException;
import org.springframework.util.StringUtils;

import java.time.Instant;


/**
 * DateTools
 * <p>
 * create 2024/10/30 11:17
 * <p>
 * update 2024/10/30 11:17
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTools {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static String now() {
        return TimestampTools.format(Instant.now(), DEFAULT_DATE_FORMAT);
    }

    public static String from(Long timestamp) {
        return from(timestamp, DEFAULT_DATE_FORMAT);
    }

    public static String from(Long timestamp, String pattern) {
        if (timestamp == null || !StringUtils.hasText(pattern)) {
            throw new DateException("时间戳或格式不能为空");
        }
        return TimestampTools.format(Instant.ofEpochMilli(timestamp), pattern);
    }
}

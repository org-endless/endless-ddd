package org.endless.ddd.simplified.starter.common.utils.time;

import java.time.Instant;

import static org.endless.ddd.simplified.starter.common.utils.time.TimeStamp.format;

/**
 * DateTime
 * <p>
 * create 2024/10/31 14:57
 * <p>
 * update 2024/10/31 14:57
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class DateTime {

    public final static String DEFAULT_DATE_TIME_FORMAT = "yyyyMMdd HH:mm:ss:SSS";

    public static String now() {
        return TimeStamp.format(Instant.now(), DEFAULT_DATE_TIME_FORMAT);
    }
    public static String format(Long timestamp) {
        return TimeStamp.format(Instant.ofEpochMilli(timestamp), DEFAULT_DATE_TIME_FORMAT);
    }
}

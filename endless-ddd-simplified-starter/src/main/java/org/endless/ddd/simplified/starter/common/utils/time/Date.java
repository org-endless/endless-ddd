package org.endless.ddd.simplified.starter.common.utils.time;

import java.time.Instant;

import static org.endless.ddd.simplified.starter.common.utils.time.TimeStamp.format;

/**
 * Date
 * <p>
 * create 2024/10/30 11:17
 * <p>
 * update 2024/10/30 11:17
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class Date {

    public final static String DEFAULT_DATE_FORMAT = "yyyyMMdd";


    public static String now() {
        return TimeStamp.format(Instant.now(), DEFAULT_DATE_FORMAT);
    }

    public static String format(Long timestamp) {
        return TimeStamp.format(Instant.ofEpochMilli(timestamp), DEFAULT_DATE_FORMAT);
    }
}

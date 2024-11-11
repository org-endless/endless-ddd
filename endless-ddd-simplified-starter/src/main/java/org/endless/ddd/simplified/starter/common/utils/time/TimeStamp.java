package org.endless.ddd.simplified.starter.common.utils.time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * TimeStamp
 * <p>
 * create 2024/10/30 11:24
 * <p>
 * update 2024/10/30 11:24
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public class TimeStamp {

    public static Long now() {
        return Instant.now().toEpochMilli();
    }

    public static Long between(Long start, Long end) {
        return Duration.between(Instant.ofEpochMilli(start), Instant.ofEpochMilli(end)).toMillis();
    }
    protected static String format(Instant timestamp, String datePattern) {
        ZonedDateTime zonedDateTime = timestamp.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        return zonedDateTime.format(formatter);
    }
}

package org.endless.ddd.simplified.starter.common.utils.id.snowflake;

import org.endless.ddd.simplified.starter.common.exception.utils.id.SnowflakeIdException;
import org.endless.ddd.simplified.starter.common.utils.time.TimeStamp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * SnowflakeIdGenerator
 * <p>主机名要求：DataCenterXXXX-ServerXXXX，其中DataCenterXXXX为数据中心编号，DomainSimplifiedServerXXXX为服务器编号，编号要求为5位数字。
 * <p>数据中心和服务器名称可修改，但必须保证唯一性。
 * <p>
 * create 2024/10/30 10:23
 * <p>
 * update 2024/10/30 10:23
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class SnowflakeIdGenerator {

    // 容忍时间窗口，单位：毫秒
    private static final long TIME_WINDOW = 5L;

    private static final long DATA_CENTER_ID_BITS = 5L;

    private static final long WORKER_ID_BITS = 5L;

    private static final long SEQUENCE_BITS = 12L;

    private static final long DATA_CENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;

    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;

    private static final long TIMESTAMP_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATA_CENTER_ID_BITS;

    private static final long MAX_DATA_CENTER_ID = ~(-1L << DATA_CENTER_ID_BITS);

    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);

    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BITS);

    private final long dataCenterId;

    private final long workerId;

    private long sequence = 0L;

    private long lastTimestamp = -1L;

    private final ReentrantLock lock = new ReentrantLock(); // 使用 ReentrantLock

    public SnowflakeIdGenerator(long dataCenterId, long workerId) {
        validateIds(dataCenterId, workerId);
        this.dataCenterId = dataCenterId;
        this.workerId = workerId;
    }

    public SnowflakeIdGenerator() {
        String hostName = null;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new SnowflakeIdException("获取主机名失败: " + e.getMessage(), e);
        }
        String[] parts = hostName.split("-");

        if (parts.length < 2) {
            throw new SnowflakeIdException("错误的主机名格式: " + hostName + " 请修改主机名格式为: DataCenterXXXX-ServerXXXX，数据中心和服务器名称可修改");
        }

        this.dataCenterId = parseIdFromPart(parts[0]);
        this.workerId = parseIdFromPart(parts[1]);

        validateIds(this.dataCenterId, this.workerId);
    }

    private void validateIds(long dataCenterId, long workerId) {
        if (dataCenterId < 0 || dataCenterId > MAX_DATA_CENTER_ID) {
            throw new SnowflakeIdException("数据中心ID无效或超出5位数范围: " + dataCenterId);
        }
        if (workerId < 0 || workerId > MAX_WORKER_ID) {
            throw new SnowflakeIdException("服务器ID无效或超出5位数范围: " + workerId);
        }
    }

    private long parseIdFromPart(String part) {
        // 提取数字部分
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(part);
        if (matcher.find()) {
            String numberStr = matcher.group();
            return Long.parseLong(numberStr);
        }
        throw new SnowflakeIdException("错误的主机名格式，请修改主机名格式为: DataCenterXXXX-ServerXXXX，数据中心和服务器名称可修改");
    }

    public long nextId() {
        lock.lock(); // 加锁
        try {
            long timestamp = TimeStamp.now();

            if (timestamp < lastTimestamp) {
                if (lastTimestamp - timestamp < TIME_WINDOW) {
                    timestamp = lastTimestamp;
                } else {
                    throw new SnowflakeIdException("服务器时间回拨，请检查系统时间是否正确，上次请求UTC时间戳: " + lastTimestamp);
                }
            }

            if (lastTimestamp == timestamp) {
                sequence = (sequence + 1) & MAX_SEQUENCE;
                if (sequence == 0) {
                    // 如果序列号超限，等待1毫秒
                    timestamp = waitNextMillis(lastTimestamp);
                }
            } else {
                sequence = 0;
            }

            lastTimestamp = timestamp;
            return ((timestamp << TIMESTAMP_SHIFT)) |
                    (dataCenterId << DATA_CENTER_ID_SHIFT) |
                    (workerId << WORKER_ID_SHIFT) |
                    sequence;
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    private long waitNextMillis(long lastTimestamp) {
        long timestamp = TimeStamp.now();
        while (timestamp <= lastTimestamp) {
            timestamp = TimeStamp.now();
        }
        return timestamp;
    }
}

package org.endless.ddd.starter.common.config.error.code.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * RedisErrorCode
 * <p>
 * create 2025/08/20 22:47
 * <p>
 * update 2025/08/21 01:41
 *
 * @author Deng Haozhi
 * @see Enum
 * @see ErrorCode
 * @since 1.0.0
 */
@Getter
@ToString
@AllArgsConstructor
public enum RedisErrorCode implements ErrorCode {

    // Redis
    RDS0000("MIO0000", "REDIS处理失败"),
    RDS0100("RDS0100", "REDIS-STREAM处理失败"),
    RDS0101("RDS0101", "REDIS-STREAM写入失败"),
    RDS0102("RDS0102", "REDIS-STREAM读取失败");

    private final String code;

    private final String description;

    public static void register() {
        for (RedisErrorCode value : values()) {
            ErrorCode.Cache.register(value);
        }
    }
}

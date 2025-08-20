package org.endless.ddd.starter.common.config.error.code.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * MinioErrorCode
 * <p>
 * create 2025/08/11 20:41
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
public enum MinioErrorCode implements ErrorCode {

    // Minio
    MIO0000("MIO0000", "MINIO处理失败"),
    MIO0001("MIO0001", "MINIO存储失败"),
    MIO0002("MIO0002", "MINIO删除失败"),
    MIO0003("MIO0003", "MINIO读取失败"),
    MIO9000("MIO9000", "MINIO处理状态未知"),
    MIO9001("MIO9001", "MINIO存储状态未知"),
    MIO9002("MIO9002", "MINIO删除状态未知"),
    MIO9003("MIO9003", "MINIO读取状态未知");

    private final String code;

    private final String description;

    public static void register() {
        for (MinioErrorCode value : values()) {
            ErrorCode.Cache.register(value);
        }
    }
}

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
 * update 2025/08/11 20:41
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Getter
@ToString
@AllArgsConstructor
public enum MinioErrorCode implements ErrorCode {

    // 文件系统异常
    DFS0000("DFS0000", "文件系统处理失败"),
    DFS0001("DFS0001", "文件系统存储失败"),
    DFS0002("DFS0002", "文件系统删除失败"),
    DFS0003("DFS0003", "文件系统读取失败"),
    DFS9000("DFS9000", "文件系统处理状态未知"),
    DFS9001("DFS9001", "文件系统存储状态未知"),
    DFS9002("DFS9002", "文件系统删除状态未知"),
    DFS9003("DFS9003", "文件系统读取状态未知");

    private final String code;

    private final String description;

    public static void register() {
        for (MinioErrorCode value : values()) {
            ErrorCode.register(value);
        }
    }

}

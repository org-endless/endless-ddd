package org.endless.ddd.starter.common.config.error.code.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * ConfigErrorCode
 * <p>
 * create 2025/08/11 17:24
 * <p>
 * update 2025/08/11 17:25
 *
 * @author Deng Haozhi
 * @see Enum
 * @see ErrorCode
 * @since 1.0.0
 */
@Getter
@ToString
@AllArgsConstructor
public enum ConfigErrorCode implements ErrorCode {

    // 配置项错误码
    CFG0000("CFG0000", "配置项加载失败"),
    CFG0100("CFG0100", "日志切面处理失败"),
    CFG0200("CFG0200", "REST配置项加载失败"),
    CFG0300("CFG0300", "MINIO配置加载失败"),
    CFG0400("CFG0400", "REDIS配置加载失败"),
    CFG0410("CFG0410", "REDIS序列化配置加载失败"),
    CFG0420("CFG0420", "REDIS-STREAM配置加载失败"),
    CFG0421("CFG0421", "REDIS-STREAM初始化失败"),
    CFG8000("CFG8000", "ID生成失败"),
    CFG8001("CFG8001", "雪花ID生成失败");


    private final String code;

    private final String description;

    public static void register() {
        for (ConfigErrorCode value : values()) {
            ErrorCode.Cache.register(value);
        }
    }
}

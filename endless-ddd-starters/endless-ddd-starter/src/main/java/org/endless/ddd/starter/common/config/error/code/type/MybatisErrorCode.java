package org.endless.ddd.starter.common.config.error.code.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * MybatisErrorCode
 * <p>
 * create 2025/08/21 00:25
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
public enum MybatisErrorCode implements ErrorCode {

    MBT0000("MBT0000", "MYBATIS-PLUS处理失败"),
    MBT0001("MBT0001", "MYBATIS-PLUS保存数据失败"),
    MBT0002("MBT0002", "MYBATIS-PLUS删除数据失败"),
    MBT0003("MBT0003", "MYBATIS-PLUS修改数据失败"),
    MBT0004("MBT0004", "MYBATIS-PLUS保存或修改数据失败"),
    MBT0100("MBT0100", "MYBATIS-PLUS批量处理失败"),

    MBT1000("MBT1000", "MYBATIS-PLUS查询数据失败"),
    MBT1001("MBT1001", "MYBATIS-PLUS未查询到相关数据"),

    MBT8000("MBT8000", "MYBATIS-PLUS方法参数为空"),
    MBT8001("MBT8001", "MYBATIS-PLUS方法参数校验失败"),
    MBT8100("MBT8100", "MYBATIS-PLUS方法返回值为空"),
    MBT8101("MBT8101", "MYBATIS-PLUS方法返回值校验失败"),

    MBT9000("MBT9000", "MYBATIS-PLUS处理状态未知"),
    MBT9001("MBT9001", "MYBATIS-PLUS保存数据状态未知"),
    MBT9002("MBT9002", "MYBATIS-PLUS删除数据状态未知"),
    MBT9003("MBT9003", "MYBATIS-PLUS修改数据状态未知"),
    MBT9004("MBT9004", "MYBATIS-PLUS保存或修改数据状态未知"),
    MBT9100("MBT9004", "MYBATIS-PLUS批量处理状态未知");

    private final String code;

    private final String description;

    public static void register() {
        for (MybatisErrorCode value : values()) {
            ErrorCode.Cache.register(value);
        }
    }
}

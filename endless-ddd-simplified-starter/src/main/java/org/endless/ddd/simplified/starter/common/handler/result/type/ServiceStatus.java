package org.endless.ddd.simplified.starter.common.handler.result.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.domain.type.EnumException;
import org.endless.ddd.simplified.starter.common.model.domain.type.BaseEnum;

/**
 * BulkResultEnum
 * <p>
 * create 2024/11/15 00:01
 * <p>
 * update 2024/11/15 00:01
 * update 2024/11/15 00:03
 *
 * @author Deng Haozhi
 * @see Enum
 * @see BaseEnum
 * @since 1.0.0
 */
@Getter
@ToString
@AllArgsConstructor
public enum ServiceStatus implements BaseEnum {

    SUCCESS("SUCCESS", "服务处理成功"),
    FAILED("FAILED", "服务处理失败"),
    UNKNOWN("UNKNOWN", "服务处理状态未知");

    private final String code;

    private final String description;

    public static ServiceStatus fromCode(String code) {
        for (ServiceStatus type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的服务处理状态: " + code);
    }
}

package org.endless.ddd.starter.common.config.errorcode;

import org.endless.ddd.starter.common.config.errorcode.type.CommonErrorCode;
import org.endless.ddd.starter.common.ddd.domain.type.BaseEnum;
import org.endless.ddd.starter.common.exception.ddd.domain.type.EnumException;

import java.util.HashMap;
import java.util.Map;

/**
 * ErrorCode
 * <p>
 * create 2025/08/11 17:05
 * <p>
 * update 2025/08/11 17:05
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface ErrorCode extends BaseEnum {

    Map<String, ErrorCode> CACHE = new HashMap<>();

    static void register(ErrorCode errorCode) {
        if (CACHE.containsKey(errorCode.getCode())) {
            throw new EnumException("重复的错误码: " + errorCode.getCode());
        }
        CACHE.put(errorCode.getCode(), errorCode);
    }

    static ErrorCode fromCode(String code) {
        return CACHE.get(code);
    }

    static void init() {
        CommonErrorCode.register();
    }

    String getCode();

    String getDescription();
}

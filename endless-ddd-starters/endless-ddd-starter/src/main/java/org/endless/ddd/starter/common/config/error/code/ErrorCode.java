package org.endless.ddd.starter.common.config.error.code;

import org.endless.ddd.starter.common.config.error.code.type.*;
import org.endless.ddd.starter.common.ddd.domain.type.BaseEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * ErrorCode
 * <p>
 * create 2025/08/11 17:05
 * <p>
 * update 2025/08/11 17:26
 *
 * @author Deng Haozhi
 * @see BaseEnum
 * @since 1.0.0
 */
public interface ErrorCode extends BaseEnum {

    static ErrorCode of(String code) {
        return Cache.of(code);
    }

    static void init() {
        CommonErrorCode.register();
        ConfigErrorCode.register();
        DDDErrorCode.register();
        MinioErrorCode.register();
        MybatisErrorCode.register();
        RedisErrorCode.register();
        RestErrorCode.register();
        SecurityErrorCode.register();
        UtilsErrorCode.register();
    }

    String getCode();

    String getDescription();

    class Cache {

        private static final Map<String, ErrorCode> ERROR_CODE_CACHE = new HashMap<>();

        private Cache() {
        }

        public static void register(ErrorCode errorCode) {
            if (ERROR_CODE_CACHE.containsKey(errorCode.getCode())) {
                throw new IllegalArgumentException("重复的错误码: " + errorCode.getCode());
            }
            ERROR_CODE_CACHE.put(errorCode.getCode(), errorCode);
        }

        public static ErrorCode of(String code) {
            if (!ERROR_CODE_CACHE.containsKey(code)) {
                throw new IllegalArgumentException("错误码不存在: " + code);
            }
            return ERROR_CODE_CACHE.get(code);
        }
    }
}

package org.endless.ddd.starter.common.config.utils.id;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.endless.ddd.starter.common.config.utils.id.snowflake.SnowflakeIdGenerator;
import org.endless.ddd.starter.common.exception.config.utils.id.IdGeneratorException;
import org.springframework.util.StringUtils;

/**
 * IdGenerator
 * <p>
 * create 2024/11/06 17:06
 * <p>
 * update 2024/11/06 17:06
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdGenerator {

    private static SnowflakeIdGenerator snowflakeIdGenerator;

    public static String of() {
        if (snowflakeIdGenerator == null) {
            throw new IdGeneratorException("ID生成器未初始化");
        }
        try {
            String nextId = String.valueOf(snowflakeIdGenerator.nextId());
            if (!StringUtils.hasText(nextId)) {
                throw new IdGeneratorException();
            }
            return nextId;
        } catch (Exception e) {
            throw new IdGeneratorException("ID生成异常: " + e.getMessage(), e);
        }
    }

    protected static synchronized void init(Long dataCenterId, Long workerId) {
        if (snowflakeIdGenerator == null) {
            snowflakeIdGenerator = new SnowflakeIdGenerator(dataCenterId, workerId);
        }
    }
}

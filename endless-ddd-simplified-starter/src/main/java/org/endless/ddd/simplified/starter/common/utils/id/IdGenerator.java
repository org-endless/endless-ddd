package org.endless.ddd.simplified.starter.common.utils.id;

import org.endless.ddd.simplified.starter.common.exception.model.domain.entity.EntityException;
import org.endless.ddd.simplified.starter.common.utils.id.snowflake.SnowflakeIdGenerator;
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
public class IdGenerator {

    private static final SnowflakeIdGenerator idGenerator = new SnowflakeIdGenerator(1, 1);

    public static String getId() {
        String nextId = String.valueOf(idGenerator.nextId());
        if (!StringUtils.hasText(nextId)) {
            throw new EntityException("ID生成异常");
        }
        return nextId;
    }
}

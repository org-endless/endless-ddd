package org.endless.domain.simplified.server.supporting.security.token.infrastructure.data.persistence.mapper;

import org.endless.domain.simplified.server.common.model.infrastructure.data.persistence.mapper.*;
import org.endless.domain.simplified.server.supporting.security.token.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

/**
 * TokenMapper
 * <p>令牌聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
 *
 * @author Deng Haozhi
 * @see DomainSimplifiedServerMapper
 * @since 2.0.0
 */
@Lazy
@Mapper
public interface TokenMapper extends DomainSimplifiedServerMapper<TokenRecord> {
}

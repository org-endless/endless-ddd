package org.endless.domain.simplified.server.supporting.security.token.infrastructure.data.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.endless.domain.simplified.server.common.model.infrastructure.data.persistence.mapper.DomainSimplifiedServerMapper;
import org.endless.domain.simplified.server.supporting.security.token.infrastructure.data.record.*;
import org.springframework.context.annotation.Lazy;

/**
 * TokenMapperSimplified
 * <p>令牌聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2024/11/11 23:38
 * <p>
 * update 2024/11/11 23:38
 *
 * @author Deng Haozhi
 * @see DomainSimplifiedServerDataMapper
 * @since 2.0.0
 */
@Lazy
@Mapper
public interface TokenMapperSimplified extends DomainSimplifiedServerMapper<TokenRecord> {
}

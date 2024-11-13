package org.endless.domain.simplified.server.supporting.security.token.application.query.repository;

import org.endless.domain.simplified.server.common.model.application.query.repository.DomainSimplifiedServerQueryRepository;
import org.endless.domain.simplified.server.supporting.security.token.domain.anticorruption.TokenRepository;
import org.endless.domain.simplified.server.supporting.security.token.domain.entity.TokenAggregate;

/**
 * TokenQueryRepository
 * <p>令牌聚合查询仓储接口
 * <p>
 * create 2024/11/11 23:38
 * <p>
 * update 2024/11/11 23:38
 *
 * @author Deng Haozhi
 * @see TokenRepository
 * @see DomainSimplifiedServerQueryRepository
 * @since 2.0.0
 */
public interface TokenQueryRepository extends TokenRepository, DomainSimplifiedServerQueryRepository<TokenAggregate> {
}

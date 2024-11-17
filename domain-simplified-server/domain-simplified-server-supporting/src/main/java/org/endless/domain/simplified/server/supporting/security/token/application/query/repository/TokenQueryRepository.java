package org.endless.domain.simplified.server.supporting.security.token.application.query.repository;

import org.endless.domain.simplified.server.common.model.application.query.repository.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.anticorruption.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.entity.*;

/**
 * TokenQueryRepository
 * <p>令牌聚合查询仓储接口
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
 *
 * @author Deng Haozhi
 * @see TokenRepository
 * @see DomainSimplifiedServerQueryRepository
 * @since 2.0.0
 */
public interface TokenQueryRepository extends TokenRepository, DomainSimplifiedServerQueryRepository<TokenAggregate> {
}

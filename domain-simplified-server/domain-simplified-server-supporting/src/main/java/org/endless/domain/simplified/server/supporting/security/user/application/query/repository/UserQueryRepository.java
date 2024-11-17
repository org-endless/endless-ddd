package org.endless.domain.simplified.server.supporting.security.user.application.query.repository;

import org.endless.domain.simplified.server.common.model.application.query.repository.*;
import org.endless.domain.simplified.server.supporting.security.user.domain.anticorruption.*;
import org.endless.domain.simplified.server.supporting.security.user.domain.entity.*;

/**
 * UserQueryRepository
 * <p>用户聚合聚合查询仓储接口
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
 *
 * @author Deng Haozhi
 * @see UserRepository
 * @see DomainSimplifiedServerQueryRepository
 * @since 2.0.0
 */
public interface UserQueryRepository extends UserRepository, DomainSimplifiedServerQueryRepository<UserAggregate> {
}

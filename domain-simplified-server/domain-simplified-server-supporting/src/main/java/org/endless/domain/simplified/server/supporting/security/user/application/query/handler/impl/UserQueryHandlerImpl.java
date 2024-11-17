package org.endless.domain.simplified.server.supporting.security.user.application.query.handler.impl;

import org.endless.domain.simplified.server.supporting.security.user.application.query.handler.*;
import org.endless.domain.simplified.server.supporting.security.user.application.query.repository.*;
import org.endless.domain.simplified.server.supporting.security.user.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * UserQueryHandlerImpl
 * <p>用户聚合领域查询处理器
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
 *
 * @author Deng Haozhi
 * @see UserQueryHandler
 * @since 2.0.0
 */
public class UserQueryHandlerImpl implements UserQueryHandler {

    /**
     * 用户聚合聚合查询仓储接口
     */
    private final UserQueryRepository userQueryRepository;

    public UserQueryHandlerImpl(UserQueryRepository userQueryRepository) {
        this.userQueryRepository = userQueryRepository;
    }
}

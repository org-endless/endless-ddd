package org.endless.domain.simplified.server.supporting.security.token.application.query.handler.impl;

import org.endless.domain.simplified.server.supporting.security.token.application.query.handler.*;
import org.endless.domain.simplified.server.supporting.security.token.application.query.repository.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.*;

/**
 * TokenQueryHandlerImpl
 * <p>令牌领域查询处理器
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
 *
 * @author Deng Haozhi
 * @see TokenQueryHandler
 * @since 2.0.0
 */
public class TokenQueryHandlerImpl implements TokenQueryHandler {

    /**
     * 令牌聚合查询仓储接口
     */
    private final TokenQueryRepository tokenQueryRepository;

    public TokenQueryHandlerImpl(TokenQueryRepository tokenQueryRepository) {
        this.tokenQueryRepository = tokenQueryRepository;
    }
}

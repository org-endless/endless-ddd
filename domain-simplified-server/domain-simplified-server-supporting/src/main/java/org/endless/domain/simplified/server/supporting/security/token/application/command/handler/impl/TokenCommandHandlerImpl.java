package org.endless.domain.simplified.server.supporting.security.token.application.command.handler.impl;

import org.endless.domain.simplified.server.supporting.security.token.application.command.handler.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * TokenCommandHandlerImpl
 * <p>令牌领域命令处理器
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
 *
 * @author Deng Haozhi
 * @see TokenCommandHandler
 * @since 2.0.0
 */
public class TokenCommandHandlerImpl implements TokenCommandHandler {

    /**
     * 令牌聚合仓储接口
     */
    private final TokenRepository tokenRepository;

    public TokenCommandHandlerImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }
}

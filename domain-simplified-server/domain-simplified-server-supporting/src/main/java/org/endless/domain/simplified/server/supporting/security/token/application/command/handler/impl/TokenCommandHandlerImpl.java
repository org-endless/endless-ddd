package org.endless.domain.simplified.server.supporting.security.token.application.command.handler.impl;

import lombok.extern.slf4j.Slf4j;
import org.endless.domain.simplified.server.supporting.security.token.application.command.handler.TokenCommandHandler;
import org.endless.domain.simplified.server.supporting.security.token.domain.anticorruption.TokenRepository;

/**
 * TokenCommandHandlerImpl
 * <p>令牌领域命令处理器
 * <p>
 * create 2024/11/11 23:38
 * <p>
 * update 2024/11/11 23:38
 *
 * @author Deng Haozhi
 * @see TokenCommandHandler
 * @since 2.0.0
 */
@Slf4j
public class TokenCommandHandlerImpl implements TokenCommandHandler {

    /**
     * 令牌聚合仓储接口
     */
    private final TokenRepository tokenRepository;

    public TokenCommandHandlerImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }
}

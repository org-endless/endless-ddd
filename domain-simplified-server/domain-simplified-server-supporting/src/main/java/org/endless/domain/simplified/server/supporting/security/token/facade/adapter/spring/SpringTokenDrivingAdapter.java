package org.endless.domain.simplified.server.supporting.security.token.facade.adapter.spring;

import org.endless.domain.simplified.server.supporting.security.token.application.command.handler.TokenCommandHandler;
import org.endless.domain.simplified.server.supporting.security.token.application.query.handler.TokenQueryHandler;
import org.endless.domain.simplified.server.supporting.security.token.facade.adapter.TokenDrivingAdapter;

/**
 * SpringTokenDrivingAdapter
 * <p>令牌领域主动适配器Spring实现类
 * <p>
 * create 2024/11/11 23:38
 * <p>
 * update 2024/11/11 23:38
 *
 * @author Deng Haozhi
 * @see TokenDrivingAdapter
 * @since 2.0.0
 */
public class SpringTokenDrivingAdapter implements TokenDrivingAdapter {

    /**
     * 令牌领域命令处理器
     */
    private final TokenCommandHandler tokenCommandHandler;

    /**
     * 令牌领域查询处理器
     */
    private final TokenQueryHandler tokenQueryHandler;

    public SpringTokenDrivingAdapter(TokenCommandHandler tokenCommandHandler, TokenQueryHandler tokenQueryHandler) {
        this.tokenCommandHandler = tokenCommandHandler;
        this.tokenQueryHandler = tokenQueryHandler;
    }
}

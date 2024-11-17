package org.endless.domain.simplified.server.supporting.security.token.facade.adapter.spring;

import org.endless.domain.simplified.server.supporting.security.token.facade.adapter.*;
import org.endless.domain.simplified.server.supporting.security.token.application.command.handler.*;
import org.endless.domain.simplified.server.supporting.security.token.application.query.handler.*;
import org.endless.ddd.simplified.starter.common.exception.model.facade.adapter.*;

/**
 * SpringTokenDrivingAdapter
 * <p>令牌领域主动适配器Spring实现类
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
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

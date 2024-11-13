package org.endless.domain.simplified.server.supporting.security.token.facade.adapter.config;

import org.endless.domain.simplified.server.supporting.security.token.application.command.handler.TokenCommandHandler;
import org.endless.domain.simplified.server.supporting.security.token.application.command.handler.impl.TokenCommandHandlerImpl;
import org.endless.domain.simplified.server.supporting.security.token.application.query.handler.TokenQueryHandler;
import org.endless.domain.simplified.server.supporting.security.token.application.query.handler.impl.TokenQueryHandlerImpl;
import org.endless.domain.simplified.server.supporting.security.token.application.query.repository.TokenInfoQueryRepository;
import org.endless.domain.simplified.server.supporting.security.token.application.query.repository.TokenQueryRepository;
import org.endless.domain.simplified.server.supporting.security.token.domain.anticorruption.TokenRepository;
import org.endless.domain.simplified.server.supporting.security.token.facade.adapter.TokenDrivingAdapter;
import org.endless.domain.simplified.server.supporting.security.token.facade.adapter.spring.SpringTokenDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * TokenDrivingConfiguration
 * <p>令牌领域主动适配器配置类
 * <p>
 * create 2024/11/11 23:38
 * <p>
 * update 2024/11/11 23:38
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Lazy
@Configuration
public class TokenDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean TokenDrivingAdapter springTokenDrivingAdapter(TokenCommandHandler commandHandler, TokenQueryHandler queryHandler) {
        return new SpringTokenDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean TokenCommandHandler tokenCommandHandler(TokenRepository repository) {
        return new TokenCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean TokenQueryHandler tokenQueryHandler(TokenQueryRepository tokenQueryRepository, TokenInfoQueryRepository tokenInfoQueryRepository) {
        return new TokenQueryHandlerImpl(tokenQueryRepository, tokenInfoQueryRepository);
    }
}

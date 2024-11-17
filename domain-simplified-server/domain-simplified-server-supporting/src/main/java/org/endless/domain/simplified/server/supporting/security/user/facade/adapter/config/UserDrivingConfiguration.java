package org.endless.domain.simplified.server.supporting.security.user.facade.adapter.config;

import org.endless.domain.simplified.server.supporting.security.user.application.command.handler.*;
import org.endless.domain.simplified.server.supporting.security.user.application.command.handler.impl.*;
import org.endless.domain.simplified.server.supporting.security.user.application.query.handler.*;
import org.endless.domain.simplified.server.supporting.security.user.application.query.handler.impl.*;
import org.endless.domain.simplified.server.supporting.security.user.application.query.repository.*;
import org.endless.domain.simplified.server.supporting.security.user.domain.anticorruption.*;
import org.endless.domain.simplified.server.supporting.security.user.facade.adapter.*;
import org.endless.domain.simplified.server.supporting.security.user.facade.adapter.spring.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * UserDrivingConfiguration
 * <p>用户聚合领域主动适配器配置类
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Lazy
@Configuration
public class UserDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean UserDrivingAdapter springUserDrivingAdapter(UserCommandHandler commandHandler, UserQueryHandler queryHandler) {
        return new SpringUserDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean UserCommandHandler userCommandHandler(UserRepository repository) {
        return new UserCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean UserQueryHandler userQueryHandler(UserQueryRepository userQueryRepository) {
        return new UserQueryHandlerImpl(userQueryRepository);
    }
}

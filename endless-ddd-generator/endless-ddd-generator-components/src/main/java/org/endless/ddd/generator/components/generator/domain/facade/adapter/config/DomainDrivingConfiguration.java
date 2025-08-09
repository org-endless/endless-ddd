package org.endless.ddd.generator.components.generator.domain.facade.adapter.config;

import org.endless.ddd.generator.components.generator.domain.application.command.handler.DomainCommandHandler;
import org.endless.ddd.generator.components.generator.domain.application.command.handler.impl.DomainCommandHandlerImpl;
import org.endless.ddd.generator.components.generator.domain.application.query.anticorruption.AggregateFieldQueryRepository;
import org.endless.ddd.generator.components.generator.domain.application.query.anticorruption.DomainQueryRepository;
import org.endless.ddd.generator.components.generator.domain.application.query.handler.DomainQueryHandler;
import org.endless.ddd.generator.components.generator.domain.application.query.handler.impl.DomainQueryHandlerImpl;
import org.endless.ddd.generator.components.generator.domain.domain.anticorruption.DomainRepository;
import org.endless.ddd.generator.components.generator.domain.facade.adapter.DomainDrivingAdapter;
import org.endless.ddd.generator.components.generator.domain.facade.adapter.spring.SpringDomainDrivingAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * DomainDrivingConfiguration
 * <p>领域领域主动适配器配置类
 * <p>
 * create 2025/08/07 16:48
 * <p>
 * update 2025/08/07 16:48
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Lazy
@Configuration
public class DomainDrivingConfiguration {

    @Lazy
    @Primary
    @ConditionalOnMissingBean
    public @Bean DomainDrivingAdapter springDomainDrivingAdapter(DomainCommandHandler commandHandler, DomainQueryHandler queryHandler) {
        return new SpringDomainDrivingAdapter(commandHandler, queryHandler);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean DomainCommandHandler domainCommandHandler(DomainRepository repository) {
        return new DomainCommandHandlerImpl(repository);
    }

    @Lazy
    @ConditionalOnMissingBean
    protected @Bean DomainQueryHandler domainQueryHandler(DomainQueryRepository domainQueryRepository, AggregateFieldQueryRepository aggregateFieldQueryRepository) {
        return new DomainQueryHandlerImpl(domainQueryRepository, aggregateFieldQueryRepository);
    }
}

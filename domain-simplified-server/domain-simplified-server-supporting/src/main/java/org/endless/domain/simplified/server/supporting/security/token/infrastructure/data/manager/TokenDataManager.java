package org.endless.domain.simplified.server.supporting.security.token.infrastructure.data.manager;

import lombok.extern.slf4j.Slf4j;
import org.endless.domain.simplified.server.common.model.infrastructure.data.manager.DomainSimplifiedServerAggregateDataManager;
import org.endless.domain.simplified.server.supporting.security.token.application.query.repository.TokenQueryRepository;
import org.endless.domain.simplified.server.supporting.security.token.domain.anticorruption.TokenRepository;
import org.endless.domain.simplified.server.supporting.security.token.domain.entity.TokenAggregate;
import org.endless.domain.simplified.server.supporting.security.token.infrastructure.data.persistence.mapper.TokenInfoMapperSimplified;
import org.endless.domain.simplified.server.supporting.security.token.infrastructure.data.persistence.mapper.TokenMapperSimplified;
import org.endless.domain.simplified.server.supporting.security.token.infrastructure.data.record.TokenRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * TokenDataManager
 * <p>令牌聚合数据管理器
 * <p>
 * create 2024/11/11 23:38
 * <p>
 * update 2024/11/11 23:38
 *
 * @author Deng Haozhi
 * @see TokenRepository
 * @see TokenQueryRepository
 * @see DomainSimplifiedServerAggregateDataManager
 * @since 2.0.0
 */
@Slf4j
@Lazy
@Component
public class TokenDataManager implements TokenRepository, TokenQueryRepository, DomainSimplifiedServerAggregateDataManager<TokenRecord, TokenAggregate> {

    /**
     * 令牌聚合 Mybatis-Plus 数据访问对象
     */
    private final TokenMapperSimplified tokenMapper;

    /**
     * 令牌信息实体 Mybatis-Plus 数据访问对象
     */
    private final TokenInfoMapperSimplified tokenInfoMapper;

    public TokenDataManager(TokenMapperSimplified tokenMapper, TokenInfoMapperSimplified tokenInfoMapper) {
        this.tokenMapper = tokenMapper;
        this.tokenInfoMapper = tokenInfoMapper;
    }

    @Override
    public TokenAggregate save(TokenAggregate aggregate) {
        return null;
    }

    @Override
    public void remove(TokenAggregate aggregate) {

    }

    @Override
    public TokenAggregate modify(TokenAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<TokenAggregate> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<TokenAggregate> findByIdForUpdate(String id) {
        return Optional.empty();
    }
}

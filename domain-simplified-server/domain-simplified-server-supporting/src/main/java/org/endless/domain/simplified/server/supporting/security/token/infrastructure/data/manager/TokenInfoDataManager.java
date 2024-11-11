package org.endless.domain.simplified.server.supporting.security.token.infrastructure.data.manager;

import org.endless.domain.simplified.server.common.model.infrastructure.data.manager.*;
import org.endless.domain.simplified.server.supporting.security.token.application.query.repository.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.entity.*;
import org.endless.domain.simplified.server.supporting.security.token.infrastructure.data.persistence.mapper.*;
import org.endless.domain.simplified.server.supporting.security.token.infrastructure.data.record.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * TokenInfoDataManager
 * <p>令牌信息实体数据管理器
 * <p>
 * create 2024/11/11 23:38
 * <p>
 * update 2024/11/11 23:38
 *
 * @author Deng Haozhi
 * @see TokenInfoQueryRepository
 * @see DomainSimplifiedServerEntityDataManager
 * @since 2.0.0
 */
@Slf4j
@Lazy
@Component
public class TokenInfoDataManager implements TokenInfoQueryRepository, DomainSimplifiedServerEntityDataManager<TokenInfoRecord, TokenInfoEntity> {

    /**
     * 令牌信息实体 Mybatis-Plus 数据访问对象
     */
    private final TokenInfoMapperSimplified tokenInfoMapper;

    public TokenInfoDataManager(TokenInfoMapperSimplified tokenInfoMapper) {
        this.tokenInfoMapper = tokenInfoMapper;
    }
}

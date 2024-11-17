package org.endless.domain.simplified.server.supporting.security.user.infrastructure.data.manager;

import org.endless.domain.simplified.server.common.model.infrastructure.data.manager.DomainSimplifiedServerAggregateDataManager;
import org.endless.domain.simplified.server.supporting.security.user.application.query.repository.UserQueryRepository;
import org.endless.domain.simplified.server.supporting.security.user.domain.anticorruption.UserRepository;
import org.endless.domain.simplified.server.supporting.security.user.domain.entity.UserAggregate;
import org.endless.domain.simplified.server.supporting.security.user.infrastructure.data.persistence.mapper.UserMapper;
import org.endless.domain.simplified.server.supporting.security.user.infrastructure.data.persistence.mapper.UserRoleAssociationMapper;
import org.endless.domain.simplified.server.supporting.security.user.infrastructure.data.record.UserRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * UserDataManager
 * <p>用户聚合聚合数据管理器
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
 *
 * @author Deng Haozhi
 * @see UserRepository
 * @see UserQueryRepository
 * @see DomainSimplifiedServerAggregateDataManager
 * @since 2.0.0
 */
@Lazy
@Component
public class UserDataManager implements UserRepository, UserQueryRepository, DomainSimplifiedServerAggregateDataManager<UserRecord, UserAggregate> {

    /**
     * 用户聚合聚合 Mybatis-Plus 数据访问对象
     */
    private final UserMapper userMapper;

    /**
     * 用户聚合-用户角色关系 Mybatis-Plus 数据访问对象
     */
    private final UserRoleAssociationMapper userRoleAssociationMapper;

    public UserDataManager(UserMapper userMapper, UserRoleAssociationMapper userRoleAssociationMapper) {
        this.userMapper = userMapper;
        this.userRoleAssociationMapper = userRoleAssociationMapper;
    }

    @Override
    public UserAggregate save(UserAggregate aggregate) {
        return null;
    }

    @Override
    public void remove(UserAggregate aggregate) {

    }

    @Override
    public UserAggregate modify(UserAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<UserAggregate> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<UserAggregate> findByIdForUpdate(String id) {
        return Optional.empty();
    }
}

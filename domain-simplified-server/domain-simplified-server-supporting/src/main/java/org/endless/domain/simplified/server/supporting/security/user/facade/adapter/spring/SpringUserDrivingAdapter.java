package org.endless.domain.simplified.server.supporting.security.user.facade.adapter.spring;

import org.endless.domain.simplified.server.supporting.security.user.facade.adapter.*;
import org.endless.domain.simplified.server.supporting.security.user.application.command.handler.*;
import org.endless.domain.simplified.server.supporting.security.user.application.query.handler.*;
import org.endless.ddd.simplified.starter.common.exception.model.facade.adapter.*;

/**
 * SpringUserDrivingAdapter
 * <p>用户聚合领域主动适配器Spring实现类
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
 *
 * @author Deng Haozhi
 * @see UserDrivingAdapter
 * @since 2.0.0
 */
public class SpringUserDrivingAdapter implements UserDrivingAdapter {

    /**
     * 用户聚合领域命令处理器
     */
    private final UserCommandHandler userCommandHandler;

    /**
     * 用户聚合领域查询处理器
     */
    private final UserQueryHandler userQueryHandler;

    public SpringUserDrivingAdapter(UserCommandHandler userCommandHandler, UserQueryHandler userQueryHandler) {
        this.userCommandHandler = userCommandHandler;
        this.userQueryHandler = userQueryHandler;
    }
}

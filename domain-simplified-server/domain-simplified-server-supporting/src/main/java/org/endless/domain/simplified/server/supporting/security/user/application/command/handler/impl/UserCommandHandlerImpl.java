package org.endless.domain.simplified.server.supporting.security.user.application.command.handler.impl;

import org.endless.domain.simplified.server.supporting.security.user.application.command.handler.*;
import org.endless.domain.simplified.server.supporting.security.user.domain.anticorruption.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.*;

/**
 * UserCommandHandlerImpl
 * <p>用户聚合领域命令处理器
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
 *
 * @author Deng Haozhi
 * @see UserCommandHandler
 * @since 2.0.0
 */
public class UserCommandHandlerImpl implements UserCommandHandler {

    /**
     * 用户聚合聚合仓储接口
     */
    private final UserRepository userRepository;

    public UserCommandHandlerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

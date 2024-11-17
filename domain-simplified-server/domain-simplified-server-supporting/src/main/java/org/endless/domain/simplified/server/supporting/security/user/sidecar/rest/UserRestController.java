package org.endless.domain.simplified.server.supporting.security.user.sidecar.rest;

import org.endless.domain.simplified.server.common.model.sidecar.rest.*;
import org.endless.domain.simplified.server.supporting.security.user.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserRestController
 * <p>用户聚合领域Rest控制器
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
 *
 * @author Deng Haozhi
 * @see DomainSimplifiedServerRestController
 * @since 2.0.0
 */
@Lazy
@RestController
@RequestMapping("/security/user")
public class UserRestController implements DomainSimplifiedServerRestController {

    /**
     * 用户聚合领域主动适配器
     */
    private final UserDrivingAdapter userDrivingAdapter;

    public UserRestController(UserDrivingAdapter userDrivingAdapter) {
        this.userDrivingAdapter = userDrivingAdapter;
    }
}

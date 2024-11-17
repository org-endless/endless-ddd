package org.endless.domain.simplified.server.supporting.security.token.sidecar.rest;

import org.endless.domain.simplified.server.common.model.sidecar.rest.*;
import org.endless.domain.simplified.server.supporting.security.token.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TokenRestController
 * <p>令牌领域Rest控制器
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
@RequestMapping("/security/token")
public class TokenRestController implements DomainSimplifiedServerRestController {

    /**
     * 令牌领域主动适配器
     */
    private final TokenDrivingAdapter tokenDrivingAdapter;

    public TokenRestController(TokenDrivingAdapter tokenDrivingAdapter) {
        this.tokenDrivingAdapter = tokenDrivingAdapter;
    }
}

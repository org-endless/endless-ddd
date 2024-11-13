package org.endless.domain.simplified.server.supporting.security.token.sidecar.rest;

import lombok.extern.slf4j.Slf4j;
import org.endless.domain.simplified.server.common.model.sidecar.rest.DomainSimplifiedServerRestController;
import org.endless.domain.simplified.server.supporting.security.token.facade.adapter.TokenDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TokenRestController
 * <p>令牌领域 Rest 控制器
 * <p>
 * create 2024/11/11 23:38
 * <p>
 * update 2024/11/11 23:38
 *
 * @author Deng Haozhi
 * @see DomainSimplifiedServerRestController
 * @since 2.0.0
 */
@Slf4j
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

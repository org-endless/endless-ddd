package org.endless.domain.simplified.server.supporting.security.token.application.command.transfer;

import org.endless.domain.simplified.server.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.validate.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.type.*;
import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TokenRefreshReqCTransfer
 * <p>刷新令牌请求传输对象
 * <p>
 * create 2024/11/11 23:38
 * <p>
 * update 2024/11/11 23:38
 *
 * @author Deng Haozhi
 * @see DomainSimplifiedServerCommandTransfer
 * @since 2.0.0
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"tokenId", "tokenInfos"})
public class TokenRefreshReqCTransfer implements DomainSimplifiedServerCommandTransfer {

    /**
     * 令牌ID
     */
    private final String tokenId;

    /**
     * 令牌信息列表
     */
    private final List<TokenInfoRespCTransfer> tokenInfos;

    @Override
    public TokenRefreshReqCTransfer validate() {
        validateTokenId();
        validateTokenInfos();
        return this;
    }

    private void validateTokenId() {
        if (!StringUtils.hasText(tokenId)) {
            throw new ValidateException("令牌ID不能为空");
        }
    }

    private void validateTokenInfos() {
        if (tokenInfos == null || tokenInfos.isEmpty()) {
            throw new ValidateException("令牌信息列表不能为 null 或空");
        }
    }
}

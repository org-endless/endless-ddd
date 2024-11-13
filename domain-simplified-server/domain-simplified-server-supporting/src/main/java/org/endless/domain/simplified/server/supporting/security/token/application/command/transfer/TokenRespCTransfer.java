package org.endless.domain.simplified.server.supporting.security.token.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.validate.ValidateException;
import org.endless.domain.simplified.server.common.model.application.command.transfer.DomainSimplifiedServerCommandTransfer;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * TokenRespCTransfer
 * <p>创建令牌响应传输对象
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
@JSONType(orders = {"tokenId", "userId", "tokenInfos"})
public class TokenRespCTransfer implements DomainSimplifiedServerCommandTransfer {

    /**
     * 令牌ID
     */
    private final String tokenId;

    /**
     * 用户ID
     */
    private final String userId;

    /**
     * 令牌信息列表
     */
    private final List<TokenInfoRespCTransfer> tokenInfos;

    @Override
    public TokenRespCTransfer validate() {
        validateTokenId();
        validateUserId();
        validateTokenInfos();
        return this;
    }

    private void validateTokenId() {
        if (!StringUtils.hasText(tokenId)) {
            throw new ValidateException("令牌ID不能为空");
        }
    }

    private void validateUserId() {
        if (!StringUtils.hasText(userId)) {
            throw new ValidateException("用户ID不能为空");
        }
    }

    private void validateTokenInfos() {
        if (tokenInfos == null || tokenInfos.isEmpty()) {
            throw new ValidateException("令牌信息列表不能为 null 或空");
        }
    }
}

package org.endless.domain.simplified.server.supporting.security.token.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.validate.ValidateException;
import org.endless.domain.simplified.server.common.model.application.command.transfer.DomainSimplifiedServerCommandTransfer;
import org.springframework.util.StringUtils;

/**
 * TokenCreateReqCTransfer
 * <p>创建令牌请求传输对象
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
@JSONType(orders = {"userId"})
public class TokenCreateReqCTransfer implements DomainSimplifiedServerCommandTransfer {

    /**
     * 用户ID
     */
    private final String userId;

    @Override
    public TokenCreateReqCTransfer validate() {
        validateUserId();
        return this;
    }

    private void validateUserId() {
        if (!StringUtils.hasText(userId)) {
            throw new ValidateException("用户ID不能为空");
        }
    }
}

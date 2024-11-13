package org.endless.domain.simplified.server.supporting.security.token.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.validate.ValidateException;
import org.endless.domain.simplified.server.common.model.application.command.transfer.DomainSimplifiedServerCommandTransfer;
import org.endless.domain.simplified.server.supporting.security.token.domain.type.TokenTypeEnum;
import org.springframework.util.StringUtils;

/**
 * TokenInfoRespCTransfer
 * <p>令牌信息命令响应传输对象
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
@JSONType(orders = {"tokenInfoId", "value", "issuedAt", "expiresAt", "type"})
public class TokenInfoRespCTransfer implements DomainSimplifiedServerCommandTransfer {

    /**
     * 令牌信息ID
     */
    private final String tokenInfoId;

    /**
     * 令牌值
     */
    private final String value;

    /**
     * 令牌生成时间
     */
    private final Long issuedAt;

    /**
     * 令牌过期时间
     */
    private final Long expiresAt;

    /**
     * 令牌类型
     */
    private final TokenTypeEnum type;

    @Override
    public TokenInfoRespCTransfer validate() {
        validateTokenInfoId();
        validateValue();
        validateIssuedAt();
        validateExpiresAt();
        validateType();
        return this;
    }

    private void validateTokenInfoId() {
        if (!StringUtils.hasText(tokenInfoId)) {
            throw new ValidateException("令牌信息ID不能为空");
        }
    }

    private void validateValue() {
        if (!StringUtils.hasText(value)) {
            throw new ValidateException("令牌值不能为空");
        }
    }

    private void validateIssuedAt() {
        if (issuedAt == null || issuedAt < 0) {
            throw new ValidateException("令牌生成时间不能为 null 或小于 0，当前值为：" + issuedAt);
        }
    }

    private void validateExpiresAt() {
        if (expiresAt == null || expiresAt < 0) {
            throw new ValidateException("令牌过期时间不能为 null 或小于 0，当前值为：" + expiresAt);
        }
    }

    private void validateType() {
        if (type == null) {
            throw new ValidateException("令牌类型不能为 null");
        }
    }
}

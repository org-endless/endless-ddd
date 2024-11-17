package org.endless.domain.simplified.server.supporting.security.token.domain.value;

import org.endless.domain.simplified.server.common.model.domain.value.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.type.*;
import org.endless.ddd.simplified.starter.common.exception.model.domain.value.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * TokenInfoValue
 * <p>令牌信息
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
 *
 * @author Deng Haozhi
 * @see DomainSimplifiedServerValue
 * @since 2.0.0
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class TokenInfoValue implements DomainSimplifiedServerValue {

    /**
     * 用户ID
     */
    private final String userId;

    /**
     * 令牌值
     */
    private final String value;

    /**
     * 客户端IP地址
     */
    private final String ipAddress;

    /**
     * HTTP指纹
     */
    private final String userAgent;

    /**
     * 令牌生成时间
     */
    private final Long issuedAt;

    /**
     * 令牌过期时间
     */
    private final Long expiresAt;

    public static TokenInfoValue create(TokenInfoValueBuilder builder) {
        return builder
                .userId(builder.userId)
                .value(builder.value)
                .ipAddress(builder.ipAddress)
                .userAgent(builder.userAgent)
                .issuedAt(builder.issuedAt)
                .expiresAt(builder.expiresAt)
            .innerBuild()
            .validate();
    }

    @Override
    public TokenInfoValue validate() {
        validateUserId();
        validateValue();
        validateIpAddress();
        validateUserAgent();
        validateIssuedAt();
        validateExpiresAt();
        return this;
    }

    private void validateUserId() {
        if (!StringUtils.hasText(userId)) {
            throw new ValueValidateException("用户ID不能为空");
        }
    }

    private void validateValue() {
        if (!StringUtils.hasText(value)) {
            throw new ValueValidateException("令牌值不能为空");
        }
    }

    private void validateIpAddress() {
        if (!StringUtils.hasText(ipAddress)) {
            throw new ValueValidateException("客户端IP地址不能为空");
        }
    }

    private void validateUserAgent() {
        if (!StringUtils.hasText(userAgent)) {
            throw new ValueValidateException("HTTP指纹不能为空");
        }
    }

    private void validateIssuedAt() {
        if (issuedAt == null || issuedAt < 0) {
            throw new ValueValidateException("令牌生成时间不能为 null 或小于 0，当前值为: " + issuedAt);
        }
    }

    private void validateExpiresAt() {
        if (expiresAt == null || expiresAt < 0) {
            throw new ValueValidateException("令牌过期时间不能为 null 或小于 0，当前值为: " + expiresAt);
        }
    }
}

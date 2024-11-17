package org.endless.domain.simplified.server.supporting.security.user.domain.value;

import org.endless.domain.simplified.server.common.model.domain.value.*;
import org.endless.ddd.simplified.starter.common.exception.model.domain.value.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * PasswordValue
 * <p>密码信息
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
public class PasswordValue implements DomainSimplifiedServerValue {

    /**
     * 加密的密码
     */
    private final String hashed;

    /**
     * 加盐值
     */
    private final String salt;

    /**
     * 密码过期时间
     */
    private final String expiresAt;

    /**
     * 上次加密的密码
     */
    private final String lastHashed;

    /**
     * 剩余尝试次数
     */
    private final Integer attemptsLeft;

    /**
     * 锁定到期时间
     */
    private final Long lockedUntil;

    public static PasswordValue create(PasswordValueBuilder builder) {
        return builder
                .hashed(builder.hashed)
                .salt(builder.salt)
                .expiresAt(builder.expiresAt)
                .lastHashed(builder.lastHashed)
                .attemptsLeft(builder.attemptsLeft)
                .lockedUntil(builder.lockedUntil)
            .innerBuild()
            .validate();
    }

    @Override
    public PasswordValue validate() {
        validateHashed();
        validateSalt();
        validateExpiresAt();
        validateLastHashed();
        validateAttemptsLeft();
        validateLockedUntil();
        return this;
    }

    private void validateHashed() {
        if (!StringUtils.hasText(hashed)) {
            throw new ValueValidateException("加密的密码不能为空");
        }
    }

    private void validateSalt() {
        if (!StringUtils.hasText(salt)) {
            throw new ValueValidateException("加盐值不能为空");
        }
    }

    private void validateExpiresAt() {
        if (!StringUtils.hasText(expiresAt)) {
            throw new ValueValidateException("密码过期时间不能为空");
        }
    }

    private void validateLastHashed() {
        if (!StringUtils.hasText(lastHashed)) {
            throw new ValueValidateException("上次加密的密码不能为空");
        }
    }

    private void validateAttemptsLeft() {
        if (attemptsLeft == null || attemptsLeft < 0) {
            throw new ValueValidateException("剩余尝试次数不能为 null 或小于 0，当前值为: " + attemptsLeft);
        }
    }

    private void validateLockedUntil() {
        if (lockedUntil == null || lockedUntil < 0) {
            throw new ValueValidateException("锁定到期时间不能为 null 或小于 0，当前值为: " + lockedUntil);
        }
    }
}

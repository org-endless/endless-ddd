package org.endless.domain.simplified.server.supporting.security.token.domain.entity;

import org.endless.domain.simplified.server.common.model.domain.entity.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.type.*;
import org.endless.ddd.simplified.starter.common.exception.domain.entity.*;
import org.endless.ddd.simplified.starter.common.exception.validate.*;
import org.endless.ddd.simplified.starter.common.utils.id.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TokenInfoEntity
 * <p>令牌信息实体
 * <p>
 * create 2024/11/11 23:38
 * <p>
 * update 2024/11/11 23:38
 *
 * @author Deng Haozhi
 * @see DomainSimplifiedServerEntity
 * @since 2.0.0
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class TokenInfoEntity implements DomainSimplifiedServerEntity {

    /**
     * 令牌信息ID
     */
    private final String tokenInfoId;

    /**
     * 令牌值
     */
    private String value;

    /**
     * 令牌生成时间
     */
    private Long issuedAt;

    /**
     * 令牌过期时间
     */
    private Long expiresAt;

    /**
     * 令牌类型
     */
    private TokenTypeEnum type;

    /**
     * 创建者ID
     */
    private final String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    public static TokenInfoEntity create(TokenInfoEntityBuilder builder) {
        return builder
                .tokenInfoId(IdGenerator.getId())
                .value(builder.value)
                .issuedAt(builder.issuedAt)
                .expiresAt(builder.expiresAt)
                .type(builder.type)
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    protected TokenInfoEntity remove() {
        if (this.isRemoved) {
            throw new EntityRemoveException("已经被删除的实体<TokenInfoEntity>不能再次删除, ID：" + tokenInfoId);
        }
        if (!canRemove()) {
            throw new EntityRemoveException("实体<TokenInfoEntity>处于不可删除状态, ID：" + tokenInfoId);
        }
        this.isRemoved = true;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public TokenInfoEntity validate() {
        validateTokenInfoId();
        validateValue();
        validateIssuedAt();
        validateExpiresAt();
        validateType();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
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

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new ValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new ValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new ValidateException("是否已删除不能为 null");
        }
    }
}

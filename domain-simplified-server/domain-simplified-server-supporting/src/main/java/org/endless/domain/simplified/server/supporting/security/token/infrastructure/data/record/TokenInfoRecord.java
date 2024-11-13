package org.endless.domain.simplified.server.supporting.security.token.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.simplified.starter.common.exception.validate.ValidateException;
import org.endless.domain.simplified.server.common.model.infrastructure.data.record.DomainSimplifiedServerRecord;
import org.endless.domain.simplified.server.supporting.security.token.domain.entity.TokenInfoEntity;
import org.endless.domain.simplified.server.supporting.security.token.domain.type.TokenTypeEnum;
import org.springframework.util.StringUtils;

/**
 * TokenInfoRecord
 * <p>令牌信息数据库记录实体
 * <p>
 * create 2024/11/11 23:38
 * <p>
 * update 2024/11/11 23:38
 *
 * @author Deng Haozhi
 * @see DomainSimplifiedServerRecord
 * @since 2.0.0
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "security_token_token_info")
public class TokenInfoRecord implements DomainSimplifiedServerRecord<TokenInfoEntity> {

    /**
     * 令牌信息ID
     */
    @TableId
    private String tokenInfoId;

    /**
     * TokenAggregateID
     */
    private String tokenId;

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
    private String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createAt;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long modifyAt;

    protected static TokenInfoRecord from(TokenInfoEntity entity, String tokenId) {
        return TokenInfoRecord.builder()
                 .tokenInfoId(entity.getTokenInfoId())
                 .tokenId(tokenId)
                .value(entity.getValue())
                .issuedAt(entity.getIssuedAt())
                .expiresAt(entity.getExpiresAt())
                .type(entity.getType())
                .createUserId(entity.getCreateUserId())
                .modifyUserId(entity.getModifyUserId())
                .isRemoved(entity.getIsRemoved())
                .build()
                .validate();
    }

    protected TokenInfoEntity to() {
        validate();
        return TokenInfoEntity.builder()
                .tokenInfoId(tokenInfoId)
                .value(value)
                .issuedAt(issuedAt)
                .expiresAt(expiresAt)
                .type(type)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public TokenInfoRecord validate() {
        validateTokenInfoId();
        validateTokenId();
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

    private void validateTokenId() {
        if (!StringUtils.hasText(tokenId)) {
            throw new ValidateException("TokenAggregateID不能为空");
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

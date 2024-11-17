package org.endless.domain.simplified.server.supporting.security.token.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.endless.domain.simplified.server.common.model.infrastructure.data.record.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.entity.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.value.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.type.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.utils.id.*;
import lombok.*;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TokenRecord
 * <p>令牌数据库记录实体
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
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
@TableName(value = "security_token")
public class TokenRecord implements DomainSimplifiedServerRecord<TokenAggregate> {

    /**
     * 令牌ID
     */
    @TableId
    private String tokenId;

    /**
     * 令牌类型
     */
    private TokenTypeEnum type;

    /**
     * 用户ID
     */
    private String infoUserId;

    /**
     * 令牌值
     */
    private String infoValue;

    /**
     * 客户端IP地址
     */
    private String infoIpAddress;

    /**
     * HTTP指纹
     */
    private String infoUserAgent;

    /**
     * 令牌生成时间
     */
    private Long infoIssuedAt;

    /**
     * 令牌过期时间
     */
    private Long infoExpiresAt;

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

    public static TokenRecord from(TokenAggregate aggregate) {
        String tokenId = aggregate.getTokenId();
        return TokenRecord.builder()
                .tokenId(tokenId)
                .type(aggregate.getType())
                .infoUserId(aggregate.getInfo().getUserId())
                .infoValue(aggregate.getInfo().getValue())
                .infoIpAddress(aggregate.getInfo().getIpAddress())
                .infoUserAgent(aggregate.getInfo().getUserAgent())
                .infoIssuedAt(aggregate.getInfo().getIssuedAt())
                .infoExpiresAt(aggregate.getInfo().getExpiresAt())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build();
    }

    public TokenAggregate to() {
        validate();
        return TokenAggregate.builder()
                .tokenId(tokenId)
                .type(type)
                .info(TokenInfoValue.builder()
                        .userId(infoUserId)
                        .value(infoValue)
                        .ipAddress(infoIpAddress)
                        .userAgent(infoUserAgent)
                        .issuedAt(infoIssuedAt)
                        .expiresAt(infoExpiresAt)
                        .innerBuild())
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public TokenRecord validate() {
        validateTokenId();
        validateType();
        validateInfoUserId();
        validateInfoValue();
        validateInfoIpAddress();
        validateInfoUserAgent();
        validateInfoIssuedAt();
        validateInfoExpiresAt();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateTokenId() {
        if (!StringUtils.hasText(tokenId)) {
            throw new DataRecordValidateException("令牌ID不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new DataRecordValidateException("令牌类型不能为 null ");
        }
    }

    private void validateInfoUserId() {
        if (!StringUtils.hasText(infoUserId)) {
            throw new DataRecordValidateException("用户ID不能为空");
        }
    }

    private void validateInfoValue() {
        if (!StringUtils.hasText(infoValue)) {
            throw new DataRecordValidateException("令牌值不能为空");
        }
    }

    private void validateInfoIpAddress() {
        if (!StringUtils.hasText(infoIpAddress)) {
            throw new DataRecordValidateException("客户端IP地址不能为空");
        }
    }

    private void validateInfoUserAgent() {
        if (!StringUtils.hasText(infoUserAgent)) {
            throw new DataRecordValidateException("HTTP指纹不能为空");
        }
    }

    private void validateInfoIssuedAt() {
        if (infoIssuedAt == null || infoIssuedAt < 0) {
            throw new DataRecordValidateException("令牌生成时间不能为 null 或小于 0，当前值为: " + infoIssuedAt);
        }
    }

    private void validateInfoExpiresAt() {
        if (infoExpiresAt == null || infoExpiresAt < 0) {
            throw new DataRecordValidateException("令牌过期时间不能为 null 或小于 0，当前值为: " + infoExpiresAt);
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DataRecordValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new DataRecordValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new DataRecordValidateException("是否已删除不能为 null ");
        }
    }
}

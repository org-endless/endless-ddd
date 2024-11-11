package org.endless.domain.simplified.server.supporting.security.token.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.endless.domain.simplified.server.common.model.infrastructure.data.record.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.entity.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.type.*;
import org.endless.ddd.simplified.starter.common.exception.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.validate.*;
import org.endless.ddd.simplified.starter.common.utils.id.*;
import lombok.*;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TokenRecord
 * <p>令牌数据库记录实体
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
@TableName(value = "security_token")
public class TokenRecord implements DomainSimplifiedServerRecord<TokenAggregate> {

    /**
     * 令牌ID
     */
    @TableId
    private String tokenId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 令牌信息列表
     */
    @TableField(exist = false)
    @Builder.Default
    private final List<TokenInfoRecord> tokenInfos = new ArrayList<>();

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
                .userId(aggregate.getUserId())
                .tokenInfos(aggregate.getTokenInfos() == null ? new ArrayList<>() : aggregate.getTokenInfos().stream()
                        .map(record -> TokenInfoRecord.from(record, tokenId)).collect(Collectors.toList()))
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public TokenAggregate to() {
        validate();
        return TokenAggregate.builder()
                .tokenId(tokenId)
                .userId(userId)
                .tokenInfos(tokenInfos== null? new ArrayList<>() : tokenInfos.stream()
                        .map(TokenInfoRecord::to).collect(Collectors.toList()))
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    public TokenRecord addTokenInfo(TokenInfoRecord tokenInfo) {
        if (tokenInfo == null) {
            throw new DataRecordAddListException("数据库实体要添加的子实体 TokenInfoRecord 不能为 null");
        }
        this.tokenInfos.add(tokenInfo);
        return this;
    }

    public TokenRecord addTokenInfos(List<TokenInfoRecord> tokenInfos) {
        if (tokenInfos == null || tokenInfos.isEmpty()) {
                throw new DataRecordAddListException("数据库实体要添加的子实体列表 List<TokenInfoRecord> 不能为空");
        }
        this.tokenInfos.addAll(tokenInfos);
        return this;
    }

    @Override
    public TokenRecord validate() {
        validateTokenId();
        validateUserId();
        validateTokenInfos();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
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

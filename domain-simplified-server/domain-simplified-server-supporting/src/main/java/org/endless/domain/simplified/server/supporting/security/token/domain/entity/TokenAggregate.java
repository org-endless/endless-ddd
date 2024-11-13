package org.endless.domain.simplified.server.supporting.security.token.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.domain.entity.AggregateAddItemException;
import org.endless.ddd.simplified.starter.common.exception.domain.entity.AggregateRemoveException;
import org.endless.ddd.simplified.starter.common.exception.validate.ValidateException;
import org.endless.ddd.simplified.starter.common.utils.id.IdGenerator;
import org.endless.domain.simplified.server.common.model.domain.entity.DomainSimplifiedServerAggregate;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TokenAggregate
 * <p>令牌聚合根
 * <p>
 * create 2024/11/11 23:38
 * <p>
 * update 2024/11/11 23:38
 *
 * @author Deng Haozhi
 * @see DomainSimplifiedServerAggregate
 * @since 2.0.0
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class TokenAggregate implements DomainSimplifiedServerAggregate {

    /**
     * 令牌ID
     */
    private final String tokenId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 令牌信息列表
     */
    private final List<TokenInfoEntity> tokenInfos;

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

    public static TokenAggregate create(TokenAggregateBuilder builder) {
        return builder
                .tokenId(IdGenerator.getId())
                .userId(builder.userId)
                .tokenInfos(builder.tokenInfos == null ? new ArrayList<>() : new ArrayList<>(builder.tokenInfos))
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    public TokenAggregate remove() {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<TokenAggregate>不能再次删除, ID：" + tokenId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<TokenAggregate>处于不可删除状态, ID：" + tokenId);
        }
        this.tokenInfos.forEach(TokenInfoEntity::remove);
        this.isRemoved = true;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    public TokenAggregate addTokenInfo(TokenInfoEntity tokenInfo) {
        if (tokenInfo == null) {
            throw new AggregateAddItemException("聚合根要添加的子实体 TokenInfoEntity 不能为 null");
        }
        this.tokenInfos.add(tokenInfo);
        return this;
    }

    public TokenAggregate addTokenInfos(List<TokenInfoEntity> tokenInfos) {
        if (tokenInfos == null || tokenInfos.isEmpty()) {
                throw new AggregateAddItemException("聚合根要添加的子实体列表 List<TokenInfoEntity> 不能为空");
        }
        this.tokenInfos.addAll(tokenInfos);
        return this;
    }

    public void removeTokenInfo(TokenInfoEntity tokenInfo) {
        if (tokenInfo == null) {
            throw new AggregateRemoveException("聚合根要删除的子实体 TokenInfoEntity 不能为 null");
        }
        this.tokenInfos.remove(tokenInfo);
    }

    public void removeTokenInfos(List<TokenInfoEntity> tokenInfos) {
        if (tokenInfos == null || tokenInfos.isEmpty()) {
            throw new AggregateRemoveException("聚合根要删除的子实体列表 List<TokenInfoEntity> 不能为 null");
        }
        this.tokenInfos.removeAll(tokenInfos);
    }

    @Override
    public TokenAggregate validate() {
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

package org.endless.domain.simplified.server.supporting.security.token.domain.entity;

import org.endless.domain.simplified.server.common.model.domain.entity.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.value.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.type.*;
import org.endless.ddd.simplified.starter.common.exception.model.domain.entity.*;
import org.endless.ddd.simplified.starter.common.utils.id.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TokenAggregate
 * <p>令牌聚合根
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
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
     * 令牌类型
     */
    private TokenTypeEnum type;

    /**
     * 令牌信息
     */
    private TokenInfoValue info;

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
                .type(builder.type)
                .info(builder.info)
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    public TokenAggregate remove() {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<令牌聚合根>不能再次删除, ID: " + tokenId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<令牌聚合根>处于不可删除状态, ID: " + tokenId);
        }
        this.isRemoved = true;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public TokenAggregate validate() {
        validateTokenId();
        validateType();
        validateInfo();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateTokenId() {
        if (!StringUtils.hasText(tokenId)) {
            throw new AggregateValidateException("令牌ID不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new AggregateValidateException("令牌类型不能为 null ");
        }
    }

    private void validateInfo() {
        if (info == null) {
            throw new AggregateValidateException("令牌信息不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new AggregateValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new AggregateValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new AggregateValidateException("是否已删除不能为 null ");
        }
    }
}

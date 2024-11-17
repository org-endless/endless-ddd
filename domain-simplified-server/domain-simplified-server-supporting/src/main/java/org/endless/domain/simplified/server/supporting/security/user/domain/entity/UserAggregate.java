package org.endless.domain.simplified.server.supporting.security.user.domain.entity;

import org.endless.domain.simplified.server.common.model.domain.entity.*;
import org.endless.domain.simplified.server.supporting.security.user.domain.value.*;
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
 * UserAggregate
 * <p>用户聚合聚合根
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
public class UserAggregate implements DomainSimplifiedServerAggregate {

    /**
     * 用户id
     */
    private final String userId;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 密码
     */
    private PasswordValue password;

    /**
     * 用户角色ID列表
     */
    private final List<String> roleIds;

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

    public static UserAggregate create(UserAggregateBuilder builder) {
        return builder
                .userId(IdGenerator.getId())
                .username(builder.username)
                .email(builder.email)
                .password(builder.password)
                .roleIds(builder.roleIds == null ? new ArrayList<>() : new ArrayList<>(builder.roleIds))
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    public UserAggregate remove() {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<用户聚合聚合根>不能再次删除, ID: " + userId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<用户聚合聚合根>处于不可删除状态, ID: " + userId);
        }
        this.roleIds.clear();
        this.isRemoved = true;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    public UserAggregate addRoleId(String roleId) {
        if (!StringUtils.hasText(roleId)) {
            throw new AggregateAddItemException("聚合根要添加的子实体 String 不能为 null");
        }
        this.roleIds.add(roleId);
        return this;
    }

    public UserAggregate addRoleIds(List<String> roleIds) {
        if (roleIds == null || roleIds.isEmpty()) {
                throw new AggregateAddItemException("聚合根要添加的子实体列表 List<String> 不能为空");
        }
        this.roleIds.addAll(roleIds);
        return this;
    }

    public void removeRoleId(String roleId) {
        if (roleId == null) {
            throw new AggregateRemoveItemException("聚合根要删除的子实体 String 不能为 null");
        }
        this.roleIds.remove(roleId);
    }

    public void removeRoleIds(List<String> roleIds) {
        if (roleIds == null || roleIds.isEmpty()) {
            throw new AggregateRemoveItemException("聚合根要删除的子实体列表 List<String> 不能为 null");
        }
        this.roleIds.removeAll(roleIds);
    }

    @Override
    public UserAggregate validate() {
        validateUserId();
        validateUsername();
        validateEmail();
        validatePassword();
        validateRoleIds();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateUserId() {
        if (!StringUtils.hasText(userId)) {
            throw new AggregateValidateException("用户id不能为空");
        }
    }

    private void validateUsername() {
        if (!StringUtils.hasText(username)) {
            throw new AggregateValidateException("用户名称不能为空");
        }
    }

    private void validateEmail() {
        if (!StringUtils.hasText(email)) {
            throw new AggregateValidateException("用户邮箱不能为空");
        }
    }

    private void validatePassword() {
        if (password == null) {
            throw new AggregateValidateException("密码不能为 null ");
        }
    }

    private void validateRoleIds() {
        if (CollectionUtils.isEmpty(roleIds)) {
            throw new AggregateValidateException("用户角色ID列表不能为空");
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

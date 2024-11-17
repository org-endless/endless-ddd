package org.endless.domain.simplified.server.supporting.security.user.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.endless.domain.simplified.server.common.model.infrastructure.data.record.*;
import org.endless.domain.simplified.server.supporting.security.user.domain.entity.*;
import org.endless.domain.simplified.server.supporting.security.user.domain.value.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.utils.id.*;
import lombok.*;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UserRecord
 * <p>用户聚合数据库记录实体
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
@TableName(value = "security_user")
public class UserRecord implements DomainSimplifiedServerRecord<UserAggregate> {

    /**
     * 用户id
     */
    @TableId
    private String userId;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 加密的密码
     */
    private String passwordHashed;

    /**
     * 加盐值
     */
    private String passwordSalt;

    /**
     * 密码过期时间
     */
    private String passwordExpiresAt;

    /**
     * 上次加密的密码
     */
    private String passwordLastHashed;

    /**
     * 剩余尝试次数
     */
    private Integer passwordAttemptsLeft;

    /**
     * 锁定到期时间
     */
    private Long passwordLockedUntil;

    /**
     * 用户角色ID列表
     */
    @TableField(exist = false)
    @Builder.Default
    private final List<String> roleIds = new ArrayList<>();

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

    public static UserRecord from(UserAggregate aggregate) {
        String userId = aggregate.getUserId();
        return UserRecord.builder()
                .userId(userId)
                .username(aggregate.getUsername())
                .email(aggregate.getEmail())
                .passwordHashed(aggregate.getPassword().getHashed())
                .passwordSalt(aggregate.getPassword().getSalt())
                .passwordExpiresAt(aggregate.getPassword().getExpiresAt())
                .passwordLastHashed(aggregate.getPassword().getLastHashed())
                .passwordAttemptsLeft(aggregate.getPassword().getAttemptsLeft())
                .passwordLockedUntil(aggregate.getPassword().getLockedUntil())
                .roleIds(aggregate.getRoleIds() == null ? new ArrayList<>() : new ArrayList<>(aggregate.getRoleIds()))
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build();
    }

    public UserAggregate to() {
        validate();
        return UserAggregate.builder()
                .userId(userId)
                .username(username)
                .email(email)
                .password(PasswordValue.builder()
                        .hashed(passwordHashed)
                        .salt(passwordSalt)
                        .expiresAt(passwordExpiresAt)
                        .lastHashed(passwordLastHashed)
                        .attemptsLeft(passwordAttemptsLeft)
                        .lockedUntil(passwordLockedUntil)
                        .innerBuild())
                .roleIds(roleIds== null? new ArrayList<>() : new ArrayList<>(roleIds))
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    public UserRecord addRoleId(String roleId) {
        if (!StringUtils.hasText(roleId)) {
            throw new DataRecordAddItemException("数据库实体要添加的子实体 String 不能为 null");
        }
        this.roleIds.add(roleId);
        return this;
    }

    public UserRecord addRoleIds(List<String> roleIds) {
        if (roleIds == null || roleIds.isEmpty()) {
                throw new DataRecordAddItemException("数据库实体要添加的子实体列表 List<String> 不能为空");
        }
        this.roleIds.addAll(roleIds);
        return this;
    }

    @Override
    public UserRecord validate() {
        validateUserId();
        validateUsername();
        validateEmail();
        validatePasswordHashed();
        validatePasswordSalt();
        validatePasswordExpiresAt();
        validatePasswordLastHashed();
        validatePasswordAttemptsLeft();
        validatePasswordLockedUntil();
        validateRoleIds();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateUserId() {
        if (!StringUtils.hasText(userId)) {
            throw new DataRecordValidateException("用户id不能为空");
        }
    }

    private void validateUsername() {
        if (!StringUtils.hasText(username)) {
            throw new DataRecordValidateException("用户名称不能为空");
        }
    }

    private void validateEmail() {
        if (!StringUtils.hasText(email)) {
            throw new DataRecordValidateException("用户邮箱不能为空");
        }
    }

    private void validatePasswordHashed() {
        if (!StringUtils.hasText(passwordHashed)) {
            throw new DataRecordValidateException("加密的密码不能为空");
        }
    }

    private void validatePasswordSalt() {
        if (!StringUtils.hasText(passwordSalt)) {
            throw new DataRecordValidateException("加盐值不能为空");
        }
    }

    private void validatePasswordExpiresAt() {
        if (!StringUtils.hasText(passwordExpiresAt)) {
            throw new DataRecordValidateException("密码过期时间不能为空");
        }
    }

    private void validatePasswordLastHashed() {
        if (!StringUtils.hasText(passwordLastHashed)) {
            throw new DataRecordValidateException("上次加密的密码不能为空");
        }
    }

    private void validatePasswordAttemptsLeft() {
        if (passwordAttemptsLeft == null || passwordAttemptsLeft < 0) {
            throw new DataRecordValidateException("剩余尝试次数不能为 null 或小于 0，当前值为: " + passwordAttemptsLeft);
        }
    }

    private void validatePasswordLockedUntil() {
        if (passwordLockedUntil == null || passwordLockedUntil < 0) {
            throw new DataRecordValidateException("锁定到期时间不能为 null 或小于 0，当前值为: " + passwordLockedUntil);
        }
    }

    private void validateRoleIds() {
        if (CollectionUtils.isEmpty(roleIds)) {
            throw new DataRecordValidateException("用户角色ID列表不能为空");
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

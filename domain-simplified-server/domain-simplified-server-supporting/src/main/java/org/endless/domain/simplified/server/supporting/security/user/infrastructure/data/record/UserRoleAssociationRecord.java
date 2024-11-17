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
 * UserRoleAssociationRecord
 * <p>用户聚合-用户角色关系数据库记录实体
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
@TableName(value = "security_user_role_association_record")
public class UserRoleAssociationRecord implements DomainSimplifiedServerRecord<UserAggregate> {

    /**
     * 用户聚合-用户角色ID
     */
    @TableId
    private String associationId;

    /**
     * 用户角色ID
     */
    private String roleId;

    /**
     * 用户聚合ID
     */
    private String userId;

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

    public static UserRoleAssociationRecord from(UserAggregate aggregate, String roleId) {
        return UserRoleAssociationRecord.builder()
                .associationId(IdGenerator.getId())
                .roleId(roleId)
                .userId(aggregate.getUserId())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build();
    }

    public String to() {
        validate();
        return roleId;
    }

    public UserRoleAssociationRecord remove() {
        if (this.isRemoved) {
            throw new DataRecordRemoveException("已经被删除的数据库记录<用户聚合-用户角色关系数据库记录实体>不能再次删除, ID: " + associationId);
        }
        if (!canRemove()) {
            throw new DataRecordRemoveException("数据库记录<用户聚合-用户角色关系数据库记录实体>处于不可删除状态, ID: " + associationId);
        }
        this.isRemoved = true;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public UserRoleAssociationRecord validate() {
        validateAssociationId();
        validateRoleId();
        validateUserId();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateAssociationId() {
        if (!StringUtils.hasText(associationId)) {
            throw new DataRecordValidateException("用户聚合-用户角色ID不能为空");
        }
    }

    private void validateRoleId() {
        if (!StringUtils.hasText(roleId)) {
            throw new DataRecordValidateException("用户角色ID不能为空");
        }
    }

    private void validateUserId() {
        if (!StringUtils.hasText(userId)) {
            throw new DataRecordValidateException("用户聚合ID不能为空");
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

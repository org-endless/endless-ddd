package org.endless.domain.simplified.server.supporting.security.user.application.query.transfer;

import org.endless.domain.simplified.server.common.model.application.query.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.transfer.*;
import org.endless.domain.simplified.server.supporting.security.user.domain.value.*;
import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UserFindByIdReqQTransfer
 * <p>根据ID查询用户请求传输对象
 * <p>
 * create 2024/11/17 16:54
 * <p>
 * update 2024/11/17 16:54
 *
 * @author Deng Haozhi
 * @see DomainSimplifiedServerQueryTransfer
 * @since 2.0.0
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"userId"})
public class UserFindByIdReqQTransfer implements DomainSimplifiedServerQueryTransfer {

    /**
     * 用户ID
     */
    private final String userId;

    @Override
    public UserFindByIdReqQTransfer validate() {
        validateUserId();
        return this;
    }

    private void validateUserId() {
        if (!StringUtils.hasText(userId)) {
            throw new QueryTransferValidateException("用户ID不能为空");
        }
    }
}

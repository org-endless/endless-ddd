package org.endless.domain.simplified.server.supporting.security.token.application.command.transfer;

import org.endless.domain.simplified.server.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.validate.*;
import org.endless.domain.simplified.server.supporting.security.token.domain.type.*;
import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TokenCreateReqCTransfer
 * <p>创建令牌请求传输对象
 * <p>
 * create 2024/11/11 23:38
 * <p>
 * update 2024/11/11 23:38
 *
 * @author Deng Haozhi
 * @see DomainSimplifiedServerCommandTransfer
 * @since 2.0.0
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"userId"})
public class TokenCreateReqCTransfer implements DomainSimplifiedServerCommandTransfer {

    /**
     * 用户ID
     */
    private final String userId;

    @Override
    public TokenCreateReqCTransfer validate() {
        validateUserId();
        return this;
    }

    private void validateUserId() {
        if (!StringUtils.hasText(userId)) {
            throw new ValidateException("用户ID不能为空");
        }
    }
}

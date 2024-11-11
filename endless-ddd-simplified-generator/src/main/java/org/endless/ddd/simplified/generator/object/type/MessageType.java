package org.endless.ddd.simplified.generator.object.type;

import lombok.Getter;

/**
 * MessageType
 * <p>
 * create 2024/11/05 10:08
 * <p>
 * update 2024/11/05 10:08
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Getter
public enum MessageType {

    REQUEST("REQUEST", "请求消息"),
    RESPONSE("RESPONSE", "响应消息");

    private final String code;

    private final String description;

    MessageType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}

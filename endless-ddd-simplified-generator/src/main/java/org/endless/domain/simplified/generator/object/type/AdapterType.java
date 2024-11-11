package org.endless.domain.simplified.generator.object.type;

import lombok.Getter;

/**
 * AdapterType
 * <p>
 * create 2024/10/23 09:35
 * <p>
 * update 2024/10/23 09:35
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Getter
public enum AdapterType {

    DRIVING("DRIVING", "主动适配器"),
    DRIVEN("DRIVEN", "被动适配器");

    private final String code;

    private final String description;

    AdapterType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}

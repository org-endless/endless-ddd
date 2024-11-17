package org.endless.ddd.simplified.generator.object.type;

import lombok.Getter;

/**
 * CQRSType
 * <p>
 * create 2024/11/05 10:04
 * <p>
 * update 2024/11/05 10:04
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Getter
public enum CQRSType {
    COMMAND("COMMAND", "命令模式"),
    QUERY("QUERY", "查询模式");

    private final String code;

    private final String description;

    CQRSType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}

package org.endless.ddd.starter.common.config.endless.constant;

import java.util.Set;

/**
 * EndlessConstant
 * <p>
 * create 2024/11/19 01:58
 * <p>
 * update 2024/11/19 01:58
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class EndlessConstant {

    public static final Set<String> SENSITIVE_KEYS = Set.of(
            "password", "passcode", "pwd", "secret", "key", "salt", "token", "verification");

    public static final String[] JSON_ALLOWED_TYPES = new String[]{
            "java.lang.String", "java.lang.Integer", "java.lang.Boolean", "java.util.List", "java.util.Map"
    };
}

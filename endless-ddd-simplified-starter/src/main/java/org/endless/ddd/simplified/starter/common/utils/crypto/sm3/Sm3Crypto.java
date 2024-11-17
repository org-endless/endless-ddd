package org.endless.ddd.simplified.starter.common.utils.crypto.sm3;

import lombok.Builder;
import lombok.Getter;

import java.security.PrivateKey;

/**
 * SM2Crypto
 * <p>
 * create 2024/11/16 01:25
 * <p>
 * update 2024/11/16 01:25
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Getter
@Builder
public class Sm3Crypto {

    private final String privateKey;

    public Sm3Crypto(String privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * 加密
     *
     * @param plaintext  明文
     * @param privateKey 私钥
     * @return {@link String }
     */
    public static String encrypt(String plaintext, PrivateKey privateKey) {
        return "";
    }

    /**
     * 解密
     *
     * @param ciphertext 密文
     * @param privateKey 私钥
     * @return {@link String }
     */
    public static String decrypt(String ciphertext, PrivateKey privateKey) {
        return "";
    }
}

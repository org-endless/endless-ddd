package org.endless.ddd.simplified.starter.common.utils.crypto.sm2;

import lombok.Builder;
import lombok.Getter;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.signers.SM2Signer;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.endless.ddd.simplified.starter.common.exception.utils.crypto.Sm2SignException;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;

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
public class SM2Crypto {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private final byte[] publicKey;

    private final byte[] privateKey;

    /**
     * 生成密钥对
     *
     * @return {@link KeyPair }
     */
    public static SM2Crypto generateKeyPair() {
        return null;
    }

    /**
     * 加密
     *
     * @param plaintext 明文
     * @param publicKey 公钥
     * @return {@link String }
     */
    public static byte[] encrypt(byte[] plaintext, byte[] publicKey) {
        return null;
    }

    /**
     * 解密
     *
     * @param ciphertext 密文
     * @param privateKey 私钥
     * @return {@link String }
     */
    public static byte[] decrypt(byte[] ciphertext, byte[] privateKey) {
        return null;
    }

    /**
     * 签名
     *
     * @param message    待签名消息
     * @param privateKey 私钥
     * @return {@link String }
     */
    public static byte[] sign(byte[] message, byte[] privateKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("EC", "BC");
            ECPrivateKeyParameters privateKeyParameters = (ECPrivateKeyParameters) keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKey));
            SM2Signer signer = new SM2Signer();
            signer.init(true, privateKeyParameters);
            signer.update(message, 0, message.length);
            return signer.generateSignature();
        } catch (Exception e) {
            throw new Sm2SignException("使用SM2签名失败: " + e.getMessage(), e);
        }
    }

    /**
     * 验签
     *
     * @param message   待验签消息
     * @param publicKey 公钥
     * @param signature 签名
     * @return boolean
     */
    public static boolean verify(byte[] message, byte[] publicKey, byte[] signature) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("EC", "BC");
            ECPrivateKeyParameters publicKeyParameters = (ECPrivateKeyParameters) keyFactory.generatePrivate(new PKCS8EncodedKeySpec(publicKey));
            SM2Signer signer = new SM2Signer();
            signer.init(false, publicKeyParameters);
            signer.update(message, 0, message.length);
            return signer.verifySignature(signature);
        } catch (Exception e) {
            throw new Sm2SignException("使用SM2验签失败: " + e.getMessage(), e);
        }
    }
}

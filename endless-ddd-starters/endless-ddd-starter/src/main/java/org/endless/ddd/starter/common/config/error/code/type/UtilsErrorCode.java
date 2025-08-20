package org.endless.ddd.starter.common.config.error.code.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.error.code.ErrorCode;

/**
 * UtilsErrorCode
 * <p>
 * create 2025/08/21 01:47
 * <p>
 * update 2025/08/21 01:48
 *
 * @author Deng Haozhi
 * @see Enum
 * @see ErrorCode
 * @since 1.0.0
 */
@Getter
@ToString
@AllArgsConstructor
public enum UtilsErrorCode implements ErrorCode {
    // 工具类错误码
    // 精度数值处理错误码
    UTL0010("UTL0010", "精度数值处理失败"),
    UTL0011("UTL0011", "精度数值为空"),
    UTL0012("UTL0012", "精度数值格式错误"),
    UTL0013("UTL0013", "精度数值超出范围"),
    UTL0014("UTL0014", "精度数值计算错误"),
    UTL0015("UTL0015", "精度计算除数不能为0"),
    // 日期时间处理错误码
    UTL0020("UTL0020", "时间戳处理失败"),
    UTL0021("UTL0021", "日期处理失败"),
    UTL0022("UTL0022", "日期时间处理失败"),
    // 对象处理错误码
    UTL0032("UTL0032", "对象处理失败"),
    // 加密解密错误码
    UTL0100("UTL0100", "加解密失败"),
    UTL0101("UTL0101", "SM2生成密钥对失败"),
    UTL0102("UTL0102", "SM2加密失败"),
    UTL0103("UTL0103", "SM2解密失败"),
    UTL0104("UTL0104", "SM2签名失败"),
    UTL0105("UTL0105", "SM2验签失败"),
    UTL0106("UTL0106", "SM3加解密失败"),
    UTL0107("UTL0107", "SM4加解密失败"),
    UTL0110("UTL0110", "RSA生成密钥对失败"),
    UTL0111("UTL0111", "RSA加密失败"),
    UTL0112("UTL0112", "RSA解密失败"),
    UTL0113("UTL0113", "RSA签名失败"),
    UTL0114("UTL0114", "RSA验签失败"),
    UTL0120("UTL0120", "AES生成密钥失败"),
    UTL0121("UTL0121", "AES加密失败"),
    UTL0122("UTL0122", "AES解密失败"),
    UTL0130("UTL0130", "PEM证书处理失败"),
    UTL0131("UTL0131", "PFX证书处理失败"),
    UTL0140("UTL0140", "PKCS1补位失败"),
    UTL0141("UTL0141", "PKCS1去除补位失败");

    private final String code;

    private final String description;

    public static void register() {
        for (UtilsErrorCode value : values()) {
            ErrorCode.Cache.register(value);
        }
    }
}

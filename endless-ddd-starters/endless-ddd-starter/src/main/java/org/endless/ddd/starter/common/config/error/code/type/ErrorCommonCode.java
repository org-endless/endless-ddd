package org.endless.ddd.starter.common.config.error.code.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.ddd.domain.type.BaseEnum;
import org.endless.ddd.starter.common.exception.ddd.domain.type.EnumException;

/**
 * ErrorCommonCode
 * <p>
 * create 2024/11/15 00:31
 * <p>
 * update 2024/11/15 00:31
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Getter
@ToString
@AllArgsConstructor
public enum ErrorCommonCode implements BaseEnum {


    // 数据库错误码
    DDP0100("DDP0100", "数据库操作失败"),
    DDP0101("DDP0101", "数据库操作状态未知"),
    DDP0110("DDP0110", "数据库新增操作失败"),
    DDP0111("DDP0111", "数据库新增操作状态未知"),
    DDP0120("DDP0120", "数据库删除操作失败"),
    DDP0121("DDP0121", "数据库删除操作状态未知"),
    DDP0130("DDP0130", "数据库修改操作失败"),
    DDP0131("DDP0131", "数据库修改操作状态未知"),
    DDP0140("DDP0140", "数据库新增或修改操作失败"),
    DDP0141("DDP0141", "数据库新增或修改操作状态未知"),
    DDP0150("DDP0150", "数据库查询失败"),
    DDP0160("DDP0160", "数据库批量操作失败"),

    // 工具类错误码
    UTL0000("UTL0000", "ID生成失败"),
    UTL0001("UTL0001", "雪花ID生成失败"),
    UTL0002("UTL0002", "加解密失败"),
    UTL0010("UTL0010", "精度数值计算错误"),
    UTL0011("UTL0011", "精度计算除数不能为0"),
    UTL0012("UTL0012", "精度数值为空"),
    UTL0013("UTL0013", "精度数值格式错误"),
    UTL0014("UTL0014", "精度数值超出范围"),
    UTL0022("UTL0022", "树结构处理失败"),
    UTL0100("UTL0100", "SM2生成密钥对失败"),
    UTL0101("UTL0101", "SM2加密失败"),
    UTL0102("UTL0102", "SM2解密失败"),
    UTL0103("UTL0103", "SM2签名失败"),
    UTL0104("UTL0104", "SM2验签失败"),
    UTL0110("UTL0110", "SM3加解密失败"),
    UTL0120("UTL0120", "SM4加解密失败"),
    UTL0130("UTL0130", "RSA生成密钥对失败"),
    UTL0131("UTL0131", "RSA加密失败"),
    UTL0132("UTL0132", "RSA解密失败"),
    UTL0133("UTL0133", "RSA签名失败"),
    UTL0134("UTL0134", "RSA验签失败"),
    UTL0140("UTL0140", "AES生成密钥失败"),
    UTL0141("UTL0141", "AES加密失败"),
    UTL0142("UTL0142", "AES解密失败"),
    UTL7000("UTL7000", "PEM证书处理失败"),
    UTL7010("UTL7010", "PFX证书处理失败"),
    UTL8000("UTL8000", "PKCS1补位失败"),
    UTL8001("UTL8000", "PKCS1去除补位失败"),
    UTL8002("UTL8002", "PKCS7补位失败"),
    UTL8003("UTL8003", "PKCS7去除补位失败"),

    // 安全模块错误码
    SEC0000("SEC0000", "初始化密码不能用于登录"),
    SEC0001("SEC0001", "用户名为空"),
    SEC0002("SEC0002", "密码为空"),
    SEC0003("SEC0003", "密码错误"),
    SEC0004("SEC0004", "密码格式错误"),
    SEC0010("SEC0010", "令牌请求无效"),
    SEC0011("SEC0011", "令牌生成失败"),
    SEC0012("SEC0012", "令牌刷新失败"),
    SEC0013("SEC0013", "令牌验证失败"),
    SEC0014("SEC0014", "令牌已过期"),
    SEC0020("SEC0020", "用户登出失败"),
    SEC0030("SEC0030", "HTTP指纹生成失败"),
    SEC0040("SEC0040", "认证请求参数错误"),
    SEC0050("SEC0050", "没有组织的访问权限"),
    SEC9020("SEC9020", "用户登出异常，状态未知"),

    // 身份认证模块错误码
    IDA0000("IDA0000", "客户未身份认证"),
    ;

    private final String code;

    private final String description;

    public static ErrorCommonCode fromCode(String code) {
        for (ErrorCommonCode type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的错误码: " + code);
    }
}

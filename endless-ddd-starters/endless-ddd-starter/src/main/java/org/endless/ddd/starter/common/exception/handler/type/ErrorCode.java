package org.endless.ddd.starter.common.exception.handler.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.ddd.domain.type.BaseEnum;
import org.endless.ddd.starter.common.exception.ddd.domain.type.EnumException;

/**
 * ErrorCode
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
public enum ErrorCode implements BaseEnum {


    // 业务错误码
    SUCCESS("SUCCESS", "服务处理成功"),
    FAILURE("FAILURE", "服务处理失败"),
    UNKNOWN("UNKNOWN", "服务处理状态未知"),
    UN_AUTH("UN_AUTH", "身份认证失败"),
    BAD_REQ("BAD_REQ", "请求参数错误"),
    NOT_FND("NOT_FND", "未找到相关资源"),
    FORBIDN("FORBIDN", "服务访问被拒绝"),

    CFG0000("CFG0000", "配置项加载失败"),
    CFG0100("CFG0100", "日志处理失败"),
    CFG0200("CFG0200", "MINIO配置加载失败"),
    CFG0400("CFG0400", "REDIS配置加载失败"),
    CFG0410("CFG0410", "REDIS序列化配置加载失败"),
    CFG0420("CFG0420", "REDIS_STREAM初始化失败"),
    CFG0421("CFG0421", "REDIS_STREAM_ADD操作处理失败"),
    RES0200("RES0200", "REST未找到相关资源"),


    // DDD通用错误码
    // 领域聚合
    DAG0000("DAG0000", "领域聚合为空"),
    DAG0001("DAG0001", "领域聚合校验失败"),

    // 领域实体
    DEN0000("DEN0000", "领域实体为空"),
    DEN0001("DEN0001", "领域实体校验失败"),

    // 领域服务
    DSV0000("DSV0000", "领域服务处理失败"),
    // 枚举
    DEM0000("DEM0000", "枚举处理失败"),
    // 数据仓储实体
    DDR0000("DDR0000", "数据仓储实体为空"),
    DDR0001("DDR0001", "数据仓储实体校验失败"),
    DDR0002("DDR0002", "数据仓储增加子项失败"),
    // 命令处理器处理失败
    DCD0000("DCD0000", "命令处理失败"),
    DCD0001("DCD0001", "创建命令处理失败"),
    DCD0002("DCD0002", "修改命令处理失败"),
    DCD0003("DCD0003", "删除命令处理失败"),
    DCD0010("DCD0010", "命令未找到相关信息"),
    // 命令处理器状态未知
    DCD9000("DCD9000", "命令处理状态未知"),
    DCD9001("DCD9001", "创建命令处理状态未知"),
    DCD9002("DCD9002", "修改命令处理状态未知"),
    DCD9003("DCD9003", "删除命令处理状态未知"),

    // 查询处理器处理失败
    DQR0000("DQR0000", "查询处理失败"),
    DQR0001("DQR0001", "未查询到相关信息"),


    // 数据管理器处理失败
    DDM0000("DDM0000", "数据管理器处理失败"),
    DDM0001("DDM0001", "数据管理器保存数据失败"),
    DDM0002("DDM0002", "数据管理器删除数据失败"),
    DDM0003("DDM0003", "数据管理器修改数据失败"),
    DDM0010("DDM0010", "数据管理器查询数据失败"),
    DDM0011("DDM0011", "数据管理器未查询到相关数据"),
    DDM0100("DDM0100", "数据管理器请求参数为空"),
    // 数据管理器状态未知
    DDM9000("DDM9000", "数据管理器处理状态未知"),
    DDM9001("DDM9001", "数据管理器保存数据状态未知"),
    DDM9002("DDM9002", "数据管理器删除数据状态未知"),
    DDM9003("DDM9003", "数据管理器修改数据状态未知"),

    // 文件系统异常
    DFS0000("DFS0000", "文件系统处理失败"),
    DFS0001("DFS0001", "文件系统存储失败"),
    DFS0002("DFS0002", "文件系统删除失败"),
    DFS0003("DFS0003", "文件系统读取失败"),
    DFS9000("DFS9000", "文件系统处理状态未知"),
    DFS9001("DFS9001", "文件系统存储状态未知"),
    DFS9002("DFS9002", "文件系统删除状态未知"),
    DFS9003("DFS9003", "文件系统读取状态未知"),

    DRT0000("DRT0000", "REST请求处理失败"),
    DRT0100("DRT0100", "REST响应处理失败"),
    // 传输对象
    DTO0000("DTO0000", "传输对象为空"),
    DTO0001("DTO0001", "传输对象校验失败"),
    DTO0101("DTO0101", "命令传输对象校验失败"),
    DTO0201("DTO0201", "查询传输对象校验失败"),
    DTO0301("DTO0301", "被动传输对象校验失败"),
    // 请求传输对象
    DTS0000("DTS0000", "请求传输对象为空"),
    DTS0100("DTS0100", "命令请求传输对象为空"),
    DTS0200("DTS0200", "查询请求传输对象为空"),
    DTS0300("DTS0300", "被动请求传输对象为空"),
    // 响应传输对象
    DTR0000("DTR0000", "响应传输对象为空"),
    DTR0100("DTR0100", "命令响应传输对象为空"),
    DTR0200("DTR0200", "查询响应传输对象为空"),
    DTR0300("DTR0300", "被动响应传输对象为空"),


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

    public static ErrorCode fromCode(String code) {
        for (ErrorCode type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的错误码: " + code);
    }
}

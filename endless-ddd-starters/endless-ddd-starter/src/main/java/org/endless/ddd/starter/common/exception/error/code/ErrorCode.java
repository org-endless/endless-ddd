package org.endless.ddd.starter.common.exception.error.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.ddd.domain.type.BaseEnum;
import org.endless.ddd.starter.common.exception.ddd.domain.type.EnumException;

/**
 * ErrorCode
 * <p>
 * create 2025/08/11 17:05
 * <p>
 * update 2025/08/11 17:26
 *
 * @author Deng Haozhi
 * @see BaseEnum
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
@ToString
public enum ErrorCode implements BaseEnum {

    // 公共错误码
    SUCCESS("SUCCESS", "服务处理成功"),
    FAILURE("FAILURE", "服务处理失败"),
    UNKNOWN("UNKNOWN", "服务处理状态未知"),
    UN_AUTH("UN_AUTH", "身份认证失败"),
    BAD_REQ("BAD_REQ", "请求参数错误"),
    NOT_FND("NOT_FND", "未找到相关资源"),
    FORBIDN("FORBIDN", "服务访问被拒绝"),

    // 配置项错误码
    CFG0000("CFG0000", "配置项加载失败"),
    CFG0100("CFG0100", "日志切面处理失败"),
    CFG0200("CFG0200", "REST配置项加载失败"),
    CFG0300("CFG0300", "MINIO配置加载失败"),
    CFG0400("CFG0400", "REDIS配置加载失败"),
    CFG0410("CFG0410", "REDIS序列化配置加载失败"),
    CFG0420("CFG0420", "REDIS-STREAM配置加载失败"),
    CFG0421("CFG0421", "REDIS-STREAM初始化失败"),
    CFG8000("CFG8000", "ID生成失败"),
    CFG8001("CFG8001", "雪花ID生成失败"),

    // DDD错误码
    // 命令处理器
    DCD0000("DCD0000", "命令处理失败"),
    DCD0001("DCD0001", "创建命令处理失败"),
    DCD0002("DCD0002", "删除命令处理失败"),
    DCD0003("DCD0003", "修改命令处理失败"),
    DCD0010("DCD0010", "命令未找到相关信息"),
    DCD9000("DCD9000", "命令处理状态未知"),
    DCD9001("DCD9001", "创建命令处理状态未知"),
    DCD9002("DCD9002", "删除命令处理状态未知"),
    DCD9003("DCD9003", "修改命令处理状态未知"),
    // 查询处理器
    DQR0000("DQR0000", "查询处理失败"),
    DQR0010("DQR0010", "查询未找到相关信息"),
    // 领域聚合
    DAG0000("DAG0000", "领域聚合处理失败"),
    DAG0001("DAG0001", "领域聚合为空"),
    DAG0002("DAG0002", "领域聚合校验失败"),
    DAG0100("DAG0100", "领域聚合创建失败"),
    DAG0101("DAG0101", "领域聚合删除失败"),
    DAG0102("DAG0102", "领域聚合修改失败"),
    DAG0200("DAG0200", "领域聚合增加子项失败"),
    DAG0201("DAG0201", "领域聚合增加子项列表失败"),
    DAG0202("DAG0202", "领域聚合删除子项失败"),
    DAG0203("DAG0203", "领域聚合删除子项列表失败"),
    DAG8000("DAG8000", "领域聚合行为方法参数为空"),
    DAG8001("DAG8001", "领域聚合行为方法参数校验失败"),
    DAG8100("DAG8100", "领域聚合行为方法返回值为空"),
    DAG8101("DAG8101", "领域聚合行为方法返回值校验失败"),
    // 领域实体
    DEN0000("DEN0000", "领域实体处理失败"),
    DEN0001("DEN0001", "领域实体为空"),
    DEN0002("DEN0002", "领域实体校验失败"),
    DEN0100("DEN0100", "领域实体创建失败"),
    DEN0101("DEN0101", "领域实体删除失败"),
    DEN0102("DEN0102", "领域实体修改失败"),
    DEN8000("DEN8000", "领域实体行为方法参数为空"),
    DEN8001("DEN8001", "领域实体行为方法参数校验失败"),
    DEN8100("DEN8100", "领域实体行为方法返回值为空"),
    DEN8101("DEN8101", "领域实体行为方法返回值校验失败"),
    // 领域事件
    DEV0000("DEV0000", "领域事件处理失败"),
    DEV9000("DEV9000", "领域事件处理状态未知"),
    // 领域服务
    DSV0000("DSV0000", "领域服务处理失败"),
    DSV9000("DSV9000", "领域服务处理状态未知"),
    // 枚举
    DEM0000("DEM0000", "枚举处理失败"),
    // 值对象
    DVO0000("DVO0000", "值对象处理失败"),
    DVO0001("DVO0001", "值对象为空"),
    DVO0002("DVO0002", "值对象校验失败"),
    // 被动适配器
    DDA0000("DDA0000", "被动适配器处理失败"),
    DDA0010("DDA0010", "被动适配器未找到相关信息"),
    DDA9000("DDA9000", "被动适配器处理状态未知"),
    // 数据管理器处理失败
    DDM0000("DDM0000", "数据管理器处理失败"),
    DDM0001("DDM0001", "数据管理器保存数据失败"),
    DDM0002("DDM0002", "数据管理器删除数据失败"),
    DDM0003("DDM0003", "数据管理器修改数据失败"),
    DDM1000("DDM1000", "数据管理器查询数据失败"),
    DDM1001("DDM1001", "数据管理器未查询到相关数据"),
    DDM8000("DDM8000", "数据管理器方法参数为空"),
    DDM8001("DDM8001", "数据管理器方法参数校验失败"),
    DDM8100("DDM8100", "数据管理器方法返回值为空"),
    DDM8101("DDM8101", "数据管理器方法返回值校验失败"),
    // 数据分页
    DPG0000("DPG0000", "数据分页处理失败"),
    DPG1001("DPG1001", "数据分页查询失败"),
    // 数据仓储实体
    DDR0000("DDR0000", "数据仓储实体处理失败"),
    DDR0001("DDR0001", "数据仓储实体为空"),
    DDR0002("DDR0002", "数据仓储实体校验失败"),
    DDR0100("DDR0100", "聚合转换数据仓储实体失败"),
    DDR0101("DDR0101", "数据仓储实体转换聚合失败"),
    DDR0200("DDR0200", "数据仓储实体增加子项失败"),
    DDR0201("DDR0201", "数据仓储实体增加子项列表失败"),
    DDR0202("DDR0202", "数据仓储实体删除子项失败"),
    DDR0203("DDR0203", "数据仓储实体删除子项列表失败"),
    DDR8000("DDR8000", "数据仓储实体方法参数为空"),
    DDR8001("DDR8001", "数据仓储实体方法参数校验失败"),
    DDR8100("DDR8100", "数据仓储实体方法返回值为空"),
    DDR8101("DDR8101", "数据仓储实体方法返回值校验失败"),
    // 传输对象
    DTO0000("DTO0000", "传输对象为空"),
    DTO0001("DTO0001", "传输对象校验失败"),
    // 请求传输对象
    DTO1000("DTO1000", "请求传输对象为空"),
    DTO1001("DTO1001", "请求传输对象校验失败"),
    DTO1100("DTO1100", "命令请求传输对象为空"),
    DTO1101("DTO1101", "命令请求传输对象校验失败"),
    DTO1200("DTO1200", "查询请求传输对象为空"),
    DTO1201("DTO1201", "查询请求传输对象校验失败"),
    DTO1300("DTO1300", "被动请求传输对象为空"),
    DTO1301("DTO1301", "被动请求传输对象校验失败"),
    // 响应传输对象
    DTO2000("DTO2000", "响应传输对象为空"),
    DTO2001("DTO2001", "响应传输对象校验失败"),
    DTO2100("DTO2100", "命令响应传输对象为空"),
    DTO2101("DTO2101", "命令响应传输对象校验失败"),
    DTO2200("DTO2200", "查询响应传输对象为空"),
    DTO2201("DTO2201", "查询响应传输对象校验失败"),
    DTO2300("DTO2300", "被动响应传输对象为空"),
    DTO2301("DTO2301", "被动响应传输对象校验失败"),

    // Minio
    MIO0000("MIO0000", "MINIO处理失败"),
    MIO0001("MIO0001", "MINIO存储失败"),
    MIO0002("MIO0002", "MINIO删除失败"),
    MIO0003("MIO0003", "MINIO读取失败"),
    MIO9000("MIO9000", "MINIO处理状态未知"),
    MIO9001("MIO9001", "MINIO存储状态未知"),
    MIO9002("MIO9002", "MINIO删除状态未知"),
    MIO9003("MIO9003", "MINIO读取状态未知"),

    // Mybatis-Plus
    MBT0000("MBT0000", "MYBATIS-PLUS处理失败"),
    MBT0001("MBT0001", "MYBATIS-PLUS保存数据失败"),
    MBT0002("MBT0002", "MYBATIS-PLUS删除数据失败"),
    MBT0003("MBT0003", "MYBATIS-PLUS修改数据失败"),
    MBT0004("MBT0004", "MYBATIS-PLUS保存或修改数据失败"),
    MBT0100("MBT0100", "MYBATIS-PLUS批量处理失败"),

    MBT1000("MBT1000", "MYBATIS-PLUS查询数据失败"),
    MBT1001("MBT1001", "MYBATIS-PLUS未查询到相关数据"),

    MBT8000("MBT8000", "MYBATIS-PLUS方法参数为空"),
    MBT8001("MBT8001", "MYBATIS-PLUS方法参数校验失败"),
    MBT8100("MBT8100", "MYBATIS-PLUS方法返回值为空"),
    MBT8101("MBT8101", "MYBATIS-PLUS方法返回值校验失败"),

    MBT9000("MBT9000", "MYBATIS-PLUS处理状态未知"),
    MBT9001("MBT9001", "MYBATIS-PLUS保存数据状态未知"),
    MBT9002("MBT9002", "MYBATIS-PLUS删除数据状态未知"),
    MBT9003("MBT9003", "MYBATIS-PLUS修改数据状态未知"),
    MBT9004("MBT9004", "MYBATIS-PLUS保存或修改数据状态未知"),
    MBT9100("MBT9100", "MYBATIS-PLUS批量处理状态未知"),

    // Redis
    RDS0000("RDS0000", "REDIS处理失败"),
    RDS0100("RDS0100", "REDIS-STREAM处理失败"),
    RDS0101("RDS0101", "REDIS-STREAM写入失败"),
    RDS0102("RDS0102", "REDIS-STREAM读取失败"),

    // REST 错误码
    RES0000("RES0000", "REST处理失败"),
    RES0100("RES0100", "REST服务处理失败"),
    RES0200("RES0200", "REST服务请求处理失败"),
    RES0201("RES0201", "REST服务请求路径不存在"),
    RES0202("RES0202", "REST服务请求方法不支持"),
    RES0250("RES0250", "REST服务请求体为空或格式错误"),
    RES0251("RES0251", "REST服务请求体校验失败"),
    RES0300("RES0300", "REST服务响应处理失败"),
    // REST 客户端错误
    RES0500("RES0500", "REST客户端处理失败"),
    RES0600("RES0600", "REST客户端请求处理失败"),
    RES0700("RES0700", "REST客户端响应处理失败"),
    // REST 状态未知
    RES9000("RES9000", "REST服务处理状态未知"),
    RES9500("RES9500", "REST客户端处理状态未知"),

    // 安全模块错误码
    SEC0000("SEC0000", "安全模块处理失败"),
    SEC0011("SEC0011", "用户名为空"),
    SEC0020("SEC0020", "密码处理失败"),
    SEC0021("SEC0021", "密码为空"),
    SEC0022("SEC0022", "密码错误"),
    SEC0023("SEC0023", "密码格式错误"),
    SEC0024("SEC0024", "初始密码不可用"),
    SEC0030("SEC0030", "令牌处理失败"),
    SEC0031("SEC0031", "令牌生成失败"),
    SEC0032("SEC0032", "令牌刷新失败"),
    SEC0033("SEC0033", "令牌验证失败"),
    SEC0034("SEC0034", "令牌已过期"),
    SEC0040("SEC0040", "用户登出失败"),
    SEC0051("SEC0051", "HTTP指纹生成失败"),
    // 身份认证
    SEC1000("SEC1000", "身份认证处理失败"),
    SEC1001("SEC1001", "未身份认证"),

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
    UTL0030("UTL0030", "对象处理失败"),
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

    public static ErrorCode fromCode(String code) {
        for (ErrorCode type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new EnumException("未知的错误码: " + code);
    }
}

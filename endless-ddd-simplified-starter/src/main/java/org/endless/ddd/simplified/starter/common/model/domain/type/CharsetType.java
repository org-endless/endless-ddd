package com.tansun.atp.starter.common.model.domain.type;

import com.tansun.atp.starter.common.exception.domain.type.EnumException;
import lombok.Getter;
import lombok.ToString;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * CharsetType
 * <p>
 * create 2024/11/09 20:01
 * <p>
 * update 2024/11/09 20:01
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Getter
@ToString
public enum CharsetType implements BaseEnum {

    UTF8("UTF-8", StandardCharsets.UTF_8),
    ISO88591("ISO-8859-1", StandardCharsets.ISO_8859_1),
    US_ASCII("US-ASCII", StandardCharsets.US_ASCII),
    UTF16("UTF-16", StandardCharsets.UTF_16),
    UTF16BE("UTF-16BE", StandardCharsets.UTF_16BE),
    UTF16LE("UTF-16LE", StandardCharsets.UTF_16LE),
    GBK("GBK", Charset.forName("GBK")),
    GB2312("GB2312", Charset.forName("GB2312"));

    private final String code;

    private final Charset charset;

    CharsetType(String code, Charset charset) {
        this.code = code;
        this.charset = charset;
    }

    public static CharsetType fromCode(String code) {
        for (CharsetType type : CharsetType.values()) {
            if (type.code.equalsIgnoreCase(code)) {
                return type;
            }
        }
        throw new EnumException("未知的字符集类型: " + code);
    }
}

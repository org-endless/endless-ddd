package org.endless.ddd.simplified.starter.common.model.sidecar.rest;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * AbstractRestResponse
 * <p>Rest主动适配器响应信息模版
 * <p>Service Mesh Sidecar
 * <p>处理外部系统Rest通讯请求的响应信息
 * <p>
 * create 2024/09/06 13:45
 * <p>
 * update 2024/09/08 20:20
 *
 * @author Deng Haozhi
 * @see RestResponse
 * @since 2.0.0
 */
@Getter
@SuperBuilder
public abstract class AbstractRestResponse implements RestResponse {

    private final int code;

    private final String msg;

    private final Object data;

    private final List<Object> rows;

    private final Long total;

    protected AbstractRestResponse(AbstractRestResponseBuilder<?, ?> builder) {

        this.code = builder.code;
        this.msg = builder.msg;
        this.data = builder.data;
        this.rows = builder.rows;
        this.total = builder.total;

        validateTemplate();
    }

    @Override
    public void validateTemplate() {
        validate();
    }
}

package org.endless.ddd.starter.common.config.rest.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * AbstractRestResponse
 * <p>Rest响应抽象类
 * <p>Service Mesh Sidecar
 * <p>用于处理对领域外部Rest请求通讯的响应信息
 * <p>
 * create 2024/09/06 13:45
 * <p>
 * update 2024/09/08 20:20
 *
 * @author Deng Haozhi
 * @see RestResponse
 * @since 1.0.0
 */
@Getter
@ToString
@SuperBuilder
@Schema(description = "Rest响应信息", name = "RestResponse")
public abstract class AbstractRestResponse implements RestResponse {

    @Schema(description = "响应状态", example = "200")
    private final String status;

    @Schema(description = "响应错误码", example = "SUCCESS")
    private final String errorCode;

    @Schema(description = "响应信息", example = "服务调用响应信息")
    private final String message;

    @Schema(description = "响应数据", implementation = Object.class)
    private final Object data;

    protected AbstractRestResponse(AbstractRestResponseBuilder<?, ?> builder) {
        this.status = builder.status;
        this.errorCode = builder.errorCode;
        this.message = builder.message;
        this.data = builder.data;
    }
}

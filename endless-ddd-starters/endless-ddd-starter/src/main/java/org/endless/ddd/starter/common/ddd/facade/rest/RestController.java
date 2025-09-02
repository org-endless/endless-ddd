package org.endless.ddd.starter.common.ddd.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.ddd.common.transfer.RespTransfer;
import org.endless.ddd.starter.common.ddd.facade.adapter.DrivingAdapter;

/**
 * RestController
 * <p>Rest控制器
 * <p>DDD用户界面层
 * <p>用于处理领域外部Rest请求的主动适配器
 * <p>
 * create 2024/09/06 13:51
 * <p>
 * update 2024/09/08 17:54
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface RestController extends DrivingAdapter {

    String serviceDescription();

    String domainDescription();

    default <R extends RespTransfer> RestResponse<R> response(
            @NotNull(message = "REST响应体不能为空")
            @Valid R response) {
        return RestResponse.<R>builder()
                .data(response)
                .serviceDescription(serviceDescription())
                .domainDescription(domainDescription())
                .build();
    }

    default RestResponse<Void> response() {
        return RestResponse.<Void>builder()
                .data(null)
                .serviceDescription(serviceDescription())
                .domainDescription(domainDescription())
                .build();
    }

}

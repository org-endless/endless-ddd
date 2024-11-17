package org.endless.ddd.simplified.starter.common.config.thread.result;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.handler.result.type.ServiceStatus;

/**
 * AsyncResult
 * <p>
 * create 2024/11/15 00:00
 * <p>
 * update 2024/11/15 00:00
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Getter
@Builder
@ToString
public class AsyncResult<T> {

    private ServiceStatus status;

    private String message;

    private T data;
}

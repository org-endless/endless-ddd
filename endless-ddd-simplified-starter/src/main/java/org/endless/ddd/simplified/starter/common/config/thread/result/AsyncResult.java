package org.endless.ddd.simplified.starter.common.config.thread.result;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.checkerframework.checker.units.qual.A;
import org.endless.ddd.simplified.starter.common.handler.result.type.ServiceStatus;

/**
 * AsyncResult
 * <p>
 * create 2024/11/15 00:00
 * <p>
 * update 2024/11/15 00:00
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Getter
@Builder
@ToString
public class AsyncResult<T> {

    private ServiceStatus status;

    private String message;

    private T data;
}

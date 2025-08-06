package org.endless.ddd.starter.common.model.application.command.handler;

import org.endless.ddd.starter.common.model.domain.entity.Aggregate;

/**
 * CommandHandler
 * <p>CQRS命令处理器
 * <p>DDD应用层
 * <p>用于处理长业务流程、跨领域逻辑、事务控制、调用基础设施层
 * <p>
 * create 2024/08/30 17:19
 * <p>
 * update 2024/08/30 17:19
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface CommandHandler<A extends Aggregate> {

}

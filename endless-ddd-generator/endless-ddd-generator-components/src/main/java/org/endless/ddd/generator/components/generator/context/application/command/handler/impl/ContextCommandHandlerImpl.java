package org.endless.ddd.generator.components.generator.context.application.command.handler.impl;

import org.endless.ddd.generator.components.generator.context.application.command.handler.ContextCommandHandler;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.context.application.command.transfer.ContextRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.context.domain.anticorruption.ContextRepository;
import org.endless.ddd.generator.components.generator.context.domain.entity.ContextAggregate;
import org.endless.ddd.generator.components.generator.context.domain.type.ContextTypeEnum;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.handler.CommandNotFoundException;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * ContextCommandHandlerImpl
 * <p>限界上下文领域命令处理器
 * <p>
 * create 2025/08/07 09:59
 * <p>
 * update 2025/08/07 09:59
 *
 * @author Deng Haozhi
 * @see ContextCommandHandler
 * @since 1.0.0
 */
public class ContextCommandHandlerImpl implements ContextCommandHandler {

    /**
     * 限界上下文聚合仓储接口
     */
    private final ContextRepository contextRepository;

    public ContextCommandHandlerImpl(ContextRepository contextRepository) {
        this.contextRepository = contextRepository;
    }

    @Override
    @Transactional
    @Log(message = "限界上下文创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(ContextCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ContextCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("限界上下文创建命令参数不能为空"));
        ContextAggregate aggregate = ContextAggregate.create(ContextAggregate.builder()
                .serviceId(command.serviceId())
                .name(command.name())
                .description(command.description())
                .version(command.version())
                .author(command.author())
                .rootPath(command.rootPath())
                .basePackage(command.basePackage())
                .type(ContextTypeEnum.fromCode(command.type()))
                .createUserId(DDD_SIMPLIFIED_GENERATOR_USER_ID));
        contextRepository.save(aggregate);
    }

    @Override
    public void remove(ContextRemoveReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ContextRemoveReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("限界上下文修改命令参数不能为空"));
        ContextAggregate aggregate = contextRepository.findById(command.contextId())
                .orElseThrow(() -> new CommandNotFoundException("限界上下文不存在"));
        contextRepository.remove(aggregate.remove(DDD_SIMPLIFIED_GENERATOR_USER_ID));
    }

    @Override
    @Transactional
    @Log(message = "限界上下文修改命令", value = "#command", level = LogLevel.TRACE)
    public void modify(ContextModifyReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ContextModifyReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("限界上下文修改命令参数不能为空"));
        ContextAggregate aggregate = contextRepository.findById(command.contextId())
                .orElseThrow(() -> new CommandNotFoundException("限界上下文不存在"));
        contextRepository.modify(aggregate.modify(ContextAggregate.builder()
                .serviceId(command.serviceId())
                .name(command.name())
                .description(command.description())
                .version(command.version())
                .author(command.author())
                .rootPath(command.rootPath())
                .basePackage(command.basePackage())
                .type(ContextTypeEnum.fromCode(command.type()))
                .modifyUserId(DDD_SIMPLIFIED_GENERATOR_USER_ID)));
    }
}

package org.endless.ddd.generator.components.generator.service.application.command.handler.impl;

import org.endless.ddd.generator.components.generator.service.application.command.handler.ServiceCommandHandler;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceGenerateReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.service.domain.anticorruption.ServiceDrivenAdapter;
import org.endless.ddd.generator.components.generator.service.domain.anticorruption.ServiceRepository;
import org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate;
import org.endless.ddd.generator.components.generator.service.domain.type.ServiceTypeEnum;
import org.endless.ddd.starter.common.config.log.annotation.Log;
import org.endless.ddd.starter.common.config.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.model.application.command.handler.CommandHandlerNotFoundException;
import org.endless.ddd.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * ServiceCommandHandlerImpl
 * <p>
 * 服务领域命令处理器实现类
 * <p>
 * create 2025/07/29 16:16
 * <p>
 * update 2025/07/29 16:16
 *
 * @author Deng Haozhi
 * @see ServiceCommandHandler
 * @since 0.0.1
 */
public class ServiceCommandHandlerImpl implements ServiceCommandHandler {

    /**
     * 服务仓储接口
     */
    private final ServiceRepository serviceRepository;

    /**
     * 服务被动适配器接口
     */
    private final ServiceDrivenAdapter serviceDrivenAdapter;

    public ServiceCommandHandlerImpl(ServiceRepository serviceRepository, ServiceDrivenAdapter serviceDrivenAdapter) {
        this.serviceRepository = serviceRepository;
        this.serviceDrivenAdapter = serviceDrivenAdapter;
    }

    @Override
    @Transactional
    @Log(message = "服务创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(ServiceCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ServiceCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("服务创建命令建参数不能为空"));
        ServiceAggregate aggregate = ServiceAggregate.create(ServiceAggregate.builder()
                .projectId(command.projectId())
                .serviceArtifactId(command.serviceArtifactId())
                .groupId(command.groupId())
                .name(command.name())
                .description(command.description())
                .version(command.version())
                .author(command.author())
                .rootPath(command.rootPath())
                .basePackage(command.basePackage())
                .classNamePrefix(command.classNamePrefix())
                .type(ServiceTypeEnum.fromCode(command.type()))
                .port(command.port())
                .createUserId(DDD_SIMPLIFIED_GENERATOR_USER_ID));
        serviceRepository.save(aggregate);
    }

    @Override
    @Transactional
    @Log(message = "服务删除命令", value = "#command", level = LogLevel.TRACE)
    public void remove(ServiceRemoveReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ServiceRemoveReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("服务删除命令参数不能为空"));
        ServiceAggregate aggregate = serviceRepository.findById(command.serviceId())
                .orElseThrow(() -> new CommandHandlerNotFoundException("服务不存在"));
        serviceRepository.remove(aggregate.remove(DDD_SIMPLIFIED_GENERATOR_USER_ID));
    }

    @Override
    @Transactional
    @Log(message = "服务创建命令", value = "#command", level = LogLevel.TRACE)
    public void modify(ServiceModifyReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ServiceModifyReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("服务修改命令参数不能为空"));
        ServiceAggregate aggregate = serviceRepository.findById(command.serviceId())
                .orElseThrow(() -> new CommandHandlerNotFoundException("服务不存在"));
        serviceRepository.modify(aggregate.modify(ServiceAggregate.builder()
                .projectId(command.projectId())
                .serviceArtifactId(command.serviceArtifactId())
                .groupId(command.groupId())
                .name(command.name())
                .description(command.description())
                .version(command.version())
                .author(command.author())
                .rootPath(command.rootPath())
                .basePackage(command.basePackage())
                .classNamePrefix(command.classNamePrefix())
                .type(ServiceTypeEnum.fromCode(command.type()))
                .port(command.port())
                .modifyUserId(DDD_SIMPLIFIED_GENERATOR_USER_ID)));
    }

    @Override
    @Transactional
    @Log(message = "服务创建命令", value = "#command", level = LogLevel.TRACE)
    public void generate(ServiceGenerateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ServiceGenerateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("服务生成命令参数不能为空"));
        ServiceAggregate aggregate = serviceRepository.findById(command.serviceId())
                .orElseThrow(() -> new CommandHandlerNotFoundException("服务不存在"));
        serviceDrivenAdapter.generate(aggregate);
    }
}

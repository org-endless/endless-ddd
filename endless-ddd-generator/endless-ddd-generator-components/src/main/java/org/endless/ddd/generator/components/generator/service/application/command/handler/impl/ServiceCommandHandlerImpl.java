package org.endless.ddd.generator.components.generator.service.application.command.handler.impl;

import org.endless.ddd.generator.components.generator.service.application.command.handler.ServiceCommandHandler;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceCreateReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceGenerateReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceModifyReqCTransfer;
import org.endless.ddd.generator.components.generator.service.application.command.transfer.ServiceRemoveReqCTransfer;
import org.endless.ddd.generator.components.generator.service.domain.anticorruption.ServiceGeneratorDrivenAdapter;
import org.endless.ddd.generator.components.generator.service.domain.anticorruption.ServiceProjectDrivenAdapter;
import org.endless.ddd.generator.components.generator.service.domain.anticorruption.ServiceRepository;
import org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate;
import org.endless.ddd.generator.components.generator.service.domain.type.ServiceTypeEnum;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.handler.CommandNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

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
 * @since 1.0.0
 */
@Lazy
@Service
@Validated
public class ServiceCommandHandlerImpl implements ServiceCommandHandler {

    /**
     * 服务领域仓储接口
     */
    private final ServiceRepository serviceRepository;

    /**
     * 服务领域被动适配器接口
     */
    private final ServiceGeneratorDrivenAdapter serviceGeneratorDrivenAdapter;

    /**
     * 项目领域被动适配器接口
     */
    private final ServiceProjectDrivenAdapter serviceProjectDrivenAdapter;

    public ServiceCommandHandlerImpl(ServiceRepository serviceRepository, ServiceGeneratorDrivenAdapter serviceGeneratorDrivenAdapter, ServiceProjectDrivenAdapter serviceProjectDrivenAdapter) {
        this.serviceRepository = serviceRepository;
        this.serviceGeneratorDrivenAdapter = serviceGeneratorDrivenAdapter;
        this.serviceProjectDrivenAdapter = serviceProjectDrivenAdapter;
    }

    @Override
    @Transactional
    @Log(message = "服务创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(ServiceCreateReqCTransfer command) {
        serviceProjectDrivenAdapter.existsById(command.projectId());
        ServiceAggregate aggregate = ServiceAggregate.create(ServiceAggregate.builder()
                .projectId(command.projectId())
                .serviceArtifactId(command.serviceArtifactId())
                .name(command.name())
                .description(command.description())
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
        ServiceAggregate aggregate = serviceRepository.findById(command.serviceId())
                .orElseThrow(() -> new CommandNotFoundException("服务不存在"));
        serviceRepository.remove(aggregate.remove(DDD_SIMPLIFIED_GENERATOR_USER_ID));
    }

    @Override
    @Transactional
    @Log(message = "服务创建命令", value = "#command", level = LogLevel.TRACE)
    public void modify(ServiceModifyReqCTransfer command) {
        ServiceAggregate aggregate = serviceRepository.findById(command.serviceId())
                .orElseThrow(() -> new CommandNotFoundException("服务不存在"));
        serviceRepository.modify(aggregate.modify(ServiceAggregate.builder()
                .projectId(command.projectId())
                .serviceArtifactId(command.serviceArtifactId())
                .name(command.name())
                .description(command.description())
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
    @Log(message = "服务生成命令", value = "#command", level = LogLevel.TRACE)
    public void generate(ServiceGenerateReqCTransfer command) {
        ServiceAggregate aggregate = serviceRepository.findById(command.serviceId())
                .orElseThrow(() -> new CommandNotFoundException("服务不存在"));
        serviceGeneratorDrivenAdapter.generate(aggregate);
    }
}

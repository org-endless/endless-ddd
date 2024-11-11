package org.endless.domain.simplified.generator.controller;

import com.alibaba.fastjson2.JSON;
import org.endless.domain.simplified.generator.object.dto.AggregateDTO;
import org.endless.domain.simplified.generator.object.dto.GeneratorDTO;
import org.endless.domain.simplified.generator.object.entity.Aggregate;
import org.endless.domain.simplified.generator.service.DDDGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * DDDGeneratorController
 * <p>
 * create 2024/10/16 19:26
 * <p>
 * update 2024/10/16 19:26
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Controller
public class DDDGeneratorController {

    private static final Logger log = LoggerFactory.getLogger(DDDGeneratorController.class);

    private final DDDGeneratorService dddGeneratorService;

    public DDDGeneratorController(DDDGeneratorService dddGeneratorService) {
        this.dddGeneratorService = dddGeneratorService;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/services")
    @ResponseBody
    public List<String> services() {
        return dddGeneratorService.services();
    }

    @GetMapping("/contexts")
    @ResponseBody
    public List<String> contexts(@RequestParam String serviceName) {
        return dddGeneratorService.contexts(serviceName);
    }

    @GetMapping("/domains")
    @ResponseBody
    public List<String> domains(@RequestParam String serviceName, @RequestParam String contextName) {
        return dddGeneratorService.domains(serviceName, contextName);
    }

    @GetMapping("/aggregates")
    @ResponseBody
    public List<String> aggregates(@RequestParam String serviceName, @RequestParam String contextName, @RequestParam String domainName) {
        return dddGeneratorService.aggregates(serviceName, contextName, domainName);
    }

    @PostMapping("/generate")
    @ResponseBody
    public String generate(@RequestBody String generatorDTOJson) {
        try {
            log.debug("生成器参数: {}", generatorDTOJson);
            GeneratorDTO generatorDTO = JSON.parseObject(generatorDTOJson, GeneratorDTO.class);
            dddGeneratorService.generate(generatorDTO);
            return "代码生成成功";
        } catch (Exception e) {
            log.error("代码生成失败", e);
            return "代码生成失败: " + e.getMessage();
        }
    }

    @PostMapping("/aggregate/get")
    @ResponseBody
    public Aggregate getAggregate(@RequestBody String aggregateDTOJson) {
        try {
            AggregateDTO aggregateDTO = JSON.parseObject(aggregateDTOJson, AggregateDTO.class);
            return dddGeneratorService.getAggregate(aggregateDTO);
        } catch (Exception e) {
            log.error("获取聚合信息失败", e);
            return null;
        }
    }

    @PostMapping("/aggregate/put")
    @ResponseBody
    public String putAggregate(@RequestBody String aggregateJson) {
        try {
            log.debug("聚合信息: {}", aggregateJson);
            Aggregate aggregate = JSON.parseObject(aggregateJson, Aggregate.class);
            dddGeneratorService.putAggregate(aggregate);
            return "聚合信息更新成功";
        } catch (Exception e) {
            log.error("聚合信息更新失败", e);
            return "聚合信息更新失败: " + e.getMessage();
        }
    }
}

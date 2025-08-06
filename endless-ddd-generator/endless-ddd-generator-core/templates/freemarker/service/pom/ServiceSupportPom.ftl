<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>${project.getGroupId()}</groupId>
        <artifactId>${service.getServiceArtifactId()}</artifactId>
        <version>${project.getVersion()}</version>
    </parent>

    <artifactId>${service.getServiceArtifactId()}-support</artifactId>
    <packaging>jar</packaging>
    <name>${service.getName()}-support</name>
    <description>${service.getDescription()}-支撑域组件</description>

    <dependencies>
        <dependency>
            <groupId>${project.getGroupId()}</groupId>
            <artifactId>${service.getServiceArtifactId()}-common</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>
</project>

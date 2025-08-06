<#-- @ftlvariable name="project" type="org.endless.ddd.generator.components.generator.project.domain.entity.ProjectAggregate" -->
<#-- @ftlvariable name="service" type="org.endless.ddd.generator.components.generator.service.domain.entity.ServiceAggregate" -->
<#-- @ftlvariable name="hasSupport" type="Boolean" -->
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

    <artifactId>${service.getServiceArtifactId()}-core</artifactId>
    <packaging>jar</packaging>
    <name>${service.getName()}-core</name>
    <description>${service.getDescription()}-核心启动模块</description>

    <dependencies>
        <dependency>
            <groupId>${project.getGroupId()}</groupId>
            <artifactId>${service.getServiceArtifactId()}-common</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>${project.getGroupId()}</groupId>
            <artifactId>${service.getServiceArtifactId()}-components</artifactId>
            <optional>true</optional>
        </dependency>
        <#if hasSupport == true>
            <dependency>
                <groupId>${project.getGroupId()}</groupId>
                <artifactId>${service.getServiceArtifactId()}-support</artifactId>
                <optional>true</optional>
            </dependency>
        </#if>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <mainClass>
                        ${project.getBasePackage()}.${service.getBasePackage()}.${service.getName()}Application
                    </mainClass>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
        <finalName>${service.getServiceArtifactId()}</finalName>
    </build>
</project>

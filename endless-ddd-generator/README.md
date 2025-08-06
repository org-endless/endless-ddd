# EndlessDDD Generator

> 🚀 一个基于 Spring Boot 和 Tauri 的 DDD 项目生成器，支持 Web 界面和桌面应用，让您快速创建符合 DDD 原则的项目结构。

---

## 📋 项目概述

EndlessDDD Generator 是一个强大的项目生成工具，它结合了 Spring Boot 的 Web 界面和 Tauri 的桌面应用，为您提供完整的 DDD 项目生成解决方案。无论是 Web 开发还是桌面应用开发，都能快速生成符合领域驱动设计原则的项目结构。

### 🎯 设计目标

- **🚀 快速生成**: 一键生成完整的 DDD 项目结构
- **🎯 架构清晰**: 严格遵循 DDD 分层架构原则
- **🔧 模板化**: 支持自定义代码生成模板
- **📈 可扩展**: 支持多种技术栈和配置
- **🔄 持续演进**: 基于最新技术栈，持续更新

### 🌟 核心优势

- **多平台支持**: Web 界面和桌面应用双重体验
- **智能生成**: 自动生成符合 DDD 原则的代码
- **可视化配置**: 图形化项目配置界面
- **实时预览**: 代码生成结果实时预览
- **模板系统**: 可自定义的代码生成模板

## 🎯 核心特性

### ✅ 多平台支持
- **Web 界面**: 基于 Spring Boot 的现代化 Web 界面
- **桌面应用**: 基于 Tauri 的原生桌面应用
- **跨平台**: 支持 Windows、macOS、Linux

### ✅ 智能生成
- **DDD 架构**: 自动生成符合 DDD 原则的项目结构
- **分层设计**: 清晰的应用层、领域层、基础设施层分离
- **CQRS 支持**: 命令查询职责分离架构
- **模板系统**: 可自定义的代码生成模板
- **代码规范**: 遵循 Java 编码规范和最佳实践

### ✅ 开发体验
- **可视化配置**: 图形化项目配置界面
- **实时预览**: 代码生成结果实时预览
- **一键部署**: 完整的构建和部署流程
- **环境检查**: 自动检查和安装依赖
- **错误处理**: 完善的错误提示和处理

### ✅ 模板系统
- **Freemarker 引擎**: 强大的模板引擎支持
- **自定义模板**: 支持自定义代码生成模板
- **变量系统**: 灵活的模板变量配置
- **条件渲染**: 支持条件渲染和循环
- **模板管理**: 模板的导入、导出和管理

### ✅ 配置管理
- **YAML 配置**: 使用 YAML 格式的配置文件
- **环境分离**: 支持多环境配置
- **配置验证**: 实时配置参数验证
- **配置导入**: 支持配置文件的导入导出
- **配置模板**: 预定义的配置模板

## 🏗️ 项目结构

```
endless-ddd-generator/
├── endless-ddd-generator-core/                  # Spring Boot 核心模块
│   ├── src/main/java/                           # Java 源码
│   │   └── org/endless/ddd/generator/
│   │       ├── config/                          # 配置类
│   │       ├── controller/                      # 控制器
│   │       ├── service/                        # 服务层
│   │       └── DDDGeneratorApplication.java
│   ├── src/main/resources/                      # 资源文件
│   │   ├── static/                             # 静态资源
│   │   ├── templates/                          # 模板文件
│   │   └── application.yaml                    # 配置文件
│   └── pom.xml                                  # Maven 配置
├── endless-ddd-generator-components/            # 组件模块
│   ├── src/main/java/                           # 生成器组件
│   │   └── org/endless/ddd/generator/
│   │       └── components/
│   │           ├── generator/                   # 生成器核心
│   │           │   ├── context/                # 生成上下文
│   │           │   ├── domain/                 # 领域生成器
│   │           │   ├── project/                # 项目生成器
│   │           │   └── service/                # 服务生成器
│   │           └── template/                   # 模板引擎
│   └── pom.xml                                  # Maven 配置
├── endless-ddd-generator-common/                # 公共模块
│   ├── src/main/java/                           # 公共工具类
│   │   └── org/endless/ddd/generator/
│   │       └── common/
│   │           ├── model/                       # 模型定义
│   │           ├── rest/                        # REST 适配器
│   │           └── ProjectConstants.java        # 项目常量
│   └── pom.xml                                  # Maven 配置
├── endless-ddd-generator-ui/                    # Tauri 桌面应用
│   ├── src-tauri/                               # Rust 后端代码
│   ├── public/                                  # 前端静态资源
│   ├── bin/                                     # 构建脚本
│   └── Cargo.toml                               # Rust 配置
├── model/                                       # 示例模型文件
│   ├── DomainSimplifiedServer/                 # 示例项目模型
│   │   ├── document/                           # 文档聚合
│   │   │   └── IndividualDocument/
│   │   │       └── IndividualDocumentAggregate.yaml
│   │   └── security/                           # 安全聚合
│   │       ├── Token/
│   │       │   └── TokenAggregate.yaml
│   │       └── User/
│   │           └── UserAggregate.yaml
│   └── GycdpServer/                            # 示例项目模型
│       └── document/
│           └── IndividualDocument/
│               └── IndividualDocumentAggregate.yaml
├── config/                                      # 配置文件
│   ├── application.yaml                         # 主配置文件
│   ├── application-dev.yaml                     # 开发环境配置
│   ├── application-prod.yaml                    # 生产环境配置
│   ├── log4j2-dev.xml                          # 开发日志配置
│   └── log4j2-prod.xml                         # 生产日志配置
└── README.md                                   # 项目说明
```

## 🚀 快速开始

### 环境要求

#### 必需环境
- **Java**: 21+ ([下载地址](https://adoptium.net/))
- **Rust**: 1.70+ ([下载地址](https://rustup.rs/))
- **Maven**: 3.6+ ([下载地址](https://maven.apache.org/))

#### 可选环境
- **Node.js**: 16+ (用于 Tauri 开发)
- **Git**: 版本控制

### 1. 克隆项目

```bash
git clone https://github.com/org-endless/endless-ddd.git
cd endless-ddd/endless-ddd-generator
```

### 2. 环境检查

```bash
# Windows
bin\check-env.bat

# Linux/macOS
bash bin/check-env.sh
```

### 3. 启动开发模式

```bash
# Windows
bin\dev.bat

# Linux/macOS
bash bin/dev.sh
```

### 4. 构建生产版本

```bash
# Windows
bin\build-installer.bat

# Linux/macOS
bash bin/build-installer.sh
```

## 🔧 功能详解

### Web 界面功能

#### 项目配置
- **基本信息**: 项目名称、包名、版本等
- **架构选择**: DDD 分层架构配置
- **技术栈**: Spring Boot、数据库、缓存等选择
- **模板定制**: 自定义代码生成模板
- **配置验证**: 实时配置参数验证

#### 代码生成
- **聚合设计**: 聚合根、实体、值对象生成
- **仓储模式**: 仓储接口和实现生成
- **应用服务**: 命令和查询服务生成
- **基础设施**: 数据库、缓存、消息等配置
- **控制器**: REST API 控制器生成

#### 预览功能
- **实时预览**: 生成代码的实时预览
- **结构展示**: 项目结构的可视化展示
- **配置验证**: 配置参数的实时验证
- **错误提示**: 详细的错误信息和修复建议

### 桌面应用功能

#### 原生体验
- **桌面集成**: 与操作系统深度集成
- **文件系统**: 直接访问本地文件系统
- **权限控制**: 细粒度的权限管理
- **性能优化**: 基于 Rust 的高性能后端
- **跨平台**: 支持 Windows、macOS、Linux

#### 开发工具
- **项目向导**: 图形化项目创建向导
- **模板管理**: 代码模板的管理和编辑
- **配置管理**: 项目配置的导入导出
- **版本控制**: 与 Git 的集成
- **文件浏览器**: 集成文件系统操作

## 🛠️ 使用指南

### 创建新项目

#### 1. 启动生成器

```bash
# 启动 Web 界面
java -jar endless-ddd-generator-core.jar

# 或启动桌面应用
./endless-ddd-generator-ui
```

#### 2. 配置项目信息

```yaml
# 项目基本信息
project:
  name: "MyDDDProject"
  package: "com.example.myddd"
  version: "1.0.0"
  description: "A DDD project generated by EndlessDDD Generator"
  
# 架构配置
architecture:
  layers:
    - application
    - domain
    - infrastructure
    - facade
    - sidecar
  enableCQRS: true
  enableEventSourcing: false
  
# 技术栈配置
technology:
  database: "mysql"
  cache: "redis"
  message: "kafka"
  security: "jwt"
```

#### 3. 设计领域模型

```yaml
# 聚合定义
aggregates:
  - name: "Order"
    description: "订单聚合"
    entities:
      - name: "OrderItem"
        description: "订单项"
        properties:
          - name: "productId"
            type: "ProductId"
            description: "产品ID"
          - name: "quantity"
            type: "int"
            description: "数量"
          - name: "price"
            type: "BigDecimal"
            description: "单价"
    valueObjects:
      - name: "OrderId"
        type: "String"
        description: "订单ID"
      - name: "OrderStatus"
        type: "enum"
        values: ["CREATED", "CONFIRMED", "CANCELLED"]
        description: "订单状态"
    commands:
      - name: "CreateOrder"
        description: "创建订单"
      - name: "ConfirmOrder"
        description: "确认订单"
      - name: "CancelOrder"
        description: "取消订单"
    queries:
      - name: "GetOrder"
        description: "获取订单"
      - name: "GetOrdersByCustomer"
        description: "获取客户订单"
```

#### 4. 生成项目

```bash
# 生成项目结构
./generate.sh --config project-config.yaml --output ./generated-project

# 或使用 Web 界面
# 点击"生成项目"按钮
```

### 自定义模板

#### 1. 创建模板

```freemarker
// 聚合根模板
package ${package}.domain.aggregate;

import ${package}.domain.entity.*;
import ${package}.domain.valueobject.*;
import ${package}.domain.exception.*;

@Aggregate
public class ${aggregateName} {
    private ${aggregateName}Id id;
    
    // 构造函数
    public ${aggregateName}(${aggregateName}Id id) {
        this.id = id;
    }
    
    // 领域方法
    public void ${methodName}() {
        // 领域逻辑
        if (/* 验证条件 */) {
            throw new DomainException("错误信息");
        }
        // 业务逻辑
    }
    
    // Getter 方法
    public ${aggregateName}Id getId() {
        return id;
    }
}
```

#### 2. 注册模板

```yaml
# 模板配置
templates:
  aggregate:
    path: "templates/aggregate.ftl"
    output: "src/main/java/{package}/domain/aggregate/{name}.java"
    variables:
      - name: "package"
        type: "string"
        required: true
        description: "包名"
      - name: "aggregateName"
        type: "string"
        required: true
        description: "聚合根名称"
      - name: "methodName"
        type: "string"
        required: false
        description: "方法名"
        default: "execute"
```

#### 3. 使用条件渲染

```freemarker
// 实体模板
package ${package}.domain.entity;

<#if imports??>
<#list imports as import>
import ${import};
</#list>
</#if>

@Entity
public class ${entityName} {
    <#if properties??>
    <#list properties as property>
    private ${property.type} ${property.name};
    </#list>
    </#if>
    
    // 构造函数
    public ${entityName}() {
    }
    
    <#if properties??>
    <#list properties as property>
    // Getter 和 Setter
    public ${property.type} get${property.name?cap_first}() {
        return ${property.name};
    }
    
    public void set${property.name?cap_first}(${property.type} ${property.name}) {
        this.${property.name} = ${property.name};
    }
    </#list>
    </#if>
}
```

### 高级配置

#### 1. 数据库配置

```yaml
# 数据库配置
database:
  type: "mysql"
  host: "localhost"
  port: 3306
  name: "myddd_db"
  username: "root"
  password: "password"
  dialect: "org.hibernate.dialect.MySQLDialect"
  ddlAuto: "update"
  showSql: true
```

#### 2. 缓存配置

```yaml
# 缓存配置
cache:
  type: "redis"
  host: "localhost"
  port: 6379
  password: ""
  database: 0
  ttl: 3600
```

#### 3. 安全配置

```yaml
# 安全配置
security:
  type: "jwt"
  secret: "your-secret-key"
  expiration: 86400
  issuer: "endless-ddd"
```

## 📦 构建输出

### Web 应用构建

```bash
# 构建 Spring Boot JAR
mvn clean package -DskipTests

# 输出文件
target/endless-ddd-generator-core-*.jar
```

### 桌面应用构建

```bash
# 构建 Tauri 应用
cargo tauri build

# 输出文件
target/release/endless-ddd-generator-ui
target/release/bundle/
├── msi/                    # Windows 安装包
├── deb/                    # Linux 安装包
└── dmg/                    # macOS 安装包
```

### 完整构建

```bash
# 构建完整应用包
bin/build-installer.sh

# 输出目录
build/output/
├── endless-ddd-generator-YYYYMMDD-HHMMSS/
│   ├── spring-boot/        # Spring Boot 应用
│   ├── tauri/              # Tauri 桌面应用
│   └── README.md           # 使用说明
```

### 生成的项目结构

```
generated-project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/myddd/
│   │   │       ├── application/           # 应用层
│   │   │       │   ├── command/          # 命令
│   │   │       │   ├── query/            # 查询
│   │   │       │   └── service/          # 应用服务
│   │   │       ├── domain/               # 领域层
│   │   │       │   ├── aggregate/        # 聚合根
│   │   │       │   ├── entity/           # 实体
│   │   │       │   ├── valueobject/      # 值对象
│   │   │       │   ├── repository/       # 仓储接口
│   │   │       │   └── service/          # 领域服务
│   │   │       ├── infrastructure/       # 基础设施层
│   │   │       │   ├── persistence/      # 持久化
│   │   │       │   ├── cache/            # 缓存
│   │   │       │   └── external/         # 外部服务
│   │   │       ├── facade/               # 外观层
│   │   │       │   ├── controller/       # 控制器
│   │   │       │   └── dto/              # 数据传输对象
│   │   │       └── sidecar/              # 边车层
│   │   │           └── controller/       # 控制器
│   │   └── resources/
│   │       ├── application.yml           # 配置文件
│   │       └── logback-spring.xml        # 日志配置
│   └── test/
│       └── java/
│           └── com/example/myddd/
│               └── test/                  # 测试代码
├── pom.xml                               # Maven 配置
├── README.md                             # 项目说明
└── .gitignore                            # Git 忽略文件
```

## 🔍 故障排除

### 常见问题

#### 1. Java 环境问题
```bash
# 检查 Java 版本
java -version

# 设置 JAVA_HOME
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk
```

#### 2. Rust 环境问题
```bash
# 检查 Rust 版本
rustc --version

# 更新 Rust
rustup update
```

#### 3. Maven 构建失败
```bash
# 清理缓存
mvn clean

# 检查依赖
mvn dependency:tree
```

#### 4. Tauri 构建问题
```bash
# 安装 Tauri CLI
cargo install tauri-cli

# 清理缓存
cargo clean
```

#### 5. 模板渲染错误
```bash
# 检查模板语法
# 确保变量名正确
# 检查文件编码为 UTF-8
```

### 平台特定问题

#### Windows
- 安装 Visual Studio Build Tools
- 安装 WebView2 运行时
- 确保 PowerShell 执行策略允许脚本运行

#### macOS
- 安装 Xcode 命令行工具: `xcode-select --install`
- 确保有开发者证书

#### Linux
```bash
# Ubuntu/Debian 依赖
sudo apt update
sudo apt install libwebkit2gtk-4.0-dev \
    build-essential \
    curl \
    wget \
    libssl-dev \
    libgtk-3-dev \
    libayatana-appindicator3-dev \
    librsvg2-dev
```

## 📚 API 文档

### 核心接口

#### 项目生成器
```java
public interface ProjectGenerator {
    void generate(ProjectConfig config, String outputPath);
    ProjectStructure preview(ProjectConfig config);
    List<String> validate(ProjectConfig config);
}
```

#### 模板引擎
```java
public interface TemplateEngine {
    String render(String template, Map<String, Object> context);
    void registerTemplate(String name, String template);
    List<String> validateTemplate(String template);
}
```

#### 配置管理器
```java
public interface ConfigManager {
    ProjectConfig loadConfig(String path);
    void saveConfig(ProjectConfig config, String path);
    List<String> validateConfig(ProjectConfig config);
}
```

### 配置模型

#### 项目配置
```java
public class ProjectConfig {
    private String name;
    private String packageName;
    private String version;
    private String description;
    private ArchitectureConfig architecture;
    private TechnologyConfig technology;
    private List<AggregateConfig> aggregates;
    private TemplateConfig templates;
}
```

#### 架构配置
```java
public class ArchitectureConfig {
    private List<String> layers;
    private boolean enableCQRS;
    private boolean enableEventSourcing;
    private String databaseType;
    private String cacheType;
    private String securityType;
}
```

#### 聚合配置
```java
public class AggregateConfig {
    private String name;
    private String description;
    private List<EntityConfig> entities;
    private List<ValueObjectConfig> valueObjects;
    private List<CommandConfig> commands;
    private List<QueryConfig> queries;
}
```

### REST API

#### 项目生成
```http
POST /api/project/generate
Content-Type: application/json

{
  "name": "MyDDDProject",
  "packageName": "com.example.myddd",
  "version": "1.0.0",
  "architecture": {
    "layers": ["application", "domain", "infrastructure"],
    "enableCQRS": true
  },
  "aggregates": [
    {
      "name": "Order",
      "entities": [
        {
          "name": "OrderItem",
          "properties": [
            {"name": "productId", "type": "ProductId"},
            {"name": "quantity", "type": "int"}
          ]
        }
      ]
    }
  ]
}
```

#### 项目预览
```http
GET /api/project/preview?config=project-config.yaml
```

#### 模板管理
```http
GET /api/templates
POST /api/templates
PUT /api/templates/{name}
DELETE /api/templates/{name}
```

## 🔗 相关链接

- **项目主页**: [返回总体项目](./README.md)
- **启动器项目**: [EndlessDDD Starter](../endless-ddd-starter/README.md)
- **桌面应用**: [EndlessDDD Generator UI](./endless-ddd-generator-ui/README.md)
- **GitHub 仓库**: [https://github.com/org-endless/endless-ddd](https://github.com/org-endless/endless-ddd)

---

**Happy Coding! 🚀** 
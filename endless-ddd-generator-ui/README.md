# EndlessDDD Generator UI

> 🖥️ 一个基于 Tauri 的现代化桌面应用程序，用于简化 DDD（领域驱动设计）项目的代码生成，提供原生桌面体验和强大的项目生成功能。

---

## 📋 项目概述

EndlessDDD Generator UI 是一个基于 Tauri 框架开发的桌面应用程序，它将 Web 技术与原生桌面应用的优势完美结合。该应用提供了直观的图形化界面，让您能够轻松创建符合领域驱动设计原则的项目结构，无需复杂的命令行操作。

### 🎯 设计目标

- **🖥️ 原生体验**: 提供原生桌面应用的用户体验
- **🎯 可视化配置**: 图形化项目配置界面
- **🔧 智能生成**: 自动生成符合 DDD 原则的代码
- **📈 可扩展**: 支持自定义模板和扩展
- **🔄 持续演进**: 基于最新技术栈，持续更新

### 🌟 核心优势

- **原生桌面体验**: 基于 Rust 的高性能后端、现代化 UI、跨平台支持
- **智能项目生成**: DDD 架构、分层设计、CQRS 支持、模板系统
- **开发体验优化**: 可视化配置、实时预览、文件管理、环境检查
- **文件系统集成**: 本地文件操作、项目导入导出
- **模板管理**: 可视化模板编辑器、模板版本控制
- **错误处理**: 完善的错误提示和修复建议

## 🎯 核心特性

### ✅ 原生桌面体验
- **🖥️ 原生性能**: 基于 Rust 的高性能后端
- **🎨 现代化 UI**: 基于 Bootstrap 5 的响应式界面
- **📱 跨平台支持**: Windows、macOS、Linux 全平台支持
- **🔒 安全权限**: 细粒度的文件系统权限控制
- **⚡ 快速启动**: 应用启动速度快，资源占用低

### ✅ 智能项目生成
- **🎯 DDD 架构**: 自动生成符合 DDD 原则的项目结构
- **🏗️ 分层设计**: 清晰的应用层、领域层、基础设施层分离
- **⚡ CQRS 支持**: 命令查询职责分离架构
- **📝 模板系统**: 可自定义的代码生成模板
- **🔧 代码规范**: 遵循 Java 编码规范和最佳实践

### ✅ 开发体验优化
- **🖱️ 可视化配置**: 图形化项目配置界面
- **👀 实时预览**: 代码生成结果实时预览
- **📁 文件管理**: 集成文件系统操作
- **🔧 环境检查**: 自动检查和安装依赖
- **📊 进度显示**: 生成过程的进度条和状态显示

### ✅ 文件系统集成
- **📁 目录浏览**: 浏览本地文件系统
- **📄 文件操作**: 创建、编辑、删除文件
- **💾 项目保存**: 保存和加载项目配置
- **📤 项目导出**: 导出生成的项目
- **📥 项目导入**: 导入现有项目配置

### ✅ 模板管理
- **📝 模板编辑**: 可视化的模板编辑器
- **🔄 模板管理**: 模板的导入、导出和管理
- **🎨 模板预览**: 模板渲染结果的预览
- **📋 变量配置**: 模板变量的配置和管理
- **🔍 模板搜索**: 快速搜索和过滤模板

## 🏗️ 项目结构

```
endless-ddd-generator-ui/
├── bin/                    # 构建脚本（保留）
│   ├── check-env.sh       # 环境检查脚本
│   ├── dev.sh             # 开发模式脚本
│   ├── build-jar.sh       # JAR 构建脚本
│   ├── build-installer.sh # 生产构建脚本
│   └── README.md          # 脚本使用说明
├── config/                 # 配置文件
│   ├── application.yaml    # 主配置文件
│   ├── application-prod.yaml # 生产环境配置
│   └── log4j2-prod.xml    # 日志配置
├── data/                   # 数据目录（空）
├── gen/                    # 生成的配置文件
│   └── schemas/           # Tauri 配置模式
├── lib/                    # 库文件
│   └── endless-ddd-generator.jar
├── logs/                   # 日志目录
├── public/                 # 静态资源
│   ├── css/               # 样式文件
│   │   ├── bootstrap.min.css
│   │   ├── bootstrap-icons.css # 已修复字体路径
│   │   ├── base.css
│   │   └── fonts/         # 字体文件
│   ├── js/                # JavaScript 文件
│   │   ├── core/          # 核心功能模块
│   │   │   ├── AlertManager.js
│   │   │   ├── AppBar.js
│   │   │   ├── DataManager.js
│   │   │   ├── FileManager.js
│   │   │   ├── ProjectManager.js
│   │   │   └── TemplateManager.js
│   │   ├── components/    # 组件模块
│   │   │   ├── ComponentLoader.js
│   │   │   ├── ContentManager.js
│   │   │   ├── FileExplorer.js
│   │   │   ├── ProjectWizard.js
│   │   │   ├── TemplateEditor.js
│   │   │   └── ConfigPanel.js
│   │   ├── ui/           # UI 模块
│   │   │   ├── TabManager.js
│   │   │   ├── ModalManager.js
│   │   │   └── ThemeManager.js
│   │   └── lib/          # 第三方库
│   │       ├── bootstrap.bundle.min.js
│   │       ├── jquery.min.js
│   │       └── popper.min.js
│   ├── components/        # HTML 组件
│   │   ├── AlertModal.html
│   │   ├── FileExplorer.html
│   │   ├── FileProcessor.html
│   │   ├── ProjectWizard.html
│   │   ├── TemplateEditor.html
│   │   └── ConfigPanel.html
│   └── index.html         # 主页面
├── src-tauri/             # Tauri 后端代码
│   ├── src/               # Rust 源码
│   │   ├── main.rs        # 主程序
│   │   ├── generator.rs   # 生成器模块
│   │   ├── template.rs    # 模板引擎
│   │   ├── file_manager.rs # 文件管理
│   │   └── config.rs      # 配置管理
│   ├── Cargo.toml         # Rust 依赖配置
│   └── tauri.conf.json5   # Tauri 配置
├── target/                # 构建输出目录
├── Cargo.toml            # Rust 依赖配置
├── Cargo.lock            # Rust 依赖锁定文件
├── build.rs              # 构建脚本
└── tauri.conf.json5      # Tauri 配置文件
```

## 🚀 快速开始

### 环境要求

#### 必需环境
- **Rust**: 1.70+ ([下载地址](https://rustup.rs/))
- **Java**: 21+ ([下载地址](https://adoptium.net/))
- **操作系统**: Windows 10+, macOS 10.15+, Linux

#### 可选环境
- **Node.js**: 16+ (用于前端开发)
- **Git**: 版本控制

### 1. 克隆项目

```bash
git clone https://github.com/org-endless/endless-ddd.git
cd endless-ddd/endless-ddd-generator-ui
```

### 2. 环境检查

```bash
# Windows
bin\check-env.bat

# Linux/macOS
bash bin/check-env.sh
```

### 3. 开发模式

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

### 🎨 用户界面

#### 主界面
- **📋 项目向导**: 图形化项目创建向导
- **⚙️ 配置面板**: 可视化的项目配置界面
- **👀 预览窗口**: 实时代码生成预览
- **📁 文件浏览器**: 集成文件系统操作
- **📊 状态栏**: 显示当前操作状态和进度

#### 项目配置
- **📝 基本信息**: 项目名称、包名、版本等
- **🏗️ 架构选择**: DDD 分层架构配置
- **🔧 技术栈**: Spring Boot、数据库、缓存等选择
- **📋 模板定制**: 自定义代码生成模板
- **🔍 配置验证**: 实时配置参数验证

#### 模板管理
- **📝 模板编辑**: 可视化的模板编辑器
- **🔄 模板管理**: 模板的导入、导出和管理
- **🎨 模板预览**: 模板渲染结果的预览
- **📋 变量配置**: 模板变量的配置和管理
- **🔍 模板搜索**: 快速搜索和过滤模板

### 🔧 核心功能

#### 代码生成
- **🎯 聚合设计**: 聚合根、实体、值对象生成
- **📦 仓储模式**: 仓储接口和实现生成
- **⚡ 应用服务**: 命令和查询服务生成
- **🏗️ 基础设施**: 数据库、缓存、消息等配置
- **🌐 控制器**: REST API 控制器生成

#### 文件管理
- **📁 目录创建**: 自动创建项目目录结构
- **📄 文件生成**: 批量生成代码文件
- **🔍 文件预览**: 生成文件的实时预览
- **💾 配置保存**: 项目配置的保存和加载
- **📤 项目导出**: 导出生成的项目

#### 模板系统
- **📝 模板编辑**: 可视化的模板编辑器
- **🔄 模板管理**: 模板的导入、导出和管理
- **🎨 模板预览**: 模板渲染结果的预览
- **📋 变量配置**: 模板变量的配置和管理
- **🔍 模板搜索**: 快速搜索和过滤模板

### 🔍 高级功能

#### 项目向导
- **🎯 步骤引导**: 分步骤引导用户完成项目配置
- **📋 表单验证**: 实时验证用户输入
- **🔄 步骤回退**: 支持返回上一步修改配置
- **💾 配置保存**: 自动保存配置进度

#### 实时预览
- **👀 代码预览**: 实时预览生成的代码
- **📊 结构预览**: 预览项目目录结构
- **🔍 语法高亮**: 代码语法高亮显示
- **📋 配置预览**: 预览当前配置参数

#### 错误处理
- **🚨 错误提示**: 友好的错误提示信息
- **🔧 修复建议**: 提供错误修复建议
- **📋 错误日志**: 详细的错误日志记录
- **🔄 自动恢复**: 自动恢复应用状态

## 🛠️ 使用指南

### 创建新项目

#### 1. 启动应用

```bash
# 开发模式
cargo tauri dev

# 或构建后运行
cargo tauri build
./target/release/endless-ddd-generator-ui
```

#### 2. 使用项目向导

1. **选择项目类型**
   - DDD 标准项目
   - CQRS 项目
   - 微服务项目
   - 自定义项目

2. **配置项目信息**
   ```yaml
   project:
     name: "MyDDDProject"
     package: "com.example.myddd"
     version: "1.0.0"
     description: "A DDD project"
   ```

3. **设计领域模型**
   ```yaml
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

4. **选择技术栈**
   - 数据库: MySQL, PostgreSQL, SQLite
   - 缓存: Redis, Caffeine
   - 消息: Kafka, RabbitMQ
   - 安全: JWT, OAuth2
   - 监控: Prometheus, Grafana

#### 3. 生成项目

1. **预览项目结构**
   - 查看生成的文件列表
   - 预览关键代码文件
   - 验证配置参数

2. **选择输出目录**
   - 浏览本地文件系统
   - 创建新目录
   - 确认目录权限

3. **生成项目**
   - 点击"生成项目"按钮
   - 等待生成完成
   - 查看生成结果

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

### 高级功能

#### 1. 项目导入导出

```bash
# 导出项目配置
# 在应用中选择"导出配置"
# 选择导出格式: JSON, YAML, XML

# 导入项目配置
# 在应用中选择"导入配置"
# 选择配置文件并导入
```

#### 2. 模板管理

```bash
# 导入模板
# 在模板管理器中点击"导入模板"
# 选择模板文件并导入

# 导出模板
# 在模板管理器中点击"导出模板"
# 选择导出格式并保存
```

#### 3. 批量生成

```bash
# 批量生成项目
# 准备多个项目配置文件
# 使用批量生成功能
# 选择输出目录
# 开始批量生成
```

## 📦 构建和部署

### 开发构建

```bash
# 开发模式
cargo tauri dev

# 调试构建
cargo tauri build --debug
```

### 生产构建

```bash
# 生产构建
cargo tauri build --release

# 构建安装包
cargo tauri build --release --config tauri.conf.json5
```

### 构建输出

```
target/release/
├── endless-ddd-generator-ui    # 可执行文件
└── bundle/                                # 安装包
    ├── msi/                              # Windows 安装包
    ├── deb/                              # Linux 安装包
    └── dmg/                              # macOS 安装包
```

### 发布流程

```bash
# 1. 构建应用
cargo tauri build --release

# 2. 测试应用
./target/release/endless-ddd-generator-ui

# 3. 创建安装包
cargo tauri build --release --config tauri.conf.json5

# 4. 签名应用（可选）
# 使用代码签名证书签名应用

# 5. 发布应用
# 上传到应用商店或官网
```

## ⚙️ 配置说明

### 应用配置

#### 主配置文件 (`config/application.yaml`)
```yaml
endless:
  version: 1.0.0-SNAPSHOT
  charset: UTF-8
  springdoc-path: /springdoc

server:
  port: 60001
  tomcat:
    connection-timeout: 20000
    max-threads: 200

spring:
  application:
    name: endless-ddd-generator
  profiles:
    active: prod
  freemarker:
    enabled: true
    template-loader-path: classpath:/templates/freemarker/
    suffix: .ftl
```

#### 生产环境配置 (`config/application-prod.yaml`)
```yaml
project-home: ${user.dir}
server-port: 60001

# 数据源配置
datasource-type: com.alibaba.druid.pool.DruidDataSource
datasource-driver-class-name: org.sqlite.JDBC
datasource-url: jdbc:sqlite:file:data/demo.db
datasource-username: ""
datasource-password: ""

# 日志配置
logging-config: file:config/log4j2-prod.xml
```

### Tauri 配置

#### 主配置文件 (`tauri.conf.json5`)
```json5
{
  "build": {
    "beforeDevCommand": "",
    "beforeBuildCommand": "",
    "devPath": "public",
    "distDir": "public"
  },
  "package": {
    "productName": "EndlessDDD Generator",
    "version": "1.0.0"
  },
  "tauri": {
    "allowlist": {
      "all": false,
      "fs": {
        "all": true,
        "scope": ["**"]
      },
      "dialog": {
        "all": true
      },
      "shell": {
        "all": true,
        "open": true
      }
    },
    "bundle": {
      "active": true,
      "targets": "all",
      "identifier": "com.endless.ddd.generator",
      "icon": [
        "icons/32x32.png",
        "icons/128x128.png",
        "icons/128x128@2x.png",
        "icons/icon.icns",
        "icons/icon.ico"
      ]
    },
    "security": {
      "csp": null
    },
    "windows": [
      {
        "fullscreen": false,
        "resizable": true,
        "title": "EndlessDDD Generator",
        "width": 1200,
        "height": 800,
        "minWidth": 800,
        "minHeight": 600
      }
    ]
  }
}
```

### 前端配置

#### JavaScript 配置
```javascript
// 应用配置
const APP_CONFIG = {
  version: '1.0.0',
  apiBaseUrl: 'http://localhost:60001',
  defaultTheme: 'light',
  autoSave: true,
  autoSaveInterval: 30000
};

// 模板配置
const TEMPLATE_CONFIG = {
  defaultPath: 'templates/',
  supportedFormats: ['ftl', 'html', 'txt'],
  maxFileSize: 1024 * 1024 // 1MB
};
```

## 🔍 故障排除

### 常见问题

#### 1. Rust 环境问题
```bash
# 检查 Rust 版本
rustc --version

# 更新 Rust
rustup update

# 清理缓存
cargo clean
```

#### 2. Java 环境问题
```bash
# 检查 Java 版本
java -version

# 设置 JAVA_HOME
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk
```

#### 3. 构建失败
```bash
# 清理所有缓存
cargo clean
rm -rf target/
cargo build
```

#### 4. 权限问题
```bash
# 检查文件权限
ls -la

# 修改权限
chmod +x bin/*.sh
```

#### 5. 网络问题
```bash
# 检查网络连接
ping github.com

# 设置代理（如果需要）
export https_proxy=http://proxy.example.com:8080
export http_proxy=http://proxy.example.com:8080
```

### 平台特定问题

#### Windows
- 安装 Visual Studio Build Tools
- 安装 WebView2 运行时
- 确保 PowerShell 执行策略允许脚本运行
- 检查 Windows Defender 是否阻止应用

#### macOS
- 安装 Xcode 命令行工具: `xcode-select --install`
- 确保有开发者证书
- 检查 Gatekeeper 设置
- 在"安全性与隐私"中允许应用

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

# CentOS/RHEL 依赖
sudo yum install gtk3-devel \
    webkitgtk3-devel \
    libappindicator-gtk3-devel \
    librsvg2-devel
```

### 调试技巧

#### 1. 启用调试模式
```bash
# 启用详细日志
RUST_LOG=debug cargo tauri dev

# 启用前端调试
# 在浏览器中打开开发者工具
```

#### 2. 检查日志
```bash
# 查看应用日志
tail -f logs/endless-ddd-generator/YYYYMMDD/app.log

# 查看系统日志
journalctl -f -u endless-ddd-generator
```

#### 3. 性能分析
```bash
# 使用 perf 分析性能
perf record -g ./target/release/endless-ddd-generator-ui
perf report

# 使用 valgrind 检查内存
valgrind --tool=memcheck ./target/release/endless-ddd-generator-ui
```

## 📚 API 文档

### 核心接口

#### 项目生成器
```rust
pub trait ProjectGenerator {
    fn generate(&self, config: ProjectConfig, output_path: &str) -> Result<(), Error>;
    fn preview(&self, config: ProjectConfig) -> Result<ProjectStructure, Error>;
    fn validate(&self, config: &ProjectConfig) -> Result<Vec<String>, Error>;
}
```

#### 模板引擎
```rust
pub trait TemplateEngine {
    fn render(&self, template: &str, context: &Value) -> Result<String, Error>;
    fn register_template(&mut self, name: &str, template: &str) -> Result<(), Error>;
    fn validate_template(&self, template: &str) -> Result<Vec<String>, Error>;
}
```

#### 文件管理器
```rust
pub trait FileManager {
    fn create_directory(&self, path: &str) -> Result<(), Error>;
    fn write_file(&self, path: &str, content: &str) -> Result<(), Error>;
    fn read_file(&self, path: &str) -> Result<String, Error>;
    fn delete_file(&self, path: &str) -> Result<(), Error>;
    fn list_files(&self, path: &str) -> Result<Vec<String>, Error>;
}
```

#### 配置管理器
```rust
pub trait ConfigManager {
    fn load_config(&self, path: &str) -> Result<ProjectConfig, Error>;
    fn save_config(&self, config: &ProjectConfig, path: &str) -> Result<(), Error>;
    fn validate_config(&self, config: &ProjectConfig) -> Result<Vec<String>, Error>;
}
```

### 配置模型

#### 项目配置
```rust
#[derive(Serialize, Deserialize)]
pub struct ProjectConfig {
    pub name: String,
    pub package_name: String,
    pub version: String,
    pub description: Option<String>,
    pub architecture: ArchitectureConfig,
    pub technology: TechnologyConfig,
    pub aggregates: Vec<AggregateConfig>,
    pub templates: Option<TemplateConfig>,
}
```

#### 架构配置
```rust
#[derive(Serialize, Deserialize)]
pub struct ArchitectureConfig {
    pub layers: Vec<String>,
    pub enable_cqrs: bool,
    pub enable_event_sourcing: bool,
    pub database_type: Option<String>,
    pub cache_type: Option<String>,
    pub security_type: Option<String>,
}
```

#### 聚合配置
```rust
#[derive(Serialize, Deserialize)]
pub struct AggregateConfig {
    pub name: String,
    pub description: Option<String>,
    pub entities: Vec<EntityConfig>,
    pub value_objects: Vec<ValueObjectConfig>,
    pub commands: Vec<CommandConfig>,
    pub queries: Vec<QueryConfig>,
}
```

### 前端 API

#### 项目管理
```javascript
// 创建项目
async function createProject(config) {
    const response = await fetch('/api/project/create', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(config)
    });
    return response.json();
}

// 预览项目
async function previewProject(config) {
    const response = await fetch('/api/project/preview', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(config)
    });
    return response.json();
}

// 生成项目
async function generateProject(config, outputPath) {
    const response = await fetch('/api/project/generate', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ config, outputPath })
    });
    return response.json();
}
```

#### 模板管理
```javascript
// 获取模板列表
async function getTemplates() {
    const response = await fetch('/api/templates');
    return response.json();
}

// 保存模板
async function saveTemplate(name, template) {
    const response = await fetch('/api/templates', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, template })
    });
    return response.json();
}

// 渲染模板
async function renderTemplate(template, context) {
    const response = await fetch('/api/templates/render', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ template, context })
    });
    return response.json();
}
```

#### 文件管理
```javascript
// 浏览目录
async function browseDirectory(path) {
    const response = await fetch(`/api/files/browse?path=${encodeURIComponent(path)}`);
    return response.json();
}

// 读取文件
async function readFile(path) {
    const response = await fetch(`/api/files/read?path=${encodeURIComponent(path)}`);
    return response.json();
}

// 写入文件
async function writeFile(path, content) {
    const response = await fetch('/api/files/write', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ path, content })
    });
    return response.json();
}
```

## 📖 使用教程

### 🎯 基础教程

#### 1. 创建第一个 DDD 项目

```bash
# 启动应用
cd endless-ddd-generator-ui
cargo tauri dev

# 在界面中配置项目
# 1. 输入项目名称: MyFirstDDDProject
# 2. 设置包名: com.example.myddd
# 3. 选择架构: 标准 DDD
# 4. 添加聚合: Order, Customer, Product
# 5. 生成项目
```

#### 2. 使用项目向导

1. **选择项目类型**
   - DDD 标准项目
   - CQRS 项目
   - 微服务项目
   - 自定义项目

2. **配置项目信息**
   ```yaml
   project:
     name: "MyDDDProject"
     package: "com.example.myddd"
     version: "1.0.0"
     description: "A DDD project"
   ```

3. **设计领域模型**
   ```yaml
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

4. **选择技术栈**
   - 数据库: MySQL, PostgreSQL, SQLite
   - 缓存: Redis, Caffeine
   - 消息: Kafka, RabbitMQ
   - 安全: JWT, OAuth2
   - 监控: Prometheus, Grafana

#### 3. 生成项目

1. **预览项目结构**
   - 查看生成的文件列表
   - 预览关键代码文件
   - 验证配置参数

2. **选择输出目录**
   - 浏览本地文件系统
   - 创建新目录
   - 确认目录权限

3. **生成项目**
   - 点击"生成项目"按钮
   - 等待生成完成
   - 查看生成结果

### 🔧 高级教程

#### 1. 自定义模板

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

### 🔍 高级功能

#### 1. 项目导入导出

```bash
# 导出项目配置
# 在应用中选择"导出配置"
# 选择导出格式: JSON, YAML, XML

# 导入项目配置
# 在应用中选择"导入配置"
# 选择配置文件并导入
```

#### 2. 模板管理

```bash
# 导入模板
# 在模板管理器中点击"导入模板"
# 选择模板文件并导入

# 导出模板
# 在模板管理器中点击"导出模板"
# 选择导出格式并保存
```

#### 3. 批量生成

```bash
# 批量生成项目
# 准备多个项目配置文件
# 使用批量生成功能
# 选择输出目录
# 开始批量生成
```

## 🔗 相关链接

- **项目主页**: [返回总体项目](./README.md)
- **启动器项目**: [EndlessDDD Starter](../endless-ddd-starter/README.md)
- **生成器项目**: [EndlessDDD Generator](../endless-ddd-generator/README.md)
- **GitHub 仓库**: [https://github.com/org-endless/endless-ddd](https://github.com/org-endless/endless-ddd)

---

**Happy Coding! 🚀** 
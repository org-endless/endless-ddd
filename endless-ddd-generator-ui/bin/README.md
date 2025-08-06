# EndlessDDD - 构建脚本使用说明

本目录包含 EndlessDDD 项目的所有构建和开发脚本，提供完整的开发、构建和部署流程。

## 📋 脚本概览

### 🔧 环境检查脚本
- `check-env.bat` / `check-env.sh` - 检查并自动安装开发环境依赖
- `install-check.bat` / `install-check.sh` - 安装包运行时的环境检查

### 🏗️ 构建脚本
- `build-jar.bat` / `build-jar.sh` - 构建 Spring Boot JAR 文件
- `build-installer.bat` / `build-installer.sh` - 构建生产安装包

### 🚀 开发脚本
- `dev.bat` / `dev.sh` - 开发模式，编译并启动应用进行调试

## 🎯 快速开始

### 1. 首次设置（环境检查）

```bash
# Windows
bin\check-env.bat

# Linux/macOS
bash bin/check-env.sh
```

**环境检查内容：**
- ✅ Java 21 或更高版本
- ✅ Maven 3.6+ (使用项目根路径的 mvnw)
- ✅ Rust 1.70+
- ✅ Tauri CLI

**自动安装功能：**
- 🔄 自动检测操作系统
- 📦 自动下载并安装缺失的依赖
- ⚙️ 自动配置环境变量
- 🔍 自动验证安装结果

### 2. 开发模式

```bash
# Windows
bin\dev.bat

# Linux/macOS
bash bin/dev.sh
```

**开发模式流程：**
1. 🔍 检查环境依赖
2. 🏗️ 构建 Spring Boot JAR 文件
3. 🧹 清理 Rust 缓存
4. ⚙️ 编译 Tauri 应用
5. 🚀 启动应用进行调试

### 3. 构建 JAR 文件

```bash
# Windows
bin\build-jar.bat

# Linux/macOS
bash bin/build-jar.sh
```

**JAR 构建用途：**
- 🔄 更新后端逻辑
- 🧪 测试 Spring Boot 功能
- 📦 准备生产构建

### 4. 构建生产安装包

```bash
# Windows
bin\build-installer.bat

# Linux/macOS
bash bin/build-installer.sh
```

**生产构建流程：**
1. 🔍 检查环境依赖
2. 🧹 清理所有缓存
3. 🏗️ 构建 Spring Boot JAR 文件
4. ⚙️ 编译 Tauri 应用
5. 📦 生成安装包（MSI/DEB/DMG）

## 📦 安装包特性

### 🎯 自动环境检查
- 🔍 检查 Java 21+ 环境
- 📥 自动下载并安装 OpenJDK 21
- ⚙️ 配置环境变量

### 🔄 进程管理
- 🚀 启动时自动启动 Spring Boot 服务
- 🛑 关闭应用时自动清理 Spring Boot 进程
- 🚫 防止端口冲突

### 🖥️ 桌面应用体验
- 🎨 原生桌面应用界面
- 📱 响应式布局，适配窗口大小
- 🚫 无滚动条，全屏体验

## 📁 文件结构

```
bin/
├── check-env.bat          # Windows 环境检查
├── check-env.sh           # Linux/macOS 环境检查
├── build-jar.bat          # Windows JAR 构建
├── build-jar.sh           # Linux/macOS JAR 构建
├── dev.bat                # Windows 开发模式
├── dev.sh                 # Linux/macOS 开发模式
├── build-installer.bat    # Windows 生产构建
├── build-installer.sh     # Linux/macOS 生产构建
├── install-check.bat      # Windows 安装环境检查
├── install-check.sh       # Linux/macOS 安装环境检查
└── README.md              # 本文档
```

## 🔧 Maven 构建说明

项目使用 Maven Wrapper (mvnw) 进行构建，确保版本一致性：

- **Windows**: `mvnw.cmd clean package`
- **Linux/macOS**: `./mvnw clean package`

所有脚本都会自动使用项目根路径的 mvnw，无需单独安装 Maven。

## 🚨 故障排除

### 常见问题

#### 1. Java 版本过低
```bash
# 运行环境检查脚本自动安装 Java 21
bin/check-env.sh

# 或手动安装 OpenJDK 21
# macOS
brew install openjdk@21

# Ubuntu/Debian
sudo apt update
sudo apt install openjdk-21-jdk

# CentOS/RHEL
sudo yum install java-21-openjdk-devel
```

#### 2. Maven 构建失败
```bash
# 检查网络连接
ping maven.apache.org

# 清理 Maven 缓存
./mvnw clean

# 检查 settings.xml 配置
cat ~/.m2/settings.xml
```

#### 3. Rust 编译失败
```bash
# 更新 Rust
rustup update

# 清理缓存
cargo clean

# 检查依赖版本
cargo tree
```

#### 4. 端口 60001 被占用
```bash
# 脚本会自动检测并清理占用进程
# 或手动终止
# Windows
taskkill /F /IM java.exe

# Linux/macOS
pkill -f java
```

### 🔍 调试技巧

#### 1. 查看详细日志
```bash
# 启用详细 Maven 输出
./mvnw clean package -X

# 启用详细 Cargo 输出
cargo build -vv

# 查看 Tauri 构建日志
cargo tauri build --verbose
```

#### 2. 检查环境变量
```bash
# Windows
echo %JAVA_HOME%
echo %PATH%

# Linux/macOS
echo $JAVA_HOME
echo $PATH
```

#### 3. 验证安装
```bash
java -version
./mvnw -version
rustc --version
cargo tauri --version
```

#### 4. 检查端口占用
```bash
# Windows
netstat -ano | findstr :60001

# Linux/macOS
lsof -i :60001
```

## 🛠️ 开发流程

### 日常开发
```bash
# 启动开发模式
bin/dev.sh

# 或 Windows
bin/dev.bat
```

### 更新后端逻辑
```bash
# 重新构建 JAR
bin/build-jar.sh

# 重新启动应用
bin/dev.sh
```

### 发布新版本
```bash
# 构建生产安装包
bin/build-installer.sh

# 检查生成的文件
ls target/release/bundle/
```

## 📋 最佳实践

### 1. 开发环境管理
- 🔄 定期运行环境检查脚本
- 📦 保持依赖版本更新
- 🧹 定期清理构建缓存

### 2. 构建优化
- 🚀 开发模式保留缓存以提高构建速度
- 🧹 生产构建清理所有缓存确保干净构建
- 📦 使用 Maven Wrapper 确保构建环境一致性

### 3. 调试技巧
- 🔍 使用详细日志模式排查问题
- 📊 监控系统资源使用情况
- 🚨 及时处理端口冲突问题

## ⚠️ 注意事项

### 环境要求
- ✅ 所有脚本都会自动检查环境依赖
- ✅ 生产构建会清理所有缓存确保干净构建
- ✅ 开发模式会保留缓存以提高构建速度
- ✅ 安装包会自动处理 Java 环境依赖

### 进程管理
- ✅ 应用关闭时会自动清理 Spring Boot 进程
- ✅ 使用 Maven Wrapper 确保构建环境一致性
- ✅ 自动检测并处理端口冲突

### 平台兼容性
- ✅ Windows: 支持 PowerShell 和 CMD
- ✅ macOS: 支持 Intel 和 Apple Silicon
- ✅ Linux: 支持主流发行版

## 🔄 更新日志

### v1.0.0
- 🎉 初始版本发布
- 🔧 完整的构建脚本套件
- 🚀 自动环境检查和安装
- 📦 跨平台安装包支持

## 📞 支持

如果遇到问题，请：

1. 🔍 查看本文档的故障排除部分
2. 📋 运行环境检查脚本
3. 🐛 查看详细构建日志
4. 📧 提交 Issue 到项目仓库

---

**Happy Coding! 🚀**

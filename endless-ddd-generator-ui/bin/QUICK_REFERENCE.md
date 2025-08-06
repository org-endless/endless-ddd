# 🚀 EndlessDDD 快速参考

## 📋 常用命令

### 🔧 环境设置
```bash
# 检查并安装环境依赖
bin/check-env.sh          # Linux/macOS
bin/check-env.bat         # Windows
```

### 🚀 开发模式
```bash
# 启动开发模式
bin/dev.sh                # Linux/macOS
bin/dev.bat               # Windows
```

### 🏗️ 构建命令
```bash
# 构建 JAR 文件
bin/build-jar.sh          # Linux/macOS
bin/build-jar.bat         # Windows

# 构建生产安装包
bin/build-installer.sh    # Linux/macOS
bin/build-installer.bat   # Windows
```

## 🔍 故障排除

### 常见问题快速解决

#### Java 版本问题
```bash
# 检查 Java 版本
java -version

# 自动安装 Java 21
bin/check-env.sh
```

#### 端口占用问题
```bash
# 检查端口占用
lsof -i :60001            # Linux/macOS
netstat -ano | findstr :60001  # Windows

# 终止占用进程
pkill -f java             # Linux/macOS
taskkill /F /IM java.exe  # Windows
```

#### 构建失败
```bash
# 清理缓存
cargo clean
./mvnw clean

# 重新构建
bin/dev.sh
```

## 📊 状态检查

### 环境验证
```bash
# 检查所有依赖
java -version
./mvnw -version
rustc --version
cargo tauri --version
```

### 构建状态
```bash
# 检查构建产物
ls target/release/
ls target/release/bundle/
```

## 🎯 开发流程

### 日常开发
1. `bin/check-env.sh` - 检查环境
2. `bin/dev.sh` - 启动开发模式
3. 修改代码
4. 自动重新构建

### 发布流程
1. `bin/build-installer.sh` - 构建安装包
2. 检查 `target/release/bundle/` 目录
3. 测试安装包
4. 发布新版本

## 📞 紧急联系

- 🐛 问题报告：提交 Issue
- 📧 技术支持：查看 README.md
- 🔍 详细文档：查看 README.md

---

**💡 提示：所有脚本都支持 `--help` 参数获取详细帮助** 
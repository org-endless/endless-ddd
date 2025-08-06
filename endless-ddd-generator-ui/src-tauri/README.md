# Tauri 应用模块化结构

## 目录结构

```
src-tauri/
├── main.rs                    # 主入口文件
├── installer.rs               # 安装程序模块
└── components/               # 应用组件模块
    ├── mod.rs                # 组件模块声明
    ├── spring_boot.rs        # Spring Boot管理
    ├── system.rs             # 系统工具
    ├── commands.rs           # Tauri命令处理
    ├── config.rs             # 应用配置
    ├── lifecycle.rs          # 应用生命周期管理
    └── window.rs             # 窗口管理
```

## 模块说明

### 1. `main.rs` - 主入口文件
- 应用的主入口点
- 初始化配置和启动Tauri应用
- 注册所有Tauri命令处理器

### 2. `components/spring_boot.rs` - Spring Boot管理模块
- **功能**: 管理Spring Boot进程的启动、停止和状态检查
- **主要函数**:
  - `spawn_spring_boot()`: 启动Spring Boot进程
  - `stop_spring_boot()`: 停止Spring Boot进程
  - `check_spring_boot_status()`: 检查Spring Boot服务状态
  - `wait_port_open()`: 异步等待端口开放

### 3. `components/system.rs` - 系统工具模块
- **功能**: 提供系统级操作和工具函数
- **主要函数**:
  - `get_default_install_path()`: 获取默认安装路径
  - `run_system_test()`: 执行系统测试
  - `select_folder()`: 选择文件夹对话框

### 4. `components/commands.rs` - Tauri命令处理模块
- **功能**: 处理所有Tauri命令，作为前端和后端的桥梁
- **主要命令**:
  - 安装相关: `get_system_info`, `select_install_path`, `install_application`等
  - Spring Boot相关: `start_spring_boot`, `stop_spring_boot_command`等
  - 系统相关: `run_system_test_command`, `select_folder_command`等

### 5. `components/config.rs` - 应用配置模块
- **功能**: 管理应用配置和资源路径
- **主要功能**:
  - `AppConfig`: 应用配置结构体
  - 资源目录验证和管理
  - 开发/生产环境路径处理

### 6. `components/lifecycle.rs` - 应用生命周期管理模块
- **功能**: 管理应用的生命周期事件
- **主要功能**:
  - `AppLifecycle::setup()`: 应用启动时的初始化
  - `AppLifecycle::handle_window_close()`: 处理窗口关闭事件

### 7. `components/window.rs` - 窗口管理模块
- **功能**: 管理窗口大小、置顶、最大化等窗口相关功能
- **主要功能**:
  - `WindowManager::set_window_size()`: 根据屏幕分辨率设置窗口大小
  - `WindowManager::set_window_always_on_top()`: 设置窗口置顶
  - `WindowManager::maximize_window()`: 最大化窗口
  - `WindowManager::set_fullscreen()`: 设置窗口全屏
  - `WindowManager::get_window_info()`: 获取窗口和屏幕信息

### 8. `installer.rs` - 安装程序模块
- **功能**: 处理应用程序的安装和卸载
- **主要功能**:
  - `Installer`: 安装器结构体
  - `InstallOptions`: 安装选项
  - `SystemInfo`: 系统信息

## 模块依赖关系

```
main.rs
├── components/ (应用组件)
│   ├── config.rs (应用配置)
│   ├── lifecycle.rs (生命周期管理)
│   ├── commands.rs (命令处理)
│   │   ├── spring_boot.rs (Spring Boot管理)
│   │   ├── system.rs (系统工具)
│   │   └── window.rs (窗口管理)
│   └── mod.rs (模块声明)
└── installer.rs (安装程序)
```

## 重构优势

1. **代码组织**: 按功能分离，每个模块职责单一
2. **可维护性**: 代码结构清晰，易于理解和修改
3. **可扩展性**: 新功能可以独立添加到相应模块
4. **可测试性**: 每个模块可以独立测试
5. **代码复用**: 通用功能可以在不同模块间共享
6. **模块化**: 所有组件集中在components目录下，便于管理

## 使用示例

### 添加新的Spring Boot功能
```rust
// 在 components/spring_boot.rs 中添加新函数
pub fn restart_spring_boot() -> Result<()> {
    stop_spring_boot()?;
    // 重启逻辑
    Ok(())
}

// 在 components/commands.rs 中添加新命令
#[tauri::command]
pub async fn restart_spring_boot_command() -> Result<String, String> {
    restart_spring_boot().map_err(|e| e.to_string())?;
    Ok("Spring Boot 已重启".to_string())
}
```

### 添加新的系统功能
```rust
// 在 components/system.rs 中添加新函数
pub fn get_system_memory() -> u64 {
    // 获取系统内存信息
    0
}

// 在 components/commands.rs 中添加新命令
#[tauri::command]
pub async fn get_system_memory_command() -> Result<u64, String> {
    Ok(get_system_memory())
}
```

## 组件模块化优势

1. **清晰的目录结构**: 所有组件集中在components目录下
2. **易于导航**: 相关功能文件在同一目录中
3. **模块化管理**: 每个组件都是独立的模块
4. **便于扩展**: 新组件可以轻松添加到components目录
5. **代码复用**: 组件间可以相互引用和复用 
use crate::installer::{InstallOptions, Installer, SystemInfo};
use crate::components::spring_boot::{check_spring_boot_status, stop_spring_boot};
use crate::components::system::{get_default_install_path, run_system_test, select_folder};
use crate::components::window::WindowManager;
use tauri::{AppHandle, Manager};

/// 获取系统信息
#[tauri::command]
pub async fn get_system_info(app_handle: AppHandle) -> Result<SystemInfo, String> {
    let installer = Installer::new(app_handle);
    installer.get_system_info().map_err(|e| e.to_string())
}

/// 选择安装路径
#[tauri::command]
pub async fn select_install_path(app_handle: AppHandle) -> Result<Option<String>, String> {
    let installer = Installer::new(app_handle);
    installer.select_install_path().await.map_err(|e| e.to_string())
}

/// 验证安装路径
#[tauri::command]
pub async fn validate_install_path(app_handle: AppHandle, path: String) -> Result<bool, String> {
    let installer = Installer::new(app_handle);
    installer.validate_install_path(&path).map_err(|e| e.to_string())
}

/// 执行安装
#[tauri::command]
pub async fn install_application(app_handle: AppHandle, options: InstallOptions) -> Result<(), String> {
    let installer = Installer::new(app_handle);
    installer.install(options).await.map_err(|e| e.to_string())
}

/// 卸载应用程序
#[tauri::command]
pub async fn uninstall_application(app_handle: AppHandle, install_path: String) -> Result<(), String> {
    let installer = Installer::new(app_handle);
    installer.uninstall(&install_path).await.map_err(|e| e.to_string())
}

/// 获取默认安装路径
#[tauri::command]
pub async fn get_default_install_path_command() -> Result<String, String> {
    Ok(get_default_install_path())
}

/// 系统测试命令
#[tauri::command]
pub async fn run_system_test_command() -> Result<String, String> {
    Ok(run_system_test())
}

/// 启动安装程序
#[tauri::command]
pub async fn launch_installer(app_handle: AppHandle) -> Result<(), String> {
    let window = app_handle.get_webview_window("main").unwrap();
    window.eval("window.location.href = 'installer.html';").map_err(|e| e.to_string())?;
    Ok(())
}

/// 选择文件夹
#[tauri::command]
pub async fn select_folder_command(_app_handle: AppHandle) -> Result<std::collections::HashMap<String, String>, String> {
    select_folder()
}

/// 启动Spring Boot的命令
#[tauri::command]
pub async fn start_spring_boot() -> Result<String, String> {
    // 这个命令可以在前端调用，但我们现在在窗口创建时自动启动
    Ok("Spring Boot 启动命令已注册".to_string())
}

/// 停止Spring Boot的命令
#[tauri::command]
pub async fn stop_spring_boot_command() -> Result<String, String> {
    stop_spring_boot().map_err(|e| e.to_string())?;
    Ok("Spring Boot 已停止".to_string())
}

/// 检查Spring Boot状态的命令
#[tauri::command]
pub async fn check_spring_boot_status_command() -> Result<bool, String> {
    Ok(check_spring_boot_status())
}

/// 获取窗口信息
#[tauri::command]
pub async fn get_window_info(app_handle: AppHandle) -> Result<std::collections::HashMap<String, String>, String> {
    let window = app_handle.get_webview_window("main").unwrap();
    Ok(WindowManager::get_window_info(&window))
}

/// 设置窗口置顶
#[tauri::command]
pub async fn set_window_always_on_top(app_handle: AppHandle, always_on_top: bool) -> Result<(), String> {
    let window = app_handle.get_webview_window("main").unwrap();
    window.set_always_on_top(always_on_top).map_err(|e| e.to_string())?;
    Ok(())
}

/// 设置窗口大小
#[tauri::command]
pub async fn set_window_size(app_handle: AppHandle) -> Result<(), String> {
    let window = app_handle.get_webview_window("main").unwrap();
    WindowManager::set_window_size(&window).map_err(|e| e.to_string())?;
    Ok(())
}

/// 最大化窗口
#[tauri::command]
pub async fn maximize_window(app_handle: AppHandle) -> Result<(), String> {
    let window = app_handle.get_webview_window("main").unwrap();
    WindowManager::maximize_window(&window).map_err(|e| e.to_string())?;
    Ok(())
}

/// 设置窗口全屏
#[tauri::command]
pub async fn set_window_fullscreen(app_handle: AppHandle, fullscreen: bool) -> Result<(), String> {
    let window = app_handle.get_webview_window("main").unwrap();
    WindowManager::set_fullscreen(&window, fullscreen).map_err(|e| e.to_string())?;
    Ok(())
} 
mod installer;
mod components;

use crate::components::commands::*;
use crate::components::config::AppConfig;
use crate::components::lifecycle::AppLifecycle;
use anyhow::Result;

#[tokio::main]
async fn main() -> Result<()> {
    // 初始化应用配置
    let app_config = AppConfig::new()?;
    let resource_dir_str = app_config.resource_dir.clone();

    // 启动 Tauri 窗口，使用自定义 splash 实现
    let result = tauri::Builder::default()
        .invoke_handler(tauri::generate_handler![
            get_system_info,
            select_install_path,
            validate_install_path,
            install_application,
            uninstall_application,
            get_default_install_path_command,
            run_system_test_command,
            launch_installer,
            select_folder_command,
            start_spring_boot,
            stop_spring_boot_command,
            check_spring_boot_status_command,
            get_window_info,
            set_window_always_on_top,
            set_window_size,
            maximize_window,
            set_window_fullscreen,
        ])
        .setup(move |app| {
            AppLifecycle::setup(app, resource_dir_str.clone())
        })
        .on_window_event(|window, event| {
            if let tauri::WindowEvent::CloseRequested { .. } = event {
                println!("🔄 窗口 '{}' 请求关闭", window.label());
                AppLifecycle::handle_window_close();
            }
        })
        .run(tauri::generate_context!());
    result.expect("运行 Tauri 应用失败");
    Ok(())
}

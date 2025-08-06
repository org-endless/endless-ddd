use std::collections::HashMap;
use tauri::WebviewWindow;

/// 窗口管理结构
pub struct WindowManager;

impl WindowManager {
    /// 根据屏幕分辨率设置窗口大小
    pub fn set_window_size(window: &WebviewWindow) -> Result<(), Box<dyn std::error::Error>> {
        // 获取屏幕信息
        if let Ok(Some(screen)) = window.primary_monitor() {
            let size = screen.size();
            let scale_factor = screen.scale_factor();

            // 计算合适的窗口大小
            let (width, height) = Self::calculate_window_size(size.width, size.height, scale_factor);

            // 设置窗口大小
            window.set_size(tauri::Size::Logical(tauri::LogicalSize::new(width, height)))?;

            // 居中显示
            window.center()?;

            println!("📱 屏幕分辨率: {}x{} (缩放: {})", size.width, size.height, scale_factor);
            println!("🪟 窗口大小: {}x{}", width, height);
        }

        Ok(())
    }

    /// 最大化窗口
    pub fn maximize_window(window: &WebviewWindow) -> Result<(), Box<dyn std::error::Error>> {
        // 最大化窗口
        window.maximize()?;

        println!("🖥️ 窗口已最大化");

        Ok(())
    }

    /// 设置窗口为全屏
    pub fn set_fullscreen(window: &WebviewWindow, fullscreen: bool) -> Result<(), Box<dyn std::error::Error>> {
        // 设置全屏状态
        window.set_fullscreen(fullscreen)?;

        let status = if fullscreen { "全屏" } else { "退出全屏" };
        println!("🖥️ 窗口已{}", status);

        Ok(())
    }

    /// 计算合适的窗口大小
    fn calculate_window_size(screen_width: u32, screen_height: u32, scale_factor: f64) -> (f64, f64) {
        // 基础窗口大小
        let base_width = 1024.0;
        let base_height = 768.0;

        // 考虑缩放因子
        let scaled_width = base_width / scale_factor;
        let scaled_height = base_height / scale_factor;

        // 确保窗口不超过屏幕的80%
        let max_width = (screen_width as f64) * 0.8;
        let max_height = (screen_height as f64) * 0.8;

        let width = scaled_width.min(max_width);
        let height = scaled_height.min(max_height);

        (width, height)
    }

    /// 设置窗口置顶
    #[allow(dead_code)]
    pub fn set_window_always_on_top(window: &WebviewWindow) -> Result<(), Box<dyn std::error::Error>> {
        // 设置窗口置顶
        window.set_always_on_top(true)?;

        // 设置窗口焦点
        window.set_focus()?;

        println!("🔝 窗口已置顶");

        Ok(())
    }

    /// 获取窗口信息
    pub fn get_window_info(window: &WebviewWindow) -> HashMap<String, String> {
        let mut info = HashMap::new();

        if let Ok(Some(screen)) = window.primary_monitor() {
            let size = screen.size();
            let scale_factor = screen.scale_factor();

            info.insert("screen_width".to_string(), size.width.to_string());
            info.insert("screen_height".to_string(), size.height.to_string());
            info.insert("scale_factor".to_string(), scale_factor.to_string());
        }

        if let Ok(window_size) = window.outer_size() {
            info.insert("window_width".to_string(), window_size.width.to_string());
            info.insert("window_height".to_string(), window_size.height.to_string());
        }

        info
    }
}

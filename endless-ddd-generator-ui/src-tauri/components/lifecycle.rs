use crate::components::spring_boot::spawn_spring_boot;
use crate::components::window::WindowManager;
use std::{sync::atomic::{AtomicBool, Ordering}, thread, time::Duration};
use tauri::{App, Emitter, Manager, WebviewWindow};
use ureq;

/// 全局停止标志
static STOP_HEALTH_CHECK: AtomicBool = AtomicBool::new(false);

/// 应用生命周期管理器
pub struct AppLifecycle;

impl AppLifecycle {
    /// 设置应用启动时的初始化
    pub fn setup(app: &mut App, resource_dir: String) -> Result<(), Box<dyn std::error::Error>> {
        STOP_HEALTH_CHECK.store(false, Ordering::Relaxed);
        let splash = app.get_webview_window("splash").unwrap();
        let main = app.get_webview_window("main").unwrap();

        // 立即显示并聚焦splash窗口，确保没有白屏
        splash.show()?;
        splash.set_focus()?;
        splash.set_always_on_top(true)?;
        println!("✅ Splash窗口已显示并置顶");

        // 确保主窗口隐藏，等待初始化完成
        main.hide()?;

        let resource_dir_clone = resource_dir.clone();
        let splash_clone = splash.clone();
        let main_clone = main.clone();

        thread::spawn(move || {
            let resource_path = std::path::Path::new(&resource_dir_clone);

            // 步骤1: 环境检查
            println!("🔍 开始环境检查...");
            let _ = splash_clone.emit("spring-boot-starting", "正在检查环境配置...");

            // 检查Java环境
            if let Err(e) = std::process::Command::new("java").arg("-version").output() {
                println!("❌ Java环境检查失败: {}", e);
                let _ = splash_clone.emit("spring-boot-error", "Java环境检查失败，将显示离线模式界面");

                // Java环境检查失败也显示主界面（离线模式）
                Self::switch_to_offline_mode(splash_clone, main_clone, 2000);
                return;
            }
            println!("✅ Java环境检查通过");

            // 检查JAR文件
            let jar_path = resource_path.join("lib/endless-ddd-generator.jar");
            if !jar_path.exists() {
                println!("❌ JAR文件不存在: {}", jar_path.display());
                let _ = splash_clone.emit("spring-boot-error", format!("JAR文件不存在，将显示离线模式界面"));

                // JAR文件不存在也显示主界面（离线模式）
                Self::switch_to_offline_mode(splash_clone, main_clone, 2000);
                return;
            }
            println!("✅ JAR文件检查通过");

            // 检查数据目录
            let data_dir = resource_path.join("data");
            if !data_dir.exists() {
                if let Err(e) = std::fs::create_dir_all(&data_dir) {
                    println!("❌ 创建数据目录失败: {}", e);
                    let _ = splash_clone.emit("spring-boot-error", format!("创建数据目录失败，将显示离线模式界面"));

                    // 数据目录创建失败也显示主界面（离线模式）
                    Self::switch_to_offline_mode(splash_clone, main_clone, 2000);
                    return;
                }
            }
            println!("✅ 数据目录检查通过");

            // 步骤2: 启动Spring Boot进程
            println!("🚀 正在启动 Spring Boot 服务...");
            let _ = splash_clone.emit("spring-boot-started", "正在启动Java进程...");

            match spawn_spring_boot(resource_path) {
                Ok(child) => {
                    println!("📦 Spring Boot 进程已启动 (PID: {})", child.id());
                    let _ = splash_clone.emit("spring-boot-started", format!("Spring Boot进程已启动 (PID: {})", child.id()));

                    // 给进程一点启动时间
                    thread::sleep(Duration::from_secs(2));

                    // 步骤3: 健康检查逻辑（最多等待 60 秒）
                    println!("🔍 开始健康检查...");
                    let mut healthy = false;
                    let mut health_check_count = 0;
                    const MAX_HEALTH_CHECKS: i32 = 60; // 增加到60秒

                    for i in 0..MAX_HEALTH_CHECKS {
                        // 检查是否需要停止健康检查
                        if STOP_HEALTH_CHECK.load(Ordering::Relaxed) {
                            println!("🛑 收到停止信号，终止健康检查");
                            break;
                        }

                        health_check_count = i + 1;
                        println!("🔍 健康检查尝试 {}/{}", health_check_count, MAX_HEALTH_CHECKS);

                        // 发送健康检查进度事件
                        let _ = splash_clone.emit("spring-boot-health-check", format!("健康检查中... ({}/{})", health_check_count, MAX_HEALTH_CHECKS));

                        match Self::check_spring_boot_health() {
                            Ok(true) => {
                                healthy = true;
                                println!("✅ 健康检查通过，服务已就绪");
                                let _ = splash_clone.emit("spring-boot-health-success", "健康检查通过，服务已就绪");
                                break;
                            }
                            Ok(false) => {
                                println!("⚠️ 健康检查返回非200状态码");
                            }
                            Err(e) => {
                                println!("⚠️ 健康检查失败: {}", e);
                                // 只在每5次检查时发送详细错误信息
                                if health_check_count % 5 == 0 {
                                    let _ = splash_clone.emit("spring-boot-health-progress", format!("等待服务启动... ({}/{}) - {}", health_check_count, MAX_HEALTH_CHECKS, e));
                                }
                            }
                        }

                        // 如果检查失败，发送详细状态
                        if health_check_count % 5 == 0 {
                            let _ = splash_clone.emit("spring-boot-health-progress", format!("等待服务启动... ({}/{})", health_check_count, MAX_HEALTH_CHECKS));
                        }

                        thread::sleep(Duration::from_secs(1));
                    }

                    if healthy {
                        let _ = splash_clone.emit("spring-boot-ready", "服务已就绪，准备切换到主界面");

                        // 步骤4: 切换窗口：先显示主窗口，再关闭splash
                        tauri::async_runtime::spawn(async move {
                            println!("🔄 切换到主窗口...");
                            let _ = splash_clone.emit("spring-boot-switching", "正在切换到主界面...");

                            // 给用户一点时间看到完成状态
                            thread::sleep(Duration::from_millis(800));

                            // 配置主窗口并显示
                            if let Err(e) = WindowManager::set_window_size(&main_clone) {
                                println!("⚠️ 设置主窗口大小失败: {}", e);
                            }

                            // 直接显示主窗口，无需复杂操作
                            let _ = main_clone.show();
                            let _ = main_clone.set_focus();
                            let _ = main_clone.center();

                            println!("✅ 主窗口已显示");

                            // 等待主窗口完全显示后再关闭splash
                            thread::sleep(Duration::from_millis(200));
                            let _ = splash_clone.close();
                            println!("✅ Splash窗口已关闭");
                        });
                    } else {
                        println!("❌ 健康检查失败，服务未就绪");
                        let _ = splash_clone.emit("spring-boot-error", format!("Spring Boot 启动失败，健康检查未通过 (尝试了{}次)。将显示离线模式界面。", health_check_count));

                        // 即使Spring Boot启动失败，也显示主界面（离线模式）
                        Self::switch_to_offline_mode(splash_clone, main_clone, 2000);
                    }
                }
                Err(e) => {
                    println!("❌ 启动 Spring Boot 失败: {}", e);
                    let _ = splash_clone.emit("spring-boot-error", format!("启动Spring Boot失败: {}。将显示离线模式界面。", e));

                    // 即使Spring Boot启动失败，也显示主界面（离线模式）
                    Self::switch_to_offline_mode(splash_clone, main_clone, 2000);
                }
            }
        });
        Ok(())
    }

    fn check_spring_boot_health() -> Result<bool, String> {
        match ureq::get("http://localhost:60001/actuator/health")
            .call()
        {
            Ok(resp) => {
                let status = resp.status();
                if status == 200 {
                    Ok(true)
                } else {
                    Err(format!("HTTP状态码: {}", status))
                }
            }
            Err(e) => {
                Err(format!("连接失败: {}", e))
            }
        }
    }

    /// 切换到离线模式的统一方法
    fn switch_to_offline_mode(splash_window: WebviewWindow, main_window: WebviewWindow, delay_ms: u64) {
        tauri::async_runtime::spawn(async move {
            println!("🔄 切换到离线模式界面...");

            // 给用户一点时间看到错误信息
            thread::sleep(Duration::from_millis(delay_ms));

            // 配置并显示主窗口
            if let Err(e) = WindowManager::set_window_size(&main_window) {
                println!("⚠️ 设置主窗口大小失败: {}", e);
            }

            let _ = main_window.show();
            let _ = main_window.set_focus();
            let _ = main_window.center();

            println!("✅ 离线模式主窗口已显示");

            // 等待主窗口完全显示后再关闭splash
            thread::sleep(Duration::from_millis(200));
            let _ = splash_window.close();
            println!("✅ 已切换到离线模式界面");
        });
    }

    /// 处理窗口关闭事件
    pub fn handle_window_close() {
        println!("🔄 窗口关闭请求，停止健康检查并清理Spring Boot进程...");

        // 设置停止标志，停止健康检查循环
        STOP_HEALTH_CHECK.store(true, Ordering::Relaxed);

        // 给健康检查线程一点时间来响应停止信号
        thread::sleep(Duration::from_millis(100));

        // 强制清理所有Java进程
        #[cfg(target_os = "windows")]
        {
            let _ = std::process::Command::new("taskkill")
                .args(&["/F", "/IM", "java.exe"])
                .output();
        }
        #[cfg(not(target_os = "windows"))]
        {
            let _ = std::process::Command::new("pkill")
                .args(&["-f", "endless-ddd-generator"])
                .output();
        }

        println!("✅ Spring Boot 进程已清理");
    }
}

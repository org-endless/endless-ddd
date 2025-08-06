use anyhow::{Context, Result};
use std::net::TcpStream;
use std::process::{Child, Command, Stdio};
use std::time::{Duration, Instant};
use tokio::time::sleep;

/// 等待端口开放（异步版本）
#[allow(dead_code)]
pub async fn wait_port_open(host: &str, port: u16, timeout_secs: u64) -> Result<()> {
    let start = Instant::now();
    let timeout = Duration::from_secs(timeout_secs);
    loop {
        if start.elapsed() > timeout {
            anyhow::bail!("等待端口 {}:{} 超时", host, port);
        }
        if TcpStream::connect((host, port)).is_ok() {
            break;
        }
        sleep(Duration::from_secs(1)).await;
    }
    Ok(())
}

/// 启动Spring Boot进程
pub fn spawn_spring_boot(resource_dir: &std::path::Path) -> Result<Child> {
    let jar_path = resource_dir.join("lib/endless-ddd-generator.jar");
    if !jar_path.exists() {
        anyhow::bail!("JAR 文件不存在: {}", jar_path.display());
    }
    
    // 确保数据目录存在
    let data_dir = resource_dir.join("data");
    if !data_dir.exists() {
        std::fs::create_dir_all(&data_dir).context("创建数据目录失败")?;
    }
    
    println!("🚀 启动 Spring Boot...");
    println!("📁 工作目录: {}", resource_dir.display());
    println!("📦 JAR 文件: {}", jar_path.display());
    
    let child = Command::new("java")
        .args(&[
            "-Xmx2g",
            "-Xms1g",
            "-Dfile.encoding=UTF-8",
            "-Dspring.profiles.active=prod",
            "-jar",
            jar_path.to_str().unwrap(),
            "--spring.config.location=file:config/application.yaml",
        ])
        .current_dir(resource_dir)
        .stdout(Stdio::piped())  // 捕获输出用于调试
        .stderr(Stdio::piped())  // 捕获错误用于调试
        .spawn()
        .context("启动 Spring Boot 失败")?;
    
    println!("✅ Spring Boot 进程已启动 (PID: {})", child.id());
    Ok(child)
}

/// 停止Spring Boot进程
pub fn stop_spring_boot() -> Result<()> {
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
    
    println!("✅ Spring Boot 进程已停止");
    Ok(())
}

/// 检查Spring Boot服务状态
pub fn check_spring_boot_status() -> bool {
    TcpStream::connect("127.0.0.1:60001").is_ok()
} 
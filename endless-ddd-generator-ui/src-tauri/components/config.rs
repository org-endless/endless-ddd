use anyhow::{Context, Result};
use std::path::Path;

/// 应用配置结构
#[allow(dead_code)]
pub struct AppConfig {
    pub resource_dir: String,
    pub lib_dir: String,
    pub config_dir: String,
    pub public_dir: String,
    pub data_dir: String,
}

impl AppConfig {
    /// 创建应用配置
    pub fn new() -> Result<Self> {
        let exe_path = std::env::current_exe().context("获取可执行文件路径失败")?;
        let exe_dir = exe_path.parent().context("获取可执行文件目录失败")?;

        // 在开发模式下，可执行文件在target\debug\目录中，需要向上查找资源目录
        let resource_dir = if exe_dir.ends_with("debug") || exe_dir.ends_with("release") {
            exe_dir.parent().unwrap().parent().unwrap()
        } else {
            exe_dir
        };

        // 验证必要的目录是否存在
        Self::validate_directories(resource_dir)?;

        let resource_dir_str = resource_dir.to_string_lossy().to_string();
        
        Ok(Self {
            resource_dir: resource_dir_str.clone(),
            lib_dir: resource_dir.join("lib").to_string_lossy().to_string(),
            config_dir: resource_dir.join("config").to_string_lossy().to_string(),
            public_dir: resource_dir.join("public").to_string_lossy().to_string(),
            data_dir: resource_dir.join("data").to_string_lossy().to_string(),
        })
    }

    /// 验证必要的目录是否存在
    fn validate_directories(resource_dir: &Path) -> Result<()> {
        for dir in &["lib", "config", "public"] {
            let d = resource_dir.join(dir);
            if !d.exists() {
                anyhow::bail!("未找到 {} 目录: {}", dir, d.display());
            }
        }
        Ok(())
    }

    /// 获取资源目录路径
    #[allow(dead_code)]
    pub fn get_resource_path(&self) -> &Path {
        std::path::Path::new(&self.resource_dir)
    }
} 
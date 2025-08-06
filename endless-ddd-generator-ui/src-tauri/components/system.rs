use std::collections::HashMap;
use std::net::TcpStream;

/// 获取默认安装路径
pub fn get_default_install_path() -> String {
    #[cfg(target_os = "windows")]
    {
        "C:\\Program Files\\Endless DDD Generator".to_string()
    }
    #[cfg(target_os = "macos")]
    {
        "/Applications/Endless DDD Generator".to_string()
    }
    #[cfg(target_os = "linux")]
    {
        "/opt/endless-ddd-generator".to_string()
    }
}

/// 系统测试命令
pub fn run_system_test() -> String {
    println!("=== EndlessDDD 系统测试开始 ===");
    println!("测试时间: {}", chrono::Local::now().format("%Y-%m-%d %H:%M:%S"));

    // 1. 测试Spring Boot服务
    println!("\n1. Spring Boot服务测试:");
    match TcpStream::connect("127.0.0.1:60001") {
        Ok(_) => {
            println!("  ✅ Spring Boot服务: 运行中");
            println!("  ✅ 端口: 60001");
            println!("  ✅ 状态: 可访问");
        }
        Err(e) => {
            println!("  ❌ Spring Boot服务: 未运行");
            println!("  ❌ 错误: {}", e);
        }
    }

    // 2. 系统信息
    println!("\n2. 系统信息:");
    println!("  操作系统: {}", std::env::consts::OS);
    println!("  架构: {}", std::env::consts::ARCH);
    println!("  当前目录: {:?}", std::env::current_dir().unwrap_or_default());

    // 3. 环境变量
    println!("\n3. 环境变量:");
    println!("  JAVA_HOME: {}", std::env::var("JAVA_HOME").unwrap_or_else(|_| "未设置".to_string()));
    println!("  PATH: {}", std::env::var("PATH").unwrap_or_else(|_| "未设置".to_string()));

    println!("\n=== 系统测试完成 ===");

    "测试完成，请查看终端输出".to_string()
}

/// 选择文件夹
pub fn select_folder() -> Result<HashMap<String, String>, String> {
    #[cfg(target_os = "windows")]
    {
        use std::process::Command;

        // 使用PowerShell选择文件夹
        let output = Command::new("powershell")
            .args(&[
                "-Command",
                "Add-Type -AssemblyName System.Windows.Forms; $folderBrowser = New-Object System.Windows.Forms.FolderBrowserDialog; $folderBrowser.Description = '选择项目根目录'; $folderBrowser.ShowNewFolderButton = $true; if ($folderBrowser.ShowDialog() -eq 'OK') { $folderBrowser.SelectedPath } else { '' }"
            ])
            .output()
            .map_err(|e| format!("执行PowerShell命令失败: {}", e))?;

        let selected_path = String::from_utf8_lossy(&output.stdout).trim().to_string();

        if selected_path.is_empty() {
            return Err("用户取消了文件夹选择".to_string());
        }

        let mut result = HashMap::new();
        result.insert("success".to_string(), "true".to_string());
        result.insert("full_path".to_string(), selected_path.clone());
        result.insert("folder_name".to_string(), std::path::Path::new(&selected_path)
            .file_name()
            .unwrap_or_default()
            .to_string_lossy()
            .to_string());

        Ok(result)
    }

    #[cfg(target_os = "macos")]
    {
        use std::process::Command;

        // 使用osascript选择文件夹
        let script = r#"
            tell application "System Events"
                activate
                set folderPath to choose folder with prompt "选择项目根目录"
                return POSIX path of folderPath
            end tell
        "#;

        let output = Command::new("osascript")
            .args(&["-e", script])
            .output()
            .map_err(|e| format!("执行AppleScript失败: {}", e))?;

        let selected_path = String::from_utf8_lossy(&output.stdout).trim().to_string();

        if selected_path.is_empty() {
            return Err("用户取消了文件夹选择".to_string());
        }

        let mut result = HashMap::new();
        result.insert("success".to_string(), "true".to_string());
        result.insert("full_path".to_string(), selected_path.clone());
        result.insert("folder_name".to_string(), std::path::Path::new(&selected_path)
            .file_name()
            .unwrap_or_default()
            .to_string_lossy()
            .to_string());

        Ok(result)
    }

    #[cfg(target_os = "linux")]
    {
        use std::process::Command;

        // 尝试使用zenity选择文件夹
        let output = Command::new("zenity")
            .args(&["--file-selection", "--directory", "--title=选择项目根目录"])
            .output();

        match output {
            Ok(output) => {
                let selected_path = String::from_utf8_lossy(&output.stdout).trim().to_string();

                if selected_path.is_empty() {
                    return Err("用户取消了文件夹选择".to_string());
                }

                let mut result = HashMap::new();
                result.insert("success".to_string(), "true".to_string());
                result.insert("full_path".to_string(), selected_path.clone());
                result.insert("folder_name".to_string(), std::path::Path::new(&selected_path)
                    .file_name()
                    .unwrap_or_default()
                    .to_string_lossy()
                    .to_string());

                Ok(result)
            }
            Err(_) => {
                // 如果zenity不可用，返回错误
                Err("系统不支持文件夹选择对话框".to_string())
            }
        }
    }

    #[cfg(not(any(target_os = "windows", target_os = "macos", target_os = "linux")))]
    {
        Err("不支持的操作系统".to_string())
    }
} 
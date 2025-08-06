/**
 * 加载管理器
 * 负责处理应用启动时的加载状态和Spring Boot服务检查
 */
class LoadingManager {
    constructor() {
        this.maxRetries = 3;
        this.retryDelay = 2000;
        this.healthCheckInterval = 500; // 减少检查间隔
        this.maxHealthCheckAttempts = 60; // 增加最大尝试次数
    }

    /**
     * 检查Spring Boot服务状态
     */
    async checkSpringBootHealth() {
        try {
            // 首先尝试健康检查端点
            const healthResponse = await fetch('http://localhost:60001/actuator/health', {
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Cache-Control': 'no-cache'
                }
            });
            
            if (healthResponse.ok) {
                const data = await healthResponse.json();
                return data.status === 'UP';
            }
        } catch (error) {
            console.log('健康检查失败，尝试基础连接...');
            
            // 如果健康检查失败，尝试基础连接
            try {
                const response = await fetch('http://localhost:60001/', {
                    method: 'GET',
                    headers: {
                        'Cache-Control': 'no-cache'
                    }
                });
                
                return response.ok;
            } catch (connError) {
                console.log('基础连接也失败:', connError.message);
            }
        }
        return false;
    }

    /**
     * 等待Spring Boot服务启动
     */
    async waitForSpringBoot() {
        let attempts = 0;
        
        while (attempts < this.maxHealthCheckAttempts) {
            if (await this.checkSpringBootHealth()) {
                console.log('✅ Spring Boot 服务已就绪');
                return true;
            }
            
            attempts++;
            console.log(`⏳ 等待 Spring Boot 服务... (${attempts}/${this.maxHealthCheckAttempts})`);
            await this.sleep(this.healthCheckInterval);
        }
        
        console.log('❌ Spring Boot 服务启动超时');
        return false;
    }

    /**
     * 重试连接
     */
    async retryConnection() {
        let retryCount = 0;
        
        while (retryCount < this.maxRetries) {
            retryCount++;
            console.log(`🔄 重试连接 (${retryCount}/${this.maxRetries})`);
            
            if (await this.waitForSpringBoot()) {
                return true;
            }
            
            if (retryCount < this.maxRetries) {
                await this.sleep(this.retryDelay);
            }
        }
        
        return false;
    }

    /**
     * 更新加载进度
     */
    updateProgress(percentage, status = '') {
        const progressBar = document.getElementById('progressBar');
        const statusText = document.getElementById('statusText');
        
        if (progressBar) {
            progressBar.style.width = percentage + '%';
        }
        
        if (statusText && status) {
            statusText.textContent = status;
        }
    }

    /**
     * 更新步骤状态
     */
    updateStep(stepIndex, steps) {
        if (stepIndex > 0) {
            // 完成上一步
            const prevStep = document.getElementById(steps[stepIndex - 1].id);
            if (prevStep) {
                prevStep.className = 'loading-step completed';
                const icon = prevStep.querySelector('.loading-step-icon');
                if (icon) icon.textContent = '✅';
            }
        }
        
        if (stepIndex < steps.length) {
            // 激活当前步骤
            const currentStep = document.getElementById(steps[stepIndex].id);
            if (currentStep) {
                currentStep.className = 'loading-step active';
                const icon = currentStep.querySelector('.loading-step-icon');
                if (icon) icon.textContent = '🔄';
            }
        }
    }

    /**
     * 显示错误信息
     */
    showError(message) {
        const errorContainer = document.getElementById('errorContainer');
        const errorMessage = document.getElementById('errorMessage');
        
        if (errorContainer && errorMessage) {
            errorMessage.textContent = message;
            errorContainer.style.display = 'block';
        }
        
        const statusText = document.getElementById('statusText');
        if (statusText) {
            statusText.textContent = '启动失败';
        }
    }

    /**
     * 隐藏错误信息
     */
    hideError() {
        const errorContainer = document.getElementById('errorContainer');
        if (errorContainer) {
            errorContainer.style.display = 'none';
        }
    }

    /**
     * 完成加载
     */
    completeLoading() {
        this.updateProgress(100, '启动完成！');
        
        // 延迟跳转到主页面
        setTimeout(() => {
            window.location.href = '../index.html';
        }, 1000);
    }

    /**
     * 开始加载流程
     */
    async startLoading() {
        const steps = [
            { id: 'step1', text: '检查环境配置', duration: 500 },
            { id: 'step2', text: '启动 Spring Boot 服务', duration: 2000 },
            { id: 'step3', text: '等待服务就绪', duration: 3000 },
            { id: 'step4', text: '加载应用界面', duration: 500 }
        ];

        try {
            // 步骤1: 检查环境配置
            this.updateStep(0, steps);
            this.updateProgress(10, steps[0].text);
            await this.sleep(steps[0].duration);
            
            // 步骤2: 启动 Spring Boot 服务
            this.updateStep(1, steps);
            this.updateProgress(30, steps[1].text);
            await this.sleep(steps[1].duration);
            
            // 步骤3: 等待服务就绪
            this.updateStep(2, steps);
            this.updateProgress(60, steps[2].text);
            
            // 立即开始检查Spring Boot状态
            const springBootReady = await this.waitForSpringBoot();
            
            if (springBootReady) {
                // 步骤4: 加载应用界面
                this.updateStep(3, steps);
                this.updateProgress(90, steps[3].text);
                await this.sleep(steps[3].duration);
                this.completeLoading();
            } else {
                this.showError('Spring Boot 服务启动超时，请检查服务状态。');
            }
        } catch (error) {
            console.error('加载过程出错:', error);
            this.showError('启动过程中发生错误: ' + error.message);
        }
    }

    /**
     * 工具方法：延迟
     */
    sleep(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }
}

// 全局加载管理器实例
window.loadingManager = new LoadingManager();

// 重试连接函数（供HTML调用）
window.retryConnection = async function() {
    window.loadingManager.hideError();
    
    if (await window.loadingManager.retryConnection()) {
        window.loadingManager.completeLoading();
    } else {
        window.loadingManager.showError('无法连接到 Spring Boot 服务，请检查服务状态。');
    }
}; 
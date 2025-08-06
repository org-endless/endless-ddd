/**
 * 统一数据管理器类
 * 负责处理服务、上下文、领域、聚合的级联选择和数据回显
 * 同时管理浏览器存储，包括项目信息、文件路径等元数据
 */
class DataManager {
    constructor() {
        this.STORAGE_KEYS = {
            PROJECT_INFO: 'endless_ddd_project_info',
            FILE_PATHS: 'endless_ddd_file_paths',
            RECENT_PROJECTS: 'endless_ddd_recent_projects',
            USER_PREFERENCES: 'endless_ddd_user_preferences',
            SESSION_DATA: 'endless_ddd_session_data'
        };
        
        this.init();
    }

    /**
     * 初始化数据管理器
     */
    init() {
        // 检查是否需要清理存储（强制刷新时）
        this.checkForForceRefresh();
        
        // 初始化默认值
        this.initializeDefaults();
        
        // 等待组件加载完成后再初始化
        this.waitForComponents().then(() => {
            this.loadServices();
            this.bindEvents();
        });
    }

    /**
     * 检查强制刷新
     */
    checkForForceRefresh() {
        const forceRefresh = sessionStorage.getItem('force_refresh');
        if (forceRefresh === 'true') {
            this.clearAllData();
            sessionStorage.removeItem('force_refresh');
        }
    }

    /**
     * 初始化默认值
     */
    initializeDefaults() {
        if (!this.getProjectInfo()) {
            this.setProjectInfo({
                name: '',
                path: '',
                lastOpened: null,
                isOpen: false
            });
        }

        if (!this.getRecentProjects()) {
            this.setRecentProjects([]);
        }

        if (!this.getUserPreferences()) {
            this.setUserPreferences({
                theme: 'light',
                language: 'zh-CN',
                autoSave: true,
                showLineNumbers: true
            });
        }
    }

    /**
     * 等待组件加载完成
     */
    async waitForComponents() {
        return new Promise((resolve) => {
            const checkComponents = () => {
                const serviceSelect = document.getElementById('serviceNameSelect');
                if (serviceSelect) {
                    resolve();
                } else {
                    setTimeout(checkComponents, 100);
                }
            };
            checkComponents();
        });
    }

    /**
     * 加载服务列表
     */
    loadServices() {
        const maxRetries = 3;
        let retryCount = 0;

        const tryLoadServices = () => {
            $.ajax({
                url: '/services',
                method: 'GET',
                timeout: 5000,
                success: function (data) {
                    data.forEach(function (service) {
                        $('#serviceNameSelect').append(`<option value="${service}">${service}</option>`);
                    });
                    console.log('服务列表加载成功');
                },
                error: function (xhr, status, error) {
                    console.error('加载服务列表失败:', error);
                    retryCount++;
                    
                    if (retryCount < maxRetries) {
                        console.log(`重试加载服务列表 (${retryCount}/${maxRetries})...`);
                        setTimeout(tryLoadServices, 1000);
                    } else {
                        console.error('服务列表加载失败，已达到最大重试次数');
                        // 可以在这里显示错误提示
                        if (typeof AlertManager !== 'undefined') {
                            AlertManager.error('无法加载服务列表，请检查Spring Boot服务是否正常运行');
                        }
                    }
                }
            });
        };

        tryLoadServices();
    }

    /**
     * 绑定事件
     */
    bindEvents() {
        // 服务选择事件
        $('#serviceNameSelect').change(function () {
            DataManager.instance.onServiceChange($(this).val());
        });

        // 上下文选择事件
        $('#contextNameSelect').change(function () {
            DataManager.instance.onContextChange($('#serviceNameSelect').val(), $(this).val());
        });

        // 领域选择事件
        $('#domainNameSelect').change(function () {
            DataManager.instance.onDomainChange($('#serviceNameSelect').val(), $('#contextNameSelect').val(), $(this).val());
        });

        // 聚合选择事件
        $('#aggregateNameSelect').change(function () {
            DataManager.instance.onAggregateChange($('#serviceNameSelect').val(), $('#contextNameSelect').val(), $('#domainNameSelect').val(), $(this).val());
        });
    }

    /**
     * 服务选择变化处理
     * @param {string} serviceName - 服务名称
     */
    onServiceChange(serviceName) {
        $('#contextNameSelect').empty().append('<option value="">限界上下文</option>');
        $('#domainNameSelect').empty().append('<option value="">领域</option>');
        $('#aggregateNameSelect').empty().append('<option value="">聚合</option>');
        
        if (serviceName) {
            $.get('/contexts', {serviceName: serviceName}, function (data) {
                data.forEach(function (context) {
                    $('#contextNameSelect').append(`<option value="${context}">${context}</option>`);
                });
            });
        }
    }

    /**
     * 上下文选择变化处理
     * @param {string} serviceName - 服务名称
     * @param {string} contextName - 上下文名称
     */
    onContextChange(serviceName, contextName) {
        $('#domainNameSelect').empty().append('<option value="">领域</option>');
        $('#aggregateNameSelect').empty().append('<option value="">聚合</option>');
        
        if (contextName) {
            $.get('/domains', {serviceName: serviceName, contextName: contextName}, function (data) {
                data.forEach(function (domain) {
                    $('#domainNameSelect').append(`<option value="${domain}">${domain}</option>`);
                });
            });
        }
    }

    /**
     * 领域选择变化处理
     * @param {string} serviceName - 服务名称
     * @param {string} contextName - 上下文名称
     * @param {string} domainName - 领域名称
     */
    onDomainChange(serviceName, contextName, domainName) {
        $('#aggregateNameSelect').empty().append('<option value="">聚合</option>');
        
        if (domainName) {
            $.get('/aggregates', {
                serviceName: serviceName,
                contextName: contextName,
                domainName: domainName
            }, function (data) {
                data.forEach(function (aggregate) {
                    $('#aggregateNameSelect').append(`<option value="${aggregate}">${aggregate}</option>`);
                });
            });
        }
    }

    /**
     * 聚合选择变化处理
     * @param {string} serviceName - 服务名称
     * @param {string} contextName - 上下文名称
     * @param {string} domainName - 领域名称
     * @param {string} aggregateName - 聚合名称
     */
    onAggregateChange(serviceName, contextName, domainName, aggregateName) {
        if (aggregateName) {
            $.get('/aggregate-data', {
                serviceName: serviceName,
                contextName: contextName,
                domainName: domainName,
                aggregateName: aggregateName
            }, function (data) {
                DataManager.instance.fillAggregateData(data);
            });
        }
        
        this.updatePathDisplay(serviceName, contextName, domainName, aggregateName);
    }

    /**
     * 更新路径显示
     */
    updatePathDisplay(serviceName, contextName, domainName, aggregateName) {
        const path = `${serviceName}/${contextName}/${domainName}/${aggregateName}`;
        $('#aggregatePath').val(path);
    }

    /**
     * 填充聚合数据
     */
    fillAggregateData(data) {
        $('#aggregateData').val(JSON.stringify(data, null, 2));
    }

    /**
     * 获取表单数据
     */
    getFormData() {
        return {
            serviceName: $('#serviceNameSelect').val(),
            contextName: $('#contextNameSelect').val(),
            domainName: $('#domainNameSelect').val(),
            aggregateName: $('#aggregateNameSelect').val(),
            aggregatePath: $('#aggregatePath').val(),
            aggregateData: $('#aggregateData').val()
        };
    }

    /**
     * 提交表单数据
     */
    submitFormData(onSuccess, onError) {
        const formData = this.getFormData();
        
        $.ajax({
            url: '/generate',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: onSuccess,
            error: onError
        });
    }

    // ========== 存储管理方法 ==========

    /**
     * 保存项目信息
     * @param {Object} projectInfo 项目信息
     */
    setProjectInfo(projectInfo) {
        try {
            localStorage.setItem(this.STORAGE_KEYS.PROJECT_INFO, JSON.stringify(projectInfo));
            this.updateRecentProjects(projectInfo);
        } catch (error) {
            console.error('保存项目信息失败:', error);
        }
    }

    /**
     * 获取项目信息
     * @returns {Object|null} 项目信息
     */
    getProjectInfo() {
        try {
            const data = localStorage.getItem(this.STORAGE_KEYS.PROJECT_INFO);
            return data ? JSON.parse(data) : null;
        } catch (error) {
            console.error('获取项目信息失败:', error);
            return null;
        }
    }

    /**
     * 保存文件路径列表
     * @param {Array} filePaths 文件路径列表
     */
    setFilePaths(filePaths) {
        try {
            localStorage.setItem(this.STORAGE_KEYS.FILE_PATHS, JSON.stringify(filePaths));
        } catch (error) {
            console.error('保存文件路径失败:', error);
        }
    }

    /**
     * 获取文件路径列表
     * @returns {Array} 文件路径列表
     */
    getFilePaths() {
        try {
            const data = localStorage.getItem(this.STORAGE_KEYS.FILE_PATHS);
            return data ? JSON.parse(data) : [];
        } catch (error) {
            console.error('获取文件路径失败:', error);
            return [];
        }
    }

    /**
     * 更新最近项目列表
     * @param {Object} projectInfo 项目信息
     */
    updateRecentProjects(projectInfo) {
        const recentProjects = this.getRecentProjects();
        const existingIndex = recentProjects.findIndex(p => p.path === projectInfo.path);
        
        if (existingIndex !== -1) {
            recentProjects.splice(existingIndex, 1);
        }
        
        recentProjects.unshift({
            name: projectInfo.name,
            path: projectInfo.path,
            lastOpened: new Date().toISOString()
        });
        
        // 只保留最近10个项目
        if (recentProjects.length > 10) {
            recentProjects.splice(10);
        }
        
        this.setRecentProjects(recentProjects);
    }

    /**
     * 保存最近项目列表
     * @param {Array} recentProjects 最近项目列表
     */
    setRecentProjects(recentProjects) {
        try {
            localStorage.setItem(this.STORAGE_KEYS.RECENT_PROJECTS, JSON.stringify(recentProjects));
        } catch (error) {
            console.error('保存最近项目失败:', error);
        }
    }

    /**
     * 获取最近项目列表
     * @returns {Array} 最近项目列表
     */
    getRecentProjects() {
        try {
            const data = localStorage.getItem(this.STORAGE_KEYS.RECENT_PROJECTS);
            return data ? JSON.parse(data) : [];
        } catch (error) {
            console.error('获取最近项目失败:', error);
            return [];
        }
    }

    /**
     * 保存用户偏好设置
     * @param {Object} preferences 用户偏好设置
     */
    setUserPreferences(preferences) {
        try {
            localStorage.setItem(this.STORAGE_KEYS.USER_PREFERENCES, JSON.stringify(preferences));
        } catch (error) {
            console.error('保存用户偏好设置失败:', error);
        }
    }

    /**
     * 获取用户偏好设置
     * @returns {Object} 用户偏好设置
     */
    getUserPreferences() {
        try {
            const data = localStorage.getItem(this.STORAGE_KEYS.USER_PREFERENCES);
            return data ? JSON.parse(data) : {};
        } catch (error) {
            console.error('获取用户偏好设置失败:', error);
            return {};
        }
    }

    /**
     * 保存会话数据
     * @param {Object} sessionData 会话数据
     */
    setSessionData(sessionData) {
        try {
            sessionStorage.setItem(this.STORAGE_KEYS.SESSION_DATA, JSON.stringify(sessionData));
        } catch (error) {
            console.error('保存会话数据失败:', error);
        }
    }

    /**
     * 获取会话数据
     * @returns {Object} 会话数据
     */
    getSessionData() {
        try {
            const data = sessionStorage.getItem(this.STORAGE_KEYS.SESSION_DATA);
            return data ? JSON.parse(data) : {};
        } catch (error) {
            console.error('获取会话数据失败:', error);
            return {};
        }
    }

    /**
     * 打开项目
     * @param {string} projectPath 项目路径
     * @param {string} projectName 项目名称
     */
    openProject(projectPath, projectName = '') {
        const projectInfo = {
            name: projectName || this.extractProjectName(projectPath),
            path: projectPath,
            lastOpened: new Date().toISOString(),
            isOpen: true
        };
        
        this.setProjectInfo(projectInfo);
        return projectInfo;
    }

    /**
     * 关闭项目
     */
    closeProject() {
        const projectInfo = this.getProjectInfo();
        if (projectInfo) {
            projectInfo.isOpen = false;
            this.setProjectInfo(projectInfo);
        }
    }

    /**
     * 从路径中提取项目名称
     * @param {string} path 项目路径
     * @returns {string} 项目名称
     */
    extractProjectName(path) {
        if (!path) return '';
        
        const pathParts = path.split(/[\\/]/);
        return pathParts[pathParts.length - 1] || path;
    }

    /**
     * 检查是否有项目打开
     * @returns {boolean} 是否有项目打开
     */
    isProjectOpen() {
        const projectInfo = this.getProjectInfo();
        return projectInfo && projectInfo.isOpen;
    }

    /**
     * 获取当前项目路径
     * @returns {string} 当前项目路径
     */
    getCurrentProjectPath() {
        const projectInfo = this.getProjectInfo();
        return projectInfo ? projectInfo.path : '';
    }

    /**
     * 清除所有数据
     */
    clearAllData() {
        try {
            Object.values(this.STORAGE_KEYS).forEach(key => {
                localStorage.removeItem(key);
                sessionStorage.removeItem(key);
            });
        } catch (error) {
            console.error('清除数据失败:', error);
        }
    }

    /**
     * 强制刷新
     */
    forceRefresh() {
        sessionStorage.setItem('force_refresh', 'true');
        window.location.reload();
    }

    /**
     * 根据URL清除数据
     */
    clearDataByUrl() {
        const currentUrl = window.location.href;
        const urlKey = `url_${btoa(currentUrl)}`;
        
        try {
            localStorage.removeItem(urlKey);
            sessionStorage.removeItem(urlKey);
        } catch (error) {
            console.error('根据URL清除数据失败:', error);
        }
    }

    /**
     * 导出数据
     * @returns {Object} 导出的数据
     */
    exportData() {
        const data = {};
        Object.values(this.STORAGE_KEYS).forEach(key => {
            const value = localStorage.getItem(key);
            if (value) {
                data[key] = value;
            }
        });
        return data;
    }

    /**
     * 导入数据
     * @param {Object} data 要导入的数据
     */
    importData(data) {
        try {
            Object.entries(data).forEach(([key, value]) => {
                localStorage.setItem(key, value);
            });
        } catch (error) {
            console.error('导入数据失败:', error);
        }
    }
}

// 创建单例实例
DataManager.instance = new DataManager(); 
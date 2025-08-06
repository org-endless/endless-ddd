/**
 * 统一异常处理类
 * 处理所有后端REST返回的异常信息
 */
class ErrorHandler {
    
    /**
     * 处理HTTP错误
     * @param {HttpError|Error} error - 错误对象
     * @returns {string} 处理后的错误消息
     */
    static handleHttpError(error) {
        console.error('HTTP错误:', error);
        
        // 如果是HttpError，使用其消息
        if (error instanceof HttpError) {
            return this.parseErrorMessage(error.message);
        }
        
        // 如果是普通Error，尝试解析消息
        if (error instanceof Error) {
            return this.parseErrorMessage(error.message);
        }
        
        // 如果是字符串，直接解析
        if (typeof error === 'string') {
            return this.parseErrorMessage(error);
        }
        
        // 如果是对象，尝试获取message字段
        if (typeof error === 'object' && error !== null) {
            // 尝试从对象中提取错误消息
            let message = null;
            
            // 检查常见的错误消息字段
            if (error.message) {
                message = error.message;
            } else if (error.error) {
                message = error.error;
            } else if (error.msg) {
                message = error.msg;
            } else if (error.detail) {
                message = error.detail;
            } else if (error.reason) {
                message = error.reason;
            } else if (typeof error === 'object') {
                // 如果是对象但没有明确的message字段，尝试JSON序列化
                try {
                    const jsonStr = JSON.stringify(error);
                    if (jsonStr !== '{}' && jsonStr !== '[]') {
                        message = jsonStr;
                    } else {
                        message = '未知错误';
                    }
                } catch (e) {
                    message = '未知错误';
                }
            }
            
            if (message) {
                return this.parseErrorMessage(message);
            }
        }
        
        return '未知错误';
    }
    
    /**
     * 解析错误消息
     * @param {string} message - 原始错误消息
     * @returns {string} 解析后的错误消息
     */
    static parseErrorMessage(message) {
        if (!message || typeof message !== 'string') {
            return message || '未知错误';
        }

        // 检查是否同时包含[]和<>
        const hasSquareBrackets = /\[([^\]]+)\]/.test(message);
        const hasAngleBrackets = /<([^>]+)>/.test(message);
        
        if (hasSquareBrackets && hasAngleBrackets) {
            // 同时有[]和<>的情况，直接返回<>中的内容
            const angleBracketMatch = message.match(/<([^>]+)>/);
            return angleBracketMatch ? angleBracketMatch[1].trim() : message.trim();
        }

        // 只有<>的情况
        const angleBracketMatch = message.match(/<([^>]+)>/);
        if (angleBracketMatch) {
            return angleBracketMatch[1].trim();
        }

        // 只有[]的情况
        const squareBracketMatches = message.match(/\[([^\]]+)\]/g);
        if (squareBracketMatches && squareBracketMatches.length > 0) {
            const lastMatch = squareBracketMatches[squareBracketMatches.length - 1];
            const content = lastMatch.match(/\[([^\]]+)\]/);
            if (content) {
                return content[1].trim();
            }
        }

        // 如果都没有，返回原始消息
        return message.trim();
    }

    /**
     * 解析异常响应对象
     * @param {Object} response - 异常响应对象
     * @returns {string} 解析后的消息
     */
    static parseResponse(response) {
        if (!response) {
            return '未知错误';
        }

        // 如果是字符串，直接解析
        if (typeof response === 'string') {
            return this.parseErrorMessage(response);
        }

        // 如果是对象，尝试获取message字段
        if (typeof response === 'object') {
            const message = response.message || response.error || response.msg || response.toString();
            return this.parseErrorMessage(message);
        }

        return '未知错误';
    }

    /**
     * 解析HTTP错误响应
     * @param {Response} response - HTTP响应对象
     * @returns {Promise<string>} 解析后的消息
     */
    static async parseHttpResponse(response) {
        try {
            const text = await response.text();

            // 尝试解析JSON
            try {
                const json = JSON.parse(text);
                return this.parseResponse(json);
            } catch (e) {
                // 如果不是JSON，直接解析文本
                return this.parseErrorMessage(text);
            }
        } catch (error) {
            return '网络错误，请稍后重试';
        }
    }
}

// 在浏览器环境中暴露到全局
if (typeof window !== 'undefined') {
    window.ErrorHandler = ErrorHandler;
} 
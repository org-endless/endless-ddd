package org.endless.ddd.starter.common.utils.model.string;

/**
 * PathTools
 * <p>
 * create 2025/08/10 02:46
 * <p>
 * update 2025/08/10 02:46
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public class PathTools {

    /**
     * 把 Windows 风格路径中的反斜杠转换为正斜杠
     * 并去除多余的连续斜杠，统一路径格式
     *
     * @param path 输入路径（可能包含反斜杠）
     * @return 统一使用正斜杠的路径，空路径返回null
     */
    public static String of(String path) {
        if (path == null || path.isEmpty()) {
            return null;
        }
        // 1. 替换所有反斜杠为正斜杠
        String replaced = path.replace('\\', '/');

        // 2. 去除重复斜杠，例如 // -> /
        String normalized = replaced.replaceAll("/+", "/");

        // 3. 去除末尾多余的斜杠（除非根路径 "/")
        if (normalized.length() > 1 && normalized.endsWith("/")) {
            normalized = normalized.substring(0, normalized.length() - 1);
        }

        return normalized;
    }

    /**
     * 判断是否为 Windows 盘符路径，如 C:/ 或 D:/abc
     *
     * @param path 路径字符串
     * @return true 是 Windows 盘符路径
     */
    public static boolean isWindows(String path) {
        return path != null && path.matches("^[A-Za-z]:/.*");
    }

    /**
     * 判断是否为 Unix 绝对路径，如 /usr/local
     *
     * @param path 路径字符串
     * @return true 是 Unix 绝对路径
     */
    public static boolean isUnixAbsolute(String path) {
        return path != null && path.startsWith("/");
    }
}

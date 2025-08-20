package org.endless.ddd.starter.common.utils.security;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * SecurityTools
 * <p>
 * create 2024/12/13 16:47
 * <p>
 * update 2025/08/18 18:01:55
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityTools {

    public static String getUserId() {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return userDetails.getUsername();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getUserId(Authentication authentication) {
        try {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails.getUsername();
        } catch (Exception e) {
            throw new RuntimeException("获取操作用户ID失败");
        }
    }
}

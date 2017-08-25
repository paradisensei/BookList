package com.aidar.util;

import com.aidar.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Aidar Shaifutdinov.
 */
public class SecurityUtils {

    public static User getPrincipal() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}

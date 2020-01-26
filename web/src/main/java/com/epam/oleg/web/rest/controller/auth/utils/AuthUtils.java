package com.epam.oleg.web.rest.controller.auth.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {

    public static Authentication getCurrentAuth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}

package ru.itis.semestrovka.security.utils;

import jakarta.servlet.http.HttpServletRequest;

public interface AuthorizationHeaderUtil {
    boolean hasAuthorizationToken(HttpServletRequest request);
    String getToken(HttpServletRequest request);
}

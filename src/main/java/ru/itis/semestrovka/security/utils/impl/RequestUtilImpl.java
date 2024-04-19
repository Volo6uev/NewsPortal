package ru.itis.semestrovka.security.utils.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import ru.itis.semestrovka.security.utils.AuthorizationHeaderUtil;

@Component
public class RequestUtilImpl implements AuthorizationHeaderUtil {

    public static final String AUTHORIZATION_HEADER_NAME = "AUTHORIZATION";

    public static final String BEARER = "Bearer ";

    @Override
    public boolean hasAuthorizationToken(HttpServletRequest request) {
        String header = request.getHeader(AUTHORIZATION_HEADER_NAME);
        return header != null && header.startsWith(BEARER);
    }

    @Override
    public String getToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER_NAME);
        return authorizationHeader.substring(BEARER.length());
    }
}

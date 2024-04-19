package ru.itis.semestrovka.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.itis.semestrovka.models.Token;
import ru.itis.semestrovka.models.User;
import ru.itis.semestrovka.repositories.TokensRepository;
import ru.itis.semestrovka.security.details.UserDetailsImpl;
import ru.itis.semestrovka.security.utils.AuthorizationHeaderUtil;

import java.io.IOException;
import java.util.Collections;

import static ru.itis.semestrovka.security.filters.TokenAuthenticationFilter.AUTHENTICATION_URL;

@Component
@RequiredArgsConstructor
public class TokenAuthorizationFilter extends OncePerRequestFilter {

    private final AuthorizationHeaderUtil authorizationHeaderUtil;

    private final TokensRepository tokensRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals(AUTHENTICATION_URL)) {
            filterChain.doFilter(request,response);
        } else {
            if(authorizationHeaderUtil.hasAuthorizationToken(request)) {
                String token = authorizationHeaderUtil.getToken(request);

                try {
                    Token userToken = tokensRepository.findFirstByToken(token).orElseThrow();
                    Authentication authentication = new UsernamePasswordAuthenticationToken(
                            new UserDetailsImpl(
                                    User.builder()
                                            .email(userToken.getEmail())
                                            .role(User.Role.valueOf(userToken.getAuthority()))
                                            .build()
                    ), null, Collections.singleton(new SimpleGrantedAuthority(userToken.getAuthority()))
                    );

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    filterChain.doFilter(request,response);
                } catch (Exception e) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                }

            } else {
                filterChain.doFilter(request,response);
            }
        }
    }
}

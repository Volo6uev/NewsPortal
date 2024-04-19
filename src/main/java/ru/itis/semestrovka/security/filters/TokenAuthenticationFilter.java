package ru.itis.semestrovka.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import ru.itis.semestrovka.models.Token;
import ru.itis.semestrovka.repositories.TokensRepository;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Component
public class TokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final String USERNAME_PARAMETER = "email";

    public static final String AUTHENTICATION_URL = "/authentication";

    private final ObjectMapper objectMapper;

    private final TokensRepository tokensRepository;

    public TokenAuthenticationFilter(AuthenticationConfiguration authenticationConfiguration,
                                     ObjectMapper objectMapper,
                                     TokensRepository tokensRepository) throws Exception {
        super(authenticationConfiguration.getAuthenticationManager());
        this.setUsernameParameter(USERNAME_PARAMETER);
        this.setFilterProcessesUrl(AUTHENTICATION_URL);
        this.objectMapper = objectMapper;
        this.tokensRepository = tokensRepository;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        response.setContentType("application/json");

        String generatedToken = UUID.randomUUID().toString();

        Map<String,String> token = Collections.singletonMap("token", generatedToken);

        objectMapper.writeValue(response.getOutputStream(),token);

        GrantedAuthority currentAuthority = authResult.getAuthorities().stream().findFirst().orElseThrow();

        tokensRepository.save(Token.builder()
                        .token(generatedToken)
                        .email(authResult.getName())
                        .authority(currentAuthority.getAuthority())
                        .build());
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}

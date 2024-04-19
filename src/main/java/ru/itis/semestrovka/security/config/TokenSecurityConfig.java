package ru.itis.semestrovka.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.itis.semestrovka.security.filters.TokenAuthenticationFilter;
import ru.itis.semestrovka.security.filters.TokenAuthorizationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class TokenSecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsServiceImpl;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,
                                                   TokenAuthenticationFilter tokenAuthenticationFilter,
                                                   TokenAuthorizationFilter tokenAuthorizationFilter) throws Exception {
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.csrf().disable();
        httpSecurity.authorizeHttpRequests()
                .requestMatchers("/articles/**").permitAll()
                .requestMatchers("swagger-ui.html/**").permitAll()
                .requestMatchers("/registration/**").permitAll()
//                .requestMatchers("/authentication/**").permitAll()
                .requestMatchers("/profile/**").authenticated()
//                .and().formLogin().loginPage("/authentication").defaultSuccessUrl("/profile").permitAll()
                .and().logout().logoutSuccessUrl("/");;


        httpSecurity.addFilter(tokenAuthenticationFilter);
        httpSecurity.addFilterBefore(tokenAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Autowired
    public void bindUserDetailsServiceAndPasswordEncoder(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }
}

package com.gonzaloquiroga.app.libreria.libreriaapp.config.security;

import com.gonzaloquiroga.app.libreria.libreriaapp.service.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    private static final String[] AUTH_WHITELIST = {
            // Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html/**",
            // AUTH & HOME
            "/api/v1/auth/**",
            "/",
            "api/v1",
            "api/v1/{id}"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return
                http
                        .csrf(csrf -> csrf.disable())
                        .authorizeHttpRequests((authorize) -> authorize
                                .requestMatchers(AUTH_WHITELIST).permitAll()
                                .requestMatchers("/api/v1/user/**").hasAnyAuthority("USER", "ADMIN")
                                .requestMatchers("/api/v1/admin/**").hasAuthority("ADMIN")
                                .anyRequest().authenticated()
                        )
                        .formLogin(Customizer.withDefaults())
                        .sessionManagement(sessionManager ->
                                sessionManager
                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .authenticationProvider(authenticationProvider)
                        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                        .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
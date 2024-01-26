package ru.altacod.prmo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                                .requestMatchers("/public/**").permitAll() // URL-адреса, доступные без аутентификации
                                .anyRequest().authenticated() // Все остальные URL-адреса требуют аутентификации
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login").permitAll() // Страница входа
                )
                .logout(LogoutConfigurer::permitAll
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement
                                .invalidSessionUrl("/login")
                                .maximumSessions(1).expiredUrl("/login")
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

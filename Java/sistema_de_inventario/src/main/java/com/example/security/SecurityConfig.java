package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/auth/**").permitAll() // Permitir acceso a rutas de autenticación
                        .anyRequest().authenticated() // Otras solicitudes requieren autenticación
                )
                .formLogin(form ->
                        form
                                .loginPage("/auth/login") // Página de inicio de sesión personalizada
                                .successHandler(new SimpleUrlAuthenticationSuccessHandler("/productos")) // Redirigir a /productos después del login
                                .failureUrl("/auth/login?error=true") // Redirigir a login en caso de fallo
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER"); // Agrega un usuario en memoria
        return authenticationManagerBuilder.build();
    }
}

package com.project.filesharingapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/home", "/login", "/oauth2/**", "/styles/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page
                        .loginProcessingUrl("/home") // This should match the form's action
                        .defaultSuccessUrl("/home", true) // Redirect after successful login
                        .permitAll()
                )
                .oauth2Login(oauth2 -> oauth2
                        .successHandler(customSuccessHandler())
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/").permitAll()
                )
                .csrf(csrf -> csrf.disable()); // Disable CSRF if handling stateless authentication

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler customSuccessHandler() {
        SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();
        successHandler.setDefaultTargetUrl("/home"); // Redirect after login
        return successHandler;
    }
}

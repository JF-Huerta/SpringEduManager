package com.springedumanager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${app.security.admin.username}")
    private String adminUsername;

    @Value("${app.security.admin.password}")
    private String adminPassword;

    @Value("${app.security.user.username}")
    private String userUsername;

    @Value("${app.security.user.password}")
    private String userPassword;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                .requestMatchers("/login")
                .permitAll()

                .requestMatchers("/cursos-web/guardar")
                .hasRole("ADMIN")

                .requestMatchers(
                    "/estudiantes-web",
                    "/cursos-web",
                    "/estudiantes",
                    "/estudiantes/**",
                    "/cursos",
                    "/cursos/**"
                )
                .hasAnyRole("ADMIN", "USER")

                .anyRequest()
                .authenticated()
            )

            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/cursos-web", true)
                .failureUrl("/login?error")
                .permitAll()
            )

            .httpBasic(basic -> {})

            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    InMemoryUserDetailsManager userDetailsService() {

        UserDetails admin = User
            .withUsername(adminUsername)
            .password("{noop}" + adminPassword)
            .roles("ADMIN")
            .build();

        UserDetails user = User
            .withUsername(userUsername)
            .password("{noop}" + userPassword)
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
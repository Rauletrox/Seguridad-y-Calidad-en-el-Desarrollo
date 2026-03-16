package com.duoc.veterinaria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(authz -> authz
                                                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                                                .requestMatchers("/", "/login").permitAll()
                                                .anyRequest().authenticated())
                                .formLogin(form -> form
                                                .loginPage("/login")
                                                .defaultSuccessUrl("/dashboard", true)
                                                .permitAll())
                                .logout(logout -> logout
                                                .logoutSuccessUrl("/login?logout")
                                                .permitAll());

                return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService() {
                UserDetails admin = User.builder()
                                .username("admin")
                                .password(passwordEncoder().encode("admin123"))
                                .roles("ADMIN")
                                .build();

                UserDetails veterinario = User.builder()
                                .username("veterinario")
                                .password(passwordEncoder().encode("vet123"))
                                .roles("VETERINARIO")
                                .build();

                UserDetails recepcion = User.builder()
                                .username("recepcion")
                                .password(passwordEncoder().encode("recep123"))
                                .roles("RECEPCION")
                                .build();

                return new InMemoryUserDetailsManager(admin, veterinario, recepcion);
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
}
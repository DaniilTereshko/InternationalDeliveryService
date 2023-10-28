package org.international_delivery_service.international_delivery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(formLogin -> {
                    formLogin
                            .loginPage("/login")
                            .loginProcessingUrl("/login-processing")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .permitAll()
                            .defaultSuccessUrl("/package")
                            .failureUrl("/login?error=true");
                })
                .authorizeHttpRequests(authorize -> {
                    authorize
                            .requestMatchers("/images/**", "/css/**", "/js/**", "/WEB-INF/views/**").permitAll()
                            .requestMatchers("/package").authenticated()
                            .requestMatchers("/registration").permitAll()
                            .requestMatchers("/worker").hasRole("WORKER")
                            .requestMatchers("/street", "/department").hasRole("ADMIN")
                            .requestMatchers("/department/info").hasAnyRole("ADMIN", "WORKER")
                            .anyRequest().authenticated();
                })
                .logout(logout -> {
                    logout
                            .logoutUrl("/logout")
                            .logoutSuccessUrl("/");
                });

        http.userDetailsService(userDetailsService);

        return http.build();
    }
}

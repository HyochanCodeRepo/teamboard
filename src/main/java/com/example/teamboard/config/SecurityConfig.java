package com.example.teamboard.config;

import jakarta.servlet.annotation.WebListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@WebListener
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        (AuthorizeHttpRequests) -> AuthorizeHttpRequests
                                .requestMatchers("/user/**", "/main/**").permitAll()
                                .requestMatchers("/board/**").hasRole("ADMIN")

                )
                .csrf(csrf -> csrf.disable())
                .formLogin(
                        formLogin -> formLogin.loginPage("/user/login") //로그인 페이지 지정
                                .defaultSuccessUrl("/main")
                                .usernameParameter("email")
                )
                .logout(logout -> logout.logoutUrl("/user/logout")
                )
                .exceptionHandling(
                        a -> a.accessDeniedHandler(new CustomAccessDeniedHandler())
                );



        return  http.build();
    }



    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}

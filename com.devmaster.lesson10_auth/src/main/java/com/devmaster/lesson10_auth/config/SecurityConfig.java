package com.devmaster.lesson10_auth.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz->authz
                        .requestMatchers("/admin/**").authenticated()
                        .requestMatchers("/login","/registry","/","/logout").permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin(form->form
                        .loginPage("/login")
                        .failureUrl("/login?error")
                            .failureHandler(customAuthenticationFailureHandler())
                        .defaultSuccessUrl("/admin",true)
                        .permitAll()
                )
                .logout(logout->logout
                        .logoutUrl("/logout") // url để kích hoạt dang xuat
                        .logoutSuccessUrl("/login?logout") // Sau khi dang xuat thanh cong
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new SimpleUrlAuthenticationFailureHandler(){
            @Override
            public  void onAuthenticationFailure(HttpServletRequest request,
                                                 HttpServletResponse response,
                                                 AuthenticationException exception)
                        throws IOException {
                String errorMessage = "Sai ten dang nhap hoac mat khau";
                if(exception instanceof UsernameNotFoundException){
                    errorMessage = exception.getMessage();
                }

                request.setAttribute("loginError", errorMessage);
                getRedirectStrategy().sendRedirect(request, response, "/login?error");
            }
        };
    }
}

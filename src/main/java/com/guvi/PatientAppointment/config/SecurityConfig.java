package com.guvi.PatientAppointment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import javax.sql.DataSource;



@Configuration
@EnableWebSecurity

public class SecurityConfig {


        @Autowired
        private DataSource securityDataSource;

        @Autowired
        private CustomAuthenticationSuccessHandler successHandler;

        @Bean
        public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        }

        @Bean
        public UserDetailsService getDetailsService() {
        return new CustomUserDetailsService();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .requestMatchers("/user/**").hasRole("USER")
                    .requestMatchers("/register").permitAll()
                    .requestMatchers("/confirm").permitAll()
                    .requestMatchers("/login/**").permitAll()
                    // Add static resources to be ignored (adjust paths as needed)
                    .requestMatchers("/css/**", "/js/**", "/static/**","/vendor/**","/resources/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin(formLogin ->
                                    formLogin
                                       .loginPage("/showMyLoginPage")
                                       .loginProcessingUrl("/authenticateTheUser")
                                       .successHandler(successHandler)
                                       .permitAll()
                    )

                    .logout(logout -> logout
                                       .permitAll())
                    .exceptionHandling(exceptionHandling->
                               exceptionHandling
                                     .accessDeniedPage("/register"));

            return http.build();
        }



        public void configure(WebSecurity web) throws Exception {

        web.ignoring().requestMatchers("/resources/**","/login/**","/static/**","/Script/**","/Style/**","/Icon/**",
                "/js/**","/vendor/**","/bootstrap/**","/Image/**");
        }


            @Bean
            public DaoAuthenticationProvider getAuthenticationProvider() {
                DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
                daoAuthenticationProvider.setUserDetailsService(getDetailsService());
                daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
                return daoAuthenticationProvider;
            }


        }



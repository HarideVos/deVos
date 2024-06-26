
package com.binary.banking.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        @Bean
        public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

            http.
        authorizeHttpRequests(authorize ->
        authorize
                .requestMatchers("/api/v1/account/list", "/api/v1/member/list").permitAll()
                .anyRequest().authenticated())
                    .formLogin(Customizer.withDefaults())
                    .httpBasic(Customizer.withDefaults())
                    .csrf(csrf -> csrf.disable());

            return http.build();
        }




    @Bean
    public UserDetailsService jdbcUserDetailsService(DataSource dataSource){
         return new JdbcUserDetailsManager(dataSource);
    }


        @Bean
        public PasswordEncoder noOpPasswordEncoder() {
            return NoOpPasswordEncoder.getInstance();
        }
    }






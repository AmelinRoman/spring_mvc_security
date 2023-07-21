package com.amelinroman.spring.security.configuration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;



@Configuration
@EnableWebSecurity
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MySecurityConfig {

    DataSource dataSource;

    @Bean
    UserDetailsManager detailsManager() {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/").hasAnyRole("MANAGER", "HR", "EMPLOYEE")
                        .requestMatchers("/hr_info").hasRole("HR")
                        .requestMatchers("/manager_info/**").hasRole("MANAGER").anyRequest().permitAll())
                .formLogin().permitAll();
        return http.build();
    }
}

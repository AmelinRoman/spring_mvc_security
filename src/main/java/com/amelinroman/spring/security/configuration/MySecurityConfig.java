package com.amelinroman.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.ldap.EmbeddedLdapServerContextSourceFactoryBean;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class MySecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(userBuilder
                .username("Roman")
                .password("123")
                .roles("MANAGER")
                .build());
        manager.createUser(userBuilder
                .username("Olya")
                .password("321")
                .roles("HR")
                .build());
        manager.createUser(userBuilder
                .username("Shanty")
                .password("111")
                .roles("EMPLOYEE")
                .build());

        return manager;
    }
}

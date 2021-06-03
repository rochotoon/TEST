/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview.infrastructure.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import org.springframework.web.filter.CorsFilter;
import org.springframework.core.Ordered;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;
/**
 * Adapter class that implements the interface: ServiceResponse
 *
 * <p>
 * Class that generates the response the comments
 * </p>
 *
 * @author Rodrigo Flores
 * @since 2019-10-10
 *
 */
@Slf4j
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    @Value("${com.kenzan.security.user}")
    private String secUser;

    @Value("${com.kenzan.security.psw}")
    private String secPsw;

    @Value("${spring.h2.console.path}")
    private String h2Db;

    /**
     * <p>
     * Function that handles the String Values To Long
     * </p>
     *
     * @param value String Value to transfom in Log
     * @return Long Long Value Of String
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.headers().frameOptions().disable();

        // All requests send to the Web Server request must be authenticated
        http.authorizeRequests().antMatchers(HttpMethod.DELETE).authenticated().and().authorizeRequests().and()
                .authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests()
                .antMatchers(String.format("%s/**", h2Db)).permitAll();
        // Use AuthenticationEntryPoint to authenticate user/password
        http.httpBasic().authenticationEntryPoint(authEntryPoint);
    }

    @Bean
    public FilterRegistrationBean simpleCorsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        CorsConfiguration config = new CorsConfiguration();  
        config.setAllowCredentials(true); 
        // *** URL below needs to match the Vue client URL and port ***
        config.setAllowedOrigins(Collections.singletonList("https://microservices921.herokuapp.com")); 
        config.setAllowedMethods(Collections.singletonList("*"));  
        config.setAllowedHeaders(Collections.singletonList("*"));  
        source.registerCorsConfiguration("/**", config);  
        FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
        return bean;  
    }  

    /**
     * <p>
     * Function that handles the String Values To Long
     * </p>
     *
     * @param value String Value to transfom in Log
     * @return Long Long Value Of String
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    /**
     * <p>
     * Function that handles the String Values To Long
     * </p>
     *
     * @param value String Value to transfom in Log
     * @return Long Long Value Of String
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        String encrytedPassword = this.passwordEncoder().encode(secPsw);

        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> //
        mngConfig = auth.inMemoryAuthentication();
        UserDetails u1 = User.withUsername(secUser).password(encrytedPassword).roles("USER").build();
        mngConfig.withUser(u1);

    }

}
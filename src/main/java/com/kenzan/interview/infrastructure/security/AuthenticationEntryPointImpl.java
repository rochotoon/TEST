/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview.infrastructure.security;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

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
@Component
public class AuthenticationEntryPointImpl extends BasicAuthenticationEntryPoint {

    @Value("${com.kenzan.security.realm}")
    String realm;

    /**
     * <p>
     * Function that handles the String Values To Long
     * </p>
     *
     * @param value String Value to transfom in Log
     * @return Long Long Value Of String
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
            throws IOException, ServletException {
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - " + authEx.getMessage());
    }

    /**
     * <p>
     * Function that handles the String Values To Long
     * </p>
     *
     * @param value String Value to transfom in Log
     * @return Long Long Value Of String
     */
    @Override
    public void afterPropertiesSet() {
        setRealmName(realm);
        super.afterPropertiesSet();
    }

}
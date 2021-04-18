/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
@SpringBootApplication
@EnableSwagger2
@EnableWebSecurity
public class kenzanApplication extends SpringBootServletInitializer {

  /**
   * <p>
   * Function that handles the String Values To Long
   * </p>
   *
   * @param value String Value to transfom in Log
   * @return Long Long Value Of String
   */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(kenzanApplication.class);
    }

    /**
     * <p>
     * Function that handles the String Values To Long
     * </p>
     *
     * @param value String Value to transfom in Log
     * @return Long Long Value Of String
     */
    public static void main(String[] args) {
        SpringApplication.run(kenzanApplication.class, args);
    }

}

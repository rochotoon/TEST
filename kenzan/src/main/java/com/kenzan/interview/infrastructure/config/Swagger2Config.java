/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview.infrastructure.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.kenzan.interview.application.employee.commons.Constants;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

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
@Configuration
public class Swagger2Config {

  /**
   * <p>
   * Function that handles the String Values To Long
   * </p>
   *
   * @param value String Value to transfom in Log
   * @return Long Long Value Of String
   */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(Constants.KENZAN_CONTROLLERS_PATH)).paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Kenzan - Employees", "Some custom description of API.", "API TOS", "Terms of service",
                new Contact("John Doe", "www.example.com", "myeaddress@company.com"), "License of API",
                "API license URL", Collections.emptyList());
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
    public WebMvcConfigurer corsCOnfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST", "GET", "OPTIONS", "PUT", "DELETE")
                        .allowCredentials(false).maxAge(3600);
            }
        };
    }
}
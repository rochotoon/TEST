/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview.application.employee.web.dto;

import java.util.List;
import com.kenzan.interview.domain.model.Employee;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Adapter class that implements the interface: ServiceResponse
 *
 * <p>
 * Data transfer object that represents an standarised way for REST outputs.  
 * </p>
 *
 * @author Rodrigo Flores
 * @since 2019-10-10
 *
 */
@Builder
@ToString
@Getter
public final class RestResultDTO {
   private String result;
   private String message;
   private List<? extends Employee> output;
}
/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview.application.employee.web.dto;

import java.time.Instant;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kenzan.interview.domain.model.Employee;
import com.kenzan.interview.domain.model.StatusType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Adapter class that implements the interface: ServiceResponse
 *
 * <p>
 * Data transfer object that represents {@link Employee}
 * </p>
 *
 * @author Rodrigo Flores
 * @since 2019-10-10
 *
 */
@Builder
@ToString
@Getter
public final class EmployeCreationDTO {
    private Long employeeId;
    private String firstName; // - Employees first name
    private String middleInitial; // - Employees middle initial
    private String lastName; // - Employeed last name
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Builder.Default
    private LocalDate dateOfBirth = LocalDate.now().minusYears(18); // - Employee birthday and year
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant dateOfEmployment; // - Employee start date
    @Builder.Default
    private StatusType status = StatusType.ACTIVE; // - ACTIVE or INACTIVE

}